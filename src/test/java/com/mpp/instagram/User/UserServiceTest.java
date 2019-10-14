package com.mpp.instagram.User;

import com.mpp.instagram.user.entity.UserEntity;
import com.mpp.instagram.user.repository.UserRepository;
import com.mpp.instagram.user.service.UserService;
import javafx.beans.binding.When;
import javafx.beans.value.ObservableBooleanValue;
import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jmx.export.annotation.ManagedOperation;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepo;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

  @Test
    public void findByUsername_IFNotNull()
  {
      UserEntity userEntity=new UserEntity("Adnan","AdnanShehzad","ashehzad@mum.edu","1234567");
      when(userRepo.findByUsername(anyString())).thenReturn(userEntity);
      UserEntity returnvalue=userService.findByUsername("Adnan");
      Assert.assertNotNull(returnvalue);
      verify(userRepo,times(1)).findByUsername("Adnan");
      Assert.assertEquals(userEntity,returnvalue);
  }
  @Test
  public void findByUsername_IFNull()
  {
      when(userRepo.findByUsername(anyString())).thenReturn(null);
      UserEntity returnValue=userService.findByUsername("Adnan");
      Assert.assertNull(returnValue);
  }
  @Test
    public void IsUserValid_IFUserExistsInDatabase()
  {
      UserEntity userEntity=new UserEntity("Adnan","AdnanShehzad","ashehzad@mum.edu","1234567");
      when(userRepo.findByUsernameAndPassword(anyString(),anyString())).thenReturn(userEntity);
      UserEntity returnValue=userService.isUserValid("Adnan","13413");
      Assert.assertNotNull(returnValue);
      Assert.assertEquals("1234567",returnValue.getPassword());
  }
  @Test
    public void IsUserValid_IFUserNotExists()
  {
      when(userRepo.findByUsernameAndPassword(anyString(),anyString())).thenReturn(null);
      UserEntity returnValue=userService.isUserValid("Adnan","1234567");
      Assert.assertNull(returnValue);
  }
  //public void isUserActive45





}

package com.mpp.instagram.FunctionalCode.profile;

import java.util.List;
import java.util.Optional;

@FunctionalInterface
public interface TriFunction<X,Y,Z,R> {
     public Optional<List<Profile>> apply(X x, Y y, Z z);
}

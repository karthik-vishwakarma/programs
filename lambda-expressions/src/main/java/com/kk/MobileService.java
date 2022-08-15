package com.kk;

//SAM: Single Abstract Method (Functional Interface annotation dictates that this interface has single abstract method.)
@FunctionalInterface
public interface MobileService {
    void call(String name);
}

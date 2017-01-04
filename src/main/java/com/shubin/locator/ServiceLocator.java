package com.shubin.locator;

public interface ServiceLocator {
    Object getService(String name) throws IllegalStateException;
}

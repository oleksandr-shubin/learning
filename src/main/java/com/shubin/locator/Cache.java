package com.shubin.locator;

import java.util.HashMap;
import java.util.Map;

public class Cache<T> {
    private Map<String, T> services;

    public Cache() {
        services = new HashMap<String, T>();
    }

    public boolean hasService(String serviceName) {
        if (services.containsKey(serviceName)) {
            return true;
        } else {
            return false;
        }
    }

    public T getService(String serviceName) {
        if (hasService(serviceName)) {
            return services.get(serviceName);
        } else {
            return null;
        }
    }

    public void addService(String serviceName, T newService) {
        if (hasService(serviceName)) {
            return;
        } else {
            services.put(serviceName, newService);
        }
    }
}

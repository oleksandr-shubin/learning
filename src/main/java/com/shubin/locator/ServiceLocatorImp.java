package com.shubin.locator;

import com.shubin.factory.Factory;

import java.sql.SQLException;

public class ServiceLocatorImp implements ServiceLocator {
    private static final String FACTORY_PACKAGE_PREFIX = "com.shubin.factory";
    private static final String FACTORY_ENDING = "Factory";
    private Cache cache;


    public ServiceLocatorImp() {
        this.cache = new Cache();
    }

    @Override
    public Object getService(String serviceName) throws IllegalStateException {
        try {
            Object service = cache.getService(serviceName);
            if (service != null) {
                return service;
            } else {
                service = createServiceByName(serviceName);
                cache.addService(serviceName, service);
                return service;
            }
        } catch (ReflectiveOperationException | SQLException e) {
            throw new IllegalStateException("", e);
        }
    }

    private Object createServiceByName(String serviceName) throws ReflectiveOperationException, SQLException {
        Factory serviceFactory = createFactory(serviceName);
        return serviceFactory.createService(this);
    }

    private Factory createFactory(String serviceName) throws ReflectiveOperationException {
        String serviceClassName = FACTORY_PACKAGE_PREFIX
                +"."
                + serviceName
                + FACTORY_ENDING;

        Class<?> serviceClass = Class.forName(serviceClassName);
        Factory factory = (Factory) serviceClass.newInstance();
        return factory;
    }
}

package com.shubin.factory;

import com.shubin.builder.ComputerBuilderDirector;
import com.shubin.builder.ComputerBuilderDirectorImp;
import com.shubin.builder.laptop.CustomLaptopBuilderImp;
import com.shubin.locator.ServiceLocator;

import java.sql.SQLException;

public class ComputerBuilderDirectorFactory implements Factory<ComputerBuilderDirector> {

    @Override
    public ComputerBuilderDirector createService(ServiceLocator serviceLocator) throws ReflectiveOperationException, SQLException {
        return new ComputerBuilderDirectorImp(new CustomLaptopBuilderImp());
    }
}

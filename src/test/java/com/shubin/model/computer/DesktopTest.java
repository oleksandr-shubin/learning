package com.shubin.model.computer;

import com.shubin.model.computer.program.Launchable;
import com.shubin.model.computer.program.calculator.Calculator;
import com.shubin.model.computer.program.os.Linux;
import com.shubin.model.computer.program.os.OperationSystem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DesktopTest {

    @Mock private OperationSystem mockedLinux;
    @Mock private Launchable mockedCalculator;
    private Desktop desktop;

    @Before
    public void setUp() {
        desktop = new Desktop();
        desktop.powerOn();
        desktop.installOS("linux", mockedLinux);
        desktop.launchOS("linux");

    }

    @Test
    public void testInstallApplicationShouldCallInstallMethodOfOperationSystem() {
        desktop.installApplication("calculator", mockedCalculator);

        verify(mockedLinux, times(1)).install(anyString(), any(Launchable.class));
    }

    @Test
    public void testLaunchApplicationShouldCallLaunchMethodOfOperationSystem() {
        desktop.installApplication("calculator", mockedCalculator);
        desktop.launchApplication("calculator");

        verify(mockedLinux, times(1)).launch(anyString());
    }
}
package com.shubin.model.computer.program.os;

import com.shubin.model.computer.program.Launchable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LinuxTest {

    @Mock private Launchable mockedCalculator;
    private OperationSystem linux;

    @Before
    public void setUp() {
        linux = new Linux();
    }

    @Test
    public void testLaunchShouldCallStartOfApplication() {
        linux.install("calculator", mockedCalculator);
        linux.launch("calculator");

        verify(mockedCalculator).start();
    }



}
package com.shubin.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class View {
    public <T> void show(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }
}

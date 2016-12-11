package com.shubin.model.reflection;

public class AnnotationTest implements Talkable {

    @MethodPreamble(currentRevision = 1)
    @Override
    public void sayOverride() {
        System.out.println("Override");
    }

    @MethodPreamble(currentRevision = 2)
    @Deprecated
    public void sayDeprecated() {
        System.out.println("Deprecated");
    }

    @MethodPreamble(currentRevision = 3)
    @SuppressWarnings("deprecation")
    public void saySuppressWarnings() {
        sayDeprecated();
        System.out.println("SuppressWarnings");
    }
}

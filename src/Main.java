import com.sun.org.apache.xpath.internal.SourceTree;
import model.computer.program.calculator.Calculator;
import model.reflection.AnnotationTest;
import model.reflection.MethodInspector;
import model.threads.MessageLoop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args)  {
        AnnotationTest annotationTest = new AnnotationTest();
        Class annotationTestClass = annotationTest.getClass();
        for (Method method : annotationTestClass.getDeclaredMethods()) {
            new MethodInspector(method).displayAnnotationsExtended();
        }
    }
}

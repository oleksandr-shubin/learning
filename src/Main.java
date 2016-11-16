import com.sun.org.apache.xpath.internal.SourceTree;
import model.computer.program.calculator.Calculator;
import model.reflection.MethodInspector;
import model.threads.MessageLoop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        Thread myThread = new Thread(new MessageLoop());
        Class myThreadClass = myThread.getClass();

        // getting and inspecting the first method
        Method firstMethod = myThreadClass.getMethods()[0];
        new MethodInspector(firstMethod).displayInfo();
    }
}

package model.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MethodInspector {
    String name;
    String modifiers;
    String returnType;
    Parameter[] parameters;
    Annotation[] annotations;

    public MethodInspector(Method method) {
        name = method.getName();
        modifiers = Modifier.toString(method.getModifiers());
        returnType = method.getReturnType().toString();
        parameters = method.getParameters();
        annotations = method.getDeclaredAnnotations();
    }

    public void displayInfo () {
        System.out.println("Method inspection:");
        System.out.println("Name: " + name);
        System.out.println("Modifiers: " + modifiers);
        System.out.println("Return type: " + returnType);
        System.out.println("Parameters: ");
        displayParameters(parameters);
        System.out.println("Annotations" );
        displayAnnotations(annotations);
    }

    private void displayParameters(Parameter[] parameters) {
        if (parameters.length == 0) {
            System.out.println("nil");
        } else {
            for(Parameter parameter : parameters) {
                System.out.println(parameter.getName() + " : " +
                        parameter.getType().getName());
            }
        }
    }

    private void displayAnnotations(Annotation[] annotations) {
        if (annotations.length == 0 ) {
            System.out.println("nil");
        } else {
            for (Annotation annotation : annotations) {
                System.out.println(annotation.toString());
            }
        }
    }
}


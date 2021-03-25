package homework;

import homework.annotations.After;
import homework.annotations.Before;
import homework.annotations.Test;
import homework.helpers.ReflectionHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRunner {

  private final Class clazz;

  private List<String> beforeMethods = new ArrayList<>();
  private List<String> testMethods = new ArrayList<>();
  private List<String> afterMethods = new ArrayList<>();

  public TestRunner(Class clazz) {
    this.clazz = clazz;
  }

  public void runTests() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
    //1. find methods
    //2. run methods
    //2.1. run @Before -> @Test 1..N -> @After
    //2.2. if @Before is fail then run @After and run Next a test
    //3. if a test is fail, run next a test

    //1. find methods in class
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      if (method.isAnnotationPresent(Before.class)) {
        beforeMethods.add(method.getName());
      } else if (method.isAnnotationPresent(After.class)) {
        afterMethods.add(method.getName());
      } else if (method.isAnnotationPresent(Test.class)) {
        testMethods.add(method.getName());
      }
    }
    System.out.println( Arrays.toString(methods) );
    System.out.println("Before methods: " + Arrays.asList(beforeMethods));
    System.out.println("Test methods: " + Arrays.asList(testMethods));
    System.out.println("After methods: " + Arrays.asList(afterMethods));

    Constructor<?>[] constructors = clazz.getConstructors();
    System.out.println("--- constructors:");
    System.out.println(Arrays.toString(constructors));

    System.out.println("--- creating new object:");
    Constructor<?> constructor = clazz.getConstructor();
    ClassTest object = (ClassTest) constructor.newInstance();

    Object instantiate = ReflectionHelper.instantiate(clazz);
    ReflectionHelper.callMethod(instantiate, beforeMethods.get(0));

    try {
      ReflectionHelper.callMethod(instantiate, testMethods.get(0));
    } catch (Exception e) {
      System.out.println("The test is failed: " + e.getMessage() + " in method: " + testMethods.get(0));
    }

    ReflectionHelper.callMethod(instantiate, afterMethods.get(0));

    //System.out.println("value:" + object.getValuePrivate());
  }
}

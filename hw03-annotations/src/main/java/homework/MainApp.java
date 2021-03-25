package homework;

import java.lang.reflect.InvocationTargetException;

public class MainApp {

  public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
    new TestRunner(ClassTest.class).runTests();
  }
}

package homework;

import homework.annotations.After;
import homework.annotations.Before;
import homework.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassTest {

  public ClassTest() {
    System.out.println("Class " + this.getClass().getName() + " is created");
  }

  @Before
  public void init() {
    System.out.println("start init() method...");
  }

  @Test
  public void test1() {
    System.out.println("running test1() method");
    String actualData = "123";
    String expectedData = "456";
    assertThat(actualData).isEqualTo(expectedData);
  }

  @Test
  public void test2() {
    System.out.println("running test2() method");
  }

  @After
  public void finish() {
    System.out.println("end finish() method...");
  }

}

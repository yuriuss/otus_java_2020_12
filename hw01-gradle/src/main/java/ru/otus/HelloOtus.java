package ru.otus;

import com.google.common.base.Splitter;

import java.util.List;

public class HelloOtus {

  public static void main(String[] args) {
    List<String> helloOtus = Splitter.on("+").splitToList("Hello+OTUS!+Get+started :)");

    System.out.println( helloOtus );
    helloOtus.forEach( System.out::println );
    System.out.println( helloOtus.toString().replaceAll("\\[|\\]|\\,",""));
  }
}

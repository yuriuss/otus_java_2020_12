package homework;


import java.util.*;

import static java.util.Comparator.comparingLong;

public class CustomerService {

  //todo: 3. надо реализовать методы этого класса
  //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

  private final NavigableMap<Customer, String> map = new TreeMap<>(comparingLong(Customer::getScores));

  public Map.Entry<Customer, String> getSmallest() {
    Map.Entry<Customer, String> entry = map.firstEntry();
    return Map.entry(entry.getKey().clone(), entry.getValue());
  }

  public Map.Entry<Customer, String> getNext(Customer customer) {
    return map.higherEntry(customer);
  }

  public final void add(Customer customer, String data) {
    map.put(customer, data);
  }

}

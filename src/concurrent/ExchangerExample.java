package concurrent;

import java.util.concurrent.*;
import java.util.*;
 
public class ExchangerExample {  
 
   public static void main(String[] args) {
 
      Exchanger<String> exchanger = new Exchanger<String>();
 
      Thread t1 = new MyThread(exchanger, "I like coffee.");
      Thread t2 = new MyThread(exchanger, "I like tea");
      Thread t3 = new MyThread(exchanger, "Nothing needed...");
      t1.start();
      t2.start();
     // t3.start();
   }
}
 
class MyThread extends Thread {
 
   Exchanger<String> exchanger;
   String message;
 
   MyThread(Exchanger<String> exchanger, String message) {
      this.exchanger = exchanger;
      this.message = message;
   }
 
   public void run() {
      try {
         System.out.println(this.getName() + " message: " + message);
 
         // exchange messages
         message = exchanger.exchange(message);
 
         System.out.println(this.getName() + " message: " + message);
      } catch (Exception e) {
      }
   }
}
package concurrent;



 class A {
	void a1(){
		System.out.println("A1:" + Thread.currentThread().getName());
	}
	
	void a2(){
		System.out.println("A2:" +  Thread.currentThread().getName());
	}
	
	synchronized void  a3(){
		System.out.println("A3:" + Thread.currentThread().getName());
	}
	
	synchronized void a4(){
		System.out.println("A4:" + Thread.currentThread().getName());
		 try {
				
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	static synchronized void a5(){
		System.out.println("A5:" + Thread.currentThread().getName());
		 try {
				
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	static synchronized void a6(){
		System.out.println("A6:" + Thread.currentThread().getName());
	}
}
 
 class MyThread1 implements Runnable{
	 A a;
	 public MyThread1(A a ){
		this.a=a;
	 }
	 @Override
	 public void run() {
		// a.a4();
		 A.a5();
		 //a.a1();
		// a.a4();
		/* try {
			Thread.currentThread().wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	 }

 }
 class MyThread2 implements Runnable{
	 A a;
	 public MyThread2(A a ){
		this.a=a;
	 }
	 @Override
	 public void run() {
		 A.a5();
		 //a.a1();
		// a.a4();
		 try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		/* try {
			Thread.currentThread().wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	 }

 }

public class ThreadExample {
public static void main(String[] args) {
	A a= new A();
	MyThread1 myThread1 = new MyThread1(a);
	Thread t1 = new Thread(myThread1,"t1");
	t1.start();
	MyThread2 myThread2 = new MyThread2(a);
	Thread t2 = new Thread(myThread2,"t2");
	
	t2.start();
	
}
	
}

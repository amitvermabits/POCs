package concurrent;

public class DeadlockExample {
	
	public void method1(){
		synchronized(String.class){
		System.out.println("Aquired lock on String.class object:" + Thread.currentThread().getId() );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (Integer.class) {
		System.out.println("Aquired lock on Integer.class object:" + Thread.currentThread().getId());
		}
		}
		}

		public void method2(){
		synchronized(Integer.class){
		System.out.println("Aquired lock on Integer.class object:" + Thread.currentThread().getId());

		synchronized (String.class) {
		System.out.println("Aquired lock on String.class object:" + Thread.currentThread().getId());
		}
		}
		}

		public static void main(String[] args) {
			
			final DeadlockExample test = new DeadlockExample();
	        new Thread(){
	            @Override
	            public void run(){
	              test.method1();
	              //test.method2();
	            }
	        }.start();
	      
	        new Thread(){
	            @Override
	            public void run(){
	              test.method2(); 
	            }
	        }.start();
	      
			
		}
	//	Read more: http://javarevisited.blogspot.com/2010/10/what-is-deadlock-in-java-how-to-fix-it.html#ixzz2vSKaXsOC

}

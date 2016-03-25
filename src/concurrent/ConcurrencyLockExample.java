package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import sun.awt.windows.ThemeReader;

public class ConcurrencyLockExample implements Runnable {
	
	 private Resource resource;
	 private Lock lock;
	     
	    public ConcurrencyLockExample(Resource r){
	        this.resource = r;
	        this.lock = new ReentrantLock();
	    }
	     
	    @Override
	    public void run() {
	        try {
	        	System.out.println("run:" + Thread.currentThread().getId());
	            lock.tryLock(10, TimeUnit.SECONDS);
	            resource.doSomething();Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }finally{
	            //release lock
	            lock.unlock();
	        }
	        resource.doLogging();
	    }

}

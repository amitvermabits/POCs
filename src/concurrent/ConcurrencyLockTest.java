package concurrent;

import sun.awt.windows.ThemeReader;

public class ConcurrencyLockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Resource resource = new Resource();
		ConcurrencyLockExample concurrencyLockExample = new ConcurrencyLockExample(resource);
		Thread t = new Thread(concurrencyLockExample);
		Thread t1 = new Thread(concurrencyLockExample);
		t.start();
		
		t1.start();
 
	}

}

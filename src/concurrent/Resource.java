package concurrent;

public class Resource {
	
	public  synchronized void foo(){
	    //do something
	    bar();
	  }
	 
	  public  synchronized void  bar(){
	    //do some more
	  }
	  
	  public void doSomething(){
	       System.out.println("dosomething:" + Thread.currentThread().getId());
	    }
	     
	    public void doLogging(){
	    	System.out.println("doLogging:" +  + Thread.currentThread().getId());
	    }
	

}

package oop;
import java.io.IOException;


abstract class A{
	void doSomething() throws  Exception{
		System.out.println("A");
	}
	
	 abstract  void compute();
		
	
}

class B extends A{

	public void doSomething() throws IOException{
		System.out.println("B");
	}
	@Override
	void compute() {
		System.out.println("Comp B");
		
	}
	
}

class C extends B{
	@Override
	void compute() {
		System.out.println("Comp C");
		
	}
}

public class InheritanceExample {
 public static void main(String[] args) {
	A a = new B();
	a.compute();
	B b = new C();
	b.compute();
	//C c = (C) new B();//error:B can not be cast to C
	C c = new C();
	c.compute();
}
}

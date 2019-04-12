//import java.util.*;
//import java.lang.*;
class MyThread extends Thread{
	public void run() {
		System.out.println("Child");
	}
}
public class ThreadDemo {
	public static void main(String args[]) {
		System.out.println(Thread.currentThread().getPriority());
		MyThread t=new MyThread();
		t.start();
		System.out.println(t.getPriority());
		System.out.println(Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(8);
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(t.getPriority());
		t.setPriority(10);
		System.out.println(t.getPriority());
	}
}

package chapter5;
import java.lang.reflect.*;
public class reflectionpractice {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * @param args
	 */
	private int number;
	private String nm;
	
	reflectionpractice(int i, String a){
		this.nm=a;
		this.number=i;
	}
	public class test{
		int anumber;
		String name;
		test(int i, String a){
			this.anumber=i;
			this.name=a;
		}
		/**
		 * 内部类的方法可以访问外部类的任意域， 因为没有任何关于类内部的access的限制。
		 * 因为内部类并不是静态的， 所以java还是会像其他非静态的attributes一样为内部类传递外部类的对象
		 * 引用， 这里用outerclass.this来标识这个对外部对象的引用。
		 * 如果为内部类传递一个其他外部类的对象， 那么这个内部类一样可以访问这个外部类的对象的attributes。
		 */
		public void accesstoouterclass(reflectionpractice r){
			System.out.println(reflectionpractice.this.nm);
			System.out.println(reflectionpractice.this.number);
			System.out.println(r.number);
			System.out.println(r.nm);		
			
		}
	}
	/**静态内部类和普通内部类的区别就是不需要给静态内部类传递外部类的对象。
	 */
	public static class test1{
		int anumber;
		String name;
		test1(int i, String a){
			this.anumber=i;
			this.name=a;
		}
		/**
		 * 内部类的方法可以访问外部类的任意域， 因为没有任何关于类内部的access的限制。
		 * 因为内部类并不是静态的， 所以java还是会像其他非静态的attributes一样为内部类传递外部类的对象
		 * 引用， 这里用outerclass.this来标识这个对外部对象的引用。
		 * 如果为内部类传递一个其他外部类的对象， 那么这个内部类一样可以访问这个外部类的对象的attributes。
		 */
		public void accesstoouterclass(reflectionpractice r){
			//System.out.println(reflectionpractice.this.nm);
			//System.out.println(reflectionpractice.this.number);
			System.out.println(r.number);
			System.out.println(r.nm);		
			
		}
	}
	
}


package chapter5;
import java.lang.reflect.*;
public class reflectionpractice {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		reflectionpractice r1= new reflectionpractice(1,"a");
		//一共有三种方式获得Class类的实例, java为每一个对象保持class对象, 类型相同的实例共享一个class.
		Class cls=r1.getClass();
		//通过对象获得Class对象
		System.out.println(cls.equals(Class.forName("chapter5.reflectionpractice")));
		//通过Class.forName方法得到class对象
		System.out.println(cls.equals(reflectionpractice.class));
		//通过类名得到Class
		//reflectionpractice r2=(reflectionpractice) cls.newInstance();
		//newInstance只能调用不带参数的默认构造器, 如果美柚默认构造器就会跑出一个异常.
		System.out.println(cls.getName());
		//得到类的名称
		Constructor[] constructors=cls.getDeclaredConstructors();
		System.out.println(constructors.length);
		for(int i=0; i<constructors.length;i++){
			System.out.println("Constructors:\n");
			System.out.println(constructors[i].getDeclaringClass().getName());
			System.out.println(constructors[i].isAccessible());
			System.out.println(constructors[i].toString());
			System.out.println(constructors[i].getName());
			System.out.println(constructors[i].getParameterTypes()[0]);
			System.out.println(constructors[i].getClass());
			//System.out.println(constructors[i].getExceptionTypes());
			//System.out.println(constructors[i].getGenericParameterTypes());
			System.out.println();
		}
		Object[] paras= {(Object) new Integer(2),(Object) "k"};
		reflectionpractice r=(reflectionpractice)constructors[0].newInstance(paras);
		//在Constructor的instance中调用newInstance这个method可以调用带参数的constructor.
		System.out.println(r.getClass());
		
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


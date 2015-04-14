package chapter4;

class A{}
//可以在同一文件中定义其他的非public类。
public class privateandpublic {

	private int anumber;
	int bnumber=10;
	private static int nums=100;
	{bnumber=100;
	nums=1;//可以在非静态模块之中对静态数据进行操作。
	}//这个模块只有在有对象被初始化的时候才会执行
	
	static{
		nums++;
		//bnumber=100;
		//无法进行这种操作， 因为bnumber是应该与某一个对象具体相关的 而静态模块之中并没有具体对象的引用（this）。
	}//只在类第一次被load进来的时候执行。
	privateandpublic(int i, int j){
		anumber=i;
		bnumber=j;
	}
	/**
	 * 静态类没有默认传递进来的this参数， 如果给静态类传递一个对象引用参数（本类或者非本类）。
	 * 如果传递的是本类的参数， 那么静态method一样可以操作本类的所有method和private fields。
	 */
	public static void ope(privateandpublic o){
		//o.anumber=20;
		System.out.println(o.anumber);
	}
	private class Aa{}
	//private类。
public int accesstoanotherobject(privateandpublic o){
	//每一个非静态类的参数部分都带有一个默认的this参数， 代表调用此method的当前对象。
	return(o.anumber);
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(privateandpublic.nums);
		
		//privateandpublic a1= new privateandpublic();
		//因为已经定义了带有int参数的constructor， 所以默认的constructor不再有效。
		privateandpublic a= new privateandpublic(1,11);
		privateandpublic b= new privateandpublic(2,22);
		System.out.println(a.accesstoanotherobject(a));
		System.out.println(a.accesstoanotherobject(b));
		//private的定义是以类为边界的， 也就是说通过A类的某一对象a的method可以access 
		//A类的另外一个对象b的private fields。所以不存在private的类， 因为private
		//是以类为边界， 除非在某一非private的类中定义一个private类。
		System.out.println(a.bnumber);
		//当修饰符为空时， 就是在以包为界定， 包内可见。
		//public就是对所有的类都可见
		System.out.println(privateandpublic.nums);
		//因为有新的对象被实例化， 所以实例模块的赋值被执行了 nums的值由101被赋值为1.
		privateandpublic.ope(a);
		
	}
	

}


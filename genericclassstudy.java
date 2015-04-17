package genericclass;
import chapter4.*;
import chapter5.*;
import java.lang.reflect.*;
public class genericclassstudy<T, U> {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		privateandpublic p= new privateandpublic(1,2);
		reflectionpractice r= new reflectionpractice(1,"a");
		genericclassstudy<privateandpublic,reflectionpractice> g= new genericclassstudy(p,r);
		p.setanumber(10);
		p.setbnumber(20);
		r.setnm("changed");
		r.setnumber(100);
		System.out.println(g.f1);
		//因为main函数还是在类内部的， 所以可以成功。
		System.out.println(g.getf1().getanumber());
		System.out.println(g.getf1().getbnumber());
		System.out.println(g.getf2().getnm());
		System.out.println(g.getf2().getnumber());
		genericclassstudy[] a=new genericclassstudy[10];
		a[0]=new genericclassstudy<Integer,String>(new Integer(1),"as");
		a[1]=new genericclassstudy<String,String>("a","as");
		//数组只能限制擦除之后的原始类的类型， 对于原始类之中的类型参数无能为力。
		//Field f= a[1].getf1().getClass().getDeclaredField("f1");
		//System.out.println(f.getName());
	    System.out.println(a[0].getf1().getClass()+"  "+ a[1].getf1().getClass());
	    genericclassstudy g1= a[0];
	    genericclassstudy g2=a[1];
	    System.out.println(g1.getf1().toString());
	    
	    genericclassstudy<String,String>[] a1=new genericclassstudy[10];
	    a1[0]=new genericclassstudy("","");
	    a1[1]=new genericclassstudy("",new Double(2.1));
	    System.out.println(a1[0].getf2().getClass());
	    //System.out.println(a1[1].getf2().getClass());
	    //编译时不报错 但是运行时就会报错。
	    //ava.lang.Double cannot be cast to java.lang.String
		//at genericclass.genericclassstudy.main(genericclassstudy.java:42)
	    
	    genericclassstudy<String,Integer>[] test= new genericclassstudy[10];
	    test[0]=new genericclassstudy("",new Integer(1));
	    test[1]=new genericclassstudy("aaa","");
	    /*genericclassstudy<String,Integer> t11= new genericclassstudy("hello",new Integer(2));
	    genericclassstudy t12= new genericclassstudy("hi","lllll");
	    System.out.println(t12.getf2());
	    t12=t11;
	    //合法， 因为t12没有声明泛型类型
	    System.out.println(t12.getf2());
	    */
	    
	    /*genericclassstudy<String,Integer> t11= new genericclassstudy("hello",new Integer(2));
	    genericclassstudy t12= new genericclassstudy("hi","lllll");
	    System.out.println(t11.getf2());
	    t11=t12;
	    //合法， 因为t12没有声明泛型类型
	    System.out.println(t11.getf2());*/
	    
	    /*genericclassstudy<String,Integer> t11= new genericclassstudy("hello",new Integer(2));
	    genericclassstudy<String,String> t12= new genericclassstudy("hi","lllll");
	    //t11=t12;
	    //Type mismatch: cannot convert from genericclassstudy<String,String> to 
		//genericclassstudy<String,Integer>*/
	    
	    /*genericclassstudy<String,Integer> t11= new genericclassstudy("hello",new Integer(2));
	    genericclassstudy t12= new genericclassstudy<String,String>("hi","lllll");
	    System.out.println(t12.getf2());
	    t12=t11;
	    //合法， 因为t12没有声明泛型类型
	    System.out.println(t12.getf2());*/
	    
	    /*以上例子说明， 泛型信息只有在声明变量之时才能导入编译器*/
	    System.out.println("hi");
	    System.out.println(a[0].newf1());
	    
	}
	private T f1;
	private U f2;
	genericclassstudy(T a, U q){
		f1=a;
		f2=q;
	}
	public T getf1(){
		return(f1);
	}
	public U getf2(){
		return(f2);
	}
	public void setf1(T f){
		f1=f;
	}
	public void setf2(U f){
		f2=f;
	}
	public T newf1() throws Exception{
		Class cls=f1.getClass();
		/*System.out.println(cls.getConstructors().length);
		for(int i=0;i<cls.getConstructors().length;i++){
			String paras="";
			for(int j=0;j<cls.getConstructors()[i].getParameterTypes().length;j++)
			paras=paras+ "  "+ cls.getConstructors()[i].getParameterTypes()[j];
			System.out.println(paras);
		}*/
		System.out.println(cls.getConstructor(int.class).newInstance(3841));
		//return(cls.newInstance());
		//Type mismatch: cannot convert from Object to T
		return(f1);
	}

	

}


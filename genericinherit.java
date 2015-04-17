package genericclass;
import java.lang.reflect.*;
import chapter4.privateandpublic;
import chapter5.reflectionpractice;
public class genericinherit extends genericclassstudy<privateandpublic,reflectionpractice>{

	/**
	 * @param args
	 */
	
	genericinherit(privateandpublic p,reflectionpractice r){
		super(p,r);
	}
	public privateandpublic getf1(){
		return(super.getf1());
	}
	public void setf1(privateandpublic f){
		super.setf1(f);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		privateandpublic p= new privateandpublic(1,2);
		reflectionpractice r= new reflectionpractice(1,"a");
		genericclassstudy<privateandpublic,reflectionpractice> g= new genericinherit(p,r);
		System.out.println(g);
		Class cls=g.getClass();
		Method[] m= cls.getMethods();
		System.out.println(m.length);
		
		System.out.println("Methods:");
		
		for(int i=0;i<m.length;i++){
			System.out.println(m[i].getName());
			//method name
			System.out.println(m[i].getReturnType().toString());
			//return type
			Class[] cl=m[i].getParameterTypes();
			String paras="";
			for(int j=0;j<cl.length;j++)
			paras= paras+ " "+cl[j].getName();
			System.out.println(paras);
			//parameter types
			
		}
		System.out.println(g.getf1());
		
		
		
		
		
	}

}


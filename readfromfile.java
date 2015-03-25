import java.io.*;
import java.net.URI;
import java.util.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
public class readfromfile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
Configuration conf= new Configuration();
FileSystem fs= FileSystem.get(URI.create(args[0]),conf);
FSDataInputStream in=fs.open(new Path(args[0]));
Scanner sc= new Scanner(in);
while(sc.hasNextInt())
	System.out.println(sc.nextLine());
	}

}

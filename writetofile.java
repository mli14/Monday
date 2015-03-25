import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.conf.*;
public class writetofile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Configuration conf= new Configuration();
FileSystem fs= FileSystem.get(conf);
FSDataOutputStream out=fs.create(new Path(args[0]));//.create(URI.create(args[0]));
out.writeChars("Write a String");
out.writeDouble(14.44);
out.writeChar('e');
out.writeLong(14);
out.close();


	}

}


import java.io.IOException;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.conf.*;
public class copyfromlocal {

	static {
		System.out.println("copyfromlocal\n");
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Configuration conf=new Configuration();
FileSystem hdfs= FileSystem.get(conf);
FileSystem local=FileSystem.getLocal(conf);
FSDataInputStream in=local.open(new Path("/home/mark/data"));
FSDataOutputStream out= hdfs.create(new Path("/mark/data"));
IOUtils.copyBytes(in, out, conf);
in.close();
out.close();

	}

}


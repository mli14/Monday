import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.conf.*;
public class copyfile {

	static {
		System.out.println("copyfromlocal\n");
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
Configuration conf=new Configuration();
FileSystem local= FileSystem.get(URI.create(args[0]),conf);
FileSystem hdfs=FileSystem.get(URI.create(args[1]),conf);
FSDataInputStream in=local.open(new Path(args[0]));
FSDataOutputStream out= hdfs.create(new Path(args[1]));
IOUtils.copyBytes(in, out, conf);
in.close();
out.close();

	}

}


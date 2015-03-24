import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;
import java.net.*;
import java.io.*;
public class  FileSystemCat{
public static void main(String[] args) throws Exception{
String uri =args[0];
Configuration conf = new Configuration();
FileSystem fs= FileSystem.get(URI.create(uri), conf);
InputStream in= null;
try{
in= fs.open(new Path(uri));
IOUtils.copyBytes(in, System.out, 4096, false);

    }finally{
IOUtils.closeStream(in);
}
  }
}

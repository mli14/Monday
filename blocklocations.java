import java.io.IOException;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
public class blocklocations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//BlockLocation bl=new BlockLocation();
//System.out.println(bl.getHosts());

Configuration conf = new Configuration();
FileSystem fs = FileSystem.get(conf);
//必须是一个具体的文件
Path path = new Path("/FileSystemCat.java");
//文件状态
FileStatus fileStatus = fs.getFileStatus(path);
//FileStatus describes meta data of files.
System.out.println("#################################################\nfileStatus starts:");
System.out.println(fileStatus.getBlockSize());
//num of bytes
System.out.println(fileStatus.getAccessTime());
//the access time of file in milliseconds since January 1, 1970 UTC. (Same for modificationtime)
System.out.println(fileStatus.getPath());
System.out.println(fileStatus.getPermission());
System.out.println(fileStatus.getReplication());
System.out.println(fileStatus.getOwner());
System.out.println(fileStatus.getGroup());
System.out.println("fileStatus ends.\n#########################################################");
//文件块
BlockLocation[] blockLocations=fs.getFileBlockLocations(fileStatus, 0,fileStatus.getLen());
int blockLen = blockLocations.length;
System.out.println(blockLen);
for(int i=0;i<blockLen;i++){
//主机名
String[] hosts = blockLocations[i].getHosts();
for(String host:hosts){
    System.out.println(host);
}
}
	}

}


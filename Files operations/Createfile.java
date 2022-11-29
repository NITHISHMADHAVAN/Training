package createfile;
import java.io.File;
import java.io.IOException;
public class Createfile {
public static void main(String[] args) throws IOException {
	File file=new File("C:\\java file\\msf.txt");
	if(file.exists())
	{
	System.out.println("the file is already exixts");

	}
	else {
		file.createNewFile();
		System.out.println("File created at "+file.getPath());
}
}
}

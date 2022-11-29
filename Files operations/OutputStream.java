import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class OutputStream {
public static void main(String[] args) throws IOException {
	
	File file =new File("msf4.txt");
	file.createNewFile();
	 FileOutputStream out = new FileOutputStream("msf4.txt");
	 String str="Hello JAVA";
	 out.write(str.getBytes());
	 out.writeInt();
	 out.flush();
	 out.close();
}
}

	
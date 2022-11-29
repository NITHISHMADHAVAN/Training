
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReaderandWriter 
{
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String Str=br.readLine();
		System.out.println(Str);
		
		File file=new File("msf5.txt");
		file.createNewFile();
		System.out.println("DONE");
		BufferedWriter bw=new BufferedWriter(new FileWriter(file));
		bw.write(Str);
		bw.flush();
		bw.close();
		}
}

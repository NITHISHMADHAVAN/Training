import java.io.File;
public class DirectoryCreation {
	public static void main(String[] args) {
		File file=new File("C:\\DirectorySample");
		file.mkdir();
		if(file.exists())
		{
			System.out.println("Directory Created");
		}
		else
		{
			System.out.println("Directory not created");
		}
		
	}

}

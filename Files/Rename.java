import java.io.File;

public class Rename {
	public static void main(String[] args)
	{
		File file=new File("C:\\java file\\msf.txt"); //current name
		File file2=new File("C:\\java file\\msf2.txt");// new rename 
		//File file= new File(args[0]);
	    //File file2= new File(args[1]);
		if(file.exists()) {
		file.renameTo(file2); //file rename
		System.out.println(file.getName()+" was renamed sucessfully");
		}
		else
		{
			System.out.println("File was not renamed");
		}
// delete the rename
	if(file2.delete())
	{
		System.out.println("the renamed file was deleted");
	}
	else
	{
		System.out.println("file can't deleted");
	}
}
}
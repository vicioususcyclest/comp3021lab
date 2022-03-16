package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;




public class TextNote extends Note {
	
	public String content;
	private static final long serialVersionUID = 1L;
	
	public TextNote(String title) {
		super(title);
	}
	
	public TextNote(String title, String content) {
		super(title);
		this.content=content;
	}
	
	public TextNote(File f) {
		super(f.getName());
		this.content = getTextFromFile(f.getAbsolutePath());
	}
	
	private String getTextFromFile(String absolutePath) {
		String result = "";
		int i = 0;
		try{
			FileInputStream fis = new FileInputStream(absolutePath);
			while ((i=fis.read())!=-1)
			{
				result += Character.toString((char)i);
			}
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return result;
	}
	
	public void exportTextToFile(String pathFolder) {
		if(pathFolder == "")
			pathFolder = ".";
		File file = new File(pathFolder + File.separator + this.getTitle().replaceAll(" ","_") + ".txt");
		try { 
		FileWriter myWriter = new FileWriter(file);
		BufferedWriter bfWriter = new BufferedWriter(myWriter);
		bfWriter.write(content);
		bfWriter.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

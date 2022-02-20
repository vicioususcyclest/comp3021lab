package base;

import java.util.ArrayList;
import java.util.Objects;

public class NoteBook {

	private ArrayList<Folder> folders;
	
	public NoteBook() {
		==============
	}
	
	public boolean createTextNote(String folderName ,String title) {
			TextNote note = new TextNote(title);
			return insertNote(folderName, =====)
	}
	
	public boolean createImageNote(String folderName,String title) {
			ImageNote note = new ImageNote(title);
			return insertNote(folderName, =====)
		
	}
	
	public ArrayList<Folder> getFolders(){
		return folders;
	}
	
	public boolean insertNote(String,Note) {
		
	}

}

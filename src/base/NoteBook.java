package base;

import java.util.ArrayList;
import java.util.Objects;

public class NoteBook {

	private ArrayList<Folder> folders;
	
	public NoteBook() {
		folders = new ArrayList<Folder>();
	}
	
	public boolean createTextNote(String folderName ,String title) {
			TextNote note = new TextNote(title);
			return insertNote(folderName, note);
	}
	
	public boolean createImageNote(String folderName,String title) {
			ImageNote note = new ImageNote(title);
			return insertNote(folderName, note);
		
	}
	
	public ArrayList<Folder> getFolders(){
		return folders;
	}
	
	public boolean insertNote(String title, Note note) {
		Folder f = null;
		for (Folder f1 : folders) {
			if(f1.getName() == title) {
				getFolders();
				f = f1;
				}
			}
		if (f == null) {
				Folder newf = new Folder(title);
				f = newf;
				folders.add(newf);
		}
		for (Note n: f.getNotes()) {
			if(Folder.name.equals(n.))
		}
		if
		
	}

}

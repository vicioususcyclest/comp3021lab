package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
			if(note.title.equals(n.title))
				{System.out.println("Creating note "+note.getTitle()+" under folder" + f.getName() + " failed");
				return false;}
		}
		f.getNotes().add(note);
		return true;
		
	}
	
	public List<Note> searchNotes(String keywords){
		List<Note> notelist_temp = new ArrayList<Note>();
		for(Folder f2 : folders) {
			notelist_temp.addAll(f2.searchNotes(keywords));
		}
		return notelist_temp;
	}
	
	public boolean createTextNote(String folderName, String title, String content) {
		TextNote note = new TextNote(title, content);
		return insertNote(folderName, note);
	}
	
	public void sortFolders() {
		for(Folder f3 : folders) {
			f3.sortFolder();
			Collections.sort(folders);
		}
	}
}

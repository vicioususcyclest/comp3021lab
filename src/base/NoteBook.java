package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NoteBook implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Folder> folders;
	
	public NoteBook() {
		folders = new ArrayList<Folder>();
	}
	
	public NoteBook(String file) {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(file);
			in = new ObjectInputStream(fis);
			//System.out.println(in.readObject());
            NoteBook n = (NoteBook) in.readObject();
			//NoteBook n = new NoteBook();
            in.close(); 
            folders = n.folders;
		}catch(Exception e) {
			e.printStackTrace();
		}
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
		}
		Collections.sort(folders);
	}
	
	public boolean save(String file) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
		fos = new FileOutputStream(file);
		out = new ObjectOutputStream(fos);
		out.writeObject(this);
		out.close();
		}catch(Exception e){
		    e.printStackTrace();
			return false;
		}
		return true;
	}
	

}

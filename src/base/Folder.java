package base;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Date;
import java.util.List;


public class Folder implements Comparable<Folder>,Serializable{

	private ArrayList<Note> notes;
	private String name;
	private static final long serialVersionUID = 1L;
	
	public Folder(String name) {
		this.name = name;
		notes = new ArrayList<Note>();
	}
	public void addNote(Note note) {
		notes.add(note);
	}
	public String getName(){
		return name;
	}
	public ArrayList<Note> getNotes(){
		return notes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folder other = (Folder) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		int nText = 0;
		int nImage = 0;
		
		for (Note n : notes)
		{
			if(n instanceof TextNote)
				nText++;
				else if(n instanceof ImageNote)
					nImage++;

		}
			
		return name + ":" + nText + ":" + nImage;
	}
	@Override
	public int compareTo(Folder o){
		return name.compareTo(o.name);
	}
	
	public void sortFolder() {
		Collections.sort(notes);
	}
	
	public List<Note> searchNotes(String keywords){
		List<Note> notestemp = new ArrayList<Note>();
		keywords = keywords.toLowerCase();
		String[] keywordstemp = keywords.split(" ");
		
		int i = 0;
		List<String> keyword_list = new ArrayList<String>();
		
		while (i < keywordstemp.length)
		{
			if (i < keywordstemp.length-2 && keywordstemp[i+1].equals("or"))
			{
				keyword_list.add(keywordstemp[i]+" "+keywordstemp[i+2]);
				i = i +3;
			}
			else
			{
				keyword_list.add(keywordstemp[i]);
				i = i +1;
			}
		}
		
		for (Note n : notes)
		{	
			String key1 = new String();
			String key2 = new String();
			
			for(String k:keyword_list) {
				
				if(k.contains(" "))
				{
					key1 = k.substring(0,k.indexOf(" "));
					key2 = k.substring(k.indexOf(" ")+1);
					if(n instanceof TextNote) 
					{
						if(n.title.toLowerCase().contains(key1) == true || n.title.toLowerCase().contains(key2) == true)
						{
							if(k.compareTo(keyword_list.get(keyword_list.size()-1)) == 0)
							{
								notestemp.add(n);
							}
							else continue;	
						}
						else if (((TextNote)n).content.toLowerCase().contains(key1) == true || ((TextNote)n).content.toLowerCase().contains(key2) == true)
						{
							if(k.compareTo(keyword_list.get(keyword_list.size()-1)) == 0)
							{
								notestemp.add(n);
							}
							else continue;	
						}
						else break;
					}
					else if(n instanceof ImageNote)
						if(n.title.toLowerCase().contains(key1) == true || n.title.toLowerCase().contains(key2) == true)
						{
							if(k.compareTo(keyword_list.get(keyword_list.size()-1)) == 0)
							{
								notestemp.add(n);
							}
							else continue;	
						}
						else break;
				}
				else {
						if(n instanceof TextNote) 
						{
							if(n.title.toLowerCase().contains(k) == true)
							{
								if(k.compareTo(keyword_list.get(keyword_list.size()-1)) == 0)
								{
									notestemp.add(n);
								}
								else continue;	
							}
							else if (((TextNote)n).content.toLowerCase().contains(k) == true)
							{
								if(k.compareTo(keyword_list.get(keyword_list.size()-1)) == 0)
								{
									notestemp.add(n);
								}
								else continue;	
							}
							else break;
						}
						else if(n instanceof ImageNote) {
							if(n.title.toLowerCase().contains(k) == true)
							{
								if(k.compareTo(keyword_list.get(keyword_list.size()-1)) == 0)
								{
									notestemp.add(n);
								}
								else continue;	
							}
							else break;
						}
					}
			
				
				}
			}
		
		return notestemp;
	}
}
	



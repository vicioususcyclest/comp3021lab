package base;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Note implements Comparable<Note>,java.io.Serializable{
	
	public java.util.Date date;
	public String title;
	private static final long serialVersionUID = 1L;
	
	public Note(String title) {
		this.title = title;
		date = new java.util.Date(System.currentTimeMillis());
	}
	
	public String getTitle(){
		return title;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(title, other.title);
	}

	@Override
	public int compareTo(Note o) {
		return date.compareTo(o.date);
	}
	
	public String toString() {
		return date.toString() + "\t" + title;
	}
}






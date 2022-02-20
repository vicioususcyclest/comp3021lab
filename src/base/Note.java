package base;

import java.util.Objects;

public class Note {
	
	private java.util.Date date;
	private String title;
	
	public Note(String title) {
		this.title = title;
		date = new java.util.Date(System.currentTimeMillis());
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
}






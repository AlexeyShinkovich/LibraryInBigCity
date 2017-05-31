package by.htp.author;

public class Author implements Comparable<Author> {
	private String name;
	private String surname;
	private int dateOfBirth;

	public Author(String surname) {
		this.surname = surname;
	}

	public Author(String name, String surname, int dateOfBirth) {
		super();
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String toString() {
		if (name == null) {
			return surname;
		} else {
			return name + " " + surname + " " + dateOfBirth;
		}
	}

	@Override
	public int compareTo(Author o) {
		return this.name.compareTo(o.name);
	}

}

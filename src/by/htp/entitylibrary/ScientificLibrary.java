package by.htp.entitylibrary;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import by.htp.entitypublication.PrintedPublication;

public class ScientificLibrary extends Library implements Comparable<Library> {
	
	private Set<PrintedPublication> scientificWorks = new HashSet<PrintedPublication>();

	public ScientificLibrary(String address, String name) {
		super(LibraryType.SCIENTIFIC, address, name);
	}

	public void addBook(PrintedPublication book) {
		scientificWorks.add(book);
	}

	public void viewBook() {
		Iterator<PrintedPublication> a = scientificWorks.iterator();
		while (a.hasNext()) {
			PrintedPublication text = a.next();
			System.out.println(text);
		}
	}

	@Override
	public void delBook(String title) {
		Iterator<PrintedPublication> a = scientificWorks.iterator();
		while (a.hasNext()) {
			PrintedPublication text = a.next();
			if (text.getTitle().equals(title)) {
				a.remove();
			}
		}
	}

	@Override
	public void searchBook(String title) {
		Iterator<PrintedPublication> a = scientificWorks.iterator();
		while (a.hasNext()) {
			PrintedPublication text = a.next();
			if (text.getTitle().equals(title)) {
				System.out.println("This book find in ScientificLibrary");
				System.out.println(text.toString());
			}
		}
	}

	@Override
	public void searchBookByAuthorTitle(String... text) {
		String[] authorTitle = text;
		Iterator<PrintedPublication> a = scientificWorks.iterator();
		while (a.hasNext()) {
			PrintedPublication book = a.next();
			if (authorTitle[0].equals(book.getAuthor().getSurname())
					&& authorTitle[1].equalsIgnoreCase(book.getTitle())) {
				System.out.println("This book find in ScientificLibrary");
				System.out.println(book.toString());
			}
		}
	}

	public void sortByTitle() {
		Set<PrintedPublication> a = new TreeSet<PrintedPublication>(new ComparatorByTitle());
		a.addAll(scientificWorks);
		System.out.println(a);
	}

	public void sortByAll() {
		Set<PrintedPublication> a = new TreeSet<PrintedPublication>(new ComparatorByAll());
		a.addAll(scientificWorks);
		System.out.println(a);
	}

	@Override
	public int compareTo(Library o) {
		return this.getName().compareTo(o.getName());
	}
}
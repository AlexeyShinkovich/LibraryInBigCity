package by.htp.entitylibrary;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import by.htp.entitypublication.PrintedPublication;

public class ChildrenLibrary extends Library {
	
	private List<PrintedPublication> childrenBook = new LinkedList<PrintedPublication>();
	
	public ChildrenLibrary(String address, String name) {
		super(LibraryType.CHILDREN, address, name);
	}



	public void addBook(PrintedPublication book) {
		childrenBook.add(book);
	}

	public void viewBook() {
		Iterator<PrintedPublication> a = childrenBook.iterator();
		while (a.hasNext()) {
			PrintedPublication text = a.next();
			System.out.println(text);
		}
	}

	public void delBook(String title) {
		Iterator<PrintedPublication> a = childrenBook.iterator();
		while (a.hasNext()) {
			PrintedPublication text = a.next();
			if (text.getTitle().equals(title)) {
				a.remove();
			}
		}

	}

	public void searchBook(String title) {
		Iterator<PrintedPublication> a = childrenBook.iterator();
		while (a.hasNext()) {
			PrintedPublication text = a.next();
			if (text.getTitle().equals(title)) {
				System.out.println("This book find in ChildrenLibrary");
				System.out.println(text);
			}
		}
	}

	@Override
	public void searchBookByAuthorTitle(String... text) {
		String[] authorTitle = text;
		Iterator<PrintedPublication> a = childrenBook.iterator();
		while (a.hasNext()) {
			PrintedPublication book = a.next();
			if (authorTitle[0].equals(book.getAuthor().getSurname()) && authorTitle[1].equals(book.getTitle())) {
				System.out.println("This book find in ChildrenLibrary");
				System.out.println(book.toString());
			}
		}
	}

	@Override
	public void sortByTitle() {
		Set<PrintedPublication> a = new TreeSet<PrintedPublication>(new ComparatorByTitle());
		a.addAll(childrenBook);
	}

	@Override
	public void sortByAll() {
		Set<PrintedPublication> a = new TreeSet<PrintedPublication>(new ComparatorByAll());
		a.addAll(childrenBook);
	}
}

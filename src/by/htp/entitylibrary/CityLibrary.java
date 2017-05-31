
package by.htp.entitylibrary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import by.htp.entitypublication.PrintedPublication;

public class CityLibrary extends Library implements Comparable<Library> {

	public CityLibrary(String address, String name) {
		super(LibraryType.CITY, address, name);
	}

	private Map<PrintedPublication, Integer> publications = new HashMap<PrintedPublication, Integer>();

	@Override
	public void addBook(PrintedPublication book) {
		if (publications.containsKey(book)) {
			publications.put(book, publications.get(book) + 1);
		} else {
			publications.put(book, 1);
		}
	}

	public void viewBook() {
		for (Entry<PrintedPublication, Integer> entry : publications.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	@Override
	public void delBook(String title) {
		Iterator<Entry<PrintedPublication, Integer>> iterator = publications.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<PrintedPublication, Integer> entry = iterator.next();
			if (entry.getKey().getTitle().equals(title)) {
				iterator.remove();
			}
		}
	}

	@Override
	public void searchBook(String title) {
		for (Entry<PrintedPublication, Integer> entry : publications.entrySet()) {
			if (entry.getKey().getTitle().equals(title)) {
				System.out.println("This book find in CityLibrary");
				System.out.println(entry.getKey().toString() + " - " + entry.getValue());
			}
		}
	}

	@Override
	public void searchBookByAuthorTitle(String... text) {
		String[] authorTitle = text;
		for (Entry<PrintedPublication, Integer> entry : publications.entrySet()) {
			if (entry.getKey().getAuthor().getSurname().equals(authorTitle[0])
					&& entry.getKey().getTitle().equals(authorTitle[1])) {
				System.out.println("This book find in CityLibrary");
				System.out.println(entry.getKey().toString());
			}
		}
	}

	public void sortByTitle() {
		Map<PrintedPublication, Integer> a = new TreeMap<PrintedPublication, Integer>(new ComparatorByTitle());
		a.putAll(publications);
		System.out.println(a.keySet());
	}

	@Override
	public void sortByAll() {
		Map<PrintedPublication, Integer> a = new TreeMap<PrintedPublication, Integer>(new ComparatorByAll());
		a.putAll(publications);
		System.out.println(a.keySet());
	}

	@Override
	public int compareTo(Library o) {
		return this.getName().compareTo(o.getName());
	}
}

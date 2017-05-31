package by.htp.entitylibrary;

import java.util.Comparator;

import by.htp.entitypublication.PrintedPublication;

public class ComparatorByTitle implements Comparator<PrintedPublication> {

	@Override
	public int compare(PrintedPublication o1, PrintedPublication o2) {
		String str1 = o1.getTitle();
		String str2 = o2.getTitle();
		return str1.compareTo(str2);
	}
}

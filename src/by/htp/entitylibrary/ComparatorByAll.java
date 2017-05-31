package by.htp.entitylibrary;

import java.util.Comparator;

import by.htp.entitypublication.PrintedPublication;

public class ComparatorByAll implements Comparator<PrintedPublication> {

	@Override
	public int compare(PrintedPublication o1, PrintedPublication o2) {
		int compareTo = o1.getTitle().compareTo(o2.getTitle());
		if (compareTo != 0) {
			return compareTo;
		} else if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
			return o1.getYear() - o2.getYear();
		}
		return o1.getAuthor().compareTo(o2.getAuthor());
	}
}

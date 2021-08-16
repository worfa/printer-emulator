package demidovTestProject.test.project.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import demidovTestProject.test.project.model.AbstractDocument;

public class SortedPrintedList {

	public List<AbstractDocument> sort(List<AbstractDocument> list, int method) {
		switch(method) {
		case 1: 
			break;
		case 2: 
			Collections.sort(list, new Comparator<AbstractDocument>() {
				public int compare(AbstractDocument o1, AbstractDocument o2) {
					return o1.getNameTypeDoc().compareTo(o2.getNameTypeDoc());
				}
			});
			break;
		case 3:
			Collections.sort(list, new Comparator<AbstractDocument>() {
				public int compare(AbstractDocument o1, AbstractDocument o2) {
					return o1.getPaperSize().compareTo(o2.getPaperSize());
				}
			});
			break;
		case 4: 
			Collections.sort(list, new Comparator<AbstractDocument>() {
				public int compare(AbstractDocument o1, AbstractDocument o2) {
					return Double.valueOf(o1.getPrintTime()).compareTo(Double.valueOf(o1.getPrintTime()));
				}
			});
			break;
		}
		
		return list;
	}
}

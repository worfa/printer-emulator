package demidovTestProject.test.project.service;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import demidovTestProject.test.project.model.AbstractDocument;
import demidovTestProject.test.project.model.TypeDoc;

public class PaperManager {

	SortedPrintedList sortPrinted = new SortedPrintedList();
	private static List<AbstractDocument> printedList = new ArrayList<>();
	private static Deque<AbstractDocument> deque = new LinkedList<AbstractDocument>();
	private static List<AbstractDocument> tempDeque = new ArrayList<AbstractDocument>();
	private static boolean checkDeque = false;
	private static boolean checkExit = false;
	FactoryDoc factoryDoc = new FactoryDoc();
	
	public PaperManager() {
		Printer.startPrint();
	}
	
	public List<AbstractDocument> stop(){
		checkDeque = false;
		tempDeque.clear();
		tempDeque.addAll(deque);
		deque.clear();
		return tempDeque;
	}
	
	public AbstractDocument addDocument(TypeDoc type) {
		deque.addLast(factoryDoc.createDocument(type));
		checkDeque = true;
		return deque.getLast();
	}
	
	public void addDocument(List<AbstractDocument> listAbDoc) {
		deque.addAll(listAbDoc);
	}
	
	public void clearLastDoc() {
		if(!deque.isEmpty()) {
			deque.removeLast();
		}else {
			System.out.println("Документов нет!");
		}
	}
	
	public List<AbstractDocument> getPritedList(int method) {
		return sortPrinted.sort(new ArrayList<AbstractDocument>(printedList), method);
	}
	
	public void exit() {
		checkExit = true;
	}
	
	private static class Printer {
		
		private static void startPrint() {
			Runnable print = () -> {
				while(!checkExit) {
					Thread.currentThread().isAlive();
					while(checkDeque) {
						if(!deque.isEmpty()) {
						try {
							Thread.sleep((long) (1000*deque.getFirst().getPrintTime()));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
							printedList.add(deque.pollFirst());
							System.out.println("печать документа");
						}else {
							checkDeque = false;
						}
					}
				}
			};
			
			Thread thread = new Thread(print);
			thread.start();
		}
	}
}

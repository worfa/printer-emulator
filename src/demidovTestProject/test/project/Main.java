package demidovTestProject.test.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demidovTestProject.test.project.model.AbstractDocument;
import demidovTestProject.test.project.model.TypeDoc;
import demidovTestProject.test.project.service.PaperManager;

public class Main {
	
	public static void main(String [] args) {
		System.out.println("�������� ������ ���������� ������!");
		PaperManager paperManager = new PaperManager();
		Scanner scan = new Scanner(System.in);
		String choose = "";
		
		while(choose != "exit") {
			
			System.out.println("������� ��������� ��� ������: "
					+ "�reate.�������� �������� \n "
					+ "create list.�������� ���� ���������� ��������� �������� \n " 
					+ "delete.������� ��������� ���������� ��������n\n "
					+ "get printed.�������� ������������ ���������\n "
					+ "stop print.��������� ������\n "
					+ "exit.��������� ���������");
			
			choose = scan.nextLine();
			switch(choose) {
			
			case "create": 
				System.out.print("������ ��������, ������� ������ ������� �� ������: txt, pdf, csv: ");
				scan.reset();
				choose = scan.nextLine();
				try {
					paperManager.addDocument(TypeDoc.valueOf(choose.toUpperCase()));
				}catch(IllegalArgumentException e){
					System.out.println("������������ �������!");
					break;
				}
				break;
				
			case "delete": 
				paperManager.clearLastDoc();
				System.out.println("������ ��������� ��������!");
				break;
			
			case "get printed": 
				System.out.println("�������� ��� �� ������ �������� ������������ ��������� 1.�� ������� ������ \n "
						+ "2.�� ���� ���������� \n"
						+ "3.�� ������� ������ \n "
						+ "4.�� ������� ������");
				scan.reset();
				choose = scan.nextLine();
				try {
				for(AbstractDocument doc :paperManager.getPritedList(Integer.valueOf(choose))) {
					System.out.println(doc);
				}
				}catch(IllegalArgumentException e) {
					System.out.println("������������ �������!");
					break;
				}
				break;
				
			case "stop print": 
				System.out.println("������ �����������. �� ������������ ���������: ");
				for(AbstractDocument doc : paperManager.stop()) {
					System.out.println(doc);
				}
				break;
				
			case "create list":
				List<AbstractDocument> listDoc = new ArrayList<>();
				for(int i = 0; i < 5; i++) {
					listDoc.add(paperManager.addDocument(TypeDoc.CSV));
					listDoc.add(paperManager.addDocument(TypeDoc.PDF));
					listDoc.add(paperManager.addDocument(TypeDoc.TXT));
				}
				paperManager.addDocument(listDoc);
				break;
				
			case "exit":
				choose = "exit";
				paperManager.exit();
				break;
			}
			scan.reset();
		}
		
		System.out.println("����!!!");
	}

}

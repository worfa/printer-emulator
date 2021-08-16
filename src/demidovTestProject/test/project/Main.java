package demidovTestProject.test.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import demidovTestProject.test.project.model.AbstractDocument;
import demidovTestProject.test.project.model.TypeDoc;
import demidovTestProject.test.project.service.PaperManager;

public class Main {
	
	public static void main(String [] args) {
		System.out.println("Эмуляция работы диспетчера печати!");
		PaperManager paperManager = new PaperManager();
		Scanner scan = new Scanner(System.in);
		String choose = "";
		
		while(choose != "exit") {
			
			System.out.println("Команды доступные для работы: "
					+ "сreate.Добавить документ \n "
					+ "create list.Добавить лист документов различных форматов \n " 
					+ "delete.Удалить последний добавленый документn\n "
					+ "get printed.Получить напечатанные документы\n "
					+ "stop print.Остановка печати\n "
					+ "exit.Остановка программы");
			
			choose = scan.nextLine();
			switch(choose) {
			
			case "create": 
				System.out.print("Ведите документ, который хотите пустить на печать: txt, pdf, csv: ");
				scan.reset();
				choose = scan.nextLine();
				try {
					paperManager.addDocument(TypeDoc.valueOf(choose.toUpperCase()));
				}catch(IllegalArgumentException e){
					System.out.println("Неправильная команда!");
					break;
				}
				break;
				
			case "delete": 
				paperManager.clearLastDoc();
				System.out.println("Удален последний документ!");
				break;
			
			case "get printed": 
				System.out.println("Выберите как вы хотите получить напечатанные документы 1.по очереди печати \n "
						+ "2.по типу документов \n"
						+ "3.по размеру бумаги \n "
						+ "4.по времени печати");
				scan.reset();
				choose = scan.nextLine();
				try {
				for(AbstractDocument doc :paperManager.getPritedList(Integer.valueOf(choose))) {
					System.out.println(doc);
				}
				}catch(IllegalArgumentException e) {
					System.out.println("Неправильная команда!");
					break;
				}
				break;
				
			case "stop print": 
				System.out.println("Печать остановлена. Не напечатанные документы: ");
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
		
		System.out.println("Пока!!!");
	}

}

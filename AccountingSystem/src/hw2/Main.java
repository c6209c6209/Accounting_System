package hw2;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	
	/***
	 * Our main method. The external interface of the accounting system.
	 * @param args The command line arguments.
	 * @throws FileNotFoundException
	 *  *Example: Type 12345678 in console.
	 *  		  output "Welcome 12345678"
						 ""
						 "輸入指令:" 
						 "1) A 顯示總支出"
						 "2) B 顯示全部消費紀錄"
						 "3) C 顯示特定日期消費金額"
						 "4) D 顯示特定月份日平均消費金額"
						 "5) Q 離開系統"
				  Then, type A in console.
				  output "您的消費總金額為: 1111113322"
						 "Bye bye!"
	 * Time estimate: O(n)
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//read input.txt
		AccountSystem system = new AccountSystem("input.txt");
		
		// user input at console
		String inputID;
		System.out.println("輸入 ID 或 Q(結束使用)");
		Scanner scanner = new Scanner(System.in);
		inputID = scanner.next();
		int id = system.checkID(inputID);
		if(id != -1) {	//有這個ID
			System.out.println("Welcome " + inputID + "\n");
			System.out.println("輸入指令: ");
			System.out.println("1) A 顯示總支出");
			System.out.println("2) B 顯示全部消費紀錄");
			System.out.println("3) C 顯示特定日期消費金額");
			System.out.println("4) D 顯示特定月份日平均消費金額");
			System.out.println("5) Q 離開系統");
			String cmd;
			cmd = scanner.next();
			Command command = new Command();
			command.execute(scanner, cmd, system, id);
			
		}
		System.out.print("Bye bye!");
		
	}
}

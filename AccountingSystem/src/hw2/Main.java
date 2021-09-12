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
						 "��J���O:" 
						 "1) A ����`��X"
						 "2) B ��ܥ������O����"
						 "3) C ��ܯS�w������O���B"
						 "4) D ��ܯS�w����饭�����O���B"
						 "5) Q ���}�t��"
				  Then, type A in console.
				  output "�z�����O�`���B��: 1111113322"
						 "Bye bye!"
	 * Time estimate: O(n)
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//read input.txt
		AccountSystem system = new AccountSystem("input.txt");
		
		// user input at console
		String inputID;
		System.out.println("��J ID �� Q(�����ϥ�)");
		Scanner scanner = new Scanner(System.in);
		inputID = scanner.next();
		int id = system.checkID(inputID);
		if(id != -1) {	//���o��ID
			System.out.println("Welcome " + inputID + "\n");
			System.out.println("��J���O: ");
			System.out.println("1) A ����`��X");
			System.out.println("2) B ��ܥ������O����");
			System.out.println("3) C ��ܯS�w������O���B");
			System.out.println("4) D ��ܯS�w����饭�����O���B");
			System.out.println("5) Q ���}�t��");
			String cmd;
			cmd = scanner.next();
			Command command = new Command();
			command.execute(scanner, cmd, system, id);
			
		}
		System.out.print("Bye bye!");
		
	}
}

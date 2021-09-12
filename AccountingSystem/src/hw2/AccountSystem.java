package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class AccountSystem {
	
	public AccountSystem() {}
	public AccountSystem(String filePath) {
		try {
			readInputTxt(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * Initializing the accounts data by reading a input text file.
	 * @param path The location of the file recorded all transactions.
	 * @return the number of accounts created.
	 * @throws FileNotFoundException
	 *  *Example: constructor calls readInputTxt(input.txt); return 8.
	 * Time estimate: O(n)
	 */
	private int readInputTxt(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		int id, day, value;
		User user;
		while(scanner.hasNextInt()) {
			id = scanner.nextInt();
			day = scanner.nextInt();
			value = scanner.nextInt();
			if (Accounts.containsKey(id)) {
				user = Accounts.get(id);
				user.addTransaction(day, value);
				Accounts.remove(id);
				Accounts.put(id, user);
			}else {
				user = new User();
				user.addTransaction(day, value);
				Accounts.put(id, user);
			}
		}
		return Accounts.size();
	}
	
	/***
	 * Check whether specific ID is valid and existing. 
	 * @param ID User ID of type "String"
	 * @return the ID of type "int". return -1 when the ID is invalid or not existing .
	 *  *Example: AccountSystem.checkID("12345678");  return (int) 12345678.
	 * Time estimate: O(1) 
	 */
	public int checkID(String ID) {
		if(ID.equals("Q")) {	//結束
			//System.out.print("Bye bye!");
			return -1;
		}
		else {
			try {
				int id = 0;
				id = Integer.parseInt(ID);
				if(userExist(id)) {	//存在此ID
					return id;
				}
				else {	//數字ID但不存在
					System.out.println("查無此ID");
					return -1;
				}
			}
			catch(NumberFormatException nfe){	//不是數字ID
				System.out.println("查無此ID");
				return -1;
			}
		}
	}
	
	/***
	 * Check whether the specific account exists in the database. 
	 * @param id The specified User ID
	 * @return true if the user is existing, return false otherwise.
	 *  *Example: Some same class methods calls userExist(12345678); return true.
	 * Time estimate: O(1)  
	 */
	private boolean userExist(int id) {
		return Accounts.containsKey(id);
	}
	
	/***
	 * Show the total expense of a specific user.
	 * @param id The specified User ID 
	 *  *Example: AccountSystem.showTotalExpense(12345678); 
	 *  		  Output "您的消費總金額為: 1111113322"
	 * Time estimate: O(n)
	 */
	public void showTotalExpense(int id) {
		User user;
		user = Accounts.get(id);
		user.showTotalExpense();
	}
	
	/***
	 * Show each transaction of a specific user.
	 * @param id The specified User ID 
	 *  *Example: AccountSystem.showAllTransaction(12345678);
	 *  		  Output "消費日期: 30000101, 消費金額: 999"
						 "消費日期: 11111111, 消費金額: 1111111111"
						 "消費日期: 20121212, 消費金額: 1212"
	 * Time estimate: O(n)
	 */
	public void showAllTransaction(int id) {
		User user;
		user = Accounts.get(id);
		user.showAllTransaction();
	}
	
	/***
	 * Show the total expense on a specific day of a specific user.
	 * @param id  The specified User ID 
	 * @param day The specified day (YYYYMMDD)
	 * 	*Example: AccountSystem.showSpecificDay(12345678, 20121212)
	 * 			  Output "您當日的消費總金額為: 1212"
	 * Time estimate: O(n) 
	 */
	public void showSpecificDay(int id, int day) {
		User user;
		user = Accounts.get(id);
		user.showSpecificDay(day);
	}
	
	/***
	 * Show the average expense per day within a specific month of a specific user.
	 * @param id 	The specified User ID 
	 * @param month The specified month (YYYYMM)
	 *  *Example: AccountSystem.showSpecificMonthAvg(12345678, 201212)
	 *  		  Output "您當月的日平均消費金額為: 39.10"
	 * Time estimate: O(n)
	 */
	public void showSpecificMonthAvg(int id, int month) {
		User user;
		user = Accounts.get(id);
		user.showSpecificMonthAvg(month);
	}
	
	private HashMap<Integer, User> Accounts = new HashMap<Integer, User>();
}

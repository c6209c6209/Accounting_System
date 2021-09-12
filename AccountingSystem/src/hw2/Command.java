package hw2;

import java.util.Scanner;


public class Command {
	
	/***
	 * The interface to execute user commands.
	 * @param scanner 	The scanner object.
	 * @param cmd 		The command that the user typed.
	 * @param system 	The pre-initialized AccountSystem.
	 * @param id 		The ID of the user.
	 *  *Example: Command.execute(scanner, "A", system, 12345678)
	 *  		  Output "您的消費總金額為: 1111113322"
	 *  		  		 "Bye bye!"
	 * Time estimate: O(n)
	 */
	public void execute(Scanner scanner, String cmd, AccountSystem system, int id) {
	
		switch(cmd) {
			case "A":
				system.showTotalExpense(id);
				return;
			case "B":
				system.showAllTransaction(id);
				return;
			case "C":	
				System.out.println("請輸入特定日期(YYYYMMDD)");
				String inputDay = scanner.next();
				int day = checkInputDayValid(inputDay);
				if(day != -1) {	//合法的日期
					system.showSpecificDay(id, day);
					return;
				}
				else {	//不合法的日期
					System.out.println("不合法的日期");
					return;
				}
			case "D":
				System.out.println("請輸入特定年月(YYYYMM)");
				String inputMonth = scanner.next();
				int month = checkInputMonthValid(inputMonth);
				if(month != -1) {	//合法的年月
					system.showSpecificMonthAvg(id, month);
					return;
				}
				else {	//不合法的年月
					System.out.println("不合法的年月");
					return;
				}
			case "Q":
				//System.out.print("Bye bye!");
				return;
			default:
				System.out.println("不合法的指令");
				break;
		}
	}
	
	/***
	 * Parse the specific day to int and check whether it is valid. 
	 * @param inputDay The specific day ("YYYYMMDD")
	 * @return int (inputDay) if the day is valid
	 * 			or return -1 if it's invalid.
	 *  *Example: Same class method calls checkInputDayValid("20001220");
	 *  		  return (int) 20001220.
	 * Time estimate: O(1)
	 */
	private int checkInputDayValid(String inputDay) {
		try {
			int day = 0;
			if(inputDay.length() == 8) {
				day = Integer.parseInt(inputDay);
				int year = day/10000;
				int month = (day%10000) / 100;
				int date = day % 100;
				switch(month) {
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:	//大月
						if(checkDateValid(date, 31)) {
							return day;
						}
						else {
							return -1;
						}
					case 4: case 6: case 9: case 11:	//小月
						if(checkDateValid(date, 30)) {
							return day;
						}
						else {
							return -1;
						}
					case 2:		//2月
						if(checkFebDays(year, date)) {
							return day;
						}
						else {
							return -1;
						}
					default:	//非合法月份
						return -1;
				}
			}
			else {	//日期非8碼
				return -1;
			}		
		}
		catch(NumberFormatException nfe){	//非數字日期
			return -1;
		}
	}
	
	/***
	 * Check whether the day is out of the range.
	 * @param date 		The specific date. (DD)
	 * @param maxDate 	The maximum numbers of day in a specific month.  
	 * @return true if the date is valid, return false otherwise.
	 *  *Example: Same class method calls checkDateValid(20, 31);
	 *  		  return true.
	 * Time estimate: O(1)
	 */
	private boolean checkDateValid(int date, int maxDate) {
		if(date >= 1 && date <= maxDate) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/***
	 * Interface to check whether the day is valid in February.
	 * @param year The year we want to check (YYYY)
	 * @param date The date we want to check. (DD)
	 * @return true if the date is valid, return false otherwise.
	 *  *Example: Same class method calls checkFebDays(2000, 29);
	 *  		  return true.
	 * Time estimate: O(1)
	 */
	private boolean checkFebDays(int year, int date) {
		if(year%4 == 0) {
			if(year%100 == 0) {
				if(year%400 == 0) {	//被400整除，閏年
					return checkDateValid(date, 29);
				}
				else {	//被100整除，但不被400整除，平年
					return checkDateValid(date, 28);
				}
			}
			else {	//不被100整除，閏年
				return checkDateValid(date, 29);
			}
		}
		else {	//不被4整除，平年
			return checkDateValid(date, 28);
		}
	}
	
	/***
	 * Check whether the month is valid
	 * @param inputMonth The specific month ("MM")
	 * @return true if the month is valid, return false otherwise.
	 * 	*Example: Same class methods calls checkInputMonthValid("10");
	 *  		  return true.
	 * Time estimate: O(1)
	 */
	private int checkInputMonthValid(String inputMonth) {
		try {
			int int_month = 0;
			if(inputMonth.length() == 6) {
				int_month = Integer.parseInt(inputMonth);
				int month = int_month % 100;
				if(month >= 1 && month <= 12) {	//合法年月
					return int_month;
				}
				else {	//月份非為12個月
					return -1;
				}
			}
			else {	//input非6碼
				return -1;
			}
		}
		catch(NumberFormatException nfe){	//非數字日期
			return -1;
		}
	}
	
}
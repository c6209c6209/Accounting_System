package hw2;

import java.util.*;

public class User {
	
	/***
	 * The implementation of showing a user's total Expense.
	 *  *Example: User.showTotalExpense()
	 *  		  Output "您的消費總金額為: " + someValue.
	 * Time estimate: O(n)
	 */
	protected void showTotalExpense() {
		int totalExpense = 0;
		for (HashMap<Integer, List<Integer>> singleMonth: monthList.values()) { //取出每一個月份個別的 HashMap<當月日期, 消費清單>
			for (List<Integer> valueList: singleMonth.values()) {	//取出每一天的消費紀錄
				for (Integer value: valueList) {
					totalExpense += value;
				}
			}
		}
		System.out.printf("您的消費總金額為: %d\n", totalExpense);
	}
	
	/***
	 * The implementation of showing a user's each transaction.
	 *  *Example: User.showAllTransaction()
	 *  		  Output "消費日期: " + someDate + "消費金額: " + someValue
	 *  				 ... 
	 * Time estimate: O(n)
	 */
	protected void showAllTransaction() {
		for (Map.Entry<Integer, HashMap<Integer, List<Integer>>> singleMonth: monthList.entrySet()) { //取出每一個月份個別的 HashMap<當月日期, 消費清單>
			for (Map.Entry<Integer, List<Integer>> valueList: singleMonth.getValue().entrySet()) {	//取出每一天的消費紀錄
				for (Integer value: valueList.getValue()) {
					String yearMonthString = String.format("%06d", singleMonth.getKey());
					String dateString = String.format("%02d", valueList.getKey());
					System.out.printf("消費日期: %s%s, 消費金額: %d\n",yearMonthString, dateString, value);
				}
			}
		}
	}
	
	/***
	 * The implementation of showing a user's total expense on a specific day.
	 * @param day The specific day (YYYYMMDD)
	 *  *Example: User.showSpecificDay(someDay)
	 *  		  Output "您當日的消費總金額為: " + someValue.
	 * Time estimate: O(n)
	 */
	protected void showSpecificDay(int day) {
		int month = day / 100;
		int date = day % 100;
		int totalExpense = 0;
		if(monthList.containsKey(month)) { //有這個月的交易紀錄
			HashMap<Integer, List<Integer>> singleMonth = monthList.get(month);
			if(singleMonth.containsKey(date)) { //有這個日的交易紀錄	
				List<Integer> valueList = singleMonth.get(date);
				for (Integer value: valueList) {
					totalExpense += value;
				}
			}
		}
		System.out.printf("您當日的消費總金額為: %d\n", totalExpense);
	}
	
	/***
	 * The implementation of showing a user's average expense per day within a specific month.
	 * @param yearMonth The specific month (YYYYMM)
	 *  *Example: User.showSpecificMonthAvg(someMonth)
	 *  		  Output "您當月的日平均消費金額為: " + someValue(floating point with 2 decimal places)
	 * Time estimate: O(n)
	 */
	protected void showSpecificMonthAvg(int yearMonth) {
		int year = yearMonth / 100;
		int month = yearMonth % 100;
		int numberOfDays = 0;
		int totalExpense = 0;
		double avgExpense = 0;
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				numberOfDays = 31;
				break;
			case 4: case 6: case 9: case 11:
				numberOfDays = 30;
				break;
			case 2:
				if(year%4 == 0) {
					if(year%100 == 0) {
						if(year%400 == 0) 	//被400整除，閏年
							numberOfDays = 29;
						else 	//被100整除，但不被400整除，平年
							numberOfDays = 28;
					}
					else 	//不被100整除，閏年
						numberOfDays = 29;
				}
				else 	//不被4整除，平年
					numberOfDays = 28;
				break;
			default:
				break;
		}
		if(monthList.containsKey(yearMonth)) {
			HashMap<Integer, List<Integer>> singleMonth = monthList.get(yearMonth);
			for (List<Integer> valueList: singleMonth.values()) {	//取出每一天的消費紀錄
				for (Integer value: valueList) {
					totalExpense += value;
				}
			}
		}
		avgExpense = (double) totalExpense / (double) numberOfDays;
		System.out.printf("您當月的日平均消費金額為: %.2f\n", avgExpense);
	}
	
	/***
	 * The implementation of adding a transaction record to a user account.
	 * @param day The specific day of the transaction.
	 * @param value The value of the transaction.
	 *  *Example: User.addTransaction(20210406, 100);
	 *  		  System will record that the user spend $100 on 2021/04/06.
	 * Time estimate: O(1)
	 */
	protected void addTransaction(int day, int value) {
		int month, date;
		HashMap<Integer, List<Integer>> monthTransaction;
		List<Integer> transaction;
		month = day/100;
		date = day%100;
		
		if(monthList.containsKey(month)) {
			monthTransaction = monthList.get(month);
			if(monthTransaction.containsKey(date)) {		//month exists, date exists
				transaction = monthTransaction.get(date);
				transaction.add(value);
				monthTransaction.remove(date);
				monthTransaction.put(date, transaction);
				monthList.remove(month);
				monthList.put(month, monthTransaction);
			}
			else {	//month exists, date not exists
				transaction = new ArrayList<Integer>();
				transaction.add(value);
				monthTransaction.put(date, transaction);
				monthList.remove(month);
				monthList.put(month, monthTransaction);
			}
		}
		else {	//month and date not exists
			transaction = new ArrayList<Integer>();
			transaction.add(value);
			monthTransaction = new HashMap<Integer, List<Integer>>();
			monthTransaction.put(date, transaction);
			monthList.put(month, monthTransaction);
		}
		
	}
	private HashMap<Integer, HashMap<Integer, List<Integer>>> monthList = new HashMap<Integer, HashMap<Integer, List<Integer>>>();
}
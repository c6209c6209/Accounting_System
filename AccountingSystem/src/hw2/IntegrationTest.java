package hw2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegrationTest {

	@BeforeEach
	void setUp() throws Exception {
		mainClass = new Main();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testQuitInBeginning() throws FileNotFoundException {
		String input="Q";
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		
		mainClass.main(new String[0]);
		
		String expectedOutput = "輸入 ID 或 Q(結束使用)\r\n" +
								"Bye bye!";
		
		assertEquals(expectedOutput, testOut.toString().trim());
	}
	
	@Test
	void testShowUserAllExpense() throws FileNotFoundException {
		String input = "11254730\r\n"+
					   "A";
		
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		
		mainClass.main(new String[0]);
		
		String expectedOutput = "輸入 ID 或 Q(結束使用)\r\n" +
								"Welcome 11254730\n\r\n" +
								"輸入指令: \r\n" +
								"1) A 顯示總支出\r\n" +
								"2) B 顯示全部消費紀錄\r\n" +
								"3) C 顯示特定日期消費金額\r\n" +
								"4) D 顯示特定月份日平均消費金額\r\n" +
								"5) Q 離開系統\r\n" +
								"您的消費總金額為: 1641\n" +
								"Bye bye!";
		
		assertEquals(expectedOutput, testOut.toString().trim());
	
	}
	
	@Test
	void testShowUserAllTransaction() throws FileNotFoundException {
		String input = "11254730\r\n"+
					   "B";
		
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		
		mainClass.main(new String[0]);
		
		String expectedOutput = "輸入 ID 或 Q(結束使用)\r\n" +
								"Welcome 11254730\n\r\n" +
								"輸入指令: \r\n" +
								"1) A 顯示總支出\r\n" +
								"2) B 顯示全部消費紀錄\r\n" +
								"3) C 顯示特定日期消費金額\r\n" +
								"4) D 顯示特定月份日平均消費金額\r\n" +
								"5) Q 離開系統\r\n" +
								"消費日期: 20200712, 消費金額: 27\n" +
								"消費日期: 20200713, 消費金額: 85\n" +
								"消費日期: 20200713, 消費金額: 130\n" +
								"消費日期: 20200714, 消費金額: 1399\n" +
								"Bye bye!";
		
		assertEquals(expectedOutput, testOut.toString().trim());
	
	}
	
	@Test
	void testShowUserSpecificDay() throws FileNotFoundException {
		String input = "11254730\r\n" +
					   "C\r\n" +
					   "20200713";
		
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		
		mainClass.main(new String[0]);
		
		String expectedOutput = "輸入 ID 或 Q(結束使用)\r\n" +
								"Welcome 11254730\n\r\n" +
								"輸入指令: \r\n" +
								"1) A 顯示總支出\r\n" +
								"2) B 顯示全部消費紀錄\r\n" +
								"3) C 顯示特定日期消費金額\r\n" +
								"4) D 顯示特定月份日平均消費金額\r\n" +
								"5) Q 離開系統\r\n" +
								"請輸入特定日期(YYYYMMDD)\r\n" +
								"您當日的消費總金額為: 215\n" +
								"Bye bye!";
		
		assertEquals(expectedOutput, testOut.toString().trim());
	
	}
	
	@Test
	void testShowUserSpecificMonthAvg() throws FileNotFoundException {
		String input = "11254730\r\n" +
					   "D\r\n" +
					   "202007";
		
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		
		mainClass.main(new String[0]);
		
		String expectedOutput = "輸入 ID 或 Q(結束使用)\r\n" +
								"Welcome 11254730\n\r\n" +
								"輸入指令: \r\n" +
								"1) A 顯示總支出\r\n" +
								"2) B 顯示全部消費紀錄\r\n" +
								"3) C 顯示特定日期消費金額\r\n" +
								"4) D 顯示特定月份日平均消費金額\r\n" +
								"5) Q 離開系統\r\n" +
								"請輸入特定年月(YYYYMM)\r\n" +
								"您當月的日平均消費金額為: 52.94\n" +
								"Bye bye!";
		
		assertEquals(expectedOutput, testOut.toString().trim());
	
	}
	
	@Test
	void testShowUserQuit() throws FileNotFoundException {
		String input = "11254730\r\n" +
					   "Q\r\n";
		
		ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		
		mainClass.main(new String[0]);
		
		String expectedOutput = "輸入 ID 或 Q(結束使用)\r\n" +
								"Welcome 11254730\n\r\n" +
								"輸入指令: \r\n" +
								"1) A 顯示總支出\r\n" +
								"2) B 顯示全部消費紀錄\r\n" +
								"3) C 顯示特定日期消費金額\r\n" +
								"4) D 顯示特定月份日平均消費金額\r\n" +
								"5) Q 離開系統\r\n" +
								"Bye bye!";
		
		assertEquals(expectedOutput, testOut.toString().trim());
	
	}
	
	
	
	
	private Main mainClass;

}

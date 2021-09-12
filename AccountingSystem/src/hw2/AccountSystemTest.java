package hw2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountSystemTest {
	
	@BeforeEach
	void setUp() throws Exception {
		testSystem = new AccountSystem("input.txt");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/***
	 * test method: AccountSystem.checkID()
	 * test data:	"�å���ID"
	 */
	@Test
	void testCheckIDInvalid() {
		
		assertEquals(-1 ,testSystem.checkID("�å���ID"));
	}
	
	/***
	 * test method: AccountSystem.checkID()
	 * test data: 	"19254301"
	 * @throws FileNotFoundException
	 */
	@Test
	void testCheckIDExisting() throws FileNotFoundException {
		
		//testSystem.readInputTxt("input.txt");
		assertEquals(19254301 ,testSystem.checkID("19254301"));
	}
	
	/***
	 * test method: AccountSystem.showTotalExpense()
	 * test account: 15317546
	 */
	@Test
	void testShowTotalExpense_1() {
		int id = 15317546;
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		testSystem.showTotalExpense(id);
		assertEquals("�z�����O�`���B��: 150" ,testOut.toString().trim());
	}
	
	/***
	 * test method: AccountSystem.showTotalExpense()
	 * test account: 15317546
	 */
	@Test
	void testShowTotalExpense_2() {
		int id = 17111563;
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		testSystem.showTotalExpense(id);
		assertEquals("�z�����O�`���B��: 1002995" ,testOut.toString().trim());
	}
	
	/***
	 * test method: AccountSystem.showAllTransaction()
	 * test account: 15317546
	 */
	@Test
	void testShowAllTransactionSingle() {
		int id = 15317546;
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		testSystem.showAllTransaction(id);
		assertEquals("���O���: 20210301, ���O���B: 150" ,testOut.toString().trim());
	}
	
	/***
	 * test method: AccountSystem.showAllTransaction()
	 * test account: 11254730
	 */
	@Test
	void testShowAllTransactionMultiple() {
		int id = 11254730;
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		testSystem.showAllTransaction(id);
		assertEquals("���O���: 20200712, ���O���B: 27\n"
				+ "���O���: 20200713, ���O���B: 85\n"
				+ "���O���: 20200713, ���O���B: 130\n"
				+ "���O���: 20200714, ���O���B: 1399" ,testOut.toString().trim());
	}
	
	/***
	 * test method: AccountSystem.showSpecificDay()
	 * test account: 11254730
	 * test day: 20200713
	 */
	@Test
	void testShowSpecificDayExist() {
		int id = 11254730;
		int day = 20200713;
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		testSystem.showSpecificDay(id, day);
		assertEquals("�z��骺���O�`���B��: 215" ,testOut.toString().trim());
	}
	
	/***
	 * test method: AccountSystem.showSpecificDay()
	 * test account: 10000001
	 * test day: 10050524
	 */
	@Test
	void testShowSpecificDayNoComsumption() {
		int id = 10000001;
		int day = 10050524;
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		testSystem.showSpecificDay(id, day);
		assertEquals("�z��骺���O�`���B��: 0" ,testOut.toString().trim());
	}
	
	/***
	 * test method: AccountSystem.showSpecificMonthAvg()
	 * test account: 18501179
	 * test month: 202004
	 */
	@Test
	void testShowSpecificMonthAvgExist() {
		int id = 18501179;
		int month = 202004;
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		testSystem.showSpecificMonthAvg(id, month);
		assertEquals("�z��몺�饭�����O���B��: 4266802.83" ,testOut.toString().trim());
	}
	
	/***
	 * test method: AccountSystem.showSpecificMonthAvg()
	 * test account: 15317546
	 * test month: 202004
	 */
	@Test
	void testShowSpecificMonthAvgNoComsumption() {
		int id = 15317546;
		int month = 202004;
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		testSystem.showSpecificMonthAvg(id, month);
		assertEquals("�z��몺�饭�����O���B��: 0.00" ,testOut.toString().trim());
	}
	
	private AccountSystem testSystem;
}

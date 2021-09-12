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
		
		String expectedOutput = "��J ID �� Q(�����ϥ�)\r\n" +
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
		
		String expectedOutput = "��J ID �� Q(�����ϥ�)\r\n" +
								"Welcome 11254730\n\r\n" +
								"��J���O: \r\n" +
								"1) A ����`��X\r\n" +
								"2) B ��ܥ������O����\r\n" +
								"3) C ��ܯS�w������O���B\r\n" +
								"4) D ��ܯS�w����饭�����O���B\r\n" +
								"5) Q ���}�t��\r\n" +
								"�z�����O�`���B��: 1641\n" +
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
		
		String expectedOutput = "��J ID �� Q(�����ϥ�)\r\n" +
								"Welcome 11254730\n\r\n" +
								"��J���O: \r\n" +
								"1) A ����`��X\r\n" +
								"2) B ��ܥ������O����\r\n" +
								"3) C ��ܯS�w������O���B\r\n" +
								"4) D ��ܯS�w����饭�����O���B\r\n" +
								"5) Q ���}�t��\r\n" +
								"���O���: 20200712, ���O���B: 27\n" +
								"���O���: 20200713, ���O���B: 85\n" +
								"���O���: 20200713, ���O���B: 130\n" +
								"���O���: 20200714, ���O���B: 1399\n" +
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
		
		String expectedOutput = "��J ID �� Q(�����ϥ�)\r\n" +
								"Welcome 11254730\n\r\n" +
								"��J���O: \r\n" +
								"1) A ����`��X\r\n" +
								"2) B ��ܥ������O����\r\n" +
								"3) C ��ܯS�w������O���B\r\n" +
								"4) D ��ܯS�w����饭�����O���B\r\n" +
								"5) Q ���}�t��\r\n" +
								"�п�J�S�w���(YYYYMMDD)\r\n" +
								"�z��骺���O�`���B��: 215\n" +
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
		
		String expectedOutput = "��J ID �� Q(�����ϥ�)\r\n" +
								"Welcome 11254730\n\r\n" +
								"��J���O: \r\n" +
								"1) A ����`��X\r\n" +
								"2) B ��ܥ������O����\r\n" +
								"3) C ��ܯS�w������O���B\r\n" +
								"4) D ��ܯS�w����饭�����O���B\r\n" +
								"5) Q ���}�t��\r\n" +
								"�п�J�S�w�~��(YYYYMM)\r\n" +
								"�z��몺�饭�����O���B��: 52.94\n" +
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
		
		String expectedOutput = "��J ID �� Q(�����ϥ�)\r\n" +
								"Welcome 11254730\n\r\n" +
								"��J���O: \r\n" +
								"1) A ����`��X\r\n" +
								"2) B ��ܥ������O����\r\n" +
								"3) C ��ܯS�w������O���B\r\n" +
								"4) D ��ܯS�w����饭�����O���B\r\n" +
								"5) Q ���}�t��\r\n" +
								"Bye bye!";
		
		assertEquals(expectedOutput, testOut.toString().trim());
	
	}
	
	
	
	
	private Main mainClass;

}

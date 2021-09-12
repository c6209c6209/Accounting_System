package hw2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandTest {

	@BeforeEach
	void setUp() throws Exception {
		testCommand = new Command();
		testSystem = new AccountSystem("input.txt");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/***
	 * test method: Command.execute()
	 * test data:	scanner, "讓我被當掉是", testSystem, 12345678 
	 */
	@Test
	void testExecuteInvalidCommand() {
		
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
		Scanner scanner = new Scanner(System.in);
		testCommand.execute(scanner, "讓我被當掉是", testSystem, 12345678);
		String expectedOutput =	"不合法的指令";
								
		assertEquals(expectedOutput, testOut.toString().trim());
	}
	
	/***
	 * test method: Command.execute()
	 * test data:	scanner, "C", testSystem, 12345678, "20008787"
	 */
	@Test
	void testExecuteInvalidDay() {
		
		String data="20008787";
		ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		Scanner scanner = new Scanner(System.in);
		testCommand.execute(scanner, "C", testSystem, 12345678);
		String expectedOutput = "請輸入特定日期(YYYYMMDD)\r\n" +
								"不合法的日期";
								
		assertEquals(expectedOutput, testOut.toString().trim());
		
	}
	
	private Command testCommand;
	private AccountSystem testSystem;
}

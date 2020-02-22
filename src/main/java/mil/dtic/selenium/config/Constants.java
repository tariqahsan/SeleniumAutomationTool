package mil.dtic.selenium.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constants {
	
	//System Variables
	public static final String URL = "http://www.store.demoqa.com";
	private static String FILE_EXTENSION = ".xlsx";
	public static final String FILE_PATH = "TestResults//TestResult_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMMdd_HH-mm-ss")) + FILE_EXTENSION ;
	public static final String KEYWORD_FAIL = "FAILED";
	public static final String KEYWORD_PASS = "PASSED";
	public static final String KEYWORD_SKIPPED = "SKIPPED";
	
	//Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID = 1 ;
	public static final int Col_PageObject = 4 ;
	public static final int Col_ActionKeyword = 5 ;
	public static final int Col_RunMode = 2 ;
	public static final int Col_Result = 3 ;
	public static final int Col_DataSet = 6 ;
	public static final int Col_TestStepResult = 7 ;
	public static final int Col_0 = 0;	
	public static final int Col_1 = 1 ;
	public static final int Col_2 = 2 ;
	public static final int Col_3 = 3 ;
	public static final int Col_4 = 4 ;
	public static final int Col_5 = 5 ;
	public static final int Col_6 = 6 ;
	public static final int Col_7 = 7 ;
		
	// Data Engine Excel sheets
	public static final String Sheet_TestSteps = "Test Steps";
	public static final String Sheet_TestCases = "Test Cases";
	
	// Test Data
	public static final String UserName = "testuser_3";
	public static final String Password = "Test@123";

	
	

}

package mil.dtic.selenium;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.Sheet;
import mil.dtic.selenium.config.Constants;

public class RunTest {

	public static final Logger logger = Logger.getLogger(RunTest.class.getName());;
	public static Result result;
	static XSSFWorkbook workbook;
	static XSSFSheet sheetTestSteps;
	static XSSFSheet sheetTestSuite;
	static XSSFSheet sheetTestCases;

	private boolean testCaseFlag = true;

	private WebDriver webDriver;
	Driver driver;
	FileOutputStream fileOutputStream;

	@BeforeClass
	public void beforeClass() throws IOException {

		driver = new Driver();
		fileOutputStream = new FileOutputStream(new File(Constants.FILE_PATH));

		// Blank workbook
		workbook = new XSSFWorkbook();

		// Create a blank sheet
		sheetTestSuite = workbook.createSheet("Test Suite");
		// Create a blank sheet
		sheetTestCases = workbook.createSheet("Test Cases");

	}

	@AfterClass
	public void afterClass() {
		webDriver.quit();
	}

	@Test
	public void readExcel() throws Exception {

		// creating class object for configFileReader
		ConfigFileReader configFileReader = new ConfigFileReader();
		ExcelSheetDriver excelSheetDriver = new ExcelSheetDriver();

		// ArrayList to store String[]
		List<Object[]> objectArrays = new ArrayList<>();
		List<TestStepInputs> testStepInputsList = new ArrayList<>();
		List<Input> inputs = new ArrayList<>();
		List<Input> suiteInputs = new ArrayList<>();
		List<Input> caseInputs = new ArrayList<>();
		List<Input> stepInputs = new ArrayList<>();

		// variable name testSuitesheet data type is Sheet
		Sheet testSuitesheet = excelSheetDriver.getWorksheet(configFileReader.getTestSuite(),
				configFileReader.getTestSuiteSheet());
		int rowCount = excelSheetDriver.rowCount();

		// Looping through the TEST SUITES
		for (int i = 1; i < rowCount; i++) {
			logger.info("The value of i is -> " + i);
			logger.info("testSuitesheet -> " + testSuitesheet.getName());
			String serialNumber = excelSheetDriver.readCell(testSuitesheet, 0, i);
			String description = excelSheetDriver.readCell(testSuitesheet, 1, i);
			String executionFlag = excelSheetDriver.readCell(testSuitesheet, 2, i);

			// TEST SUITE : IF ONLY THE 'EXECUTION FLAG' IS SET TO 'Y'
			if (executionFlag.equalsIgnoreCase("Y")) {
				Sheet testCaseSheet = excelSheetDriver.getWorksheet(configFileReader.getTestCasePath(), description);
				int rowTestcase = excelSheetDriver.rowCount(); 

				// Create the workbook sheet named by the corresponding description value of the test suite
				sheetTestSteps = workbook.createSheet(description);
				logger.info("sheetTestSteps is -> " + sheetTestSteps.getSheetName());

				// Looping through the TEST CASES
				for (int k = 1; k < rowTestcase; k++) {

					// Reset testCaseFlag
					testCaseFlag = true;

					String testCaseSerialNumber = excelSheetDriver.readCell(testCaseSheet, 0, k);
					String testCaseNumber = excelSheetDriver.readCell(testCaseSheet, 1, k);
					String testCaseDescription = excelSheetDriver.readCell(testCaseSheet, 2, k);
					String testCaseExecutionFlag = excelSheetDriver.readCell(testCaseSheet, 3, k);
					logger.info("TestCases: testCaseSerialNumber: " + testCaseSerialNumber);
					logger.info("TestCases: testCaseNumber: " + testCaseNumber);
					logger.info("TestCases: testCaseDescription: " + testCaseDescription);
					logger.info("TestCases: testCaseExecutionFlag: " + testCaseExecutionFlag);

					Input caseInput = new Input(sheetTestSteps, testCaseSerialNumber, testCaseNumber, testCaseExecutionFlag, new Object[] {testCaseSerialNumber, testCaseNumber, testCaseDescription, testCaseExecutionFlag});

					// TEST CASES : IF ONLY THE 'EXECUTION FLAG' IS SET TO 'Y'
					if (testCaseExecutionFlag.equalsIgnoreCase("y")) {

						caseInput.setObjArray(new Object[] {testCaseSerialNumber, testCaseNumber, testCaseDescription, testCaseExecutionFlag});
						Sheet testStepSheet = excelSheetDriver.getWorksheet(configFileReader.getTestStepsPath(), description);
						int testStepsRow = excelSheetDriver.rowCount(); 

						webDriver = driver.InitateDriver();
						KeywordFunctions comlib = new KeywordFunctions(webDriver);
						TestStepInputs testStepInputs = new TestStepInputs();

						// Looping through the TEST STEPS
						for (int w = 1; w < testStepsRow; w++) {
							String testStepsSerialNumber = excelSheetDriver.readCell(testStepSheet, 0, w);
							String testStepCaseNumber = excelSheetDriver.readCell(testStepSheet, 1, w);
							String testStepsDescription = excelSheetDriver.readCell(testStepSheet, 2, w);
							String webElement = excelSheetDriver.readCell(testStepSheet, 3, w);
							String webElementValue = excelSheetDriver.readCell(testStepSheet, 4, w);
							String inputValue = excelSheetDriver.readCell(testStepSheet, 5, w);
							String testStepsKeyword = excelSheetDriver.readCell(testStepSheet, 6, w);
							String testStepsAssertMethod = excelSheetDriver.readCell(testStepSheet, 7, w);
							String testStepsActualValue = excelSheetDriver.readCell(testStepSheet, 8, w);
							String testStepsExpectedValue = excelSheetDriver.readCell(testStepSheet, 9, w);

							Input stepInput = new Input(sheetTestSteps, testStepsSerialNumber, testStepCaseNumber, testCaseExecutionFlag, new Object[] {testStepsSerialNumber, testStepCaseNumber, testStepsDescription, webElement, webElementValue, inputValue, testStepsKeyword, testStepsAssertMethod, testStepsActualValue, testStepsExpectedValue });

							testStepInputs.setTestStepsSerialNumber(testStepsSerialNumber);
							testStepInputs.setTestStepCaseNumber(testStepCaseNumber);
							testStepInputs.setTestStepsDescription(testStepsDescription);
							testStepInputs.setWebElement(webElement);
							testStepInputs.setWebElementValue(webElementValue);
							testStepInputs.setInputValue(inputValue);
							testStepInputs.setTestStepsKeyword(testStepsKeyword);
							testStepInputs.setActualValue(testStepsActualValue);
							testStepInputs.setAssertMethod(testStepsAssertMethod);
							testStepInputs.setActualValue(testStepsActualValue);
							testStepInputs.setExpectedValue(testStepsExpectedValue);

							if (testCaseNumber.equalsIgnoreCase(testStepCaseNumber)) {
								logger.info("testStepsSerialNumber:" + testStepsSerialNumber);
								logger.info("testStepsDescription:" + testStepsDescription);
								logger.info("webElement:" + webElement);
								logger.info("webElementValue:" + webElementValue);
								logger.info("inputValue:" + inputValue);
								logger.info("testStepsKeyword:" + testStepsKeyword);
								logger.info("testStepsAssertMethod:" + testStepsAssertMethod);
								logger.info("testStepsActualValue:" + testStepsActualValue);
								logger.info("testStepsExpectedValue:" + testStepsExpectedValue);
								logger.info("testCaseExecutionFlag:" + testCaseExecutionFlag);

								logger.info("Setting testCaseExecutionFlag:" + testCaseExecutionFlag + " to testCaseNumber : "  + testCaseNumber);
								stepInput.setExecutionFlag(testCaseExecutionFlag);

								logger.info("Executing performActions Method with the five arguments -"
										+ testStepsKeyword + " " + inputValue + " " + webElementValue + " " + testStepsAssertMethod + " " + testStepsActualValue + " " + testStepsExpectedValue);

								// Run tests
								result = comlib.runTest(testStepInputs);
								if (result.isResult() == true) {
									Object[] objectArray = new Object[] { testCaseNumber, testStepsSerialNumber, testStepsDescription, webElementValue, inputValue,
											testStepsKeyword, Constants.KEYWORD_PASS, result.getMessage() };
									// add the Object Array into a List object
									Input input = new Input(sheetTestSteps, testStepsSerialNumber,testCaseNumber, testCaseExecutionFlag, objectArray);
									stepInput.setObjArray(objectArray);

									TestStepInputs testStepInput = new TestStepInputs(testStepsSerialNumber, testCaseNumber, testStepsDescription, webElement, webElementValue, inputValue, testStepsKeyword, Constants.KEYWORD_PASS, result.getMessage(), testStepsAssertMethod, testStepsActualValue, testStepsExpectedValue);
									testStepInputsList.add(testStepInput);
									inputs.add(input);

								} else {

									Object[] objectArray = new Object[] { testCaseNumber, testStepsSerialNumber, testStepsDescription, webElementValue, inputValue,
											testStepsKeyword, Constants.KEYWORD_FAIL, result.getMessage() };
									// add the Object Array into a List object
									Input input = new Input(sheetTestSteps, testCaseSerialNumber, testCaseNumber, testCaseExecutionFlag, objectArray);
									stepInput.setObjArray(objectArray);
									objectArrays.add(objectArray);

									inputs.add(input);
									testCaseFlag = false;
								}
								// logger.info("Adding to step input list ...");
								// Filter out blank rows
								if (!stepInput.getTestCaseNumber().isEmpty() && stepInput.getExecutionFlag().equalsIgnoreCase("Y")) {
									logger.info(stepInput.getTestCaseNumber() + stepInput .getExecutionFlag());
									stepInputs.add(stepInput);
								}
							}

						} // END OF TEST STEPS LOOP

					} 
					if (testCaseExecutionFlag.equalsIgnoreCase("y")) {
						if (testCaseFlag == true) {

							logger.info("In test case execution flag - Y");		
							Object[] objectArray = new Object[] { description, testCaseSerialNumber, testCaseNumber, testCaseDescription, testCaseExecutionFlag, Constants.KEYWORD_PASS };
							Input input = new Input(sheetTestCases, testCaseSerialNumber, testCaseNumber, testCaseExecutionFlag, objectArray);
							caseInputs.add(input);

						} else {

							Object[] objectArray = new Object[] { description, testCaseSerialNumber, testCaseNumber, testCaseDescription, testCaseExecutionFlag, Constants.KEYWORD_FAIL };
							Input input = new Input(sheetTestCases, testCaseSerialNumber, testCaseNumber, testCaseExecutionFlag, objectArray);
							caseInputs.add(input);

						}
					} else {

						logger.info("In test case execution flag - N");
						Object[] objectArray = new Object[] { description, testCaseSerialNumber, testCaseNumber, testCaseDescription, testCaseExecutionFlag, Constants.KEYWORD_SKIPPED };
						Input input = new Input(sheetTestCases, testCaseSerialNumber, testCaseNumber, testCaseExecutionFlag, objectArray);
						caseInputs.add(input);

					}
				}

				// Add to list
				logger.info("Adding to case list ...");

			}
			if (executionFlag.equalsIgnoreCase("Y")) {
				if (testCaseFlag == true) {

					Object[] objectArray = new Object[] { serialNumber, description, executionFlag, Constants.KEYWORD_PASS };
					Input input = new Input(sheetTestSuite, serialNumber, description, executionFlag, objectArray);
					suiteInputs.add(input);
				} else {

					Object[] objectArray = new Object[] { serialNumber, description, executionFlag, Constants.KEYWORD_FAIL };
					Input input = new Input(sheetTestSuite, serialNumber, description, executionFlag, objectArray);
					suiteInputs.add(input);
				}
			} else {

				Object[] objectArray = new Object[] { serialNumber, description, executionFlag, Constants.KEYWORD_SKIPPED };
				Input input = new Input(sheetTestSuite, serialNumber, description, executionFlag, objectArray);
				suiteInputs.add(input);
			}	

		}

		// Creating header and executing the excel spreadsheet of generated result outputs
		String[] columns = {"Test Case Number", "Test Step Number", "Test Step Description", "Element", "Value", "Keyword",
				"Test Result", "Test Result Description"};
		writeToExcelFile(stepInputs, columns);

		String[] testCaseColumns = {"Test Sheet Name", "Test Step Number", "Test Case Number", "Test Step Description", "Execution Flag", "Result"};
		writeToExcelFile(caseInputs, testCaseColumns);

		String[] testSuiteColumns = {"Serial Number", "Test Sheet Name", "Execution Flag"," Test Suite Result"};
		writeToExcelFile(suiteInputs, testSuiteColumns);

		try {

			// Writes test results in Workbook
			workbook.write(fileOutputStream);
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Closing workbook ...");
		excelSheetDriver.closeworkbook();
	}

	private void writeToExcelFile(List<Input> inputDataList, String[] columns) {

		// Initialize
		int rowNum = 1;
		String testCase = null;
		// Iterate over data and write to sheet
		for (Input input : inputDataList) {

			if (!input.getSheetName().getSheetName().equals(testCase)) {

				testCase = input.getSheetName().getSheetName();
				// reset row number
				rowNum = 1;
			} else {
				// increment row number
				rowNum++;
			}

			logger.info("Sheet -> " + input.getSheetName().getSheetName() + " Test Case # -> " + input.getTestCaseNumber() + " Row Number is -> " + rowNum);

			// this creates a new row in the sheet
			Row row = input.getSheetName().createRow(rowNum);

			// Create a Row
			Row headerRow = input.getSheetName().createRow(0);

			// Create cells
			for(int i = 0; i < columns.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columns[i]);
				//cell.setCellStyle(headerCellStyle);
			}

			int cellnum = 0;
			for(Object obj: input.getObjArray()) {
				// this line creates a cell in the next column of that row
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String) {
					logger.info("obj.toString() -> " + obj.toString());
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					//logger.info("(Integer) obj) -> " + obj.toString());
					cell.setCellValue((Integer) obj);
				}
			}
			// Resize all columns to fit the content size
			for(int i = 0; i < columns.length; i++) {
				input.getSheetName().autoSizeColumn(i);
			}

		}

	}

}
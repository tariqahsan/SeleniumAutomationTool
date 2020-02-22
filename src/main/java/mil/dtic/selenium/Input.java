package mil.dtic.selenium;

import java.util.Arrays;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Input {
	
	private XSSFSheet sheetName;
	private String serialNumber;
	private String testCaseNumber;
	private String executionFlag;
	private Object[] objArray;
	
	// No-arg constructor
	public Input() {}

	public Input(XSSFSheet sheetName, String serialNumber, String testCaseNumber, String executionFlag,
			Object[] objArray) {
		super();
		this.sheetName = sheetName;
		this.serialNumber = serialNumber;
		this.testCaseNumber = testCaseNumber;
		this.executionFlag = executionFlag;
		this.objArray = objArray;
	}

	public XSSFSheet getSheetName() {
		return sheetName;
	}

	public void setSheetName(XSSFSheet sheetName) {
		this.sheetName = sheetName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getTestCaseNumber() {
		return testCaseNumber;
	}

	public void setTestCaseNumber(String testCaseNumber) {
		this.testCaseNumber = testCaseNumber;
	}

	public String getExecutionFlag() {
		return executionFlag;
	}

	public void setExecutionFlag(String executionFlag) {
		this.executionFlag = executionFlag;
	}

	public Object[] getObjArray() {
		return objArray;
	}

	public void setObjArray(Object[] objArray) {
		this.objArray = objArray;
	}

	@Override
	public String toString() {
		return "Input [sheetName=" + sheetName + ", serialNumber=" + serialNumber + ", testCaseNumber=" + testCaseNumber
				+ ", executionFlag=" + executionFlag + ", objArray=" + Arrays.toString(objArray) + "]";
	}

}

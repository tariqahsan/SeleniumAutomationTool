package mil.dtic.selenium;

public class TestCase {
	
	private String testCaseSerialNumber;
	private String testCaseNumber;
	private String testCaseDescription;
	private String testCaseExecutionFlag;
	private String result;
	private String message;
	
	public TestCase() {
		super();
	}

	public TestCase(String testCaseSerialNumber, String testCaseNumber, String testCaseDescription,
			String testCaseExecutionFlag, String result, String message) {
		super();
		this.testCaseSerialNumber = testCaseSerialNumber;
		this.testCaseNumber = testCaseNumber;
		this.testCaseDescription = testCaseDescription;
		this.testCaseExecutionFlag = testCaseExecutionFlag;
		this.result = result;
		this.message = message;
	}

	public String getTestCaseSerialNumber() {
		return testCaseSerialNumber;
	}

	public void setTestCaseSerialNumber(String testCaseSerialNumber) {
		this.testCaseSerialNumber = testCaseSerialNumber;
	}

	public String getTestCaseNumber() {
		return testCaseNumber;
	}

	public void setTestCaseNumber(String testCaseNumber) {
		this.testCaseNumber = testCaseNumber;
	}

	public String getTestCaseDescription() {
		return testCaseDescription;
	}

	public void setTestCaseDescription(String testCaseDescription) {
		this.testCaseDescription = testCaseDescription;
	}

	public String getTestCaseExecutionFlag() {
		return testCaseExecutionFlag;
	}

	public void setTestCaseExecutionFlag(String testCaseExecutionFlag) {
		this.testCaseExecutionFlag = testCaseExecutionFlag;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "TestCase [testCaseSerialNumber=" + testCaseSerialNumber + ", testCaseNumber=" + testCaseNumber
				+ ", testCaseDescription=" + testCaseDescription + ", testCaseExecutionFlag=" + testCaseExecutionFlag
				+ ", result=" + result + ", message=" + message + "]";
	}

}

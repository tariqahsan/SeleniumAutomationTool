package mil.dtic.selenium;

public class TestSuite {
	
	private String serialNumber;
	private String testSuiteDescription;
	private String executionFlag;
	private String testSuiteResult;
	private String result;
	private String message;
	
	public TestSuite() {
		super();
	}

	public TestSuite(String serialNumber, String testSuiteDescription, String executionFlag, String testSuiteResult,
			String result, String message) {
		super();
		this.serialNumber = serialNumber;
		this.testSuiteDescription = testSuiteDescription;
		this.executionFlag = executionFlag;
		this.testSuiteResult = testSuiteResult;
		this.result = result;
		this.message = message;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getTestSuiteDescription() {
		return testSuiteDescription;
	}

	public void setTestSuiteDescription(String testSuiteDescription) {
		this.testSuiteDescription = testSuiteDescription;
	}

	public String getExecutionFlag() {
		return executionFlag;
	}

	public void setExecutionFlag(String executionFlag) {
		this.executionFlag = executionFlag;
	}

	public String getTestSuiteResult() {
		return testSuiteResult;
	}

	public void setTestSuiteResult(String testSuiteResult) {
		this.testSuiteResult = testSuiteResult;
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
		return "TestSuite [serialNumber=" + serialNumber + ", testSuiteDescription=" + testSuiteDescription
				+ ", executionFlag=" + executionFlag + ", testSuiteResult=" + testSuiteResult + ", result=" + result
				+ ", message=" + message + "]";
	}

}

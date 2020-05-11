package mil.dtic.selenium;

public class TestStepInputs {
	
	String testStepsSerialNumber;
	String testStepCaseNumber;
	String testStepsDescription;
	String webElement;
	String webElementValue;
	String inputValue;
	String testStepsKeyword;
	String result;
	String message;
	String comparisonType;
	String valueOne;
	String valueTwo;
	String failMessage;
	
	public TestStepInputs() {
		// No arg constructor
	}

	// Field constructor
	public TestStepInputs(String testStepsSerialNumber, String testStepCaseNumber, String testStepsDescription,
			String webElement, String webElementValue, String inputValue, String testStepsKeyword, String result,
			String message, String comparisonType, String valueOne, String valueTwo, String failMessage) {
		super();
		this.testStepsSerialNumber = testStepsSerialNumber;
		this.testStepCaseNumber = testStepCaseNumber;
		this.testStepsDescription = testStepsDescription;
		this.webElement = webElement;
		this.webElementValue = webElementValue;
		this.inputValue = inputValue;
		this.testStepsKeyword = testStepsKeyword;
		this.result = result;
		this.message = message;
		this.comparisonType = comparisonType;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
		this.failMessage = failMessage;
	}

	public String getTestStepsSerialNumber() {
		return testStepsSerialNumber;
	}

	public void setTestStepsSerialNumber(String testStepsSerialNumber) {
		this.testStepsSerialNumber = testStepsSerialNumber;
	}

	public String getTestStepCaseNumber() {
		return testStepCaseNumber;
	}

	public void setTestStepCaseNumber(String testStepCaseNumber) {
		this.testStepCaseNumber = testStepCaseNumber;
	}

	public String getTestStepsDescription() {
		return testStepsDescription;
	}

	public void setTestStepsDescription(String testStepsDescription) {
		this.testStepsDescription = testStepsDescription;
	}

	public String getWebElement() {
		return webElement;
	}

	public void setWebElement(String webElement) {
		this.webElement = webElement;
	}

	public String getWebElementValue() {
		return webElementValue;
	}

	public void setWebElementValue(String webElementValue) {
		this.webElementValue = webElementValue;
	}

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public String getTestStepsKeyword() {
		return testStepsKeyword;
	}

	public void setTestStepsKeyword(String testStepsKeyword) {
		this.testStepsKeyword = testStepsKeyword;
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

	public String getComparisonType() {
		return comparisonType;
	}

	public void setComparisonType(String comparisonType) {
		this.comparisonType = comparisonType;
	}

	public String getValueOne() {
		return valueOne;
	}

	public void setValueOne(String valueOne) {
		this.valueOne = valueOne;
	}

	public String getValueTwo() {
		return valueTwo;
	}

	public void setValueTwo(String valueTwo) {
		this.valueTwo = valueTwo;
	}

	public String getFailMessage() {
		return failMessage;
	}

	public void setFailMessage(String failMessage) {
		this.failMessage = failMessage;
	}

	@Override
	public String toString() {
		return "TestStepInputs [testStepsSerialNumber=" + testStepsSerialNumber + ", testStepCaseNumber="
				+ testStepCaseNumber + ", testStepsDescription=" + testStepsDescription + ", webElement=" + webElement
				+ ", webElementValue=" + webElementValue + ", inputValue=" + inputValue + ", testStepsKeyword="
				+ testStepsKeyword + ", result=" + result + ", message=" + message + ", comparisonType="
				+ comparisonType + ", valueOne=" + valueOne + ", valueTwo=" + valueTwo + ", failMessage=" + failMessage
				+ "]";
	}
	
}

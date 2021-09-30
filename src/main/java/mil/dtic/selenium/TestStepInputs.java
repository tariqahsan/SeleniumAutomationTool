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
	String assertMethod;
	String actualValue;
	String expectedValue;
	
	
	public TestStepInputs() {
		// No arg constructor
	}

	// Field constructor
	public TestStepInputs(String testStepsSerialNumber, String testStepCaseNumber, String testStepsDescription,
			String webElement, String webElementValue, String inputValue, String testStepsKeyword, String result,
			String message, String assertMethod, String actualValue, String expectedValue) {
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
		this.assertMethod = assertMethod;
		this.actualValue = actualValue;
		this.expectedValue = expectedValue;
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

	public String getAssertMethod() {
		return assertMethod;
	}

	public void setAssertMethod(String assertMethod) {
		this.assertMethod = assertMethod;
	}

	public String getActualValue() {
		return actualValue;
	}

	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}

	public String getExpectedValue() {
		return expectedValue;
	}

	public void setExpectedValue(String expectedValue) {
		this.expectedValue = expectedValue;
	}

	@Override
	public String toString() {
		return "TestStepInputs [testStepsSerialNumber=" + testStepsSerialNumber + ", testStepCaseNumber="
				+ testStepCaseNumber + ", testStepsDescription=" + testStepsDescription + ", webElement=" + webElement
				+ ", webElementValue=" + webElementValue + ", inputValue=" + inputValue + ", testStepsKeyword="
				+ testStepsKeyword + ", result=" + result + ", message=" + message + ", assertMethod=" + assertMethod
				+ ", actualValue=" + actualValue + ", expectedValue=" + expectedValue + "]";
	}

}

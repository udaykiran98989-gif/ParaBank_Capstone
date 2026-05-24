package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferFundsPage {

	WebDriver driver;
	WebDriverWait wait;

	public TransferFundsPage(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver,
				Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}


	@FindBy(linkText = "Transfer Funds")
	WebElement transferFundsLink;

	@FindBy(id = "amount")
	WebElement txtAmount;

	@FindBy(xpath = "//input[@value='Transfer']")
	WebElement btnTransfer;

	@FindBy(xpath = "//h1")
	WebElement pageHeading;

	@FindBy(id = "showResult")
	WebElement resultBox;


	public void clickTransferFundsLink() {

		transferFundsLink.click();
	}

	public void enterAmount(String amount) {

		txtAmount.clear();
		txtAmount.sendKeys(amount);
	}

	public void clickTransferButton() {

		btnTransfer.click();
	}


	public boolean verifyTransferFundsPage() {

		wait.until(ExpectedConditions
				.visibilityOf(pageHeading));

		return pageHeading.getText()
				.contains("Transfer Funds");
	}

	public boolean verifyTransferSuccess() {

		wait.until(ExpectedConditions
				.visibilityOf(resultBox));

		String text = resultBox.getText();

		System.out.println(text);

		return text.contains("Transfer Complete");
	}

	public boolean verifyTransferMessage() {

		wait.until(ExpectedConditions
				.visibilityOf(resultBox));

		String text = resultBox.getText();

		System.out.println(text);

		return text.contains("transferred");
	}

	public boolean verifyInvalidTransfer() {

		wait.until(ExpectedConditions
				.visibilityOf(resultBox));

		String text = resultBox.getText();

		System.out.println(text);

		return text.length() > 0;
	}
}
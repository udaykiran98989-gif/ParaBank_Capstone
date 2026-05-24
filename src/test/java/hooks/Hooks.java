package hooks;

import base.BaseClass;
import io.cucumber.java.After;

public class Hooks extends BaseClass {

	@After
	public void closeBrowser() {

		if(driver != null) {

			driver.quit();
		}
	}
}
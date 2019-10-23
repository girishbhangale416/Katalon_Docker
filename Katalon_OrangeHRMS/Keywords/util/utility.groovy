package util
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class utility {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}



	@Keyword
	def get_table_data(){

		def policy  = [:]
		String key
		String val

		WebDriver driver = DriverFactory.getWebDriver()

		//'To locate table'
		WebElement Table = driver.findElement(By.xpath('//table/tbody'))

		// 'To locate rows of table it will Capture all the rows available in the table '
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))
		def row_count=  Rows.size()

		//'Find a matching text in a table and performing action'
		//'Loop will execute for all the rows of the table'

		for (int i = 0; i < row_count ; i++) {
			//'To locate columns(cells) of that specific row'

			List<WebElement> Cols = Rows.get(i).findElements(By.tagName('td'))

			for (int j = 0; j < Cols.size(); j++) {
				key = Cols.get(j).getText()

				val = Cols.get(j).getText()

				println(key + ":- " + val)
				//'Verifying the expected text in the each cell'
				//				if(j==0){
				//					key = Cols.get(j).getText()
				//				}else{
				//
				//					val = Cols.get(j).getText()
				//
				//				}
			}

			policy.put(key, val)
		}

		return policy
	}



	@Keyword
	def get_table_data1(){

		def policy  = [:]
		String key
		String val

		WebDriver driver = DriverFactory.getWebDriver()

		//'To locate table'
		WebElement Table = driver.findElement(By.xpath('//table/thead'))

		// 'To locate rows of table it will Capture all the rows available in the table '
		List<WebElement> Rows = Table.findElements(By.tagName('tr'))
		def row_count=  Rows.size()

		List<WebElement> Cols = Rows.get(i).findElements(By.tagName('th'))

	}


	@Keyword
	def Random_String(){
		String alphabet = (('A'..'N')+('P'..'Z')+('a'..'k')+('m'..'z')+('2'..'9')).join()
		def length = 6
		def key = new Random().with {(1..length).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()}

		return key

	}

	@Keyword
	def Random_Num(){

		Random rnd = new Random()
		//		println(rnd.next(9)) // 2 bits of random number that is, one of the following: 0,1,2,3
		//		println(rnd.nextInt((99 - 10) + 1) + 10) // random integer in the range of 0, 3  (so one of 0,1, 2)

		def R_num = rnd.nextInt((99 - 10) + 1) + 10
		return R_num.toString()

	}



	@Keyword
	def handleDatepicker(String Year,String Day,String Month){

		/*def intyear = findTestData(‘Give your Data File Path’).getValue(‘Year’, 1)
		 def intmonth = findTestData(‘Give your Data File Path’).getValue(‘Month’, 1)
		 def intdate = findTestData(‘Give your Data File Path’).getValue(‘Day’, 1)
		 */

		def intyear = Year

		def intmonth = Month

		def intdate = Day

		WebUI.selectOptionByLabel(findTestObject('Object Repository/Assigne_leave/datepicker-month'), intmonth, false)

		WebUI.selectOptionByValue(findTestObject('Object Repository/Assigne_leave/datepicker-year'), intyear, false)

		WebDriver driver2 = DriverFactory.getWebDriver()

		WebElement tb =driver2.findElement(By.xpath("//div[@class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']/table/tbody"))

		List hr = tb.findElements(By.tagName('tr'))

		List tcells

		for(int i=0;i<hr.size();i++)

		{

			tcells= hr.get(i).findElements(By.tagName("td"))



			for(int j=0;j<tcells.size();j++)

			{

				//System.out.println(tcells.get(j).getText());

				if(tcells.get(j).getText().toString().equals(intdate))

				{

					tcells.get(j).click()

				}

			}
		}


	}


}
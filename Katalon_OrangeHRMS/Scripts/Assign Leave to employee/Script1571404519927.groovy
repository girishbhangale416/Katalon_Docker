import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.mouseOver(findTestObject('Header_Menu/Leave/a_Leave'))

WebUI.click(findTestObject('Header_Menu/Leave/a_Assign Leave'))

WebUI.sendKeys(findTestObject('Assigne_leave/Emp_name'), emp_name)

not_run: WebUI.waitForElementPresent(findTestObject('auto_complete'), 5)

not_run: WebUI.click(findTestObject('auto_complete'))

WebUI.selectOptionByLabel(findTestObject('Assigne_leave/Type_dropdown'), leave_type, false)

WebUI.clearText(findTestObject('Assigne_leave/from_date'))

WebUI.click(findTestObject('Assigne_leave/from_date'))

CustomKeywords.'util.utility.handleDatepicker'(from_year, from_day, from_month)

WebUI.clearText(findTestObject('Assigne_leave/to_date'))

WebUI.click(findTestObject('Assigne_leave/to_date'))

CustomKeywords.'util.utility.handleDatepicker'(to_year, to_day, to_month)

WebUI.waitForElementPresent(findTestObject('Assigne_leave/assignleave_partialDays_dropdown'), 5)

WebUI.selectOptionByLabel(findTestObject('Assigne_leave/assignleave_partialDays_dropdown'), 'All Days', false)

WebUI.sendKeys(findTestObject('Assigne_leave/comment'), 'Test Katalon')

WebUI.waitForElementPresent(findTestObject('Assigne_leave/multiperiod_balance'), 20)

WebUI.click(findTestObject('Assigne_leave/Assign_btn'))

WebUI.waitForElementPresent(findTestObject('Assigne_leave/popup_ok_btn'), 5)

WebUI.click(findTestObject('Assigne_leave/popup_ok_btn'))


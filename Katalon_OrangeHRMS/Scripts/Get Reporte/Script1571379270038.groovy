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

WebUI.callTestCase(findTestCase('Login to OrangeHRMS'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Header_Menu/Leave/a_Leave'))

WebUI.mouseOver(findTestObject('Header_Menu/Leave/a_Reports'))

WebUI.click(findTestObject('Header_Menu/Leave/a_Leave Entitlements and Usage Report'))

WebUI.selectOptionByLabel(findTestObject('Leave Entitlements and Usage Report/select_-- Select --Leave TypeEmployee'), 'Employee', 
    false)

WebUI.sendKeys(findTestObject('Leave Entitlements and Usage Report/input__leave_balanceemployeeempName'), 'John Smith')

WebUI.click(findTestObject('auto_complete'))

WebUI.click(findTestObject('Leave Entitlements and Usage Report/input__view'))

not_run: data = CustomKeywords.'util.utility.get_table_data'()

not_run: println(data)

CustomKeywords.'util.utility.get_table_data1'()


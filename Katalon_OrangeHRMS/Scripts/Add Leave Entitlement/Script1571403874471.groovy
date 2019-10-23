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

not_run: WebUI.click(findTestObject('Header_Menu/a_Dashboard'))

WebUI.waitForElementVisible(findTestObject('Header_Menu/Leave/a_Leave'), 5)

WebUI.mouseOver(findTestObject('Header_Menu/Leave/a_Leave'))

WebUI.waitForElementVisible(findTestObject('Header_Menu/Leave/Add_Entitlement/a_Entitlements'), 5)

WebUI.mouseOver(findTestObject('Header_Menu/Leave/Add_Entitlement/a_Entitlements'))

not_run: WebUI.click(findTestObject('Header_Menu/Leave/a_Entitlements'))

WebUI.click(findTestObject('Header_Menu/Leave/Add_Entitlement/Add_Entitlement'))

WebUI.sendKeys(findTestObject('Add_Leave/Emp_name'), emp_name)

WebUI.click(findTestObject('auto_complete'))

WebUI.selectOptionByLabel(findTestObject('Add_Leave/leave_type_dropdown'), leave_types, false)

WebUI.selectOptionByLabel(findTestObject('Add_Leave/Leave_period'), '2020-01-01 - 2020-12-31', false)

WebUI.sendKeys(findTestObject('Add_Leave/entitlements_no'), num_leave)

WebUI.click(findTestObject('Add_Leave/save_btn'))


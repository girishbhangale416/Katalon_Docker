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

not_run: WebUI.callTestCase(findTestCase('Login to OrangeHRMS'), [('user_name') : 'admin', ('password') : 'Bitnami.12345'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Header_Menu/Leave/a_Leave'))

WebUI.mouseOver(findTestObject('Header_Menu/Leave/a_Configure'))

WebUI.click(findTestObject('Header_Menu/Leave/leave_type'))

WebUI.click(findTestObject('leave_type/Add_type'))

WebUI.sendKeys(findTestObject('leave_type/Type_name'), type_name)

WebUI.click(findTestObject('leave_type/leaveType_excludeIfNoEntitlement_CHECKBOX'))

WebUI.click(findTestObject('leave_type/Save_button'))


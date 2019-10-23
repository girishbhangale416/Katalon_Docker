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

WebUI.callTestCase(findTestCase('Login to OrangeHRMS'), [('user_name') : 'admin', ('password') : 'Bitnami.12345'], FailureHandling.STOP_ON_FAILURE)

Usr_name = CustomKeywords.'util.utility.Random_String'()

first_n = CustomKeywords.'util.utility.Random_String'()

last_n = CustomKeywords.'util.utility.Random_String'()

name = ((first_n + ' ') + last_n)

WebUI.callTestCase(findTestCase('Add employee'), [('First_name') : first_n, ('Last_Name') : last_n, ('emp_ID') : CustomKeywords.'util.utility.Random_Num'()
        , ('User_name') : Usr_name], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Employee_info/Employee_Name', [('Name') : name]), 15)

WebUI.click(findTestObject('Header_Menu/PIM/a_Employee List'))

WebUI.click(findTestObject('welcom_link'))

WebUI.waitForElementVisible(findTestObject('Logout_btn'), 15)

WebUI.click(findTestObject('Logout_btn'))

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('Login to OrangeHRMS'), [('user_name') : Usr_name, ('password') : 'Synerzip@123'], FailureHandling.STOP_ON_FAILURE)

Emp_name = WebUI.getText(findTestObject('welcom_link'))

assert true == Emp_name.endsWith(first_n)

WebUI.click(findTestObject('welcom_link'))

WebUI.click(findTestObject('Logout_btn'))

WebUI.closeBrowser()


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

leave_type = CustomKeywords.'util.utility.Random_String'()

WebUI.callTestCase(findTestCase('Add leave type'), [('type_name') : leave_type], FailureHandling.STOP_ON_FAILURE)

WebUI.refresh()

WebUI.delay(10)

WebUI.callTestCase(findTestCase('Add Leave Entitlement'), [('leave_types') : leave_type, ('emp_name') : name, ('num_leave') : '15'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Assign Leave to employee'), [('emp_name') : name, ('leave_type') : leave_type, ('from_year') : '2020'
        , ('to_year') : '2020', ('from_day') : '1', ('from_month') : 'Jan', ('to_day') : '31', ('to_month') : 'Dec'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Assigne_leave/multiperiod_balance'), 20)

WebUI.click(findTestObject('welcom_link'))

WebUI.waitForElementVisible(findTestObject('Logout_btn'), 15)

WebUI.click(findTestObject('Logout_btn'))

WebUI.closeBrowser()


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

not_run: WebUI.callTestCase(findTestCase('Login to OrangeHRMS'), [:], FailureHandling.STOP_ON_FAILURE)

Password = 'Synerzip@123'

WebUI.mouseOver(findTestObject('Header_Menu/PIM/a_PIM'))

WebUI.click(findTestObject('Header_Menu/PIM/a_Add Employee'))

WebUI.sendKeys(findTestObject('Add_Employee/input__firstName'), First_name)

WebUI.sendKeys(findTestObject('Add_Employee/input__lastName'), Last_Name)

WebUI.clearText(findTestObject('Add_Employee/input_Employee Id_employeeId'))

WebUI.sendKeys(findTestObject('Add_Employee/input_Employee Id_employeeId'), emp_ID)

WebUI.click(findTestObject('Add_Employee/input_Create Login Details_chkLogin'))

WebUI.sendKeys(findTestObject('Add_Employee/input__user_name'), User_name)

WebUI.sendKeys(findTestObject('Add_Employee/input__user_password'), Password)

WebUI.sendKeys(findTestObject('Add_Employee/input__re_password'), Password)

WebUI.click(findTestObject('Add_Employee/input__btnSave'))

println(User_name)


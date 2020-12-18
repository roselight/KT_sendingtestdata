import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestData 

//Data Files alanında eklemiş olduğumuz excel veri seti dosyasındaki verileri kullanabilmek için TestData tanımlamasını gerçekleştiriyoruz.
TestData data = findTestData("trendyolSearchData")

//For yaparak veri dosyasındaki satırlarda bulunan verileri sırası ile çağırarak test case içerisinde kullanıyoruz.
for (def index : (1..data.getRowNumbers()))

{
	WebUI.openBrowser('')
		
	//web sitesine git
	WebUI.navigateToUrl('trendyol.com')

	WebUI.click(findTestObject('Trendyol/popUp_close'))

	WebUI.click(findTestObject('Trendyol/search_box'))

	/***
	 * data.getValue() metodunda ilk alan excel veri dosyamızdaki parametre olarak kullanacağımız verilerin bulunduğu sütun adı.
	 *ikinci kısım ise index yani for döngüsünde sırasıyla hangi satırda ise o satırdaki veriyi okuyarak parametre gönderme işlemini yapmakta.
	 **/
	WebUI.setText(findTestObject('Trendyol/search_box'), data.getValue("ara",index))

	WebUI.click(findTestObject('Trendyol/search_btn'))

	WebUI.delay(1)

	WebUI.closeBrowser()
}




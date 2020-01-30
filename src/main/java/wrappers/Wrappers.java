package wrappers;

public interface Wrappers {
	
	public void invokeApp(String browser, String url);
	
	public void enterTextByXpath(String text, String data);
	
	public void selectTextByXpath(String xpath, String value);
	
	public void verifyTextByXpath(String text, String data);
	
	public void clickByXpath(String Xpath);
	
	public void getTextByXpath(String Xpath);
	
	public void mouseHoverByXpath(String xpath);
	
	public void closeAllBrowsers();
	
	public void geAttributesByXpath(String xPath, String Attribute);	
	
	public void pageDownbyxPath(String xPath);
	
	public void tabkeys(String xPath);
	
	public void arrowDownbyxPath(String xPath );
	
	public void clearText(String name);
	
	public void switchToParentWindow();
	
	public void switchToLastWindow();
	
	public void acceptAlert();
	
	public void dismissAlert();
	
	public void getAlertText();
	
	public void ImplicitWaitTillElementVisible(String xpath);
	
	
	
	
	
	
	

}

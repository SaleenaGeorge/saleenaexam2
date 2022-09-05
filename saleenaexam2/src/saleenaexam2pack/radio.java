package saleenaexam2pack;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class radio {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//RADIO BUTTON SELECTION
		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		
		//SUGGESTION CLASS
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("Canada");
		Thread.sleep(4000);
		
        List<WebElement> dropdown= driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		
		for (WebElement a:dropdown) {
			
			if(a.getText().contains("Canada")){
				
				a.click();
				Thread.sleep(2000);}

}
		
		//DROPDOWN
		WebElement drop=driver.findElement(By.id("dropdown-class-example"));
		drop.click();
				Select sele =new Select(drop);
				sele.selectByValue("option1");
				
		//Checkbox
				driver.findElement(By.name("checkBoxOption1")).click();
				
		//Switch window 
				String parentwindow=driver.getWindowHandle();
				driver.findElement(By.id("openwindow")).click();
				Set<String> Childwindow=driver.getWindowHandles();
				
				for(String a:Childwindow) {
					
					driver.switchTo().window(a);
					Thread.sleep(4000);
					System.out.println(driver.getTitle());
					if(driver.getTitle().contains("Academy")) {
						driver.close();}
					}
				
driver.switchTo().window(parentwindow);
	    
        //Switch tab
        driver.findElement(By.partialLinkText("Open")).click();
        Set<String> Childwindow1=driver.getWindowHandles();

               for(String b:Childwindow1) {
	
	            driver.switchTo().window(b);
	            Thread.sleep(4000);
	            System.out.println(driver.getTitle());
	            if(driver.getTitle().contains("Rahul")) {
		        driver.close();}
               }
 driver.switchTo().window(parentwindow);
               
               //swith to alert example
               driver.findElement(By.cssSelector("input[id='name']")).sendKeys("saleena");
               driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
               
               Alert alt1=driver.switchTo().alert();
               System.out.println(alt1.getText());
               Thread.sleep(2000);
               alt1.accept();
               
               driver.findElement(By.cssSelector("input#confirmbtn")).click();
               
               Alert alt2=driver.switchTo().alert();
               System.out.println(alt2.getText());
               Thread.sleep(2000);
               alt2.dismiss();
	
               //Element displayed example
               
               driver.findElement(By.name("show-hide")).sendKeys("saleena");
               driver.findElement(By.cssSelector("input#hide-textbox")).click();
               Thread.sleep(2000);
               driver.findElement(By.cssSelector("input#show-textbox")).click();
               
               //Webtable
               
               List <WebElement> elements=driver.findElements(By.xpath("//*[@class=\"table-display\"]/tbody/tr/td[3]"));
       		
               for (int i=0; i<elements.size();i++){
            	      System.out.println("price of courses:" + elements.get(i).getText());
       		}
               
              
               
               //Mouse hover
              
               Actions act=new Actions(driver);
               WebElement com=driver.findElement(By.id("mousehover"));
               act.moveToElement(com).build().perform();
               Thread.sleep(3000);
               WebElement com2=driver.findElement(By.xpath("//a[text()='Top']"));
               act.moveToElement(com2).click().perform();
               
               //iframe
               
               driver.switchTo().frame("courses-iframe");
               JavascriptExecutor js=(JavascriptExecutor)driver;
               js.executeScript("window.scrollBy(0,8000)");
               driver.findElement(By.xpath("//a[text()='VIEW ALL COURSES']")).click();
               driver.switchTo().defaultContent();               
               
               //Fixed header webtable
               
               List <WebElement> element1=driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr/td[4]"));
          		
               for (int i=0; i<element1.size();i++){
            	      System.out.println("Amount:" + element1.get(i).getText());
        		}
               
               int sum_price=0;
               for(WebElement e : element1)
               {
                  sum_price= sum_price+Integer.parseInt(e.getText());
               }
               System.out.println("total price: "+sum_price);

               
               
	}}
	
             
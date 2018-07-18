package testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
    @Parameters("browser")
	@Test
	public void testlogic( String value)
	{
    	WebDriver driver=null;
    	System.out.println(value);
        if (value.equals("chrome")) {
			
        	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
    		driver=new ChromeDriver();
    		
		} else if(value.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver","C:\\Program Files\\geckodriver.exe");
    		driver=new FirefoxDriver();
    		
		}
        else {
        	System.out.println("No driver Found");
        }
		
		driver.get("https://github.com/login");
		driver.findElement(By.xpath("//*[@id='login_field']")).sendKeys("Rashsrikath");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Rash@1992");
		driver.findElement(By.xpath("//*[@value='Sign in']")).click();
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "GitHub");
		System.out.println("Continue");
		if (title.contains("GitHub")) {
			 System.out.println("Successfully logged In");
			 System.out.println("Successfully logged In");
		} else {
			System.out.println("Failed to login to browser");

		}
	}

}

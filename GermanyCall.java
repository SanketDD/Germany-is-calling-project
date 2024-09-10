import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GermanyCall {

    public String baseurl ="https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcommon%2Fhome%2F";
    public WebDriver driver;

    @BeforeTest
    public void setup()
    {
        System.out.println("Before test executed");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void loginTest() {
        //Find Email
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("sanket.dambhare10@gmail.com");

        //find password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Sanket123@");

        //login button click
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div/form/div[3]/button")).click();

        //verify if login is successful by checking the page title or specific element
        String PageTitle = driver.getTitle();
        if (PageTitle.equals("Germany is Calling")) {
            System.out.println("Login is successful");
        } else {
            System.out.println("Login failed");
        }
    }
        public void Logout()
        {
            // we have clicked on Sanket dropdown and click on it
            driver.findElement(By.xpath("//*[@id=\"dropdownUser1\"]/span")).click();

            // click on logout button directly
            driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/ul/li[3]/a/span")).click();
        }


    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000); //wait for 5 sec before quit

        //calling logout function
        Logout();
        driver.close();
        driver.quit();
    }
}

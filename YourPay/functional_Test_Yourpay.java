//TEST CASE ID = THA | BP-005
//1. User enter the link https://yourpay.co
//2. verify user on the homepage
//3. Click Blog menu in navbar
//4. verify that you see the text "Most Popular"
//5. Click the name one of the blog
//6. Verify the text title of the Blog


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class functional_Test_Yourpay {

    WebDriver driver;

    @Test
    public void blogFeature() throws InterruptedException {
        //1. Buka browser enter the link yourpay.co
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://yourpay.co");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //2. verify user on the homepage
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'All in One Stop Financial Mobile App Serving Indonesian Globally')]"))));
        String myTextActual = driver.findElement(By.xpath("//p[contains(.,'All in One Stop Financial Mobile App Serving Indonesian Globally')]")).getText();
        String myTextExpected = "All in One Stop Financial Mobile App Serving Indonesian Globally";

        Assert.assertEquals(myTextActual, myTextExpected);

        //3. CLick Block Menu in Navbar menu
        WebElement navBlog = driver.findElement(By.xpath(".//a[text()='Blog']"));
        navBlog.click();

        //4. Verify that you see the text "Most Popular"
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Most Popular')]"))));
        String mostPopularTextActual = driver.findElement(By.xpath("//h3[contains(.,'Most Popular')]")).getText();
        String mostPopularTextExpected = "Most Popular";

        Assert.assertEquals(mostPopularTextActual, mostPopularTextExpected);

        //5. Click the name one of the Blog
        WebElement titleBlog = driver.findElement(By.cssSelector("div.wrapper-text-popular-article"));
        titleBlog.click();

        //6. Verify the text title of the Blog
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3.title"))));
        String titleBlogTextActual = driver.findElement(By.cssSelector("h3.title")).getText();
        String titleBlogTextExpected = "6 Hal yang Perlu Calon PMI Ketahui Sebelum Bekerja Di Luar Negeri";

        Assert.assertEquals(titleBlogTextActual, titleBlogTextExpected);

        Thread.sleep(3);

        // Close Browser
        driver.quit();

    }
}

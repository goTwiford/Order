package web.order;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.NameList;

public class SeleniumGitProject {

    public static void main(String[] args) throws IOException, InterruptedException {
    	System.setProperty("webdriver.chrome.driver",
				"/Users/goaratwiford/Documents/selenium-dependencies/drivers/chromedriver");
		WebDriver driver= new ChromeDriver();
  
  driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
  Thread.sleep(1000);
  driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
  Thread.sleep(1000);
  driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
  Thread.sleep(1000);
  driver.findElement(By.name("ctl00$MainContent$login_button")).click();
  Thread.sleep(1000);
  driver.findElement(By.xpath("//a[contains(@href,'Process.aspx')]")).click();
  
  Random rn = new Random();
  int rand = rn.nextInt(100);
  driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(""+rand);
  Thread.sleep(1000);
  
  List<String> nameList = new ArrayList<>();
  FileReader fr = new FileReader("name.txt");
  BufferedReader br = new BufferedReader(fr);
  String temp = "";
  while(temp!=null) {
       temp = br.readLine();
  nameList.add(temp);
  }
  String name = "John " + nameList.get(rn.nextInt(100))+" Smith";
    
  driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(name);
  Thread.sleep(1000);
  
  driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
  Thread.sleep(1000);
  driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Vienna");
  Thread.sleep(1000);
  driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
  Thread.sleep(1000);
  driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("22046");
  Thread.sleep(1000);
  
  
  List<String> optionList = new ArrayList<>();
  optionList.add("ctl00_MainContent_fmwOrder_cardList_0");
  optionList.add("ctl00_MainContent_fmwOrder_cardList_1");
  optionList.add("ctl00_MainContent_fmwOrder_cardList_2");
  
  int rand2 = rn.nextInt(3);
  System.out.println(rand2);
  long cardNumber = 0000000000;
  driver.findElement(By.id(optionList.get(rand2))).click();
  switch (rand2){
  case 0:
      String card="4";
      for(int i = 0; i<15;i++) {
    card+=rn.nextInt(10);
      }
      cardNumber=Long.parseLong(card);
      break;
  case 1:
      String card2="5";
      for(int i = 0; i<15;i++) {
    card2+=rn.nextInt(10);
      }
      cardNumber=Long.parseLong(card2);
      break;
  case 2:
      String card3="3";
      for(int i = 0; i<14;i++) {
    card3+=rn.nextInt(10);
      }
      cardNumber=Long.parseLong(card3);
      break;
  }
  driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(""+cardNumber);
  Thread.sleep(1000);
  driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("04/20");
  Thread.sleep(1000);
  
  driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
  Thread.sleep(1000);
  if (driver.findElement(By.xpath("//strong[contains(text(),'New order has been successfully added.')]"))
		  .isDisplayed()) {

		    System.out.println("Order was submited successfully... ");
		}

  
	}

}
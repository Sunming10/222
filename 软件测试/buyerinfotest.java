package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class buyerinfotest {
	String name;
	String phone;
	String address;
	String result;
	private static WebDriver d;
	@Parameterized.Parameters
    public static Collection prepareData() throws IOException {
		ArrayList<String[]> obj = new ArrayList<>();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Eclipse\\test\\src\\test\\buyerinfotest.csv"),"GBK"));
	    String line=null;
	    
	    while ((line = reader.readLine()) != null) {
	    	String[] nextLine;
	    	nextLine = line.split(",");
            obj.add(nextLine);
        }
        return obj;	
	}
	@Before
	public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D:\\Eclipse\\test\\src\\test\\geckodriver.exe");
        d = new FirefoxDriver();
    }
	public buyerinfotest(String name,String phone,String address,String result) {
		this.name=name;
		this.phone=phone;
		this.address=address;
		this.result=result;
	}
	@Test
	public void test() throws InterruptedException {
		d.get("http://localhost:8080/#/welcome");
		d.findElement(By.id("buyinfo")).click();
		d.findElement(By.id("buyer_name")).sendKeys(name);
		d.findElement(By.id("buyer_phone")).sendKeys(phone);
		d.findElement(By.id("buyer_address")).sendKeys(address);
		d.findElement(By.id("buyinfo_submit")).click();
		System.out.println(name);
		System.out.println(phone);
		System.out.println(address);
		Thread.sleep(500);
		assertEquals(result, d.findElement(By.className("el-message__content")).getText());
		d.close();
	}


}

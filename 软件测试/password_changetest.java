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
import org.openqa.selenium.support.ui.Sleeper;

@RunWith(Parameterized.class)
public class password_changetest {

	String oldpass;
	String pass1;
	String pass2;
	String result;
	private static WebDriver d;
	@Parameterized.Parameters
    public static Collection prepareData() throws IOException {
		ArrayList<String[]> obj = new ArrayList<>();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Eclipse\\test\\src\\test\\password_changetest.csv"),"GBK"));
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
	public password_changetest(String oldpass,String pass1,String pass2,String result) {
		this.oldpass=oldpass;
		this.pass1=pass1;
		this.pass2=pass2;
		this.result=result;
	}
	@Test
	public void test() throws InterruptedException {
		d.get("http://localhost:8080/#/login");
		d.findElement(By.id("login_btn")).click();
		Thread.sleep(5000);
		d.findElement(By.id("infochange")).click();
		d.findElement(By.id("old_pass")).sendKeys(oldpass);
		d.findElement(By.id("newpass1")).sendKeys(pass1);
		d.findElement(By.id("newpass2")).sendKeys(pass2);
		d.findElement(By.id("change_sub")).click();
		System.out.println(oldpass);
		System.out.println(pass1);
		System.out.println(pass2);
		assertEquals(result, d.findElement(By.className("el-message__content")).getText());
		d.close();
	}

}

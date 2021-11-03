package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import au.com.bytecode.opencsv.CSVReader;




@RunWith(Parameterized.class)
public class logintest {
	String username;
	String password;
	String result;
	Charset ch = Charset.forName("UTF-8");
	private static WebDriver d;
	@Parameterized.Parameters
    public static Collection prepareData() throws IOException {
		ArrayList<String[]> obj = new ArrayList<>();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Eclipse\\test\\src\\test\\logintest.csv"),"GBK"));
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
	public logintest(String username,String password,String result) {
		this.username=username;
		this.password=password;
		this.result=result;
	}
	@Test
	public void test() throws InterruptedException {
		d.get("http://localhost:8080/#/login");
		d.findElement(By.id("msg_login")).sendKeys(username);
		d.findElement(By.id("msg_password")).sendKeys(password);
		d.findElement(By.id("btn_login")).click();
		System.out.println(username);
		System.out.println(password);
		System.out.println(result);
		assertEquals(result, d.findElement(By.className("el-message__content")).getText());
		d.close();
	}

}

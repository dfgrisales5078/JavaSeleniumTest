// Diego Grisales
// Assignment 2
// CEN 4072 - Software Testing
// 03/02/2023

package com.example.javaseleniumtest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.safaridriver().setup();
        WebDriver safariDriver = new SafariDriver();
        safariDriver.manage().window().maximize();

        //--------------   Add/Delete Web Element  --------------
        safariDriver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(4000);
        WebElement addElementButton = safariDriver.findElement(
                By.xpath("//*[@id=\"content\"]/div/button"));
        addElementButton.click();
        Thread.sleep(4000);
        WebElement deleteElementButton = safariDriver.findElement(
                By.xpath("//*[@id=\"elements\"]/button"));
        deleteElementButton.click();

        //--------------   Enter text in text and search button  --------------
        safariDriver.get("https://demo.automationtesting.in/Register.html");
        // Enter first and last name using xpath
        safariDriver.findElement(
                By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input"))
                .sendKeys("John");
        safariDriver.findElement(
                By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input"))
                .sendKeys("Doe");
        Thread.sleep(4000);
        // clear first and last name text
        safariDriver.findElement(
                By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).clear();
        safariDriver.findElement(
                By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).clear();
        Thread.sleep(4000);

        // Enter email and phone number using cssSelector
        safariDriver.findElement(By.cssSelector("#eid > input")).sendKeys("email@gmail.com");

        // Enter phone number using xpath
        safariDriver.findElement(
                By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input"))
                .sendKeys("2397777777");

        //--------------   Checkboxes and Radio buttons   --------------
        safariDriver.findElement(
                By.cssSelector("#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(1) > input")).click();

        for (int i = 1; i <= 3; i++) {
            safariDriver.findElement(By.id("checkbox" + i)).click();
        }

        safariDriver.findElement(By.id("Button1")).click();
        Thread.sleep(4000);

        //--------------   Dropdown Menus  --------------
        safariDriver.get("https://leafground.com/select.xhtml;jsessionid=node017poao36bf3jpf8z96wy3hxk1135438.node0");
        Thread.sleep(4000);
        Select fav_ui_automation_tool_dropdown = new Select(safariDriver.findElement(
                By.className("ui-selectonemenu")));
        fav_ui_automation_tool_dropdown.selectByVisibleText("Selenium");
        Thread.sleep(4000);

        // -------------- Drag and Drop ----------------
        safariDriver.get("https://demoqa.com/droppable");
        Thread.sleep(4000);
        Actions action = new Actions(safariDriver);
        WebElement drag = safariDriver.findElement(By.id("draggable"));
        WebElement drop = safariDriver.findElement(By.id("droppable"));
        action.dragAndDrop(drag, drop).build().perform();
        Thread.sleep(4000);

        // --------------  Click on using Link Text & Partial Link Text  --------------
        safariDriver.findElement(By.linkText("Accept")).click();
        Thread.sleep(4000);
        safariDriver.findElement(By.partialLinkText("Propogation")).click();
        Thread.sleep(4000);

        // -------------- Get the title and current url of the selected webpage --------------
        System.out.println(safariDriver.getTitle());
        String current_url = safariDriver.getCurrentUrl();
        System.out.println(current_url);

        // ---------- List the size and display the number of Web Elements present in the current Webpage. -----------
        safariDriver.get("https://www.amazon.com/");
        List<WebElement> all_elements = safariDriver.findElements(By.tagName("a"));
        System.out.println("Size of elements: " + all_elements.size() + "\n");

        for (WebElement element : all_elements) {
            System.out.println(element.getText());
        }

        safariDriver.close();

    }
}

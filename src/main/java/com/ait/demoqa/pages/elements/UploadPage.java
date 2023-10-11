package com.ait.demoqa.pages.elements;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadPage performKeyEventUsingRobot() {
        pause(1000);

        clickWithRectangle(uploadFile,2,4);

        //создаем объект класса робот
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //нажимаем на Shift
        robot.keyPress(KeyEvent.VK_SHIFT);
        //нажимаем на d, а получим Shift+d = D
        robot.keyPress(KeyEvent.VK_D);
        //отпускаем SHIFT
        robot.keyRelease(KeyEvent.VK_SHIFT);
        pause(1000);
        //нажимаем на 1
        robot.keyPress(KeyEvent.VK_1);
        //нажимаем на .
        robot.keyPress(KeyEvent.VK_PERIOD);
        //нажимаем на t
        robot.keyPress(KeyEvent.VK_T);
        //нажимаем на x
        robot.keyPress(KeyEvent.VK_X);
        //нажимаем на t
        robot.keyPress(KeyEvent.VK_T);
        //нажать enter
        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }

    @FindBy(id = "uploadFilePath")//D1.txt
    WebElement uploadFilePath;
    public UploadPage assertPath(String path) {
        Assert.assertTrue(isTextPresent(uploadFilePath, path));
        return this;
    }

    public UploadPage performMouseEventUsingRobot() {
        pause(1000);

        clickWithRectangle(uploadFile,2,4);
        //создаем объект класса робот
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //найдем разрешение экрана
        Dimension dimension =  driver.manage().window().getSize();
        System.out.println("Dimension x and y: "
                + dimension.getWidth() + " "
                + dimension.getHeight());
        //ищем точку расположения файла
        int x = dimension.getWidth() / 4 + 550;
        int y = dimension.getHeight() /2;

        //двигаем мышкой по заданным координатам:
        robot.mouseMove(x,y);
        pause(1500);

        //кликаем-нажимаем левой кнопкой мыши на наведенный объект:
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //кликаем-отпускаем левой кнопкой мыши на наведенный объект:
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1500);

        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }

}


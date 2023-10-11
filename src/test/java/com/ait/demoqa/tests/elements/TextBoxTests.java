package com.ait.demoqa.tests.elements;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.elements.TextBoxPage;
import com.ait.demoqa.pages.interactions.DroppablePage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox().hideIFrames();
    }
    @Test
    public void keyBoardEventTest() {
        new TextBoxPage(driver).keyBoardEvent()
        .assertTextEquals();
    }
}

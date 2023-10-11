package com.ait.demoqa.tests.elements;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.elements.LinksPage;
import com.ait.demoqa.pages.links.BrokenLinksImagesPage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
    }

    @Test
    public void getAllLinksTest() {
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).getAllLinks();
    }

    @Test
    public void  checkBrokenLinksTest() {
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).checkBrokenLinks();
    }

    @Test
    public void checkBrokenImages() {
        new SidePanel(driver).selectBrokenLinksImages();
        new BrokenLinksImagesPage(driver).checkBrokenImages();
    }
}

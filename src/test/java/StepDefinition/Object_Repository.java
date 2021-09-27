package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class Object_Repository {
    WebDriver driver;

    public Object_Repository(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //********************UserName Text Box*************
    @FindBy(how= How.ID,using="user-name")
    public WebElement UserNameTextBox;

    //********************Password Text Box*************
    @FindBy(how=How.ID,using="password")
    public WebElement PasswordTextBox;

    //********************Login button******************
    @FindBy(how=How.ID,using="login-button")
    public WebElement LoginButton;

    //********************Product Sort Container Drop Down****************
    @FindBy(how=How.XPATH,using="//*[@class='product_sort_container']")
    public WebElement ProductSortContainer_Dropdown;

    //********************Inventory Name*********************
    @FindBy(how=How.XPATH,using="//div[@class='inventory_item_name'][contains(text(),'Sauce Labs Onesie')]")
    public WebElement Inventory_Name;

    //********************Inventory Name Add To Cart*********************
    @FindBy(how=How.ID,using="add-to-cart-sauce-labs-onesie")
    public WebElement Inventory_Name_ATC;

    //********************Shopping Cart Link*********************
    @FindBy(how=How.XPATH,using="//span[@class='shopping_cart_badge']")
    public WebElement Shopping_Cart_Link;

    //********************Shopping Cart Page Title*********************
    @FindBy(how=How.XPATH,using="//span[@class='title']")
    public WebElement Shopping_Cart_PageTitle;

    //********************Remove Button*********************
    @FindBy(how=How.XPATH,using="//*[@class='btn btn_secondary btn_small cart_button'][contains(text(),'Remove')]")
    public WebElement Remove_Button;

    //********************Menu Button*********************
    @FindBy(how=How.ID,using="react-burger-menu-btn")
    public WebElement Menu_Button;

    //********************LogOut Button*********************
    @FindBy(how=How.ID,using="logout_sidebar_link")
    public WebElement LogOut_Button;
}

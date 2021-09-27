package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class saucedemo{

    Object_Repository or=new Object_Repository(Hook.driver);
    String ActualItem_Name;
    @Given("Navigate to the site URL")
    public void navigateToTheSiteURL() throws IOException, InterruptedException {
        Hook.get_URL();
    }


    @And("The user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
         or.LoginButton.click();
    }

    @Given("The user enters the username as {string} and password as {string}")
    public void theUserEntersTheUsernameAsAndPasswordAs(String arg0, String arg1) {
        or.UserNameTextBox.sendKeys(arg0);
        or.PasswordTextBox.sendKeys(arg1);
    }

    @When("The user clicks on the product sort container")
    public void theUserClicksOnTheProductSortContainer() {
           or.ProductSortContainer_Dropdown.click();
    }

    @And("Select the sort option as {string}")
    public void selectTheSortOptionAs(String arg0) {
        Select s=new Select(or.ProductSortContainer_Dropdown);
        s.selectByVisibleText(arg0);
    }

    @And("Select the inventory item name as {string}")
    public void selectTheInventoryItemNameAs(String arg0) {
       //or.Inventory_Name.click();

    }

    @And("Select the inventory item name as Sauce Labs Onesie")
    public void selectTheInventoryItemNameAsSauceLabsOnesie() {
        ActualItem_Name=or.Inventory_Name.getText();
        or.Inventory_Name.click();
    }

    @When("The user clicks on the Add to cart button")
    public void theUserClicksOnTheAddToCartButton() {
        or.Inventory_Name_ATC.click();
    }

    @And("The user navigates to the shopping cart link")
    public void theUserNavigatesToTheShoppingCartLink() {
        or.Shopping_Cart_Link.click();
        String ExpectedCartPageTitle=or.Shopping_Cart_PageTitle.getText();
        String ActualCartPageTitle=Hook.prop.getProperty("ExpectedCartPageTitle");
        try{
            Assert.assertEquals(ExpectedCartPageTitle,ActualCartPageTitle);
            System.out.println("Assertion Passed");
        }
        catch (AssertionError e){
            e.printStackTrace();
        }
    }

    @Then("Validate the item name in the cart")
    public void validateTheItemNameInTheCart() {
        String ExpectedItemName=Hook.prop.getProperty("Item_Name");
        try{
             Assert.assertEquals(ExpectedItemName,ActualItem_Name);
             System.out.println("The correct item is added to the cart");
        }
        catch (AssertionError e){
            e.printStackTrace();
        }
    }

    @And("The user clicks on the Remove button")
    public void theUserClicksOnTheRemoveButton() {
         or.Remove_Button.click();
    }

    @Then("Logout of the application")
    public void logoutOfTheApplication() {
      or.Menu_Button.click();
        WebDriverWait wait=new WebDriverWait(Hook.driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        or.LogOut_Button.click();
    }
}

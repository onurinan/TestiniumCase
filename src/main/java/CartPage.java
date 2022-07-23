import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By deleteIconLocator = By.className("red-icon");
    By inputLocator = By.cssSelector("input[name='quantity']");
    By refreshButtonLocator = By.className("fa-refresh");
    By refreshTextLocator = By.id("swal2-title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductAdded() {
        return getProducts().size() > 0;
    }

    public boolean isRefreshingTextValid(){
        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return isDisplayed(refreshTextLocator);
    }

    public void clearInputValue(){
        find(inputLocator).clear();
    }
    public void increaseItem(){
        clearInputValue();

        find(inputLocator).sendKeys("2");

        click(refreshButtonLocator);
    }

    private List<WebElement> getProducts(){
        return findAll(deleteIconLocator);
    }
}

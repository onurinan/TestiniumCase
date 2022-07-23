import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By deleteIconLocator = By.className("red-icon");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductAdded() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts(){
        return findAll(deleteIconLocator);
    }
}

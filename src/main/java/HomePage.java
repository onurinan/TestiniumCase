import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    SearchBox searchBox;

    By cartItemCountLocator = new By.ByCssSelector("div #cart-items");
    By cartContainerLocator = By.id("cart");
    By cartNavigatorButtonLocator = By.id("js-cart");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountUp(){
        return getCartCount() > 0;
    }

    public void goToCart() {
        click(cartContainerLocator);

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        find(cartNavigatorButtonLocator).click();
    }

    private int getCartCount() {

        synchronized (driver){
            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String count = find(cartItemCountLocator).getText();

        return Integer.parseInt(count);
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class AddProductToCartTest extends BaseTest{

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;


    @Test
    @Order(1)
    public void searchProduct(){
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);

        homePage.searchBox().search("roman");

        Assertions.assertTrue(productsPage.isOnProductsPage(), "Should be on products page.");
    }

    @Test
    @Order(2)
    public void SelectProduct(){
        productDetailPage = new ProductDetailPage(driver);

        productsPage.selectProduct(1);

        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Should be on product detail page.");
    }

    @Test
    @Order(3)
    public void AddProduct(){
        productDetailPage.addToCart();

        Assertions.assertTrue(homePage.isProductCountUp(), "Should increase product count.");
    }

    @Test
    @Order(4)
    public void GoToCart(){
        cartPage = new CartPage(driver);

        homePage.goToCart();

        Assertions.assertTrue(cartPage.isProductAdded(), "Should added product to cart.");
    }


}

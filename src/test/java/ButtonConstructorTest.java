import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobject.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ButtonConstructorTest extends BaseTest {
    private HomePage objHomePage;

    @BeforeEach
    public void setUp() {
        baseSetUp();
        objHomePage = new HomePage(driver);
        objHomePage.openHomePage();

    }


    @Test
    @DisplayName("Тест перехода к разделу Булки")
    public void followBunTest() {
        assertTrue(objHomePage.checkBunsButtonActive());
    }

    @Test
    @DisplayName("Тест перехода к разделу Соусы")
    public void followSaucesTest() {
        objHomePage.clickSaucesButton();
        assertTrue(objHomePage.checkSaucesButtonActive());
    }

    @Test
    @DisplayName("Тест перехода к разделу Начинки")
    public void followFillingTest() {
        objHomePage.clickFillingsButton();
        assertTrue(objHomePage.checkFillingsButtonActive());
    }

}

package Page;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import java.time.Duration;


import static org.junit.Assert.fail;

public class BasePage extends PageObject {

    @Managed
    public static WebDriver driver;
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    //Constructor inicializado
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Accion click
    public void click(By element) throws Exception {
        try {
            driver.findElement(element).click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo dar click sobre el elemento: " + element);
        }
    }

    public void clear(By element) throws Exception {
        try {
            driver.findElement(element).clear();
        } catch (Exception e) {
            throw new Exception("No se pudo limpiar el elemento: " + element);
        }
    }

    public boolean isDisplayed(By element, int i) {
        try {
            WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(i));
            //WebDriverWait espera = new WebDriverWait(driver, i);
            return espera.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //Accion obtener texto
    public String getText(By element) throws Exception {
        try {
            return driver.findElement(element).getText();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el texto del elemento: " + element);
        }
    }


    //Accion escribir caja de texto
    public void sendKey(By element, String textoCaja) throws Exception {
        try {
            driver.findElement(element).sendKeys(textoCaja);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("No se pudo escribir dentro del elemento: " + element);
        }
    }

    //Accion obtiene el titulo de la pagina
    public String getTitle() {
        return driver.getTitle();
    }

    //Scroll para mostrar el valor de un elemento
    public void scrollToElement(By element) {
        try {
            // Utiliza JavascriptExecutor para hacer visible el elemento
            WebElement element1 = driver.findElement(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
            fail("FAIL : No se pudo dar Scroll al elemento : " + element);
        }
    }

    public void switchToMainFrame() throws Exception {
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
    }

}





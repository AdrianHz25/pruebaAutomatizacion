package Page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends PageObject {

    private final WebDriver driver;
    private BasePage basePage;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By opMexico = By.id("MX");
    By txbBuscar = By.id("cb1-edit");
    By btnBuscar = By.xpath("//button[@type='submit']");
    By labelCondicion = By.xpath("//*[@id=\"root-app\"]/div/div[2]/aside/section[2]/div[5]/h3");
    By labelUbicacion = By.xpath("//h3[normalize-space()='Ubicación']");
    By btnOrdenar = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[2]/section[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/div[1]/*[name()='svg'][1]");
    By btnMayorPrecio  = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[2]/section[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]");



    public void seleccionaMexicoComoPais() throws Exception {
        // Código para seleccionar México como país
        basePage.click(opMexico);
    }
    public void buscaElTermino(String termino) throws Exception {
        // Código para buscar el término especificado
        basePage.sendKey(txbBuscar, termino);
        basePage.click(btnBuscar);
        Thread.sleep(5000);
    }
    public void filtraPorCondicion(String condicion) throws Exception {
        // Código para aplicar el filtro de condición
        basePage.scrollToElement(labelCondicion);
        Thread.sleep(2500);

        switch (condicion.toLowerCase()) {
            case "nuevo":
                By linkNuevo = By.xpath("/html[1]/body[1]/main[1]/div[1]/div[2]/aside[1]/section[2]/div[5]/ul[1]/li[1]/a[1]/span[1]");
                basePage.click(linkNuevo);
                Thread.sleep(5000);

                break;
            case "usado":
                basePage.click(By.xpath("/html[1]/body[1]/main[1]/div[1]/div[2]/aside[1]/section[2]/div[5]/ul[1]/li[2]/a[1]/span[1]"));
                Thread.sleep(5000);

                break;
            default:
                throw new IllegalArgumentException("Condición no válida: " + condicion);
        }

    }
    public void filtraPorUbicacion(String ubicacion) throws Exception {
        // Código para aplicar el filtro de ubicación
        basePage.scrollToElement(labelUbicacion);
        Thread.sleep(2500);
        switch (ubicacion.toLowerCase()) {
            case "cdmx":
                // Aquí podrías agregar lógica para filtrar por ubicación específica si es necesario
                basePage.click(By.xpath("//span[normalize-space()='Distrito Federal']"));
                Thread.sleep(2500);
                break;
            case "estado de méxico":
                // Aquí podrías agregar lógica para filtrar por ubicación específica si es necesario
                basePage.click(By.xpath("//span[normalize-space()='Estado De México']"));
                Thread.sleep(2500);
                break;
            case "jalisco":
                // Aquí podrías agregar lógica para filtrar por ubicación específica si es necesario
                basePage.click(By.xpath("//span[normalize-space()='Jalisco']"));
                Thread.sleep(2500);
                break;
            default:
                throw new IllegalArgumentException("Ubicación no válida: " + ubicacion);
        }
    }
    public void ordenaLosResultadosPorPrecioDeMayorAMenor() throws Exception {
        basePage.scrollToElement(btnOrdenar);
        Thread.sleep(2500);
        basePage.click(btnOrdenar);
        basePage.click(btnMayorPrecio);
    }
    public void obtieneElNombreYElPrecioDeLosPrimerosProductos() {
        // Código para obtener el nombre y precio de los productos
        try {
            // Encuentra todos los elementos que coinciden con el localizador
            List<WebElement> elementoNombre = driver.findElements(By.xpath("//h3[@class='poly-component__title-wrapper']"));
            String producto = "";

            // Itera sobre los primeros 5 elementos y obtiene su texto
            for (int i = 0; i < Math.min(5, elementoNombre.size()); i++) {
                // Re-localiza el elemento para evitar StaleElementReferenceException
                WebElement nombreElemento = driver.findElements(By.xpath("//h3[@class='poly-component__title-wrapper']")).get(i);
                WebElement precioElemento = driver.findElements(By.xpath("//div[@class='poly-component__price']")).get(i);

                String nombre = nombreElemento.getText();
                String precio = precioElemento.getText();

                // Concatenar nombre y precio con un salto de línea
                producto += "\nNombre: " + nombre + "\nPrecio: " + precio + "\n\n";

                // Imprimir la variable en la consola
                System.out.println(producto);
            }
            Serenity.recordReportData().withTitle("Nombre y precio productos").andContents(producto);

        } catch (StaleElementReferenceException e) {
            System.err.println("Error: El elemento ya no es válido en el DOM. " + e.getMessage());
        }

    }
}

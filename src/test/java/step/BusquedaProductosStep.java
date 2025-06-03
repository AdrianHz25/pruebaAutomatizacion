package step;

import Page.BasePage;
import Page.HomePage;
import net.thucydides.core.steps.ScenarioSteps;

public class BusquedaProductosStep extends ScenarioSteps {

    private BasePage basePage;
    private HomePage homePage;
    public void queElUsuarioEntraAlSitioWebDeMercadoLibre() {
        // Código para abrir el sitio web
        basePage.open();
    }

    public void seleccionaMexicoComoPais() throws Exception {
        // Código para seleccionar México como país
        homePage.seleccionaMexicoComoPais();
    }

    public void buscaElTermino(String termino) throws Exception {
        // Código para buscar el término especificado
        homePage.buscaElTermino(termino);
    }

    public void filtraPorCondicion(String condicion) throws Exception {
        // Código para aplicar el filtro de condición
        homePage.filtraPorCondicion(condicion);
    }

    public void filtraPorUbicacion(String ubicacion) throws Exception {
        // Código para aplicar el filtro de ubicación
        homePage.filtraPorUbicacion(ubicacion);
    }

    public void ordenaLosResultadosPorPrecioDeMayorAMenor() throws Exception {
        homePage.ordenaLosResultadosPorPrecioDeMayorAMenor();
    }

    public void obtieneElNombreYElPrecioDeLosPrimerosProductos() {
        // Código para obtener el nombre y precio de los productos
        homePage.obtieneElNombreYElPrecioDeLosPrimerosProductos();
    }
}

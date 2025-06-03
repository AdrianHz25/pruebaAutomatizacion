package stepDefinition;


import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import step.BusquedaProductosStep;

public class BusquedaProductosStepDefinitions {

    @Steps
    private BusquedaProductosStep busquedaProductosStep;

    @Dado("que el usuario entra al sitio web de Mercado Libre")
    public void queElUsuarioEntraAlSitioWebDeMercadoLibre() {
        // Código para abrir el sitio web
        busquedaProductosStep.queElUsuarioEntraAlSitioWebDeMercadoLibre();
    }

    @Dado("selecciona México como país")
    public void seleccionaMexicoComoPais() throws Exception {
        // Código para seleccionar México como país
        busquedaProductosStep.seleccionaMexicoComoPais();
    }

    @Cuando("busca el término {string}")
    public void buscaElTermino(String termino) throws Exception {
        // Código para buscar el término especificado
        busquedaProductosStep.buscaElTermino(termino);
    }

    @Cuando("filtra por condición {string}")
    public void filtraPorCondicion(String condicion) throws Exception {
        // Código para aplicar el filtro de condición
        busquedaProductosStep.filtraPorCondicion(condicion);
    }

    @Cuando("filtra por ubicación {string}")
    public void filtraPorUbicacion(String ubicacion) throws Exception {
        // Código para aplicar el filtro de ubicación
        busquedaProductosStep.filtraPorUbicacion(ubicacion);
    }

    @Y("ordena los resultados por precio de mayor a menor")
    public void ordenaLosResultadosPorPrecioDeMayorAMenor() throws Exception {
        busquedaProductosStep.ordenaLosResultadosPorPrecioDeMayorAMenor();
    }

    @Entonces("obtiene el nombre y el precio de los primeros 5 productos")
    public void obtieneElNombreYElPrecioDeLosPrimerosProductos() {
        // Código para obtener el nombre y precio de los productos
        busquedaProductosStep.obtieneElNombreYElPrecioDeLosPrimerosProductos();
    }


}

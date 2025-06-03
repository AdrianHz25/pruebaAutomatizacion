#language: es

Característica: Búsqueda y filtrado de productos en Mercado Libre

  @MercadoLibre
  Escenario: Buscar y filtrar productos en Mercado Libre
    Dado que el usuario entra al sitio web de Mercado Libre
    Y selecciona México como país
    Cuando busca el término "playstation 5"
    Y filtra por condición "Nuevo"
    Y filtra por ubicación "Cdmx"
    Y ordena los resultados por precio de mayor a menor
    Entonces obtiene el nombre y el precio de los primeros 5 productos

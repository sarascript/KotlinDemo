package es.sarascript.recyclerviewwithretrofitdemo

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ResourceService {

    // Método get datos

    @GET("resource/hma6-9xbg.json") // copiamos el final de la url, en la que se indica la ruta concreta de la petición
    // Creamos un método (requestResourceList)
    suspend fun requestResourceList(@Query("category") category: String, @Query("item") item: String) // y añadimos los campos @Query que le vamos a pasar con el nombre exacto
            : Response<List<ItemDto>> // La llamada devolverá una lista, a la que añadimos el modelo de transferencia de datos (ItemDto)

}
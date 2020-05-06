package es.sarascript.recyclerviewwithretrofitdemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    // ---------------------------- RECYCLERVIEW + RETROFIT -------------------------------

        // Implementar las librerías en el Gradle -> implementation 'androidx.recyclerview:recyclerview:1.0.0'
        // implementation("com.squareup.okhttp3:okhttp:4.6.0")
        // implementation("com.squareup.okhttp3:logging-interceptor:4.6.0")
        // implementation('com.squareup.retrofit2:retrofit:2.8.1') { exclude module: 'okhttp' }
        // implementation 'com.squareup.retrofit2:converter-gson:2.8.1'
        // implementation 'com.squareup.retrofit2:converter-moshi:2.8.1'
        // implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.1'

        // Implementamos los permisos de internet en el Manifest -> <uses-permission android:name="android.permission.INTERNET" />

        // Creamos el layout row_item.xml para cada item con los campos que tiene la clase Item.kt

        // Creamos el adapter ItemAdapter.kt y su código -> New kotlin file/class - class

        // Creamos un componente RecyclerView en el activity_main.xml, le damos un id
        // y le añadimos la propiedad -> tools:listitem="@layout/row_item"

        // Creamos una interfaz donde declaramos los métodos que vamos a usar para conectarnos a la API -> ResourceService.kt
        // @GET("resource/hma6-9xbg.json") // copiamos el final de la url, en la que se indica la ruta concreta de la petición
        // Creamos un método (requestResourceList)
        // suspend fun requestResourceList(@Query("category") category: String, @Query("item") item: String) // y añadimos los campos @Query que le vamos a pasar con el nombre exacto
        // : Response<List<ItemDto>> // La llamada devolverá una lista, a la que añadimos el modelo de transferencia de datos (ItemDto)

        // Creamos el modelo de transferencia de datos donde se guardarán los datos recibidos de la API (ItemDto)
        // añadimos todos los campos que tiene el .json con su nombre exacto (farmer_id)-> @SerializedName("farmer_id") val farmerId: String,
        // y lo guardamos en una val (farmerId)

        // Creamos el modelo (ItemModel) donde se guardarán los datos del ItemDto
        // añadimos todas las variables que creamos en el ItemDto -> val farmerId: String?,

        // Creamos un mapeador para convertir los ItemDto a ItemModel (ItemMapper) y sus dos métodos transform

        // Creamos una clase AppConstants.kt y cambiamos la class a object
        // añadimos una constante con la url base de la API -> const val ENDPOINT = "https://data.ct.gov/"

        // Creamos una clase ApiUtils.kt y configuramos Retrofit y OkHttp

        // Inicializamos Retrofit y lo conectamos con la interfaz
        val resourceService = ApiUtils.generateRetrofitInstance()
                .create(ResourceService::class.java)

        // Realizamos la petición y pintamos la lista

        CoroutineScope(Dispatchers.IO).launch {
            val response = resourceService.requestResourceList("Fruit", "Peaches")
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        val items = ItemMapper().transform(response.body()!!)

                        // Asignamos el layoutManager (Linear o Grid) al RecyclerView
                        mainList.layoutManager = LinearLayoutManager(this@MainActivity)

                        // Asignamos el adapter al RecyclerView
                        mainList.adapter = ItemAdapter(items, { Toast.makeText(this@MainActivity, it.item, Toast.LENGTH_SHORT).show() })

                    } else {
                        Log.e("error","Error: ${response.code()}")
                    }
                } catch (e: HttpException) {
                    Log.e("error","Exception ${e.message}")
                } catch (e: Throwable) {
                    Log.e("error","Ooops: Something else went wrong")
                }
            }
        }
    }
}

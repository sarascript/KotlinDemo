package es.sarascript.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val itemList = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    // ---------------------------- RECYCLER VIEW Y ADAPTER -------------------------------

        // Implementar la librería en el Gradle -> implementation 'androidx.recyclerview:recyclerview:1.0.0'

        // Creamos el objeto Item.kt y definimos sus propiedades -> New kotlin file/class - class

        // Creamos el layout row_item.xml para cada item con los campos que tiene la clase Item.kt

        // Creamos el adapter ItemAdapter.kt y su código -> New kotlin file/class - class

        // Creamos un componente RecyclerView en el activity_main.xml, le damos un id
        // y le añadimos la propiedad -> tools:listitem="@layout/row_item"

        // Creamos la lista de items
        for (number in 1..100) {
            itemList.add(Item(number.toString(), "Item " + number))
        }

        // Asignamos el layoutManager (Linear o Grid) al RecyclerView
        mainList.layoutManager = LinearLayoutManager(this)

        // Asignamos el adapter al RecyclerView
        mainList.adapter = ItemAdapter(itemList, { Toast.makeText(this@MainActivity, it.name, Toast.LENGTH_SHORT).show() })

    }

}

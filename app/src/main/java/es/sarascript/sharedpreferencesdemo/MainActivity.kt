package es.sarascript.sharedpreferencesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val key = "MY_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    // ---------------------------- SHARED PREFERENCES -------------------------------

        // Obtenemos el PreferenceManager
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        btnGet.setOnClickListener() {
        // Recuperar las preferencias
            prefs.getString(key, "No hay valor para la clave")
        }

        btnPut.setOnClickListener() {
        // Guardar las preferencias
            val editor = prefs.edit()
            editor.putString(key, "Valor por defecto")
            editor.apply()
        }

        btnDelete.setOnClickListener() {
        // Borrar las preferencias
            val editor = prefs.edit()
            editor.remove(key)
            editor.apply()
        }
    }
}

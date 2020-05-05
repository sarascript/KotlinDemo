// VARIABLES Y PROPIEDADES

class A {
    // Variable mutable
    var variable1: String
    // Variable inmutable
    val value1: String
    // Variable de tipo boolean
    var isEmpty: Boolean
    // Método que se ejecuta al consultar la variable
    	get() = variable1.count() == 0 // Al consultar isEmpty va a ver si variable1 está vacía
	var number: Int
    // Método que se ejecuta al asignarle un valor a la variable
    	set(value) {
            if(value >= 0) field = value else field = 0// Field hace referencia a number
        }
    // Constructor personalizado de la clase
    constructor(variable1: String, value1: String, number: Int) {
        // Asignamos los parámetros a las variables
        this.variable1 = variable1
        this.value1 = value1
        this.isEmpty = false
        this.number = number
    }
}

fun main(args: Array<String>) {
    var objA = A("Variable mutable", "Variable inmutable", 1)
    println(objA.variable1)
    objA.variable1 = "Hola mundo"
    println(objA.variable1)
    println(objA.value1)
    //objA.value1 = "Adiós mundo" -> Da error al compilar porque value1 es inmutable
    //println(objA.value1)
    println(objA.number)
    objA.number = -10
    println(objA.number) // Imprime 0 respetando la definición del set()
    
    // Kotlin infiere el tipo de variable automáticamente
    val text = "StringComoArray"
    // Las variables String se pueden tratar como Arrays
    println("Accedemos a text[2]: " + text[2])
    // Iteración sobre un String
    for(item in text) {
        println(item)
    }
    //text[2] = "a" -> Los Strings no son editables como un Array
}
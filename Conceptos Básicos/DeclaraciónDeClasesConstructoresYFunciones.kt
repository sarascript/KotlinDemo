// DECLARACIÓN DE CLASES, CONSTRUCTORES Y VARIABLES

// Definir una clase
class A(var var1: String, var var2: Int)

// Definir una clase de la que se puede extender
open class B(open var var1: String)

// Definir una clase que extiende de la clase B
class C(override var var1: String, var var2: String) : B(var1)

// Definir una interfaz
interface MyInterface {
    fun foo()
}

// Definir una clase que implementa la interfaz
class D(var var1: String) : MyInterface {
    override fun foo() {
        println("Método foo")
    }
}

// Definir una clase que extiende de la clase B e implementa la interfaz
class E(override var var1: String, var var2: String) : B(var1), MyInterface {
    override fun foo() {
        println("Método foo")
    }
}

class F(var var1: String, var var2: String, var var3: Int) {
    // Definir un init para implementar algo en el cuerpo del constructor
    init {
        println("Init invocado")
    }
    
    // Definir un método para concatenar strings
    fun concat(): String {
        return var1 + var2
    }
    
    // Definir un método que recibe un número (dándole un valor por defecto)
    // y retorna otro número (var3 + number)
    fun sum(number: Int = 0) : Int{
        return var3 + number
    }
    
    // Definir un constructor de una clase
    constructor(var1: String) : this(var1, "", 0)
}

// Método main
fun main(args: Array<String>) {
    
    // Instanciar un objeto de la clase A
    var objA = A("Hola", 1)
    
    println(objA.var1)
    var objE = E("HolaB", "Var2")
    objE.foo()
    var objF = F("HolaF", "AdiósF", 2)
    println(objF.concat())
    println(objF.sum(3))
}
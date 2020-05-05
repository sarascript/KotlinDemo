// CASTING DE OBJETOS

open class A (open var var1: String)
class B (override var var1: String, var var2: String) : A(var1)
class C (override var var1: String, var var3: String) : A(var1)

fun main(args: Array<String>) {
	var objB: Any = B("Hola Mundo", "Test") // Any es cualquier tipo
    
    // El operador is compara y castea automáticamente
    if (objB is A) {
        println(objB.var1)
    }
    
    if (objB !is C) {
        // El operador as fuerza el casteo
        println((objB as B).var2) 
    }
}
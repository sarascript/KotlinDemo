// NULABILIDAD

// Clase con variable que permite nulos
class A (var var1: String?, var var2: String)

fun main(args: Array<String>) {
	var objA = A(null, "test")
    //objA.var2 = null -> var2 no permite nulos
    
    // count() sólo se ejecutará si var1 no es nulo
    println("Count var1: " + objA.var1?.count())
    
    objA.var1 = "Hola"
    println("Count var1: " + objA.var1?.count())
    
    objA.var1 = null
    
    // Si var1 es nulo printeará un 0
    println("Count var1 elvis: " + (objA.var1?.count() ?: 0))
    
    //println("Count: " + objA.var1!!.count()) -> Forzar la ejecución de count() aunque sea nulo

    // Instanciar clase permitiendo que sea nula
	var objB: A? = null
    
    // let() sólo se ejecuta si objB y var1 no son nulas
    objB?.var1?.let { println("Se ha ejecutado let") }
    
    objB = A("ObjB", "var2")
    objB.var1?.let { println("Se ha ejecutado let después de asignar un valor a objB") }

	var objC: A? = A("ObjC", "var2")
    objC?.var1?.let { println("ObjC") }
    objC = null
}
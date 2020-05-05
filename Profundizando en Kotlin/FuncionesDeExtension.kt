// FUNCIONES DE EXTENSIÓN

class A (var var1: Int, var var2: Int, private var var3: Int) {
    fun sum(): Int {
        return var1 + var2 + var3
    }
}

// Función de extensión
fun A.multiply(): Int {
    return this.var1 * this.var2
    //return this.var1 * this.var3 -> una función de extensión no puede acceder a propiedades privadas
}

// Función de extensión sobre clase primitiva
fun Int.isPair(): Boolean {
    return this % 2 == 0
}

fun Int.isPositive(): Boolean {
    return this >= 0
}

fun String.upperCaseFirstLetter(): String {
    return if (this.count() > 0) this.substring(0, 1).toUpperCase().plus(this.substring(1)) else ""
}

fun main() {
    var objA = A(1, 2, 3)
    println(objA.sum())
    println(objA.multiply())
    var num1 = -10
    println(num1.isPair())
    println(num1.isPositive())
    println("hola".upperCaseFirstLetter())
}
// OPERADOR WHEN

open class A (open var var1: String)
class B (override var var1: String, var var2: String) : A(var1)
class C (override var var1: String, var var3: String) : A(var1)
class D (override var var1: String, var var4: String) : A(var1)

enum class Country(var code: String, var fullName: String) {
    SPAIN("ES", "España"),
    GERMANY("DE", "Alemania"),
    JAPAN("JP", "Japón")
}

// When
fun getText(value: Any) = when(value) {
    is B -> value.var2
    is C -> value.var3
    else -> "Error"
}

fun isEuropean(country: Country) = when(country) {
    Country.SPAIN, Country.GERMANY -> "Sí"
    else -> "No"
}

fun main(args: Array<String>) {
    println(getText(B("Test2", "Test var2")))
    println(getText(C("Test2", "Test var3")))
    println(getText(D("Test2", "Test var4")))
    println(getText("No soy un objeto válido"))
    val spain = Country.SPAIN
    val japan = Country.JAPAN
    println(spain.fullName + " " + isEuropean(spain))
    println(japan.fullName + " " + isEuropean(japan))
}
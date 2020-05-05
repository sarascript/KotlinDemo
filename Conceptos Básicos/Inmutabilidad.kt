// INMUTABILIDAD

fun main(args: Array<String>) {
	// Lista inmutable
    val list = listOf("Test1", "Test2")
    //Lista mutable
    var mutableList = mutableListOf("TEST1", "TEST2")
    
    // list.add("Test3") -> Las listas inmutables no tienen el método add()
    mutableList.add("TEST3")
    
    // .map es un método para iterar en listas
    list.map {
        println(it) // it representa cada elemento iterado
    }
    
    mutableList.map {
        println(it)
    }
    
    // list.clear() -> Las listas inmutables no tienen el método clear()
    mutableList.clear()
}
// ITERADORES FOR Y WHILE

fun main(args: Array<String>) {
	val listaDeEnterosConNulos: List<Int?> = listOf(0, 1, 2, null)
    
    // Iterador for
    for (number in listaDeEnterosConNulos) {
        number?.let { print(it) } ?: println("null")
    }
    
    // Iterador in
    for (number in 1..10) {
        if (number != 10) print(number) else print(number%10)
    }
    
    println("")
    
    // Iterador until
    for (number in 1 until 10) {
        print(number)
    }
    
    println("")
    
    var count = 10
    
    // Iterador while
    while (count > 0) {
        print(count)
        count--
    }

}
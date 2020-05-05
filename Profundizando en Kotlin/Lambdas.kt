// LAMBDAS

class A (var number: Int, var text: String)

// Función que recibe otra función por parámetro
fun iterateWithLambda(list: List<Int>, function: (number:Int) -> Unit) { //Unit para que no devuelva nada
	list.map {
    	println("Test " + it)
    	function(it)
    }
}

fun executeMethodsIfNumberIsPair(number: Int, pair: () -> Unit, odd: () -> Unit) {
    if (number %2 == 0) pair() else odd()
}

fun main(args: Array<String>) {
	val objList = listOf(A(1, "Test"), A(2, "Test 2"), A(3, "Test 3"))
    val intList = listOf(1, 2, 3, 4)
    
    // Lambda
    objList.map { current: A -> println(current.number) }
    objList.map { println(it.number) }
    
    objList.map { it.number++ }
    objList.map { println(it.number) }
    
    var number = 0
    iterateWithLambda(intList, {
        number += it
    })
    
    executeMethodsIfNumberIsPair(11, {
        println("Es par")
    }, {
        println("Es impar")
    })
}
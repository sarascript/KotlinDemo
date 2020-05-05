// COLECCIONES

fun main(args: Array<String>) {
    // Array de enteros
	val ints = IntArray(10)
    val ints2 = intArrayOf(1, 2, 3, 4)
    val ints3 = IntArray(10, { i -> i+2 }) //Lambda - rellena el array iterando desde i haciendo i+2 hasta rellenar 10 huecos
    
    for (number in ints3) {
        print("$number")
    }
    
    println("")

    val list = listOf("Test 1", "Test 2", "Test 3", "Test 4")
    
    // Filter
    val filterList = list.filter {
        it.contains("Test")
    }
    
    for (text in filterList) {
        println(text)
    }
    
	// Map
    val mapList = list.map {
        text -> text + ", "
    }
    
    for (text in mapList) {
        print(text)
    }
    
    println("")
    
    val list2 = listOf(1, -2, 3, 4, 5)
    
    // Fold
    println(list2.fold(2) {
        count, it -> count + it
    })
    
	// Any
    println(list2.any() {
        it < 0
    })
    
    // Count
    println(list2.count() {
        it < 0
    })
    
    // Find
    println(list2.find() {
        it < 0
    })
    
    // Max
    println(list2.max())
    
    // Min
    println(list2.min())
    
    // Element at or null
    println(list2.elementAtOrNull(5))
    
    // Partition
    println(list2.partition() {
        it > 0
    // }).first) -> .first para devolver sólo la primera lista, .second para la segunda
	}))
    
    val ints4 = intArrayOf(10, 2, 8, 4, 3)
    
    // Sort
    ints4.sort()
    
    for (number in ints4) {
        print("$number")
    }
}
// CONTROL DE EXCEPCIONES

// Throw exception
fun error(): Nothing {
    throw RuntimeException()
}

fun main(args: Array<String>) {
    val number: String? = null
    
    // Bloque try/catch
    val count: Int = try {
        number!!.count()
    } catch (e: Exception) {
        0
    }
    
    println(count)
    //error() 
    number?.let { println(number) } ?: error()
}
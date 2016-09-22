package syntax.forWhileLoops

fun forLoop(collection: Collection<String>) {
    for (i in 1..10) {}

    for (s in collection) {}

    for ((index, s) in collection.withIndex()) {println("$index => $s")}
}

fun main(args: Array<String>) {
    breakStuff()
}

fun iteratingOverMap(map: Map<Int, String>) {
    for ((key, value) in map) {}
}

fun whileLoop() {
    while (true) {
    }
}

fun doWhileLoop() {
    do {

    } while (true)
}

fun labels() {
    outerLoop@ while (true) {
        innerLoop@ for (i in 1..10) {
            if (i < 10) {
                continue@innerLoop
            }
            else {
                break@outerLoop
            }
        }
    }
}

fun breakStuff() {
    free@ while(true) {
        for (i in 1..30) {
            println("processing $i")
            if (i == 14) break@free
        }
    }
    println("I po wszystkim !")
}


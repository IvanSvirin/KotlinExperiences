import expressions.Num
import expressions.Sum
import expressions.eval
import expressions.evalWhen
import geometry.example.Person
import geometry.shapes.*
import geometry.shapes.Color.*

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", 29))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")

    val value = "String"
    if (value is String) println(value.toUpperCase())

    println(max(1, 2))

    val languages = arrayListOf("Java")
    languages.add("Kotlin")

    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name")

    if (args.size > 0) println("Hello, ${args[0]}")

    println("Hello, ${if (args.size > 0) args[0] else "someone"}")

    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)

    println(createRandomRectangle().isSquare)

    println(Color.BLUE.rgb())
    println(getMnemonic(Color.BLUE))
    println(getWarmth(Color.ORANGE))
    println(mix(BLUE, YELLOW))
    println(mixOptimized(BLUE, YELLOW))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalWhen(Sum(Sum(Num(1), Num(2)), Num(4))))
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Каждый"
        Color.ORANGE -> "Охотник"
        Color.YELLOW -> "Желает"
        Color.GREEN -> "Знать"
        Color.BLUE -> "Где"
        Color.INDIGO -> "Сидит"
        Color.VIOLET -> "Фазан"
    }

fun getWarmth(color: Color) =
    when (color) {
        RED, ORANGE, YELLOW -> "теплый"
        GREEN -> "нейтральный"
        BLUE, INDIGO, VIOLET -> "холодный"
    }

fun mix(color1: Color, color2: Color) =
    when (setOf(color1, color2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Грязный цвет")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
        else -> throw Exception("Dirty color")
    }
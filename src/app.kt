import cycles.fizzBuzz
import cycles.isLetter
import cycles.isNotDigit
import cycles.recognize
import expressions.*
import data.Person
import exception.readNumber
import exception.readNumberNoReturn
import exception.readNumberNullReturn
import geometry.shapes.*
import geometry.shapes.Color.*
import java.io.BufferedReader
import java.io.StringReader
import java.util.*

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", 29))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")

//    val value = "String"
//    if (value is String) println(value.toUpperCase())

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
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))

    for (i in 1..100) print(fizzBuzz(i))
    println()
    for (i in 100 downTo 1 step 2) print(fizzBuzz(i))
    println()

    val binaryReps = TreeMap<Char, String>()
    for(c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps ) println("$letter = $binary")

    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) println("$index: $element")

    println(isLetter('x'))
    println(isNotDigit('y'))
    println(recognize('7'))

    println("Kotlin" in "Java".."Scala")
    println("Kotlin" in setOf("Java","Scala"))

    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))

    val reader1 = BufferedReader(StringReader("not a number"))
    println(readNumberNoReturn(reader1))
    println(readNumberNullReturn(reader1))
}

fun max(a: Int, b: Int) = if (a > b) a else b


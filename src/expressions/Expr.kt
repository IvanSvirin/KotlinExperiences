package expressions

import kotlin.IllegalArgumentException

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.right) + eval(e.left)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

fun evalWhen(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> evalWhen(e.right) + evalWhen(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            right + left
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

package pl.politechnika.lodzka.michalowskid.calc.torando.fx

import java.util.*
import kotlin.collections.ArrayList

class ReversePolishNotationImpl {
    private val operators: Map<String, Int> = hashMapOf(
        "=" to 2,
        "x" to 1,
        "/" to 1,
        "+" to 0,
        "-" to 0)

    fun calculate(value: String) : String{
        val rpnArray = convertToRpn(value)
        return resolveRpn(rpnArray).toString()
    }

    private fun convertToRpn(input: String) : List<String> {
        var output = ArrayList<String>()
        val inputStack = LinkedList<String>();

        var currChar: String
        var i = 0
        while (i < input.length) {
            if (!Character.isDigit(input[i])) {
                currChar = input[i].toString()
            } else {
                currChar = ""
                while (Character.isDigit(input[i])) {
                    currChar += input[i]
                    i++
                }
                i--
            }
            if (!operators.containsKey(currChar)) {
                output.add(currChar)
            } else if (currChar == "=") {
                while (!inputStack.isEmpty()) {
                    output.add(inputStack.first)
                    inputStack.removeFirst()
                }
            } else {
                if (!inputStack.isEmpty()) {
                    while (operators[currChar]!! < operators[inputStack.first]!!) {
                        output.add(inputStack.first)
                        inputStack.removeFirst()
                    }
                }
                inputStack.push(currChar)
            }
            i++
        }
        return output
    }

    private fun isOperator(operator: String): Boolean {
        return operator == "+" || operator == "-" || operator == "x" || operator == "/"
    }

    private fun resolveRpn(tokens: List<String>): Int {
        val stack = Stack<Int>()
        var answer = 0
        for (token in tokens) {
            if (!isOperator(token)) {
                stack.add(token.toInt())
            } else {
                val a = stack.pop()
                val b = stack.pop()
                when (token) {
                    "+" -> answer = a + b
                    "-" -> answer = b - a
                    "x" -> answer = a * b
                    "/" -> answer = a / b
                }
                stack.add(answer)
            }
        }
        return answer
    }
}
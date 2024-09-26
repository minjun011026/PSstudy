import java.io.*
import java.util.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().map {it}
    val stack1 = Stack<Char>()
    val stack2 = Stack<String>()
    var sum = 0

    try {
        if (input.isNotEmpty()) {
            stack1.add(input[0])
            stack2.add("${input[0]}")
            for (i in 1..input.lastIndex) {
                if (input[i] == '(' || input[i] == '[') {
                    stack1.add(input[i])
                    stack2.add("${input[i]}")
                } else {
                    if (stack1.peek() == '(' && input[i] == ')') {
                        stack1.pop()
                        sum = 0
                        while (stack2.peek() != "(") {
                            sum += stack2.pop().toInt()
                        }
                        stack2.pop()
                        if (sum == 0) sum = 2
                        else sum *=2
                        stack2.add("$sum")
                    } else if (stack1.peek() == '[' && input[i] == ']') {
                        stack1.pop()
                        sum = 0
                        while (stack2.peek() != "[") {
                            sum += stack2.pop().toInt()
                        }
                        stack2.pop()
                        if (sum == 0) sum = 3
                        else sum *=3
                        stack2.add("$sum")
                    } else {
                        stack1.add(input[i])
                        stack2.add("${input[i]}")
                    }
                }
            }
        }
        if(stack1.isEmpty()) {
            sum = 0
            while(stack2.isNotEmpty()){
                sum += stack2.pop().toInt()
            }
            bw.write("$sum")
        }
        else bw.write("0")
    }catch (e : Exception){
        bw.write("0")
    }

    bw.flush()
    bw.close()
}

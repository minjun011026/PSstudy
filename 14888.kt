import java.io.*

var max = -1000000000
var min = 1000000000
val number = ArrayList<Int>()

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val operator = ArrayList<Char>()
    number.addAll(br.readLine().split(" ").map {it.toInt()})
    val input = br.readLine().split(" ").map {it.toInt()}
    for(i in 0..3){
        when(i){
            0-> repeat(input[i]) {operator.add('+')}
            1-> repeat(input[i]){operator.add('-')}
            2-> repeat(input[i]){operator.add('*')}
            3-> repeat(input[i]){operator.add('/')}
        }
    }
    dfs(operator, "")
    bw.write("$max\n$min")
    bw.flush()
    bw.close()
}

fun dfs(operator: ArrayList<Char>, operation : String) {
    if(operator.size==0) chk(operation)
    for(i in 0..operator.lastIndex){
        val tmp = operator[i]
        operator.removeAt(i)
        dfs(operator, operation+tmp)
        operator.add(i,tmp)
    }
}

fun chk(operation: String){
    var sum = number[0]
    for(i in 0..operation.lastIndex){
        when(operation[i]){
            '+' -> sum += number[i+1]
            '-' -> sum -= number[i+1]
            '*' -> sum *= number[i+1]
            '/' -> sum /= number[i+1]
        }
    }

    if(sum>=max) max = sum
    if(sum<min) min = sum
}

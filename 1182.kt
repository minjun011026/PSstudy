import java.io.*

val number = ArrayList<Int>()
val combination = ArrayList<Int>()

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n,s) = br.readLine().split(" ").map {it.toInt()}
    number.addAll(br.readLine().split(" ").map {it.toInt()})

    bw.write("${dfs(s)}")
    bw.flush()
    bw.close()
}

fun dfs(s : Int) : Int{
    var sum = 0
    for(i in 1..number.size){
        sum +=makeCombination(i,0,0, s)
    }

    return sum
}


fun makeCombination(size: Int, index: Int, depth: Int, s : Int) : Int{
    var sum = 0
    if (depth == size) {
        return if(combination.sum() == s) 1 else 0
    }

    for (i in index .. number.lastIndex) {
        combination.add(number[i])
        sum += makeCombination(size, i + 1, depth + 1, s)
        combination.removeAt(combination.lastIndex)
    }
    
    return sum
}

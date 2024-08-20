import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val dictionary = ArrayList<String>()
    repeat(n){
        dictionary.add(br.readLine())
    }
    dictionary.sortWith(
        compareBy(
            {it.length},
            {getInt(it)},
            {it}
        )
    )
    bw.write(dictionary.joinToString("\n"))
    bw.flush()
    bw.close()
}

fun getInt(str: String): Int{
    var sum = 0
    for(i in 0..str.lastIndex){
        if(str[i].code in 48..57){
            sum += str[i].code-48
        }
    }
    return sum
}

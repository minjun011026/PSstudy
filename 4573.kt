import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val arr = Array(10001) {it}

    for(i in 10000 downTo 0) {
        val tmp = arr[i]+sum(arr[i])
        if(tmp <= 10000){
            arr[tmp] = 0
        }
    }

    bw.write(arr.filter {it != 0}.joinToString("\n"))

    bw.flush()
    bw.close()
}

fun sum(a:Int) : Int{
    var s = 0
    var input = a
    while(input>0){
        s+=input%10
        input/=10
    }
    return s
}

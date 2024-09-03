import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().map {it}
    val t = br.readLine().map {it}
    var isSame = true
    val arr = ArrayList<Char>()
    arr.addAll(t)

    while(arr.size != s.size){
        if(arr.last() == 'A')
            arr.removeAt(arr.lastIndex)
        else{
            arr.removeAt(arr.lastIndex)
            arr.reverse()
        }
    }

    for(i in 0..s.lastIndex){
        if(arr[i]!=s[i]) isSame=false
    }

    if(isSame) bw.write("1")
    else bw.write("0")

    bw.flush()
    bw.close()
}

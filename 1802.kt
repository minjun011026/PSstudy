import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    repeat(n){
        val f = br.readLine()
        bw.write(foldcheck(f, 0, f.lastIndex)+"\n")
    }

    bw.flush()
}

fun foldcheck(f : String, s : Int, e : Int) : String {
    val m = (s+e)/2

    if(s==e)
        return "YES"

    val s1 = f.substring(s..< m).reversed()
    val s1_i = ArrayList<Int>()

    for(i in 0..<s1.length){
        if(s1[i] == '0')
            s1_i.add(1)
        else
            s1_i.add(0)
    }

    val s2 = f.substring(m+1 .. e)
    return if(s1_i.joinToString("") != s2) {
        "NO"
    }else{
        if (foldcheck(f,s,m-1).equals("NO") || foldcheck(f,m+1,e).equals("NO")) "NO" else "YES"
    }
}
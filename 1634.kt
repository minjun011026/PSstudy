import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.pow

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val k = br.readLine().toInt()
    val kpow = 2.0.pow(k-1).toInt()
    val map1 = Array(kpow+1, {IntArray(kpow+1)})
    val map2 = Array(kpow+1, {IntArray(kpow+1)})
    var set = Array(kpow+1, {ArrayList<Int>()})
    val arr1 = ArrayList<Int>()
    val arr2 = ArrayList<Int>()

    var st = StringTokenizer(br.readLine())
    while(st.hasMoreTokens())
        arr1.add(st.nextToken().toInt())

    st = StringTokenizer(br.readLine())
    while(st.hasMoreTokens())
        arr2.add(st.nextToken().toInt())

    for(i in 1..<k){
        for(j in 0..<kpow step(2.0.pow(i).toInt())){
            for(l in 0..<2.0.pow(i-1).toInt()){
                for(m in 2.0.pow(i-1).toInt()..<2*(2.0.pow(i-1).toInt())){
                    map1[arr1[j+l]][arr1[j+m]] = 2*i
                    map1[arr1[j+m]][arr1[j+l]] = 2*i
                    map2[arr2[j+l]][arr2[j+m]] = 2*i
                    map2[arr2[j+m]][arr2[j+l]] = 2*i
                }
            }
        }
    }

    for(i in 1..kpow){
        for(j in 1..kpow){
            if(map1[i][j] == map2[i][j]){
                set[i].add(j)
            }
        }
    }

    var cnt = 0
    for(i in 1..kpow){
        cnt = 0
        for(j in 0..set[i].lastIndex){
            for(k in j..set[i].lastIndex) {
                if (map1[set[i][j-cnt]][set[i][k-cnt]] != map2[set[i][j-cnt]][set[i][k-cnt]]){
                    set[i].removeAt(j - cnt)
                    cnt++
                }
            }
        }
    }

    var max = 0
    for(i in 1..kpow)
        if(set[i].size>max) max = set[i].size

    bw.write("${max}\n")
    bw.flush()
}
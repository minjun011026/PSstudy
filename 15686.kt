import java.io.*
import java.util.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N,M) = br.readLine().split(" ").map {it.toInt()}
    val arr = Array(N) {ArrayList<Int>()}
    val chicken = ArrayList<Pair<Int,Int>>()
    val home = ArrayList<Pair<Int,Int>>()
    var minDis = 100000000
    val cSet = ArrayList<Pair<Int,Int>>()
    val q : Queue<Triple<Int, Int, Int>> = LinkedList()
    repeat(N){
        val node = br.readLine().split(" ").map {it.toInt()}.toTypedArray()
        for(i in node.indices){
            if(node[i] == 1)
                home.add(Pair(it,i))
            else if(node[i] == 2)
                chicken.add(Pair(it,i))
        }
        arr[it].addAll(node)
    }
    fun getChicken(cSet : ArrayList<Pair<Int,Int>>, idx : Int){
        for(i in idx..chicken.lastIndex){
            cSet.add(chicken[i])
            if(cSet.size == M){
                var homeMin = 10000000
                var sum = 0
                for(j in home){
                    homeMin = 10000000
                    for(k in cSet){
                        homeMin = min(homeMin, abs(k.first-j.first) + abs(k.second-j.second))
                    }
                    sum += homeMin
                }
                minDis = min(minDis,sum)
            }else
                getChicken(cSet, i+1)
            cSet.removeLast()
        }
        return
    }
    getChicken(cSet,0)
    bw.write("$minDis")
    bw.flush()
    bw.close()
}

import java.io.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (M,N) = br.readLine().split(" ").map {it.toInt()}
    val planet = ArrayList<List<Int>>()
    repeat(M){
        planet.add(br.readLine().split(" ").asSequence().map{it.toInt()}.distinct().withIndex().sortedBy { it.value }.map { it.index }
            .toList())
    }

    var sum = 0
    for(i in 0..<M){
        for(j in i+1..<M){
            if(planet[i] == planet[j]) sum++
        }
    }

    bw.write("$sum")
    bw.flush()
    bw.close()
}

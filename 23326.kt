import java.io.*
import java.util.TreeSet

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, Q) = br.readLine().split(" ").map { it.toInt() }
    val sight = TreeSet<Int>()
    var position = 1
    sight.addAll(br.readLine().split(" ").mapIndexedNotNull { index, s -> if (s.toInt() == 1) index + 1 else null })
    repeat(Q){
        val cmd = br.readLine().split(" ").map {it.toInt()}
        when(cmd[0]){
            1 -> {
                val newSight = cmd[1]
                if(sight.contains(newSight)) sight.remove(newSight)
                else sight.add(newSight)
            }
            2 -> position = (position + cmd[1] - 1) % N + 1
            3 -> {
                if(sight.isEmpty()) bw.write("-1\n")
                else{
                    if(sight.contains(position)) bw.write("0\n")
                    else{
                        val result = sight.higher(position)
                        if(result == null) bw.write("${sight.first() + N-position}\n")
                        else bw.write("${result - position}\n")
                    }
                }
            }
        }
    }
    bw.flush()
    bw.close()
}

import java.io.*
import java.util.PriorityQueue

data class Room(
    val s :Int,
    val e :Int
)

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val reserve = ArrayList<Room>()
    val room = PriorityQueue<Int>()
    room.add(-1)
    repeat(n){
        val (s,e) = br.readLine().split(" ").map {it.toInt()}
        reserve.add(Room(s,e))
    }
    reserve.sortWith(compareBy{it.s})

    for(i in 0..reserve.lastIndex) {
        if (room.peek() <= reserve[i].s) {
            room.poll()
        }
        room.add(reserve[i].e)
    }
    bw.write("${room.size}")
    bw.flush()
    bw.close()
}

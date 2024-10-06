import java.io.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    repeat(t){
        val n = br.readLine().toInt()
        val students = ArrayList<Int>()
        val visited = Array(n){false}
        val finish  = Array(n){false}
        var cnt = n
        students.add(0)
        students.addAll(br.readLine().split(" ").map {it.toInt()})
        for(i in 1..n){
            cnt -= dfs(i,visited, students, finish)
        }
        bw.write("$cnt\n")
    }

    bw.flush()
    bw.close()
}

fun dfs(idx : Int, visited : Array<Boolean>, students : ArrayList<Int>, finish : Array<Boolean>) :Int{
    var cnt = 0
    visited[idx-1] = true
    var next = students[idx]
    if(!visited[next-1]) cnt += dfs(next, visited,students,finish)
    else if(!finish[next-1]){
        cnt++
        while(next != idx){
            cnt++
            next = students[next]
        }
    }
    finish[idx-1] = true
    return cnt
}


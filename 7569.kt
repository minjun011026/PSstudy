import java.io.*
import java.util.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (M, N, H) = br.readLine().split(" ").map {it.toInt()}
    var cnt = N*M*H
    val tomato = ArrayList<Int>()
    val queue : Queue<Int> = LinkedList()
    var day = 0
    for(i in 0..<H){
        for(j in 0..< N){
            val tmp = br.readLine().split(" ").map {it.toInt()}
            tomato.addAll(tmp)
            cnt -= tmp.filter { it == 1 || it == -1 }.size
            for(k in 0..tmp.lastIndex){
                if(tmp[k]==1) queue.add(k+M*j+(N*M)*i)
            }
        }
    }

    while(queue.isNotEmpty()){
        val t = queue.size
        repeat(t){
            val tmp = queue.poll()
            if(tmp+1 < tomato.size && tmp%M != M-1 && tmp%(M*N) != M*N-1 && tomato[tmp+1] == 0) {
                tomato[tmp+1] = 1
                queue.add(tmp+1)
            }
            if(tmp-1 >= 0 && tmp%M != 0 && tmp%(M*N) != 0 && tomato[tmp-1]==0) {
                tomato[tmp-1] = 1
                queue.add(tmp-1)
            }
            if(tmp+M < tomato.size && tmp%(N*M) < M*(N-1) && tomato[tmp+M] == 0){
                tomato[tmp+M] = 1
                queue.add(tmp+M)
            }
            if(tmp-M >= 0 && tmp%(N*M) >= M && tomato[tmp-M] == 0){
                tomato[tmp-M] = 1
                queue.add(tmp-M)
            }
            if(tmp+N*M < tomato.size && tomato[tmp+N*M] == 0){
                tomato[tmp+M*N] = 1
                queue.add(tmp+M*N)
            }
            if(tmp-N*M >= 0 && tomato[tmp-N*M] == 0){
                tomato[tmp-M*N] = 1
                queue.add(tmp-M*N)
            }
        }
        cnt -= queue.size
        day++
    }

    if(cnt==0)bw.write("${day-1}")
    else bw.write("-1")
    bw.flush()
    bw.close()
}

import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = ArrayList<Int>()
    val cnt = Array(n) { 1 }
    arr.addAll(br.readLine().split(" ").map { it.toInt() }.toTypedArray())
    val stack = ArrayList<Int>()
    var top = 0
    stack.add(0)
    for(i in 1..< n){
        if(arr[i] > arr[stack[top]]){
            stack.add(i)
            cnt[i] = cnt[stack[top]] + 1
            top++
        }else if(arr[i] < arr[stack[top]]){
            var q = 0
            var r = top
            while(q<r){
                val m = (q+r)/2
                if(arr[stack[m]]<arr[i])
                    q = m + 1
                else if(arr[stack[m]] > arr[i])
                    r = m
                else {
                    q = m
                    break
                }
            }
            cnt[i] = cnt[stack[q]]
            stack[q] = i
        }
    }
    top++
    bw.write("$top\n")
    var before = 2000000001
    val answer = ArrayList<Int>()
    for(i in n-1 downTo 0){
        if(cnt[i] == top && arr[i] < before) {
            answer.add(arr[i])
            before = arr[i]
            top--
        }
    }
    bw.write(answer.reversed().joinToString(" "))
    bw.flush()
    bw.close()
}

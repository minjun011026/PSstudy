import java.io.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = ArrayList<Int>()
    arr.addAll(br.readLine().split(" ").map{it.toInt()}.sorted())
    var result = 0L
    for(i in 0..< N-2){
        var s = i+1
        var e = N-1
        while(s<e) {
            val sum = arr[i] + arr[s] +arr[e]
            if (sum == 0){
                val left = arr[s]
                val right = arr[e]
                if(left == right){
                    result += e-s
                    s++
                }else{
                    var r = 0
                    var l = 0
                    while(right == arr[e--]){
                        r++
                        if(right!=arr[e]) break
                    }
                    while(left == arr[s++]){
                        l++
                        if(left!=arr[s]) break
                    }

                    result += l*r
                }
            }else if(sum>0) e--
            else s++
        }
    }
    bw.write("$result")
    bw.flush()
    bw.close()
}

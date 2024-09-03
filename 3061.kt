import java.io.*

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().trim().toInt()
    repeat(t) {
        val n = br.readLine().trim().toInt()
        val arr = ArrayList<Int>()
        arr.addAll(br.readLine().trim().split(" ").map { it.toInt() })
        bw.write("${mergeSort(arr,0, n - 1)}\n")
    }
    bw.flush()
    bw.close()
}

fun mergeSort(arr : ArrayList<Int>, p: Int , r: Int) : Long{
    if(p >= r) return 0

    val q = (p+r)/2
    var i = p
    var j = q + 1
    var result = mergeSort(arr,p,q) + mergeSort(arr,q+1,r)
    val tmp = Array(r-p+1){0}
    var idx = 0
    while(i<=q || j<=r){
        if(i<=q &&((j>r) || arr[i] <= arr[j])){
            tmp[idx++] = arr[i++]
        }else{
            result += q-i+1
            tmp[idx++] = arr[j++]
        }
    }

    for(k in 0..tmp.lastIndex){
        arr[k+p] = tmp[k]
    }

    return result
}

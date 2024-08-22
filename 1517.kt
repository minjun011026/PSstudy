import java.io.*

val arr = ArrayList<Int>()

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    arr.addAll(br.readLine().split(" ").map {it.toInt()})
    bw.write("${mergeSort(0,n-1)}")
    bw.flush()
    bw.close()
}

fun mergeSort(p: Int , r: Int) : Long{
    if(p >= r) return 0

    val q = (p+r)/2
    var i = p
    var j = q + 1
    var result = mergeSort(p,q) + mergeSort(q+1,r)
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

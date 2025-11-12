import kotlin.math.min

fun main() {
    var n = readln().toInt()
    val arr = Array(n+1) { Int.MAX_VALUE }
    arr[1] = 0
    for(i in 2..n) {
        arr[i] = min(arr[i], arr[i-1])
        if(i%2 == 0) arr[i] = min(arr[i],arr[i/2])
        if(i%3 == 0) arr[i] = min(arr[i],arr[i/3])
        arr[i] = arr[i] + 1
    }
    println("${arr[n]}")
    while(true) {
        if(n == 1) {
            print("1")
            return
        }
        print("$n ")
        if(n%3 == 0 && arr[n] - 1 == arr[n/3]) n/=3
        else if(n%2 == 0 && arr[n] - 1 == arr[n/2]) n/=2
        else if(arr[n-1] == arr[n] - 1) n--

    }
}

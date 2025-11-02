fun main() {
    val t = readln().toInt()
    val arr = Array(10001) { 0 }

    fun dp(idx: Int) : Int{
        if(arr[idx] != 0) return arr[idx]
        arr[idx] = if(idx > 2) dp(idx-3) + idx/2 + 1 else idx/2 + 1
        return arr[idx]
    }

    repeat(t){
        val n = readln().toInt()
        println("${dp(n)}")
    }
}

import java.io.*
import java.util.*

fun main(){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val pic1 = ArrayList<Array<Char>>()
    val pic2 = ArrayList<Array<Char>>()
    var chk = Array(n){Array(n){false}}
    var cnt = 0
    repeat(n){
        val tmp = br.readLine().map{it}.toTypedArray()
        val tmp2 = tmp.map {if(it=='B') it else 'R'}.toTypedArray()
        pic1.add(tmp)
        pic2.add(tmp2)
    }

    for(i in 0..<n){
        for(j in 0..<n){
            if(!chk[i][j]) {
                if (pic1[i][j] == 'R') {
                    dfs(i, j, pic1, 'R', chk)
                    cnt++
                }
                if (pic1[i][j] == 'B') {
                    dfs(i, j, pic1, 'B', chk)
                    cnt++
                }
                if (pic1[i][j] == 'G') {
                    dfs(i, j, pic1, 'G', chk)
                    cnt++
                }
            }
        }
    }
    bw.write("$cnt ")
    cnt = 0
    chk = Array(n){Array(n){false}}
    for(i in 0..<n){
        for(j in 0..<n){
            if(!chk[i][j]) {
                if (pic2[i][j] == 'R') {
                    dfs(i, j, pic2, 'R', chk)
                    cnt++
                }
                if (pic2[i][j] == 'B') {
                    dfs(i, j, pic2, 'B', chk)
                    cnt++
                }
            }
        }
    }
    bw.write("$cnt")
    bw.flush()
    bw.close()
}

fun dfs(i : Int, j : Int, arr : ArrayList<Array<Char>>, target : Char, chk : Array<Array<Boolean>>){
    chk[i][j] = true
    if(i+1<arr.size && arr[i+1][j] == target && !chk[i+1][j]) dfs(i+1,j,arr,target,chk)
    if(i-1>=0 && arr[i-1][j] == target && !chk[i-1][j]) dfs(i-1,j,arr,target,chk)
    if(j+1<arr.size && arr[i][j+1] == target && !chk[i][j+1]) dfs(i,j+1,arr,target,chk)
    if(j-1>=0 && arr[i][j-1] == target && !chk[i][j-1]) dfs(i,j-1,arr,target,chk)
}

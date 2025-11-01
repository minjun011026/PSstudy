fun main() {
    val gear = Array(5) { Array(8) {0} }
    repeat(4) {
        gear[it+1] = readln().map {c -> c.code-48}.toTypedArray()
    }
    val cnt = readln().toInt()

    fun spin(idx: Int, dir : Int) {
        if(dir == 1) {
            val tmp = gear[idx][7]
            for(i in 7 downTo 1) {
                gear[idx][i] = gear[idx][i-1]
            }
            gear[idx][0] = tmp
        }else {
            val tmp = gear[idx][0]
            for(i in 0 .. 6) {
                gear[idx][i] = gear[idx][i+1]
            }
            gear[idx][7] = tmp
        }
    }

    repeat(cnt) {
        val (num, dir) = readln().split(" ").map {it.toInt()}

        if(num > 1) {
            if(gear[num-1][2] != gear[num][6]) {
                if(num > 2) {
                    if(gear[num-2][2] != gear[num-1][6]) {
                        if(num > 3) {
                            if(gear[num-3][2] != gear[num-2][6]) {
                                spin(num-3, dir * -1)
                            }
                        }
                        spin(num-2, dir)
                    }
                }
                spin(num-1, dir * -1)
            }
        }
        if(num<4) {
            if(gear[num+1][6] != gear[num][2]) {
                if(num<3) {
                    if(gear[num+2][6] != gear[num+1][2]) {
                        if(num<2) {
                            if(gear[num+3][6] != gear[num+2][2]) {
                                spin(num+3, dir*-1)
                            }
                        }
                        spin(num+2,dir)
                    }
                }
                spin(num+1,dir*-1)
            }
        }
        spin(num,dir)
    }
    var sum = 0
    if(gear[1][0] == 1) sum+=1
    if(gear[2][0] == 1) sum+=2
    if(gear[3][0] == 1) sum+=4
    if(gear[4][0] == 1) sum+=8
    println("$sum")
}

fun main() {
    val (x, y, z) = readln().split(" ").map {it.toInt()}

    if(x==y && y==z)
        println("${10000+x*1000}")
    else if(x==y || y==z || x==z){
        if(x==y)
            println("${1000+x*100}")
        else if(y==z)
            println("${1000+y*100}")
        else
            println("${1000+x*100}")
    }else{
        if(x>y){
            if(x>z)
                println("${x*100}")
            else
                println("${z*100}")
        }else{
            if(y>z)
                println("${y*100}")
            else
                println("${z*100}")
        }
    }

}

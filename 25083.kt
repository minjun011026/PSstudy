import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    bw.write("         ,r'\"7\n" +
            "r`-_   ,'  ,/\n" +
            " \\. \". L_r'\n" +
            "   `~\\/\n" +
            "      |\n" +
            "      |")
    bw.flush()
}


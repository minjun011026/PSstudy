import java.io.*
import java.util.*

val bw = BufferedWriter(OutputStreamWriter(System.out))
val br = BufferedReader(InputStreamReader(System.`in`))

data class TreeNode<String>(
    var data: String,
    var left: TreeNode<String>? = null,
    var right: TreeNode<String>? = null
)

class Tree{
    var root : TreeNode<String>? = null

    fun add(data: String, left:String, right:String){
        if(root == null){
            root = TreeNode(data)
            if(left!=".")
                root!!.left = TreeNode(left)
            if(right!=".")
                root!!.right = TreeNode(right)
        }
        else
            search(root!!, data, left, right)
    }

    fun search(root:TreeNode<String>, data : String, left: String, right :String){
        if(root.data == data){
            if(left!=".")
                root.left = TreeNode(left)
            if(right!=".")
                root.right = TreeNode(right)
        }else{
            if(root.left!=null)
                search(root.left!!, data, left, right)
            if(root.right!=null)
                search(root.right!!,data,left,right)
        }
    }

    fun inOrder(root:TreeNode<String>){
        if(root.left!=null)
            inOrder(root.left!!)
        bw.write(root.data)
        if(root.right!=null)
            inOrder(root.right!!)
    }

    fun preOrder(root:TreeNode<String>){
        bw.write(root.data)
        if(root.left!=null)
            preOrder(root.left!!)
        if(root.right!=null)
            preOrder(root.right!!)
    }

    fun postOrder(root:TreeNode<String>){
        if(root.left!=null)
            postOrder(root.left!!)
        if(root.right!=null)
            postOrder(root.right!!)
        bw.write(root.data)
    }
}

fun main() {

    val n = br.readLine().toInt()

    val tree : Tree = Tree()
    repeat(n){
        val (a,b,c) = br.readLine().split(" ")
        tree.add(a,b,c)
    }

    tree.preOrder(tree.root!!)
    bw.write("\n")
    tree.inOrder(tree.root!!)
    bw.write("\n")
    tree.postOrder(tree.root!!)


    bw.flush()
}
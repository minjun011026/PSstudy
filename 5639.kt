import java.io.*

val bw = BufferedWriter(OutputStreamWriter(System.out))

data class TreeNode<Int>(
    var data: Int,
    var left: TreeNode<Int>? = null,
    var right: TreeNode<Int>? = null
)

class Tree{
    var root : TreeNode<Int>? = null

    fun add(data: Int, parent : TreeNode<Int>?){
        if(root == null){
            root = TreeNode(data)
        }else{
            if(parent!!.data < data) {
                if(parent.right==null)
                    parent.right = TreeNode(data)
                else
                    add(data, parent.right!!)
            }
            else {
                if(parent.left==null)
                    parent.left = TreeNode(data)
                else
                    add(data, parent.left!!)
            }
        }
    }

    fun postOrder(root:TreeNode<Int>){
        if(root.left!=null)
            postOrder(root.left!!)
        if(root.right!=null)
            postOrder(root.right!!)
        bw.write("${root.data}\n")
    }
}


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val tree = Tree()

    while(true){
        try {
            val n = br.readLine().toInt()
            tree.add(n, tree.root)
        } catch(e : Exception) {
            break
        }
    }
    tree.postOrder(tree.root!!)
    bw.flush()
}



public class HeightOfTree {
	public static void main(String[] args) 
    {
        BinaryTree2 tree = new BinaryTree2();
  
        tree.root = new Node3(1);
        tree.root.left = new Node3(2);
        tree.root.right = new Node3(3);
        tree.root.left.left = new Node3(4);
        tree.root.left.right = new Node3(5);
  
        System.out.println("Height of tree is : " + 
                                      tree.maxDepth(tree.root));
    }
	
}
class Node3{
	int data;
	Node3 left;
	Node3 right;
	Node3(int data){
		this.data = data;
		left = right = null;
	}
}
class BinaryTree2{
	Node3 root;
	
	int maxDepth(Node3 node){
		if(node == null){
			return 0;
		}else{
			int leftMaxDepth = maxDepth(node.left);
			int rightMaxDepth = maxDepth(node.right);
			
			if(leftMaxDepth > rightMaxDepth){
				return (leftMaxDepth + 1);
			}else{
				return (rightMaxDepth + 1);
			}
		}
	}
}
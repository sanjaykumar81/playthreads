package codality;

import sj.subtree.Node;
import sj.subtree.Tree;

import java.util.Stack;

public class PrintBSTInOrder {

    public static void main(String[] args) {
        Node left = new Node(7,

                new Node(2,
                        new Node(1,null,null),
                        new Node(3,null,null)),
                new Node(8,
                        new Node(6,null,null),
                        new Node(9,null,null)));

        Node right = new Node(20,
                new Node(15,
                        new Node(13,null,null),
                        new Node(17,null,null)),
                new Node(30,
                        new Node(25,
                                new Node(24,null,null),
                                new Node(27,null,null)),
                        new Node(36,
                                new Node(32,
                                        new Node(31,null,null),
                                        new Node(34,
                                                new Node(33,null,null),
                                                new Node(35,null,null))),
                                new Node(38,null,null)))
        );


        Tree tree = new Node(10,left,right);
        PrintBSTInOrder pTree = new PrintBSTInOrder();
        pTree.printBST(tree);


    }


    public void printBST(Tree root){

        Stack<Tree> stack = new Stack<>();

        stack.push(root);
        while (!stack.empty()){
            Tree node = stack.peek();
            if(isLeafNode(node)){

                System.out.println(node.data);
                stack.pop(); // removing the leaf node
                if(!stack.isEmpty()) {
                    node = stack.pop(); // removing the parent of leaf node
                    System.out.println(node.data);
                    if (node.getR() != null) {
                        stack.push(node.getR());
                    }
                }
            }else{
                stack.push(node.getL());
            }

        }
    }

    private boolean isLeafNode(Tree node) {
        return node.getL() == null && node.getR() == null;
    }
}

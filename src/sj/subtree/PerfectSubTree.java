package sj.subtree;

import java.util.Random;

import java.util.stream.IntStream;

public class PerfectSubTree {

    public static void main(String [] args){
        Tree t = buildTree();
//        Tree t = buildRandomTree();  // for testing with randomly generated tree
//        printTree(t);
        Solutions solution = new Solutions();

        int height = solution.nodeCountOfBiggestPBT(t);

        System.out.println("Node count of the biggest perfect binary tree within the tree : " +height);
    }

    private static Tree buildTree() {

        // answer 7 -- if use this left
//        Node left = new Node(7,
//                                new Node(2,
//                                        null,
//                                        new Node(3,null,null)),
//                                new Node(8,
//                                       null,
//                                        new Node(9,null,null)));
        // answer 15 -- if use this left
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
        return tree;
    }

    private  static void printTree(Tree node){

        if(node == null){
            System.out.println("");
            return;
        }
        System.out.print("Node data: "+ node.getData() + "\n");
        System.out.println(" Printing Left node");
        printTree(node.getL());
        System.out.println(" Printing Right node");
        printTree(node.getR());
    }

    private static Tree buildRandomTree(){
        Tree tree = new Tree(new Random().nextInt(), buildRandomNode(),buildRandomNode());
        return tree;
    }

    private static Node buildRandomNode() {
        int data = new Random().ints(1,50).findFirst().getAsInt();
        Node node = new Node(data,null,null);
        if(isPrime(data)){
            return node;
        }else{
            node.setL(buildRandomTree());
            node.setR(buildRandomTree());
            return node;
        }
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .filter(n -> (n & 0X1) != 0)
                .allMatch(n -> number % n != 0);
    }
}



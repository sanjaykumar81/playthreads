package sj.generics;


class  BNode<D extends  Comparable<D>> {
    BNode<D> left = null;
    BNode<D> right = null;
    D data = null;
    public BNode(D data){
        this.data = data;
    }

    public void insert(BNode<D> node){
        if(this.data.compareTo(node.data) >0){
            if (this.left == null) {
                this.left = node;
            }else{
                this.left.insert(node);
            }
        }else{
            if(this.right == null) {
                this.right = node;
            }else{
                this.right.insert(node);
            }
        }
    }

    public  static <D extends Comparable<D>> int getHeight(BNode<D> node){
        int height =0;
        if (node.left == null && node.right== null){
            return height;
        }else if (node.left == null ){

            int rHeight = getHeight(node.right) + 1;

            height = rHeight;
            return height;
        } else if (node.right == null ){
            int lHeight = getHeight(node.left) +1;

            height = lHeight;

            return height;
        }else{
            int lHeight = getHeight(node.left) +1;
            int rHeight = getHeight(node.right) + 1;

            if (lHeight >= rHeight){
                height = lHeight;
            }else{
                height = rHeight;
            }
            return height;
        }
    }
}


public class GenericBinaryTree {

    public static  void main(String[] args){

        BNode<Integer> bNode = new BNode<>(2);
        bNode.insert(new BNode<>(4));
        bNode.insert(new BNode<>(6));
        bNode.insert(new BNode<>(7));
        bNode.insert(new BNode<>(8));
        bNode.insert(new BNode<>(1));
        System.out.println(BNode.getHeight(bNode));


        BNode<String> bNode2 = new BNode<>("sanjay");
        bNode2.insert(new BNode<>("ajay"));
        bNode2.insert(new BNode<>("vijay"));
        bNode2.insert(new BNode<>("rakesh"));
        bNode2.insert(new BNode<>("amit"));
        bNode2.insert(new BNode<>("ram"));
        System.out.println(BNode.getHeight(bNode2));

    }

}

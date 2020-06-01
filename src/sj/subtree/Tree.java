package sj.subtree;

import java.util.TreeMap;

public class Tree{
    public int data;
    public Tree l;
    public Tree r;
    public Tree(int data, Tree l, Tree r) {
        TreeMap<String, String> tree= new TreeMap<>();
        this.data = data;
        this.l = l;
        this.r = r;

    }

    public int getData() {
        return data;
    }

    public Tree getL() {
        return l;
    }

    public Tree getR() {
        return r;
    }

    public void setL(Tree l) {
        this.l = l;
    }

    public void setR(Tree r) {
        this.r = r;
    }
}

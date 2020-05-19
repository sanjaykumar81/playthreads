package sj.generics;

import java.util.*;

class Node<D> {
    D data;
    Node<D> next;
    Node(D d) {
        data = d;
        next = null;
    }
}

class List<D> {

    public Node<D> insert(Node<D> head, D data) {
        if (head == null) {
            return new Node(data);
        } else {
            Node<D> node = new Node(data);
            if (head.next == null) {
                head.next = node;
                return head;
            }
            Node<D> start = head.next;
            while (start.next != null) {
                start = start.next;
            }
            start.next = node;
            return head;
        }
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }
}

public class MyGenericList {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node<String> head = null;
        int N = sc.nextInt();

        List<String> list = new List<>();

        while(N-- > 0) {
            String ele = sc.next();
            head = list.insert(head,ele);
        }
        list.display(head);
        sc.close();
    }
}
package com.wy.springbootdemo.until;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class BinaryTree {

    static Random random = new Random();

    @Getter
    @Setter
    @ToString
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }

    }

    /**
     * @param root   遍历的根节点
     * @param method 遍历的方法，pre：先序遍历，in：中序遍历，pos：后序遍历
     * @return
     */
    public static List<Integer> traversal(Node root, String method) {
        List<Integer> array = new ArrayList<>();
        if (root == null) {
            return array;
        }
        if ("pre".equals(method)) {
            array.add(root.value);
            System.out.println(root.value);
        }

        traversal(root.left, method);
        if ("in".equals(method)) {
            array.add(root.value);
            System.out.println(root.value);
        }
        traversal(root.right, method);
        if ("pos".equals(method)) {
            array.add(root.value);
            System.out.println(root.value);
        }

        return array;
    }


    /**
     * 随机生成二叉树
     * @return
     */
    public static Node create() {

        TreeMap<Integer,Integer> map = new TreeMap<>();



        int index = random.nextInt(100);
        if (index > 50) {
            Node node = new Node(index);
            node.left = create();
            node.right = create();
            return node;
        }
        return null;
    }




    public static Node buildTreeByPreIn(int[] pre,int[] in){
        if (pre == null || in == null ||  pre.length != in.length)
            return null;
        return PreIn(pre,0,pre.length - 1, in, 0, in.length - 1);
    }

    /**
     *根据传入的数组确认当前节点，同时传入以当前先序数组得到的头节点，根据范围递归调用函数去寻找两个子节点的结果。
     * @param pre 先序遍历数组
     * @param L1  数组左边界
     * @param R1  数组右边界
     * @param in  中序遍历数组
     * @param L2  数组左边界
     * @param R2  数组右边界
     * @return
     */
    public static Node PreIn(int[] pre, int L1, int R1, int[] in, int L2, int R2){
        if (L1 > R1)
            return null;
        Node head = new Node(pre[L1]);
        if (L1 == R1)
            return head;
        int find = L2;
        while (in[find] != pre[L1])
            find++;
        head.left = PreIn(pre,L1+1, find - L2,in,L2,find-1);
        head.right =PreIn(pre,L1 + find - L2 +1,R1,in,find + 1,R2);
        return head;

    }


    /**
     * 以当前传入的两个节点为头节点，判断两二叉树结够是否相同
     * @param node1
     * @param node2
     * @return
     */
    public static boolean isSameTree(Node node1, Node node2){
        if (node1 == null ^ node2 == null){
            return  false;
        }
        if (node1 == null && node2 == null){
            return true;
        }
        return node1.value == node2.value && isSameTree(node1.left,node2.left) && isSameTree(node1.right,node2.right);


    }


    public static void main(String[] args) {

        int[] pre = new int[]{1,2,3};
        int[] in = new int[]{2,1,3};

        Node root = buildTreeByPreIn(pre, in);
        System.out.println("重建完成！");

        traversal(root,"pos");
    }


}

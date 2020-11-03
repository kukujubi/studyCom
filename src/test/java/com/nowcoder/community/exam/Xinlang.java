package com.nowcoder.community.exam;


import com.sun.source.tree.Tree;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;

import java.util.Scanner;

public class Xinlang {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val=x;
        }
    }
    public static TreeNode process(TreeNode root){
        if(root==null||root.left==null){
            return root;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        TreeNode t=process(l);
        l.left=r;
        l.right=root;
        root.left=null;
        root.right=null;
        return t;

    }
    public static TreeNode create(Integer[] arr,int index){
        TreeNode treeNode = null;
        if(index<arr.length){
            Integer v = arr[index];
            if (v==null){
                return null;
            }
            treeNode = new TreeNode(v);
            treeNode.left=create(arr,2*index+1);
            treeNode.right=create(arr,2*index+2);
            return treeNode;

        }
        return treeNode;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

    }
}

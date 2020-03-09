package com.test.code.tree;

public class RedBlackDemo {
    public static void main(String[] args) {
        RedBlackTreeMap<String,String> rm = new RedBlackTreeMap<>();
        rm.put("1","one");
        rm.put("2","one");
        rm.put("3","one");
        rm.keySet().forEach(System.out::println);
    }
}

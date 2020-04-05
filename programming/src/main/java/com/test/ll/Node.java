package com.test.ll;

import java.io.*;
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}
class LinkedListDuplicate
{

    public static Node removeDuplicates(Node head) {
      //Write your code here
       if(head == null){
           return head;
       }
        Node curr = head;
       //3,9,9,11,11,11,11,89,89,100,100,101,102,103,108,200,250,250,250,250
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

	 public static  Node insert(Node head,int data)
     {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(Node head)
        {
              Node start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              Node head=null;
              /*int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }*/
              int arr [] = {3,9,9,11,11,11,11,89,89,100,100,101,102,103,108,200,250,250,250,250};
              for( int ele : arr){
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }
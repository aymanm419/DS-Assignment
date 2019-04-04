package com.company;
import java.lang.*;
import java.util.*;
public class MySpecialLinkedListUtils {
    public static LinkedListNode arrayListToLinkedList(ArrayList<Integer> myArr)
    {
        LinkedListNode head = new LinkedListNode();
        if(myArr.size() == 0)
            return head;
        head.value = myArr.get(0);
        LinkedListNode Tmp = head;
        for(int i = 1;i < myArr.size();i++)
        {
            LinkedListNode curNode = new LinkedListNode();
            curNode.value = myArr.get(i);
            Tmp.next = curNode;
            Tmp = curNode;
        }
        return head;
    }
    public static double[] summary(LinkedListNode head)
    {
         int sum = 0;
         int maxNum = 0x80000000;
         int minNum = 0x7FFFFFFF;
         int Sz = 0;
         LinkedListNode sHead = head;
         while(head != null)
         {
             sum += head.getValue();
             Sz++;
             maxNum = Math.max(maxNum,head.getValue());
             minNum = Math.min(minNum,head.getValue());
             head = head.getNext();
         }
         return new double[]{(double)sum,(double)sum / Sz,(Sz % 2 == 1 ? (double)getKthNode(sHead,Sz / 2).value :
                 ((double)getKthNode(sHead,Sz / 2).value + (double)getKthNode(sHead,(Sz / 2) - 1).value) / 2),(double)maxNum,(double)minNum};
    }
    public static LinkedListNode reverse(LinkedListNode head)
    {
        LinkedListNode nextNode = null,previousNode = null,Tmp = head;
        while(Tmp != null)
        {
            nextNode = Tmp.next;
            Tmp.next = previousNode;
            previousNode = Tmp;
            Tmp = nextNode;
        }
        return previousNode;
    }
    public static LinkedListNode evenIndexedElements(LinkedListNode head)
    {
        LinkedListNode Shead = head;
        while(Shead != null)
        {
            LinkedListNode Tmp = Shead.next;
            if(Tmp != null)
                Tmp = Tmp.next;
            Shead.next = Tmp;
            Shead = Tmp;
        }
        return head;
    }
    public static ArrayList<Integer> sortArrayList(int l,int r,ArrayList<Integer> myArr)
    {
        if(l == r)
            return new ArrayList<Integer>(Arrays.asList(myArr.get(l)));
        int mid = (l + r) >> 1;
        ArrayList<Integer> Lp = sortArrayList(l,mid,myArr);
        ArrayList<Integer> Rp = sortArrayList(mid + 1,r,myArr);
        ArrayList<Integer> Tmp = new ArrayList<Integer>();
        int c1 = 0,c2 = 0;
        while(c1 < Lp.size() && c2 < Rp.size())
        {
            if(Lp.get(c1) <= Rp.get(c2))
            {
                Tmp.add(Lp.get(c1));
                c1++;
            }
            else
            {
                Tmp.add(Rp.get(c2));
                c2++;
            }
        }
        while(c1 < Lp.size())
        {
            Tmp.add(Lp.get(c1));
            c1++;
        }
        while(c2 < Rp.size())
        {
            Tmp.add(Rp.get(c2));
            c2++;
        }
        return Tmp;
    }
    public static LinkedListNode mergeSort(LinkedListNode head)
    {
        ArrayList<Integer> myArr = new ArrayList<Integer>();
        while(head != null)
        {
            myArr.add(head.getValue());
            head = head.getNext();
        }
        return arrayListToLinkedList(sortArrayList(0,myArr.size()-1,myArr));
    }
    public static LinkedListNode getKthNode(LinkedListNode head,int k)
    {
        while(k > 0 && head != null)
        {
            k--;
            head = head.getNext();
        }
        return head;
    }
    public static LinkedListNode insertionSort(LinkedListNode head)
    {
        LinkedListNode curHead = null;
        while(head != null)
        {
            LinkedListNode Tmp = new LinkedListNode();
            Tmp.value = head.value;
            Tmp.next = curHead;
            curHead = Tmp;
            while(Tmp.next != null)
            {
                if(Tmp.getValue() > Tmp.getNext().getValue())
                {
                    int TmpValue = Tmp.getValue();
                    Tmp.value = Tmp.getNext().getValue();
                    Tmp.next.value = TmpValue;
                    Tmp = Tmp.next;
                } else break;
            }
            head = head.getNext();
        }
        return curHead;
    }
    public static LinkedListNode removeCentralNode(LinkedListNode head)
    {
        ArrayList<Integer> myArr = new ArrayList<Integer>();
        LinkedListNode Tmp = head;
        int Sz = 0;
        while(Tmp != null)
        {
            Sz++;
            Tmp = Tmp.getNext();
        }
        if(Sz <= 1)
            return null;
        if(Sz % 2 == 0) {
            Tmp = getKthNode(head, (Sz / 2) - 2);
            Tmp.next = Tmp.next.next;
        }
        else
        {
            Tmp = getKthNode(head, (Sz / 2) - 1);
            Tmp.next = Tmp.next.next;
        }
        return head;
    }
    public static boolean palindrome(LinkedListNode head)
    {
        ArrayList<Integer> myArr = new ArrayList<Integer>();
        while(head != null)
        {
            myArr.add(head.getValue());
            head = head.getNext();
        }
        for(int i = 0;i < myArr.size();i++)
        {
            if(myArr.get(i) != myArr.get(myArr.size() - i - 1))
                return false;
        }
        return true;
    }
    public static void printList(LinkedListNode head)
    {
        while(head != null){
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(2);
        arr.add(1);
        arr.add(3);
        arr.add(1);
        LinkedListNode head = arrayListToLinkedList(arr);
        printList(insertionSort(head));
    }
}

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
         ArrayList<Integer> myArr = new ArrayList<Integer>();
         int sum = 0;
         int maxNum = 0x80000000;
         int minNum = 0x7FFFFFFF;
         while(head != null)
         {
             System.out.println(head.getValue());
             sum += head.getValue();
             myArr.add(head.getValue());
             maxNum = Math.max(maxNum,head.getValue());
             minNum = Math.min(minNum,head.getValue());
             head = head.getNext();
         }
         return new double[]{(double)sum,(double)sum / (myArr.size()),(double)myArr.get(myArr.size() / 2),(double)maxNum,(double)minNum};
    }
    public static LinkedListNode reverse(LinkedListNode head)
    {
        ArrayList<Integer> myArr = new ArrayList<Integer>();
        while(head != null)
        {
            myArr.add(head.getValue());
            head = head.getNext();
        }
        for(int i = 0;i < myArr.size()/2;i++)
        {
            int tmp = myArr.get(i);
            myArr.set(i, myArr.get(myArr.size() - i - 1));
            myArr.set(myArr.size() - i - 1, tmp);
        }
        return arrayListToLinkedList(myArr);
    }
    public static LinkedListNode evenIndexedElements(LinkedListNode head)
    {
        ArrayList<Integer> myArr = new ArrayList<Integer>();
        int cnt = 0;
        while(head != null)
        {
            if(cnt % 2 == 0)
                myArr.add(head.getValue());
            cnt = (cnt + 1) % 2;
            head = head.getNext();
        }
        return arrayListToLinkedList(myArr);
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
        LinkedListNode Tmp,NodeBefore;
        int Place = 1;
        while(getKthNode(head,Place) != null)
        {
            int j = Place;
            while(j >= 1)
            {
                NodeBefore = getKthNode(head,j-1);
                Tmp = getKthNode(head,j);
                if(NodeBefore.getValue() > Tmp.getValue())
                {
                    int Tvalue = NodeBefore.getValue();
                    NodeBefore.value = Tmp.getValue();
                    Tmp.value = Tvalue;
                    j--;
                    continue;
                }
                break;
            }
            Place++;
        }
        return head;
    }
    public static LinkedListNode removeCentralNode(LinkedListNode head)
    {
        ArrayList<Integer> myArr = new ArrayList<Integer>();
        while(head != null)
        {
            myArr.add(head.getValue());
            head = head.getNext();
        }
        if(myArr.size() % 2 == 0)
            myArr.remove((myArr.size() / 2) - 1);
        else
            myArr.remove(myArr.size() / 2);
        return arrayListToLinkedList(myArr);
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
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        LinkedListNode head = arrayListToLinkedList(arr);
        System.out.println(palindrome(head));
    }
}

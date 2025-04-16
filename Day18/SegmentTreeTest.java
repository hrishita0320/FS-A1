package Day18;
/*Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.
Your task is to solve this problem using Segment Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------       
An integer result, for every sumRange query.


Sample Input:
-------------
5 5
4 2 13 3 25
1 0 4		//sumRange
1 1 3		//sumRange
2 2 18	//update
2 4 17	//update
1 0 4		//sumRange

5 5
4 2 13 3 25
1 0 4
1 1 3
2 2 18	
2 4 17
1 0 4	

Sample Output:
--------------
47
18
44
 */
import java.util.*;
public class SegmentTreeTest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        SegmentTree s = new SegmentTree(arr);
        while(q-->0){
            int val = sc.nextInt();
            if(val==1){
                int start = sc.nextInt();
                int end = sc.nextInt();
                System.out.println(s.sumRange(start,end));
            }
            else if(val==2){
                int index = sc.nextInt();
                int newVal = sc.nextInt();
                s.updateValue(index,newVal);
            }
        }
    }
}
class SegmentTreeNode{
    int start;
    int end;
    SegmentTreeNode left,right;
    int sum;
    public SegmentTreeNode(int start,int end){
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum =0;
    }
}
class SegmentTree{
    SegmentTreeNode root;
    public SegmentTree(int[] arr){
        this.root = buildTree(arr,0,arr.length-1);
    }
    public SegmentTreeNode buildTree(int[] arr,int start,int end){
        if(start>end){
            return null;
        }
        else{
            SegmentTreeNode seg = new SegmentTreeNode(start,end);
            if(start==end){
                seg.sum= arr[start];
            }
            else{
                int mid = (start+end)/2;
                seg.left = buildTree(arr,start,mid);
                seg.right = buildTree(arr,mid+1,end);
                seg.sum = seg.left.sum+seg.right.sum;                
            }
            return seg;
        }
        
    }
    public int sumRange(int start,int end){
        return findSum(root,start,end);
        
    }
    public int findSum(SegmentTreeNode root,int start,int end){
        if(root.start==start && root.end == end){
            return root.sum;
        }
        else{
            int mid = (root.start+root.end)/2;
            if(end<=mid){
                return findSum(root.left,start,end);
            }
            else if(start>mid){
                return findSum(root.right,start,end);
            }
            else{
                return findSum(root.left,start,mid) + findSum(root.right,mid+1,end);
            }
        }
    }
    public void updateValue(int index,int newVal){
        actualUpdate(root,index,newVal);
    }
    public void actualUpdate(SegmentTreeNode root,int index,int newVal){
        if(root.start == root.end){
            root.sum = newVal;
            return;
        }
        else{
            int mid = (root.start+root.end)/2;
            if(index<=mid){
                actualUpdate(root.left,index,newVal);
            }
            else{
                actualUpdate(root.right,index,newVal);
            }
            root.sum = root.left.sum+root.right.sum;
        }
    }
    
}
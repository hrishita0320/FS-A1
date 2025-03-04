package Day17;
/*Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input-1:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output-1:
----------------
75
86
80



Sample Input-2:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7

Sample Output-2:
----------------
75
86
83
 */
import java.util.*;
public class FenWickTree{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        

        createTree ct = new createTree(nums);
        while(q-->0){
            int a = sc.nextInt();
            if(a==1){
                int start = sc.nextInt();
                int end = sc.nextInt();
                System.out.println(ct.sumRange(start,end));
                
            }
            else{
                

int index = sc.nextInt();


int value = sc.nextInt();


ct.update(index,value);
                

}
        }
    }
}
class createTree{
    int n;
    int[] nums;
    int[] BITS;
    public createTree(int[] nums){
        this.nums = nums;
        n=nums.length;
        BITS = new int[n+1];
        for(int i=0;i<n;i++){
            init(i,nums[i]);
        }
    }
    public void init(int i,int val){
        i++;
        while(i<=n){
            BITS[i]+=val;
            i+=(i &-i);
        }
    }
    public int getSum(int i){
        int sum =0;
        i++;
        while (i > 0)  {
            sum += BITS[i]; 
            i -= (i & -i); 
        } 
        return sum; 
        
    }
    public int sumRange(int start,int end){
        return getSum(end) - getSum(start-1);
        
    }
    public void update(int i,int val){
        int diff = val - nums[i];
        nums[i]=val;
        init(i,diff);
    }
}

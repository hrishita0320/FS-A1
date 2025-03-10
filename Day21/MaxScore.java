package Day21;
/*You are given an array of positive integers. 
Your task is to find a contiguous subarray where all elements are unique 
and return the maximum possible sum that can be obtained by erasing exactly one such subarray.

A subarray is defined as a contiguous sequence of elements within the given array.

Input Format:
-------------
Line-1: An integer N, representing the number of elements in the array.
Line-2: Space-separated integers, representing the elements of the array.

Output Format:
--------------
Line-1: A single integer, representing the maximum sum of a contiguous subarray with all unique elements.

Sample Input-1:
---------------
5  
4 2 4 5 6  

Sample Output-1:
----------------
17

Explanation:
-------------
The longest unique subarray is [2, 4, 5, 6] with a sum of 2 + 4 + 5 + 6 = 17.
This is the maximum possible sum that can be obtained.


Sample Input-2:
---------------
6  
1 2 3 1 2 3  

Sample Output-2:
----------------
6


Explanation:
------------
The longest unique subarray is [1, 2, 3] with a sum of 1 + 2 + 3 = 6.
This sum cannot be improved by choosing another unique subarray.
 */
import java.util.*;
class MaxScore{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> set = new HashMap<>();
        int left = 0;
        int right = 0;
        int sum =0;
        int count = 0;
        int maxSum=0;
        
        while(right<n){
            set.put(nums[right],set.getOrDefault(nums[right],0)+1);
            sum+=nums[right];
            while(set.get(nums[right])>1){
                set.put(nums[left],set.get(nums[left])-1);
                sum-=nums[left];
                left++;
            }
            if(count<right-left+1){
                count = right-left+1;
                maxSum = sum;
            }
            right++;
        }
        System.out.println(maxSum);
    }
}
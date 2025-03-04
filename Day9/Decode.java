package Day9;

/*
 * Mr Bond is a spy and he is working on a mission to solve that mission he needs 
list of numbers which are password to a secret locker, he got a secret code from his informer 
which consists of a circular array code of length of n and a key k.

To decrypt the code, he must replace every number. All the numbers are replaced simultaneously.
with your programming skills help bond to decrypt the code.
The following are the rules to be followed to decrypt the code.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.

As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Input Format: 
-------------
Line-1: An integer (n)
Line-2: n space separated integers
Line-3: An integer (k)

Output Format:
---------------
Line-1: list of integers

Sample Input-1:
---------------
4
5 7 1 4
3

Sample Output-1: 
----------------
[12,10,16,13]

Explanation: Each number is replaced by the sum of the next 3 numbers. 
The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

Sample Input-2:
---------------
4
1 2 3 4
0

Sample Output-2:
----------------
[0,0,0,0]

Explanation: When k is zero, the numbers are replaced by 0. 

Sample Input-3:
---------------
4
2 4 9 3
-2

Sample Output-3:
----------------
[12,5,6,13]

Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. 
Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 

Constraints:

n == code.length
1 <= n <= 100
1 <= code[i] <= 100
-(n - 1) <= k <= n - 1
 */

 //All test cases didnt pass (1 failed)
 import java.util.*;
 class Decode{
     public static List<Integer> helper(int[] arr,int n,int k){
         List<Integer> res=new ArrayList<>();
         if(k==0){
             return res;
         }
         int[] arr1=new int[2*n];
         for(int i=0;i<2*n;i++){
             arr1[i]=arr[i%n];
         }
         int start=k>0?1:n+k;
         int end=k>0?k:n-1;
         int sum=0;
         for(int i=start;i<=end;i++){
             sum+=arr1[i];
         }
         for(int i=0;i<n;i++){
             res.add(sum);
             sum-=arr1[start++];
             sum+=arr1[++end];
         }
         return res;
     }
     public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int[] arr=new int[n];
         for(int i=0;i<n;i++){
             arr[i]=sc.nextInt();
         }
         int k=sc.nextInt();
         List<Integer> nums=helper(arr,n,k);
         System.out.println(nums);
         sc.close();
     }
 }

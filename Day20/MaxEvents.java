import java.util.*; 
import java.io.*; 
// Segment Tree 
class Solution { 
class SegmentTreeNode { 
int start, end; 
SegmentTreeNode left, right; 
int val; 
public SegmentTreeNode(int start, int end) { 
this.start = start; 
this.end = end; 
left = null; 
right = null; 
val = 0; 
} 
} 
SegmentTreeNode root; 
public int maxEvents(int[][] events) { 
if (events == null || events.length == 0) return 0; 
Arrays.sort(events, (a, b) -> { 
if (a[1] == b[1]) 
return a[0] - b[0]; 
return a[1] - b[1]; 
}); 
int lastDay = events[events.length - 1][1]; 
int firstDay = Integer.MAX_VALUE; 
for (int i = 0; i < events.length; i++) { 
firstDay = Math.min(firstDay, events[i][0]); 
} 
root = buildSegmentTree(firstDay, lastDay); 
int count = 0; 
for (int[] event: events) { 
int earliestDay = query(root, event[0], event[1]); 
if (earliestDay != Integer.MAX_VALUE) { 
count++; 
update(root, earliestDay); 
} 
} 
return count; 
} 
private SegmentTreeNode buildSegmentTree(int start, int end) { 
if (start > end) 
return null; 
SegmentTreeNode node = new SegmentTreeNode(start, end); 
node.val = start; 
if (start != end) { 
int mid = start + (end - start) / 2; 
node.left = buildSegmentTree(start, mid); 
node.right = buildSegmentTree(mid + 1, end); 
} 
return node; 
} 
private void update(SegmentTreeNode curr, int lastDay) { 
if (curr.start == curr.end) { 
curr.val = Integer.MAX_VALUE; 
} else { 
int mid = curr.start + (curr.end - curr.start) / 2; 
if (mid >= lastDay) { 
update(curr.left, lastDay); 
} else { 
update(curr.right, lastDay); 
} 
curr.val = Math.min(curr.left.val, curr.right.val); 
} 
} 
private int query(SegmentTreeNode curr, int left, int right) { 
if (curr.start == left && curr.end == right) { 
return curr.val; 
} 
int mid = curr.start + (curr.end - curr.start) / 2; 
if (mid >= right) { 
return query(curr.left, left, right); 
} else if (mid < left) { 
return query(curr.right, left, right); 
} else 
return Math.min(query(curr.left, left, mid), query(curr.right, mid + 1, right)); 
} 
} 
public class MaxEvents { 
public static void main(String args[]) throws IOException { 
Scanner scan = new Scanner(System.in); 
int n = scan.nextInt(); 
scan.nextLine(); 
String str[] = scan.nextLine().split(","); 
int nums[][] = new int[n][2]; // declaring 10000 records to read from the input.txt file 
for (int i = 0; i < n; i++) { 
String val[] = str[i].split(" "); 
nums[i][0] = Integer.parseInt(val[0]); 
nums[i][1] = Integer.parseInt(val[1]); 
} // reading input into nums array 
Solution fna = new Solution(); // Fenwick Tree Approch Class Object Creation 
long result = fna.maxEvents(nums); // call Fenwick sumRange() 
System.out.println(result); 
} 
}
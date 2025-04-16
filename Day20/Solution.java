import java.util.*;

public class Solution {
    static class TreapNode {
        long key;
        int priority;
        int count;
        TreapNode left, right;

        public TreapNode(long key) {
            this.key = key;
            this.priority = new Random().nextInt();
            this.count = 1;
        }
    }

    static class Treap {
        TreapNode root = null;

        private int size(TreapNode node) {
            return node == null ? 0 : node.count;
        }

        private void updateCount(TreapNode node) {
            if (node != null) {
                node.count = 1 + size(node.left) + size(node.right);
            }
        }

        private TreapNode rotateRight(TreapNode p) {
            TreapNode q = p.left;
            p.left = q.right;
            q.right = p;
            updateCount(p);
            updateCount(q);
            return q;
        }

        private TreapNode rotateLeft(TreapNode p) {
            TreapNode q = p.right;
            p.right = q.left;
            q.left = p;
            updateCount(p);
            updateCount(q);
            return q;
        }

        public TreapNode insert(TreapNode node, long key) {
            if (node == null) return new TreapNode(key);

            if (key < node.key) {
                node.left = insert(node.left, key);
                if (node.left.priority > node.priority) {
                    node = rotateRight(node);
                }
            } else {
                node.right = insert(node.right, key);
                if (node.right.priority > node.priority) {
                    node = rotateLeft(node);
                }
            }

            updateCount(node);
            return node;
        }

        public int countLessThan(TreapNode node, double key) {
            if (node == null) return 0;

            if (key <= node.key) {
                return countLessThan(node.left, key);
            } else {
                return 1 + size(node.left) + countLessThan(node.right, key);
            }
        }

        public void insert(long key) {
            root = insert(root, key);
        }

        public int countLessThan(double key) {
            return countLessThan(root, key);
        }
    }

    public int reversePairs(int[] nums) {
        Treap treap = new Treap();
        int count = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            count += treap.countLessThan(nums[i] / 2.0);
            treap.insert(nums[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.reversePairs(nums);
        System.out.println("Number of reverse pairs: " + result);
    }
}

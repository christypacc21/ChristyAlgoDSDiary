//package Leeetcode;
//
//public class _112 {
//
//     public class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//         TreeNode() {}
//         TreeNode(int val) { this.val = val; }
//         TreeNode(int val, TreeNode left, TreeNode right) {
//             this.val = val;
//             this.left = left;
//             this.right = right;
//         }
//     }
//
//    public static boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) return false;
//        if (root.left == null && root.right == null){ // if is leaf(the end node)
//            return sum == root.val;
//        }
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//    }
//
//    public static void main(String[] args) {
//        TreeNode nums = {5,4,8,11,0,13,4,7,2,0,0,0,1};
//        int val = 22;
//        System.out.println(hasPathSum(nums, 22));
//    }
//}

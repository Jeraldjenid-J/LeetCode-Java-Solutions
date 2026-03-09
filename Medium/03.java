// Balance a Binary Search Tree

class Solution {
    List<Integer> sortedList = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        // Step 1: In-order traversal panni sorted list edukanum
        inOrder(root);
        // Step 2: Sorted list-ah vachi balanced tree create pannanum
        return buildBalancedTree(0, sortedList.size() - 1);
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        sortedList.add(node.val);
        inOrder(node.right);
    }

    private TreeNode buildBalancedTree(int start, int end) {
        if (start > end) return null;

        // Middle element-ah root-ah pick panna thaan tree balance aagum
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedList.get(mid));

        // Left half-ah left child-aavum, Right half-ah right child-aavum mathanum
        node.left = buildBalancedTree(start, mid - 1);
        node.right = buildBalancedTree(mid + 1, end);

        return node;
    }
}

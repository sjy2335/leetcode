/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int heightDiff = getHeight(p) - getHeight(q);
        Node deeper = heightDiff >= 0 ? p : q;
        Node shallower = heightDiff >= 0 ? q : p;
        
        deeper = moveUp(deeper, Math.abs(heightDiff));
        while (deeper != shallower) {
            deeper = moveUp(deeper);
            shallower = moveUp(shallower);
        }
        return deeper;
    }

    private int getHeight(Node v) {
        int height = 0;
        while (v.parent != null) {
            v = v.parent;
            height++;
        }
        return height;
    }
    
    private Node moveUp(Node v) {
        return moveUp(v, 1);
    }

    private Node moveUp(Node v, int count) {
        while (count-- > 0 && v.parent != null) {
            v = v.parent;
        }
        return v;
    }
}
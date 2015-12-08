/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon.OA2;

import Util.TreeNode;

/**
 *
 * @author Wu
 */
public class PathSumMin {

    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return solution(root.right) + root.val;
        }
        if (root.left != null && root.right == null) {
            return solution(root.left) + root.val;
        }
        return Math.min(solution(root.left), solution(root.right)) + root.val;
    }

}

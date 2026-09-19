import Algorithm.TreeNode;
import org.junit.jupiter.api.Test;
import Algorithm.TreeTransversal;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsSymmetric {


    private TreeTransversal treeTransversal;

    @Test
    public void test1() {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(3), 2, new TreeNode(4)),
                1,
                new TreeNode(new TreeNode(4), 2, new TreeNode(3))
        );
        assertTrue(new IsSymmetric().treeTransversal.isSymmetric(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(
                new TreeNode(null, 2, new TreeNode(3)),
                1,
                new TreeNode(null, 2, new TreeNode(3))
        );
        assertFalse(new IsSymmetric().treeTransversal.isSymmetric(root));
    }


}

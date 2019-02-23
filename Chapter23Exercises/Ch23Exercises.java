
public class Ch23Exercises
{

    public static void main( String[] args )
    {
        TreeNode<String> a = new TreeNode<String>("A", null, null);
        TreeNode<String> b = new TreeNode<String>("B", null, null);
        TreeNode<String> c = new TreeNode<String>("C", null, null);
        TreeNode<String> d = new TreeNode<String>("D", null, null);
        TreeNode<String> e = new TreeNode<String>("E", null, null);
        TreeNode<String> f = new TreeNode<String>("F", null, null);
        
        a.setLeft( b );
        a.setRight( c );
        c.setRight( e );
        c.setLeft( d );
        e.setRight( f );

        process(a);
        System.out.println( a.getValue() );
    }
    
    public static void process(TreeNode<String> root)
    {
        if (root == null)
            return;
        process(root.getLeft());
        process(root.getRight());
        String s = (String)root.getValue();
        if (root.getLeft() != null)
            s += root.getLeft().getValue();
        if (root.getRight() != null)
            s += root.getRight().getValue();
        root.setValue( s );
    }

}

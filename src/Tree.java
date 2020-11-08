/*
 * Copyright (c) 2020. Mohammed A. Shehab
 * Website: https://users.encs.concordia.ca/~m_shehab/
 * Contact: m_shehab@encs.concordia.ca or mohammed_shihab@daad-alumni.de
 */
import javax.swing.*;

public class Tree
{
    private Node root;

    final String SPACES = "     ";

    public Tree() {
        this.root = null;
    }

    // Setter and getter.
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // Main functions to process the tree.

    public boolean isempty()
    {
        return (root == null);
    }

    boolean search(int item)
    {
        boolean found = false;
        Node location = root;
        Node pre = null;
        while (location != null && !found)
        {
            if (item > location.Data)
            {
                pre = location; location = location.right;
            }
            else if (item < location.Data)
            {
                pre = location;
                location = location.left;
            }
            else
                found = true;
        }
        return  found;
    }
    
    void insert(Node item)
    {
        Node location = root,  pre = null;
        while (location != null)
        {
            if (item.Data > location.Data)
            {
                pre = location; location = location.right;
            }
            else
            if (item.Data < location.Data)
            {
                pre = location; location = location.left;
            }
        }//end
        
        location = new Node();
        location.Data = item.Data;
        location.left = location.right = null;
        if (pre == null)
            root = location;
        else
        {
            if (pre.Data > item.Data)
                pre.left = location;
            else
                pre.right = location;
        }
    }

    void delete(int item)
    {
        // We start from root, while pre is null
        Node location = root,  pre = null,  m = null;
        // We suppose that found is false (the worst case).
        boolean found = false;

        // We start search for element, the termaintion condation is to find element or reach the leaves.
        while (location != null && !found)
        {
            // If the item is greater than current data location, then we exclude all elements in the left
            if (item > location.Data)
            {
                pre = location; location = location.right;
            }
            // If the item is less than current data location, then we exclude all elements in the right
            else if (item < location.Data)
            {
                pre = location;
                location = location.left;
            }
            // The last state is equal so we find its location.
            else
                found = true;
        }
        // We need to chack if that location has child nodes or not.
        if (location.left == null && location.right == null)
        {
            // Now ,we need to check location of that node based on parent and make it null.
            if (pre.right != null)
                pre.right = null;
            else
                pre.left = null;
            // Finally, free memory allocation.
//            delete location;
        }
        // Here the complex issue. If the node has children
        if (location.left != null && location.right != null)
        {
            // We need to select successor from these children.
            int temp;
            // based on inserting process, the successor must be the maximum
            temp = max(location);
            // if the left child has same data value of location.
            if (location.left.Data == temp)    //if 1
            {
                // First move pointer of pre from location to left location child.
                pre = location.left;
                if (pre.left != null)
                    location.left = pre.left;
                else
                    location.left = null;
//                delete pre;
            }                                //end if 1
            else                                //else of if 1
            {
                // Do shift up for children
                pre = location.left;
                while (pre.right.Data != temp)
                {
                    pre = pre.right;
                }

                m = pre.right;
                if (m.left != null)            //if 2
                    pre.right = m.left;
                else
                    pre.right = null;
//                delete m;
            }                                //end else of if 1

            location.Data = temp;
        }
        else
        {
            if (pre.right == location)
                if (location.right != null)
                    pre.right = location.right;
                else
                    pre.right = location.left;
            else
            if (location.right != null)
                pre.left = location.right;
            else
                pre.left = location.left;
        }
    }

    public int max(Node maximem)
    {
        maximem = maximem.left;
        while (maximem.right != null)
        {
            maximem = maximem.right;
        }
        return (maximem.Data);
    }

    void reset()
    {
        root = null;
    }

    void print()
    {
        String input= JOptionPane.showInputDialog("MAIN OF PRINT\n\n1) Pre Order\n2) Post Order\n3) In Order\n4) Level-order\nmain\nEnter your Choose : ");
        int x = Integer.parseInt(input);

        if (x == 1) {
            System.out.println("Pre-order:");
            pre(root);
        }
        else
        if (x == 2) {
            System.out.println("Post-order:");
            post(root);
        }
        else if(x == 3){
            System.out.println("In-order:");
            in(root);
        }
        else if(x == 4)
        {
            System.out.println("Level-order:");
            printLevelOrder();
        }
        System.out.println();
    }

    void pre(Node tree)
    {
        if (tree != null)
        {
            System.out.print(tree.Data+SPACES);
            pre(tree.left);
            pre(tree.right);
        }
    }

    void post(Node tree)
    {
        if (tree != null)
        {
            post(tree.left);
            post(tree.right);
            System.out.print(tree.Data+SPACES);
        }
    }

    void in(Node tree)
    {
        if (tree != null)
        {
            in(tree.left);
            System.out.print(tree.Data+SPACES);
            in(tree.right);
        }
    }

    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.Data +SPACES);
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
}

/*
 * Copyright (c) 2020. Mohammed A. Shehab
 * Website: https://users.encs.concordia.ca/~m_shehab/
 * Contact: m_shehab@encs.concordia.ca or mohammed_shihab@daad-alumni.de
 */

public class Node
{
    public int Data;         // Store the data.
    public Node right;     // Right child
    public Node left;      // Left child

    public Node() {
        this.right = this.left = null;
    }
}

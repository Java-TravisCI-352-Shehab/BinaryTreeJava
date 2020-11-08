/*
 * Copyright (c) 2020. Mohammed A. Shehab
 * Website: https://users.encs.concordia.ca/~m_shehab/
 * Contact: m_shehab@encs.concordia.ca or mohammed_shihab@daad-alumni.de
 */

import javax.swing.*;

public class Driver {

    public static void main(String []arg)
    {
        run();
        System.exit(0);
    }

    public static void run()
    {
        Tree t = new Tree();
        // create a jframe
        JFrame frame = new JFrame("JOptionPane show MessageDialog");
        int ch, num;

        do
        {
            String input= JOptionPane.showInputDialog("\t\t\t\"MAIN\"\n\n1) Insert item\n2) Delete item\n3) Search\n4) Print\n5) Reset\n6) EXIT\nEnter your chose :");
            ch = Integer.parseInt(input);
            switch (ch)
            {
                case 1: {
                    input= JOptionPane.showInputDialog("Enter the item :");
                    num = Integer.parseInt(input);

                    if (t.search(num))
                        JOptionPane.showMessageDialog(frame, "The item is in the tree","Error MSG",JOptionPane.ERROR_MESSAGE);
                    else {
                        Node n = new Node();
                        n.Data = num;
                        t.insert(n);
                    }
                }break;//end 1
                case 2: {
                    if (t.isempty())
                        JOptionPane.showMessageDialog(frame, "Sorry the tree is empty !","Error MSG",JOptionPane.ERROR_MESSAGE);
                else
                {
                    input= JOptionPane.showInputDialog("Enter the item :");
                    num = Integer.parseInt(input);

                    if (t.search(num))
                        t.delete(num);
                    else
                        JOptionPane.showMessageDialog(frame, "Sorry the item is not in the tree!!","Error MSG",JOptionPane.ERROR_MESSAGE);
                }
                }break;//End 2
                case 3: {
                    if (t.isempty())
                        JOptionPane.showMessageDialog(frame, "Sorry the tree is empty !","Error MSG",JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        input= JOptionPane.showInputDialog("Enter the item :");
                        num = Integer.parseInt(input);

                        if (t.search(num))
                            JOptionPane.showMessageDialog(frame, "The element in the tree..","Info MSG",JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(frame, "Not found","Info MSG",JOptionPane.INFORMATION_MESSAGE);
                    }
                }break;
                case 4: {if (t.isempty())
                    JOptionPane.showMessageDialog(frame, "the tree is empty","Info MSG",JOptionPane.INFORMATION_MESSAGE);
                else
                    t.print();
                }break;
                case 5:t.reset(); break;
                case 6:break;
                default: JOptionPane.showMessageDialog(frame, "Wrong choise !\nPlease chose between 1 - 6","Error MSG",JOptionPane.ERROR_MESSAGE);

            }//end switch
        }//end do
        while (ch != 6);
        JOptionPane.showMessageDialog(frame, "Mohammed Ali Alawi Bin Shehab","Info MSG",JOptionPane.INFORMATION_MESSAGE);

    }
}

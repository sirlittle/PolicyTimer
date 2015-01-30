
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vanvari
 */
public class PolicyFrame extends JFrame {
    public PolicyFrame()
    {
        setTitle("Policy Timer");
        setSize(300,400);
        setLocation(100,200);
        JMenuBar jmb = new JMenuBar();
        JMenu menu = new JMenu("Test");
        jmb.add(menu);
        JMenuItem item  = new JMenuItem("Exit");
        item.getAccessibleContext().setAccessibleDescription("Just a test!");
        class itemListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        }
        ActionListener a = new itemListener();
        item.addActionListener(a);
        menu.add(item);
        this.setJMenuBar(jmb);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
            
}

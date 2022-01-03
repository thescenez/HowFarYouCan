/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package howfaryoucan;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author chaiyawat
 */
public class EnterNameView {
    private JFrame frame;
    private JTextField name;
    private JLabel background, lb_name;
    private JButton bnEnter;

    public EnterNameView(){
        frame = new JFrame("How Far You Can !?");
        name = new JTextField();
        lb_name = new JLabel("Enter your name");
        bnEnter = new JButton("START");
        background = new JLabel(new ImageIcon(EnterNameView.class.getResource("/Image/Background.png")));

        background.setSize(1200, 750);
        Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setBounds((p.width/2)-600, (p.height/2)-375, 1200, 750);
        Dimension d = frame.getSize();
        name.setBounds((d.width/2)-200, (d.height/2)-80, 400, 80);
        
        lb_name.setBounds((d.width/2-195), (d.height/2)-225, 500, 200);
        lb_name.setFont(new Font("Alatsi", Font.BOLD, 50));
        lb_name.setForeground(new Color(59, 75, 87));
        
        bnEnter.setForeground(new Color(58, 132, 142));
        bnEnter.setBackground(new Color(243, 199, 129));
        bnEnter.setFont(new Font("Browallia New", Font.BOLD, 35));
        
        name.setFont(new Font("Browallia New", Font.BOLD, 50));
        name.setHorizontalAlignment(JTextField.CENTER);
        name.setForeground(new Color(58, 132, 142));
        
        bnEnter.setBounds(650, 400, 150, 60);
        bnEnter.setFocusable(false);
        
        frame.add(name);
        frame.add(lb_name);
        frame.add(bnEnter);
        frame.add(background);
        
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getName() {
        return name.getText();
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public JButton getBnEnter() {
        return bnEnter;
    }

    public void setBnEnter(JButton bnEnter) {
        this.bnEnter = bnEnter;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    public JTextField getTf(){
        return name;
    }

    public JLabel getBackground() {
        return background;
    }

    public void setBackground(JLabel background) {
        this.background = background;
    }

    public JLabel getLb_name() {
        return lb_name;
    }

    public void setLb_name(JLabel lb_name) {
        this.lb_name = lb_name;
    }
}

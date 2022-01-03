/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howfaryoucan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author x.thescene
 */
public class HowToPlayView {
    private JFrame fr;
    private JLabel background;
    private JButton bnBack;
    
    public HowToPlayView(){
        fr = new JFrame("How To Play");
        bnBack = new JButton("Main Menu");
        background = new JLabel(new ImageIcon(HowToPlayView.class.getResource("/Image/howtoplay.png")));
        background.setSize(1200, 750);
        
        fr.setLayout(null);
        
        bnBack.setForeground(new Color(58, 132, 142));
        bnBack.setBackground(new Color(243, 199, 129));
        bnBack.setFont(new Font("Browallia New", Font.BOLD, 26));
        bnBack.setBounds(50, 635, 120, 50);
        bnBack.setFocusable(false);
        
        fr.add(bnBack);
        fr.add(background);
        fr.setSize(1200, 750);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int widthScreen = (int)(screenSize.width/2)-(fr.getSize().width/2);
        int heightScreen = (int)(screenSize.height/2)-(fr.getSize().height/2);
        
        fr.setLocation(widthScreen, heightScreen);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }

    public JButton getBnBack() {
        return bnBack;
    }

    public void setBnBack(JButton bnBack) {
        this.bnBack = bnBack;
    }
    
    
}

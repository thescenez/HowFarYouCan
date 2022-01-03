/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howfaryoucan;

/**
 *
 * @author x.thescene
 */

import java.awt.*;
import javax.swing.*;

public class ScoreBoardView {
    private JFrame fr;
    private JLabel background, name1, name2, name3, score1, score2, score3;
    private JButton bnBack;
    
    public ScoreBoardView(){
        fr = new JFrame("Score Board");
        bnBack = new JButton("Main Menu");
        name1 = new JLabel("1.  ");
        name2 = new JLabel("2.  ");
        name3 = new JLabel("3.  ");
        score1 = new JLabel();
        score2 = new JLabel();
        score3 = new JLabel();
        background = new JLabel(new ImageIcon(ScoreBoardView.class.getResource("/Image/ScoreBoard.png")));
        background.setSize(1200, 750);
        
        fr.setLayout(null);
        
        bnBack.setForeground(new Color(58, 132, 142));
        bnBack.setBackground(new Color(243, 199, 129));
        name1.setForeground(new Color(255, 241, 137));
        name2.setForeground(new Color(255, 253, 197));
        name3.setForeground(new Color(255, 253, 197));
        score1.setForeground(new Color(255, 241, 137));
        score2.setForeground(new Color(255, 253, 197));
        score3.setForeground(new Color(255, 253, 197));
        
        bnBack.setFont(new Font("Browallia New", Font.BOLD, 26));
        name1.setFont(new Font("Browallia New", Font.BOLD, 60));
        name2.setFont(new Font("Browallia New", Font.BOLD, 60));
        name3.setFont(new Font("Browallia New", Font.BOLD, 60));
        score1.setFont(new Font("Browallia New", Font.BOLD, 65));
        score2.setFont(new Font("Browallia New", Font.BOLD, 65));
        score3.setFont(new Font("Browallia New", Font.BOLD, 65));
        
        bnBack.setBounds(950, 635, 120, 50);
        name1.setBounds(320, 300, 500, 50);
        name2.setBounds(320, 400, 500, 50);
        name3.setBounds(320, 500, 500, 50);
        score1.setBounds(860, 300, 500, 50);
        score2.setBounds(860, 400, 500, 50);
        score3.setBounds(860, 500, 500, 50);
        bnBack.setFocusable(false);
        
        fr.add(bnBack);
        fr.add(name1);
        fr.add(name2);
        fr.add(name3);
        fr.add(score1);
        fr.add(score2);
        fr.add(score3);  
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

    public JLabel getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1.setText("1. "+name1);
    }

    public JLabel getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2.setText("2. "+name2);
    }

    public JLabel getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3.setText("3. "+name3);
    }

    public JLabel getScore1() {
        return score1;
    }

    public void setScore1(String score1) {
        this.score1.setText(score1);
    }

    public JLabel getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2.setText(score2);
    }

    public JLabel getScore3() {
        return score3;
    }

    public void setScore3(String score3) {
        this.score3.setText(score3);
    }
}

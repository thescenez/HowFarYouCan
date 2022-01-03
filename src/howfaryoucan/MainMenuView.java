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
import java.io.IOException;
import javax.swing.*;

public class MainMenuView{
    private JFrame fr;
    private JButton bnPlay, bnHowto, bnScore, bnExit;
    private JPanel panel;
    private JLabel name, shadow;
    private JLabel background;
    
    public MainMenuView(){
        fr = new JFrame("How Far You Can !?");
        name = new JLabel("How Far You Can");
        shadow = new JLabel("How Far You Can");
        bnPlay = new JButton("PLAY");
        bnHowto = new JButton("How to play");
        bnScore = new JButton("Score board");
        bnExit = new JButton("Exit");
        background = new JLabel(new ImageIcon(MainMenuView.class.getResource("/Image/Background.png")));
        background.setSize(1200, 750);
       
        try {
            Font fontAdelia = Font.createFont(Font.TRUETYPE_FONT, MainMenuView.class.getResource("/Fonts/ADELIA.ttf").openStream());
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fontAdelia);
        }catch (FontFormatException ex) {
            System.out.println(ex);
        }catch (IOException ex) {
            System.out.println(ex);
        }
        
        fr.setLayout(null);
        
        name.setFont(new Font("ADELIA", Font.PLAIN, 75));
        shadow.setFont(new Font("ADELIA", Font.PLAIN, 75));
        name.setForeground(new Color(58, 132, 142));
        shadow.setForeground(new Color(255, 255, 255));
        bnPlay.setForeground(new Color(255, 255, 255));
        bnHowto.setForeground(new Color(58, 132, 142));
        bnScore.setForeground(new Color(58, 132, 142));
        bnExit.setForeground(new Color(58, 132, 142));
        bnPlay.setBackground(new Color(124, 122, 166));
        bnHowto.setBackground(new Color(243, 199, 129));
        bnScore.setBackground(new Color(243, 199, 129));
        bnExit.setBackground(new Color(243, 199, 129));
        
        bnPlay.setFont(new Font("Browallia New", Font.BOLD, 60));
        bnHowto.setFont(new Font("Browallia New", Font.BOLD, 45));
        bnScore.setFont(new Font("Browallia New", Font.BOLD, 45));
        bnExit.setFont(new Font("Browallia New", Font.BOLD, 45));
        
        name.setBounds(230, 50, 1000, 175);
        shadow.setBounds(236, 56, 1000, 175);
        bnPlay.setBounds(450, 250, 350, 70);
        bnHowto.setBounds(450,350, 350, 70);
        bnScore.setBounds(450, 450, 350, 70);
        bnExit.setBounds(525, 550, 200, 70);
        
        bnPlay.setFocusable(false);
        bnHowto.setFocusable(false);
        bnScore.setFocusable(false);
        bnExit.setFocusable(false);
        
        fr.add(name);
        fr.add(shadow);
        
        fr.add(bnPlay); 
        fr.add(bnHowto); 
        fr.add(bnScore);
        fr.add(bnExit);
        
        fr.add(background);     
               
        fr.setSize(1200, 750);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int widthScreen = (int)(screenSize.width/2)-(fr.getSize().width/2);
        int heightScreen = (int)(screenSize.height/2)-(fr.getSize().height/2);
        fr.setLocation(widthScreen, heightScreen);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getBnPlay() {
        return bnPlay;
    }

    public void setBnPlay(JButton bnPlay) {
        this.bnPlay = bnPlay;
    }

    public JButton getBnHowto() {
        return bnHowto;
    }

    public void setBnHowto(JButton bnHowto) {
        this.bnHowto = bnHowto;
    }

    public JButton getBnScore() {
        return bnScore;
    }

    public void setBnScore(JButton bnScore) {
        this.bnScore = bnScore;
    }

    public JButton getBnExit() {
        return bnExit;
    }

    public void setBnExit(JButton bnExit) {
        this.bnExit = bnExit;
    }

    public JLabel getBackground() {
        return background;
    }

    public void setBackground(JLabel background) {
        this.background = background;
    }

    public JFrame getFr() {
        return fr;
    }

    public void setFr(JFrame fr) {
        this.fr = fr;
    }
}

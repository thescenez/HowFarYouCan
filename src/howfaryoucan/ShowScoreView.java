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

public class ShowScoreView {
    private JFrame fr;
    private JLabel background, player_score, topic, topicShadow;
    private JButton bnMainMenu, bnScoreBoard, bnPlayAgain;
    
    public ShowScoreView(){
        fr = new JFrame("How Far You Can !?");
        bnMainMenu = new JButton("Main Menu");
        bnScoreBoard = new JButton("Score Board");
        bnPlayAgain = new JButton("Play Again");
        background = new JLabel(new ImageIcon(ShowScoreView.class.getResource("/Image/showscore.png")));
        topic = new JLabel("Your Level");
        topicShadow = new JLabel("Your Level");
        player_score = new JLabel("18");
        
        try {
            Font fontAdelia = Font.createFont(Font.TRUETYPE_FONT, ShowScoreView.class.getResource("/Fonts/ADELIA.ttf").openStream());
            Font fontDilo = Font.createFont(Font.TRUETYPE_FONT, ShowScoreView.class.getResource("/Fonts/Dilo World.ttf").openStream());
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fontAdelia);
            ge.registerFont(fontDilo);
        } catch (IOException ex) {
            System.out.println(ex);
        }catch (FontFormatException ex) {
            System.out.println(ex);
        }
        
        background.setSize(1200, 750);
        
        fr.setLayout(null);
        
        bnMainMenu.setForeground(new Color(255, 255, 255));
        bnMainMenu.setBackground(new Color(124, 122, 166));
        bnScoreBoard.setForeground(new Color(255, 255, 255));
        bnScoreBoard.setBackground(new Color(124, 122, 166));
        bnPlayAgain.setForeground(new Color(58, 132, 142));
        bnPlayAgain.setBackground(new Color(243, 199, 129));
        topic.setForeground(new Color(58, 132, 142));
        topicShadow.setForeground(new Color(255, 253, 197));
        player_score.setForeground(new Color(58, 132, 142));
        
        bnMainMenu.setFont(new Font("Browallia New", Font.BOLD, 30));
        bnScoreBoard.setFont(new Font("Browallia New", Font.BOLD, 30));
        bnPlayAgain.setFont(new Font("Browallia New", Font.BOLD, 34));
        topic.setFont(new Font("ADELIA", Font.BOLD, 50));
        topicShadow.setFont(new Font("ADELIA", Font.BOLD, 50));
        player_score.setFont(new Font("Dilo World", Font.PLAIN, 100));
        
        bnMainMenu.setBounds(615, 400, 175, 60);
        bnScoreBoard.setBounds(390, 400, 175, 60);
        bnPlayAgain.setBounds(505, 325, 175, 60);
        topic.setBounds(400, 90, 1000, 70);
        topicShadow.setBounds(408, 98, 1000, 70);
        player_score.setBounds(0, 190, 1200, 80);
        player_score.setHorizontalAlignment(JLabel.CENTER);
        
        bnMainMenu.setFocusable(false);
        bnMainMenu.setFocusable(false);
        bnScoreBoard.setFocusable(false);
        bnPlayAgain.setFocusable(false);
        
        fr.add(bnMainMenu);
        fr.add(bnScoreBoard);
        fr.add(bnPlayAgain);
        fr.add(topic);
        fr.add(player_score);
        fr.add(topicShadow);
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

    public JButton getBnMainMenu() {
        return bnMainMenu;
    }

    public void setBnMainMenu(JButton bnMainMenu) {
        this.bnMainMenu = bnMainMenu;
    }

    public JButton getBnScoreBoard() {
        return bnScoreBoard;
    }

    public void setBnScoreBoard(JButton bnScoreBoard) {
        this.bnScoreBoard = bnScoreBoard;
    }

    public JButton getBnPlayAgain() {
        return bnPlayAgain;
    }

    public void setBnPlayAgain(JButton bnPlayAgain) {
        this.bnPlayAgain = bnPlayAgain;
    }

    public JLabel getPlayer_score() {
        return player_score;
    }

    public void setPlayer_score(String player_score) {
        this.player_score.setText(player_score);
    }
}

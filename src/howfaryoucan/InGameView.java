/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package howfaryoucan;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
/**
 *
 * @author chaiyawat
 */
public class InGameView {
    private JFrame frame;
    private JTextField prob, answer;
    private JLabel background, lb_level, lb_time;

    public InGameView(){
        frame = new JFrame("How Far You Can !?");
        prob = new JTextField();
        answer = new JTextField();
        lb_level = new JLabel();
        lb_time = new JLabel();
       
        background = new JLabel(new ImageIcon(InGameView.class.getResource("/Image/Background.png")));
        background.setSize(1200, 750);
        
        try {
            Font fontAlatsi = Font.createFont(Font.TRUETYPE_FONT, InGameView.class.getResource("/Fonts/Alatsi.ttf").openStream());
            Font fontDilo = Font.createFont(Font.TRUETYPE_FONT, InGameView.class.getResource("/Fonts/Dilo World.ttf").openStream());
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fontAlatsi);
            ge.registerFont(fontDilo);
        } catch (IOException ex) {
            System.out.println(ex);
        }catch (FontFormatException ex) {
            System.out.println(ex);
        }
        
        Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLayout(null);
        frame.setBounds((p.width/2)-600, (p.height/2)-375, 1200, 750);
        
        Dimension d = frame.getSize();
        prob.setBounds((d.width/2)-300, (d.height/2)-200, 700, 80);
        answer.setBounds((d.width/2)-150, (d.height/2)-50, 400, 80);
        lb_level.setBounds((d.width/2-40), (d.height/2)-380, 500, 200);
        lb_time.setBounds((d.width/2+325), (d.height/2)-370, 300, 80);
        
        lb_level.setFont(new Font("Alatsi", Font.BOLD, 50));
        lb_level.setForeground(new Color(59, 75, 87));
        lb_time.setFont(new Font("Dilo World", Font.BOLD, 46));
        lb_time.setForeground(new Color(58, 132, 142));
        prob.setFont(new Font("Browallia New", Font.BOLD, 50));
        prob.setHorizontalAlignment(JTextField.CENTER);
        answer.setFont(new Font("Browallia New", Font.BOLD, 35));
        answer.setHorizontalAlignment(JTextField.CENTER);
        
        frame.add(prob);
        frame.add(answer);
        frame.add(lb_level);
        frame.add(lb_time);
        frame.add(background);
        
        frame.setResizable(false);
        prob.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        answer.requestFocusInWindow();
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public JTextField getProb() {
        return prob;
    }

    public void setProb(String prob) {
        this.prob.setText(prob);
    }

    public JLabel getLb_level() {
        return lb_level;
    }

    public void setLb_level(String lb_level) {
        this.lb_level.setText("Level "+lb_level);
    }
    
    public void setLb_time(String lb_time) {
        this.lb_time.setText("Time: "+lb_time+" s");
    }

    public JTextField getAnswer() {
        return answer;
    }

    public void setAnswer(JTextField answer) {
        this.answer = answer;
    }

    public JLabel getBackground() {
        return background;
    }

    public void setBackground(JLabel background) {
        this.background = background;
    }
}

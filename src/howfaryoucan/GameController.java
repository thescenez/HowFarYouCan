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
import java.awt.event.*;
import org.json.simple.JSONObject;   
import org.json.simple.JSONArray;  
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GameController implements ActionListener, KeyListener, Runnable{
    private MainMenuView mainMenuView;
    private EnterNameView enterNameView;
    private HowToPlayView howToPlayView;
    private InGameView inGameView;
    private ScoreBoardView scoreBoardView;
    private ShowScoreView showScoreView;
    private GameModel gameModel;
    private JSONObject nowLevel;
    private int level_no;
    private int sec;
    private Thread th;

    public GameController() {
        mainMenuView = new MainMenuView();
        enterNameView = new EnterNameView();
        inGameView = new InGameView();
        howToPlayView = new HowToPlayView();
        scoreBoardView = new ScoreBoardView();
        showScoreView = new ShowScoreView();
        openMainMenu();
    }

    public void openMainMenu() {
        mainMenuView = new MainMenuView();
        mainMenuView.getFr().setVisible(true);
        mainMenuView.getBnPlay().addActionListener(this);
        mainMenuView.getBnHowto().addActionListener(this);
        mainMenuView.getBnScore().addActionListener(this);
        mainMenuView.getBnExit().addActionListener(this);

    }

    public void openEnterName() {
        enterNameView = new EnterNameView();
        enterNameView.getFrame().setVisible(true);
        enterNameView.getBnEnter().addActionListener(this);
        enterNameView.getTf().addKeyListener(this);
    }
    
    public void openInGame(int level) {
        this.openInGame(level, "");
    }
    public void openInGame(int level, String stage) {
        if(stage.equals("first")){
            level_no = 1;
            sec = 46;
            th = new Thread(this);
            th.start();
            inGameView = new InGameView();
        }
        inGameView.setLb_time(sec + "");
        inGameView.getAnswer().setText("");
        nowLevel = GameModel.updateLevel(level);
        JSONArray wordArray = (JSONArray) nowLevel.get("word");
        if(level == 1 && stage.equals("first")){
            inGameView.getFrame().setVisible(true);
        }
        inGameView.getBackground().setIcon(new ImageIcon(MainMenuView.class.getResource(nowLevel.get("img") + "")));
        inGameView.setProb(wordArray.get(new Random().nextInt(wordArray.size()-1)) + "");
        inGameView.setLb_level(nowLevel.get("level") + "");
        if(level == 1 && stage.equals("first")){
            inGameView.getAnswer().addKeyListener(this);
        }
        inGameView.getFrame().requestFocus();
        inGameView.getAnswer().requestFocusInWindow();
    }
    
    public void openHowToPlay(){
        howToPlayView = new HowToPlayView();
        howToPlayView.getFr().setVisible(true);
        howToPlayView.getBnBack().addActionListener(this);
    }
    
    public void openScoreBoard() {
        scoreBoardView = new ScoreBoardView();
        scoreBoardView.getFr().setVisible(true);
        gameModel = new GameModel();
        scoreBoardView.getBnBack().addActionListener(this);
        JSONObject top1 = (JSONObject) gameModel.getScoreBoard().get(0);
        scoreBoardView.setName1(top1.get("name") + "");
        scoreBoardView.setScore1(top1.get("level") + "");
        JSONObject top2 = (JSONObject) gameModel.getScoreBoard().get(1);
        scoreBoardView.setName2(top2.get("name") + "");
        scoreBoardView.setScore2(top2.get("level") + "");
        JSONObject top3 = (JSONObject) gameModel.getScoreBoard().get(2);
        scoreBoardView.setName3(top3.get("name") + "");
        scoreBoardView.setScore3(top3.get("level") + "");
    }
    
    public void openShowScore(){
        showScoreView = new ShowScoreView();
        showScoreView.getFr().setVisible(true);
        showScoreView.getBnPlayAgain().addActionListener(this);
        showScoreView.getBnScoreBoard().addActionListener(this);
        showScoreView.getBnMainMenu().addActionListener(this);
        showScoreView.setPlayer_score(level_no + "");
    }
    
    @Override
    public void run(){
        try {
            while(sec != 0 && level_no != 21){
                sec--;
                inGameView.setLb_time(sec+"");
                Thread.sleep(1000);
            }
            if(sec==0){
                inGameView.getFrame().dispose();
                openShowScore();
                gameModel.setPlayerLevel(level_no);
                GameModel.updateScoreBoard();
                level_no = 1;
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(mainMenuView.getBnPlay())) {
            openEnterName();
            mainMenuView.getFr().dispose();
        } else if (ae.getSource().equals(mainMenuView.getBnHowto())) {
            openHowToPlay();
            mainMenuView.getFr().dispose();
        } else if (ae.getSource().equals(mainMenuView.getBnScore())) {
            openScoreBoard();
            mainMenuView.getFr().dispose();
        } else if (ae.getSource().equals(mainMenuView.getBnExit())) {
            System.exit(0);
        } else if (ae.getSource().equals(enterNameView.getBnEnter())) {
            gameStart();
        } else if (ae.getSource().equals(scoreBoardView.getBnBack())) {
            openMainMenu();
            scoreBoardView.getFr().dispose();
        } else if (ae.getSource().equals(showScoreView.getBnPlayAgain())) {
            openInGame(1, "first");
            showScoreView.getFr().dispose();
        } else if (ae.getSource().equals(showScoreView.getBnScoreBoard())) {
            openScoreBoard();
            showScoreView.getFr().dispose();
        } else if (ae.getSource().equals(showScoreView.getBnMainMenu())) {
            openMainMenu();
            showScoreView.getFr().dispose();
        } else if (ae.getSource().equals(howToPlayView.getBnBack())) {
            openMainMenu();
            howToPlayView.getFr().dispose();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent ke){
        if(ke.getSource().equals(enterNameView.getTf())){
            int key = ke.getKeyCode();
            if (key == KeyEvent.VK_ENTER) {
                gameStart();
            }
        }else if(ke.getSource().equals(inGameView.getAnswer())){
            int key = ke.getKeyCode();
            if (key == KeyEvent.VK_ENTER) {
                if(inGameView.getAnswer().getText().equals(inGameView.getProb().getText()) && level_no != 20){
                    openInGame(++level_no);
                }else if(inGameView.getAnswer().getText().equals(inGameView.getProb().getText()) == false && level_no != 1){
                    openInGame(--level_no); 
                }else if(level_no == 20){
                    sec = 0;
                }
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent ke){}
    
    @Override
    public void keyTyped(KeyEvent ke){}
    
    public void gameStart(){
        if(enterNameView.getName().isEmpty()){
            JOptionPane.showMessageDialog(null, "เอ๊ะ!~ ฉันยังไม่รู้จักชื่อของเธอเลย..", "", JOptionPane.PLAIN_MESSAGE);
        }else{
            gameModel = new GameModel();
            gameModel.setPlayer(enterNameView.getName(), 1);
            openInGame(1, "first");
            enterNameView.getFrame().dispose();
        }
    }
}

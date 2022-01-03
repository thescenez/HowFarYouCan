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

import java.io.*;
import org.json.simple.JSONObject;   
import org.json.simple.JSONArray;  
import org.json.simple.parser.*;  

public class GameModel {
    private static JSONArray scoreBoard;
    private static JSONArray gameData;
    private static Player player;
    
    public GameModel(){
        try {
            JSONParser parser = new JSONParser();
            Object scoreBoardObj = parser.parse(new FileReader("scoreboard.json"));
            scoreBoard = (JSONArray) scoreBoardObj;
            Object wordJson = parser.parse(new FileReader("word.json"));
            gameData = (JSONArray) wordJson;
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void updateScoreBoard(){
        JSONParser parser = new JSONParser();
        JSONArray saveScoreBoard = new JSONArray();
        JSONObject playerObj;
        
        playerObj = new JSONObject();
        playerObj.put("name", player.getName());
        playerObj.put("level", player.getLevel());
        
        try {
            Object scoreBoardObj = parser.parse(new FileReader("scoreboard.json"));
            scoreBoard = (JSONArray) scoreBoardObj;
            for(int i = 0; i < scoreBoard.size(); i++){
                JSONObject objInScoreBoard = (JSONObject) scoreBoard.get(i);
                Long level = (Long) objInScoreBoard.get("level");
                if(player.getLevel() > level.intValue()){
                    scoreBoard.add(i, playerObj);
                    System.out.println(scoreBoard);
                    break;
                }
            }
        }catch(ParseException e) {
            System.out.println(e);
        }catch (IOException e) {
            System.out.println(e);
        }
        
        try (FileWriter file = new FileWriter("scoreboard.json");){
            for(int i = 0; i < 3; i++){
                saveScoreBoard.add(scoreBoard.get(i));
            }
            file.write(saveScoreBoard.toJSONString());
            file.flush();
            System.out.println("Successfully Copied JSON Object to File...");
        } catch (IOException e) {
            System.out.println("Error Writer "+e);
        }
    }
    
    public static JSONObject updateLevel(int level){
        return (JSONObject) gameData.get(level-1);
    }

    public static JSONArray getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(JSONArray scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void setPlayer(String name, int level) {
        this.player = new Player(name, level);
    }
    
    public void setPlayerLevel(int level) {
        this.player.setLevel(level);
    }
    
    public static Player getPlayer() {
        return player;
    }
}

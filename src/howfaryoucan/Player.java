/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howfaryoucan;

/**
 *
 * @author chaiyawat
 */
public class Player {
    private String name;
    private int level;
    
    public Player(){
        this("NoName", 1);
    }
    
    public Player(String name, int level){
        this(level, name);
    }
    
    public Player(int level, String name){
        this.level = level;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    @Override
    public String toString(){
        return name + level + "";
    }
}

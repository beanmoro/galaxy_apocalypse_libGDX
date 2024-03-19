package com.shoza.galaxyapocalypse.entities.parts;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.List;


public class Ship {
    
    private String name;
    private float power; // poder de reserva si no hay motor anclado a la nave
    private float attackSpeed;
    private TextureRegion region;
    private Vector2 thrusterDock;
   
    
    
    public Ship(String name, float power, float attackSpeed, int x, int y, int width, int height, Texture texture, float xthruster,float ythruster){
        this.name = name;
        this.power = power;
        this.attackSpeed = attackSpeed;
        region = new TextureRegion(texture);
        region.setRegion(x, y, width, height);
        thrusterDock = new Vector2(xthruster, ythruster);
        
        
    
    }
    
    public TextureRegion getRegion(){
        return region;
    }
    
    public String getName(){
        return name;
    }
    
    public float getPower(){
        return power;
    }
    
    public float getAttackSpeed(){
        return attackSpeed;
    }
}

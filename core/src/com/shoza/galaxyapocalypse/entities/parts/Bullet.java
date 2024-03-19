package com.shoza.galaxyapocalypse.entities.parts;
    
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Bullet {
    
    private String name;
    private float damage;
    private float speed;
    private TextureRegion region;
    
    
    public Bullet(String name, float damage, float speed, int x, int y, int width, int height, Texture texture){
        this.name = name;
        this.damage = damage;
        this.speed = speed;
        region = new TextureRegion(texture);
        region.setRegion(x, y, width, height);
    
    }
    
    public TextureRegion getRegion(){
        return region;
    }
    
    public String getName(){
        return name;
    }
    
    public float getDamage(){
        return damage;
    }
    
    public float getSpeed(){
        return speed;
    }
    
    
    
}

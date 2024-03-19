package com.shoza.galaxyapocalypse.entities.parts;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Thruster {
    
    private String name;
    private float power;
    private TextureRegion region;
    
    public Thruster(String name, float power, int x, int y, int width, int height, Texture texture){
        this.name = name;
        this.power = power;
        region = new TextureRegion(texture);
        region.setRegion(x, y, width, height);
        
    
    
    }
    
    public TextureRegion getRegion(){
        return region;
    }


}

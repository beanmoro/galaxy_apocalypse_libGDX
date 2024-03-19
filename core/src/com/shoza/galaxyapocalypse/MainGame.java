package com.shoza.galaxyapocalypse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.shoza.galaxyapocalypse.screens.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainGame extends Game {
    
    
    private ResourceManager rManager;
    
    @Override
    public void create(){
        
        
        try {
            rManager = new ResourceManager();
        } catch (IOException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Gdx.graphics.setWindowedMode(1280, 720);
        setScreen(new GameScreen(this));
        
    }
    
    public ResourceManager getResourceManager(){
        return rManager;
    }

}

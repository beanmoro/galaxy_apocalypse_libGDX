package com.shoza.galaxyapocalypse.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.shoza.galaxyapocalypse.MainGame;
import com.shoza.galaxyapocalypse.entities.PlayerEntity;
import com.shoza.galaxyapocalypse.entities.parts.*;


public class PlayerConfiguration {

    private Ship shipSelected;
    private Thruster thrusterSelected;
    private Bullet bulletSelected;
    
    public PlayerConfiguration(MainGame game, int shipIndex, int thrusterIndex, int bulletIndex){
        
        
        shipSelected = game.getResourceManager().getShipFromList(shipIndex);
        thrusterSelected = game.getResourceManager().getThrusterFromList(thrusterIndex);
        bulletSelected = game.getResourceManager().getBulletFromList(bulletIndex);
    
    }
    
    public Ship getShip(){
        return shipSelected;
    }
    
    public Thruster getThruster(){
        return thrusterSelected;
    }
    
    public Bullet getBullet(){
        return bulletSelected;
    }
}

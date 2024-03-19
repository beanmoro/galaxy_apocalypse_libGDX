package com.shoza.galaxyapocalypse.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.shoza.galaxyapocalypse.MainGame;
import com.shoza.galaxyapocalypse.ResourceManager;
import com.shoza.galaxyapocalypse.entities.*;
import com.shoza.galaxyapocalypse.system.PlayerConfiguration;
import com.shoza.galaxyapocalypse.system.tools.BulletDispenser;


public class GameScreen extends DefaultScreen {
    
    private Stage stage;
    private PlayerEntity player;
    private ResourceManager manager;
    private PlayerConfiguration playerConfig;
    private Vector3 touchPos;
    private BulletDispenser bulletDispenser;
    
    
    public GameScreen(MainGame game) {
        super(game);
        manager = game.getResourceManager();
        stage = new Stage(new FitViewport(640, 360));
        touchPos = new Vector3();

    }
    
    @Override
    public void show(){
        
        playerConfig = new PlayerConfiguration(game, 0,0,0);
        player = new PlayerEntity(new Vector2(64, 360/2), playerConfig.getShip(), playerConfig.getThruster(), playerConfig.getBullet(), stage.getCamera());
        stage.addActor(player);
        player.getBulletDispenser().addBulletsToStage(stage);




    
    }
    
    @Override
    public void hide(){
    
    }
    

    
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        stage.act();
        stage.draw();
    }   
    
    @Override
    public void dispose(){
        stage.dispose();
    }
    
    
    
}

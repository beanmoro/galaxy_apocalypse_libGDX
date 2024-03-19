package com.shoza.galaxyapocalypse;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.shoza.galaxyapocalypse.entities.parts.*;
import com.shoza.galaxyapocalypse.system.GameConstants;
import static com.shoza.galaxyapocalypse.system.GameConstants.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class ResourceManager {
    
    private AssetManager manager;
    private ArrayList<Ship> shipList = new ArrayList<Ship>();
    private ArrayList<Thruster> thrusterList = new ArrayList<Thruster>();
    private ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    
    public ResourceManager() throws IOException{
        
        manager = new AssetManager();
        loadResources();
        loadShipFile();
        loadBulletFile();
        loadThrusterFile();
        
    }
    
    private void loadResources(){
        manager.load("pilotCapsule.png", Texture.class);
        manager.load("Chassis_Sheet.png", Texture.class);
        manager.load("thruster_sheet.png", Texture.class);
        manager.load("bullet_sheet.png", Texture.class);
        manager.finishLoading();
        System.out.println("Loading Finished!");
    }
    
    private void loadBulletFile() throws IOException {
        
        FileHandle handle = Gdx.files.internal("Data/Bullets.data");
        String loadedText = handle.readString();
        String [] lines = loadedText.split("\\r?\\n");
        
        for(String line : lines){
            
            String [] token = line.split("\\s+");
            String name = token[0];
            float damage = Float.parseFloat(token[1]);
            float speed = Float.parseFloat(token[2]);
            int x = Integer.parseInt(token[3]);
            int y = Integer.parseInt(token[4]);
            int width = Integer.parseInt(token[5]);
            int height = Integer.parseInt(token[6]);
            Texture texture = manager.get("bullet_sheet.png");
            
            
            bulletList.add(new Bullet(name, damage, speed, x, y, width, height, texture));
        }
    
    }
    
    private void loadThrusterFile() throws IOException {
    
        FileHandle handle = Gdx.files.internal("Data/Thrusters.data");
        String loadedText = handle.readString();
        String [] lines = loadedText.split("\\r?\\n");

        for(String line : lines){
        
            String [] token = line.split("\\s+");
            String name = token[0];
            float power = Float.parseFloat(token[1]);
            int x = Integer.parseInt(token[2]);
            int y = Integer.parseInt(token[3]);
            int width = Integer.parseInt(token[4]);
            int height = Integer.parseInt(token[5]);
            Texture texture = manager.get("thruster_sheet.png");

            thrusterList.add(new Thruster(name, power, x, y, width, height, texture));
        }
    }
    
    private void loadShipFile(){
        
        FileHandle handle = Gdx.files.internal("Data/Ships.data");
        String loadedText = handle.readString();
        String[] lines = loadedText.split("\\r?\\n");

        for(String line : lines){
            String [] token = line.split("\\s+");
            String name = token[0];
            float power = Float.parseFloat(token[1]);
            float attackSpeed = Float.parseFloat(token[2]);
            int x = Integer.parseInt(token[3]);
            int y = Integer.parseInt(token[4]);
            int width = Integer.parseInt(token[5]);
            int height = Integer.parseInt(token[6]);
            Texture texture = manager.get("Chassis_Sheet.png");
            float xthruster = Float.parseFloat(token[7]);
            float ythruster = Float.parseFloat(token[8]);

            shipList.add(new Ship(name, power, attackSpeed, x, y, width, height, texture, xthruster, ythruster));
        }
        
    }
    
    public Object getResource(String resource){
        return manager.get(resource);
    }
    
    public Ship getShipFromList(int index){
        return shipList.get(index);
    }
    
    public Thruster getThrusterFromList(int index){
        return thrusterList.get(index);
    }
    
    public Bullet getBulletFromList(int index){
        return bulletList.get(index);
    }
}

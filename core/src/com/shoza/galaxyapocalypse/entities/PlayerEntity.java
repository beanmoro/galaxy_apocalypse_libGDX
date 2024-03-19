package com.shoza.galaxyapocalypse.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.shoza.galaxyapocalypse.entities.parts.*;
import com.shoza.galaxyapocalypse.system.tools.BulletDispenser;

public class PlayerEntity extends Actor {
    
    private Vector2 position;
    private TextureRegion regThruster, regShip, regShipSpecialWeapon;
    private Sprite sprShip, sprTruster, sprShipSpecialWeapon;
    private Camera cam;

    private BulletDispenser bulletDispenser;


    private Vector3 touchPointer;
    
    private Ship ship;
    private Thruster thruster;
    private Bullet bullet;

    private boolean isShooting;
    
    int hp = 100; // Vida
    int ep = 75; // Energia
    float er = 0.1f; // Regeneracion de eneregia por segundo
    
    int lives = 3; // Total de vidas antes de perder
    
    public PlayerEntity(Vector2 position, Ship ship, Thruster thruster, Bullet bullet, Camera cam){
        this.position = position;
        this.ship = ship;
        this.thruster = thruster;
        this.cam = cam;
        this.bullet = bullet;

        isShooting = false;

        regShip = ship.getRegion();
        sprShip = new Sprite(regShip);
        touchPointer = new Vector3(0, 360/2, 0);
        bulletDispenser = new BulletDispenser(bullet);
        this.setZIndex(0); // depth

    }

        
    @Override
    public void act(float delta){

        if(Gdx.input.isTouched()){
            touchPointer.set(Gdx.input.getX() , Gdx.input.getY()  , 0);
            cam.unproject(touchPointer);
            isShooting = true;
            bulletDispenser.playerShooting(delta, bullet, position, 90, ship.getAttackSpeed());

        }else{

            isShooting = false;
        }

        if( position.y+2 < touchPointer.y && position.y < 310){
            
            position.y += ship.getPower() * delta * 20;
            
        }else if( position.y-2 > touchPointer.y && position.y > 50){
            position.y -= ship.getPower() * delta * 20;
        }
        
        
        setPosition(position.x , position.y);
        sprShip.setPosition(position.x-(sprShip.getWidth()/2), position.y-(sprShip.getHeight()/2));
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha){
        
        sprShip.draw(batch, parentAlpha);
        
    }
    
    public int getHP(){
        return hp;
    }
    
    public int getEP(){
        return ep;
    }
    
    public void doDamage(int damage){ // Funcion para hacer daño al jugador
        hp -= damage;
    }

    public Ship getShip(){
        return ship;
    }

    public Thruster getThruster(){
        return thruster;
    }

    public Bullet getBullet(){
        return bullet;
    }


    public Vector2 getPosition(){
        return position;
    }

    public boolean getShootingState(){
        return isShooting;
    }

    public BulletDispenser getBulletDispenser(){
        return bulletDispenser;
    }


    
}

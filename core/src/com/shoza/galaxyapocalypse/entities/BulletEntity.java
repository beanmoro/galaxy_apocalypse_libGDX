package com.shoza.galaxyapocalypse.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.shoza.galaxyapocalypse.entities.parts.Bullet;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class BulletEntity extends Actor{


    protected TextureRegion region;
    private Sprite sprite;
    private Vector2 position;

    private boolean alive = false;
    private boolean enemy = false;
    private float angle = 0.0f;
    
    //Bullet Data 
    private Bullet bullet;
    
    
    public BulletEntity(Bullet bullet, Vector2 position, float angle){
        
        this.bullet = bullet;
        this.position = new Vector2(position.x, position.y);
        this.angle = angle;
        
        region = bullet.getRegion();
        sprite = new Sprite(region);
        this.setZIndex(1); // depth
        
    }

    public void shot(Bullet bullet, Vector2 position, float angle){

        this.bullet = bullet;
        this.position = new Vector2((float) (position.x + sprite.getWidth()*2 * sin(toRadians(angle))), (float) ( position.y + sprite.getWidth()*2 * cos(toRadians(angle)))); // Ecuacion gigante para que salga la bala un poco mas adelante
        this.angle = angle;
        alive = true;
    }
    
    
    @Override
    public void act(float delta){

        if (alive) {


            if (angle < 0) {
                angle += 360;
            } else if (angle > 360) {
                angle -= 360;
            }


            position.x += (bullet.getSpeed() * sin(toRadians(angle)));
            position.y += (bullet.getSpeed() * cos(toRadians(angle)));

            if (! ((position.x > 0 && position.y > 0) && (position.x < 640 && position.y < 480)) ) {
                alive = false;
            }
            setPosition(position.x, position.y);
            sprite.setPosition(position.x-sprite.getWidth()/2, position.y-sprite.getHeight()/2);
        }
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha){
        if(alive) {
            sprite.draw(batch, parentAlpha);
        }
    }

    public boolean isAlive(){

        return alive;
    }

    public void setAlive(boolean alive){
        this.alive = alive;

    }
    
}

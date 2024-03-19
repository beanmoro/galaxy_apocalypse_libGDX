package com.shoza.galaxyapocalypse.system.tools;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.shoza.galaxyapocalypse.entities.BulletEntity;
import com.shoza.galaxyapocalypse.entities.parts.Bullet;

public class BulletDispenser {

    private BulletEntity [] bullets;
    private float fireDelay;

    public BulletDispenser(Bullet bullet){

        bullets = new BulletEntity[100];
        for(int i = 0; i < 100; i++){
            bullets[i] = new BulletEntity(bullet, new Vector2(0,0), 0);
        }

    }

    public void playerShooting(float delta, Bullet bulletData, Vector2 position, float angle, float attackSpeed){
        fireDelay -= delta;
        if(fireDelay <= 0) {

            for(BulletEntity bllet : bullets){

                if(!bllet.isAlive()){
                    bllet.shot(bulletData, position, angle);
                    fireDelay = attackSpeed;
                    break;
                }
            }
        }
    }

    public void addBulletsToStage(Stage stage){
        for(int i = 0; i < bullets.length; i++){
            stage.addActor(bullets[i]);
        }
    }
}

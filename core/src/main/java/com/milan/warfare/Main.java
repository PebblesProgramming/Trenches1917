package com.milan.warfare;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.milan.warfare.components.PositionComponent;
import com.milan.warfare.components.VelocityComponent;
import com.milan.warfare.systems.MovementSystem;

public class Main extends ApplicationAdapter {
   
   private Engine engine;

    @Override
    public void create() {
        engine = new Engine();

        engine.addSystem(new MovementSystem());

        Entity player = new Entity();
        PositionComponent position = new PositionComponent();
        position.x = 0;
        position.y = 0;

        VelocityComponent velocity = new VelocityComponent();
        velocity.x = 50;
        velocity.y = 0;

        player.add(position);
        player.add(velocity);

        engine.addEntity(player);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        engine.update(delta);
    }

}

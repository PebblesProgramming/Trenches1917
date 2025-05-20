package com.milan.warfare;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.milan.warfare.factories.SoldierFactory;
import com.milan.warfare.systems.SoldierSystem;


public class Main extends ApplicationAdapter {
    private Engine engine;
    private SoldierFactory soldierFactory;
    private SpriteBatch batch;

    @Override
    public void create() {
        engine = new Engine();
        batch = new SpriteBatch();
        soldierFactory = new SoldierFactory();


        engine.addSystem(new SoldierSystem(batch));

        Entity soldier = soldierFactory.createSoldier(0, 0);

        engine.addEntity(soldier);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        engine.update(delta);
    }

    @Override
    public void dispose(){
        soldierFactory.dispose();
        batch.dispose();
    }
}

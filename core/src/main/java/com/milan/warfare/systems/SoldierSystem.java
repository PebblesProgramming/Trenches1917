package com.milan.warfare.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.milan.warfare.components.CommandLoggingComponent;
import com.milan.warfare.components.DualRenderTextureComponent;
import com.milan.warfare.components.PositionComponent;
import com.milan.warfare.components.VelocityComponent;

public class SoldierSystem extends IteratingSystem {

    private final ComponentMapper<PositionComponent> posComp = ComponentMapper.getFor(PositionComponent.class);
    private final ComponentMapper<VelocityComponent> velComp = ComponentMapper.getFor(VelocityComponent.class);
    private final ComponentMapper<DualRenderTextureComponent> textureComp = ComponentMapper.getFor(DualRenderTextureComponent.class);
    private final ComponentMapper<CommandLoggingComponent> commandComp = ComponentMapper.getFor(CommandLoggingComponent.class);

    private SpriteBatch batch;

    public SoldierSystem(SpriteBatch batch) {
        super(Family.all(PositionComponent.class, VelocityComponent.class, DualRenderTextureComponent.class).get());
        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = posComp.get(entity);
        VelocityComponent velocity = velComp.get(entity);
        DualRenderTextureComponent textures = textureComp.get(entity);
        CommandLoggingComponent command = commandComp.get(entity);

        batch.draw(textures.lowerBody, position.x, position.y);
        batch.draw(textures.upperBody, position.x, position.y);

        position.x += velocity.x * deltaTime;
        position.y += velocity.y * deltaTime;

        System.out.println(command.command);
    }


    @Override
    public void update(float deltaTime) {
        batch.begin();
        super.update(deltaTime);  // Calls processEntity for all entities at once and not one at a time, use super to call the parent class(IteratingSystem)
        batch.end();
}

    
}

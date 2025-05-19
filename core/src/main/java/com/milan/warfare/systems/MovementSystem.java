package com.milan.warfare.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.milan.warfare.components.PositionComponent;
import com.milan.warfare.components.VelocityComponent;

public class MovementSystem extends IteratingSystem {

    private final ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
    private final ComponentMapper<VelocityComponent> vm = ComponentMapper.getFor(VelocityComponent.class);

    public MovementSystem() {
        super(Family.all(PositionComponent.class, VelocityComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = pm.get(entity);
        VelocityComponent velocity = vm.get(entity);

        position.x += velocity.x * deltaTime;
        position.y += velocity.y * deltaTime;

        // System.out.println("Position X: " + position.x + "Position Y: " + position.y);
        // System.out.println("Position X: " + velocity.x + "Position Y: " + velocity.y);
        Gdx.app.log("MovementSystem", "Position X: " + position.x + " Y: " + position.y);
        Gdx.app.log("MovementSystem", "Velocity X: " + velocity.x + " Y: " + velocity.y);
    }
}

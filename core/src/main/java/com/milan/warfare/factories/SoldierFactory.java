package com.milan.warfare.factories;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.milan.warfare.components.CommandLoggingComponent;
import com.milan.warfare.components.DualRenderTextureComponent;
import com.milan.warfare.components.PositionComponent;
import com.milan.warfare.components.VelocityComponent;

public class SoldierFactory {
    private Texture lowerBody;
    private Texture upperBody;
    
    public SoldierFactory() {
        lowerBody = new Texture("ww1/unit_ger_1_a.png");
        upperBody = new Texture("ww1/unit_ger_1_d.png");
    }

    public Entity createSoldier(float x, float y) {
        Entity soldier = new Entity();

        PositionComponent pos = new PositionComponent();
        pos.x = x;
        pos.y = y;

        VelocityComponent vel = new VelocityComponent();
        vel.x = 20;
        vel.y = 2;

       DualRenderTextureComponent renderComp = new DualRenderTextureComponent();
        renderComp.lowerBody = lowerBody;
        renderComp.upperBody = upperBody;


        CommandLoggingComponent commandComp = new CommandLoggingComponent();
        commandComp.command = "Roger";

        soldier.add(pos);
        soldier.add(vel);
        soldier.add(renderComp);
        soldier.add(commandComp);

        return soldier;
    }

    public void dispose(){
        lowerBody.dispose();
        upperBody.dispose();
    }
}

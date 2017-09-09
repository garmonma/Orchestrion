package com.nni.gamevate.orchestrion.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class JumpComponent implements Component {

    public final Vector2 gravity = new Vector2(0, -3.82f);
    public final float mass = 2f;
    public final Vector2 acceleration = new Vector2();
    public final Vector2 force = new Vector2();

}

package com.nni.gamevate.orchestrion.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class JumpComponent implements Component {
    public final Vector2 jumpVelocity = new Vector2();
    public final Vector2 maxJumpHeight = new Vector2();
    public boolean maxJumpHeightReached = false;

}
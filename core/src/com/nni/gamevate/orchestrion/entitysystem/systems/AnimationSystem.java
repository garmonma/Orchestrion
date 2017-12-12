package com.nni.gamevate.orchestrion.entitysystem.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nni.gamevate.orchestrion.entitysystem.components.AnimationComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.StateComponent;
import com.nni.gamevate.orchestrion.entitysystem.components.TextureComponent;

public class AnimationSystem extends IteratingSystem {

    private ComponentMapper<TextureComponent> tm =  ComponentMapper.getFor(TextureComponent.class);
    private ComponentMapper<AnimationComponent> am = ComponentMapper.getFor(AnimationComponent.class);
    private ComponentMapper<StateComponent> sm = ComponentMapper.getFor(StateComponent.class);

    public AnimationSystem(){
        super(Family.all(TextureComponent.class,  AnimationComponent.class, StateComponent.class).get());
 
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
 
        AnimationComponent ani = am.get(entity);
        StateComponent state = sm.get(entity);
 
        if(ani.animations.containsKey(state.get())){
            TextureComponent tex = tm.get(entity);
            tex.region = ani.animations.get(state.get()).getKeyFrame(state.time, state.isLooping);
        }
 
        state.time += deltaTime;
    }
}
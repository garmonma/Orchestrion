package com.nni.gamevate.orchestrion;

import java.util.Comparator;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;

public class ZComparator implements Comparator<Entity> {
    private ComponentMapper<TransformComponent> transformM;
 
    public ZComparator(){
        transformM = ComponentMapper.getFor(TransformComponent.class);
    }
 
    @Override
    public int compare(Entity entityA, Entity entityB) {
        float az = transformM.get(entityA).pos.z;
        float bz = transformM.get(entityB).pos.z;
        int res = 0;
        if(az > bz){
            res = 1;
        }else if(az < bz){
            res = -1;
        }
        return res;
    }
}
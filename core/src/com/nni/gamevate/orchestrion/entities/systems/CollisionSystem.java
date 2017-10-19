package com.nni.gamevate.orchestrion.entities.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.nni.gamevate.orchestrion.entities.components.CollisionComponent;
import com.nni.gamevate.orchestrion.entities.components.PlayerComponent;
import com.nni.gamevate.orchestrion.entities.components.TypeComponent;

public class CollisionSystem extends IteratingSystem {
    ComponentMapper<CollisionComponent> cm;
    ComponentMapper<PlayerComponent> pm;

    @SuppressWarnings("unchecked")
    public CollisionSystem() {
	// only need to worry about player collisions
	super(Family.all(CollisionComponent.class, PlayerComponent.class).get());

	cm = ComponentMapper.getFor(CollisionComponent.class);
	pm = ComponentMapper.getFor(PlayerComponent.class);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
	// get player collision component
	CollisionComponent cc = cm.get(entity);

	Entity collidedEntity = cc.collisionEntity;

	TypeComponent thisType = entity.getComponent(TypeComponent.class);

	if (thisType.type == TypeComponent.PLAYER) {
	    playerCollision(cc, collidedEntity);
	} else if (thisType.type == TypeComponent.BEAT) {

	} else if (thisType.type == TypeComponent.ENEMY) {

	} else if (thisType.type == TypeComponent.CHAOS) {

	}

    }

    private void playerCollision(CollisionComponent cc, Entity collidedEntity) {
	if (collidedEntity != null) {
	    TypeComponent type = collidedEntity.getComponent(TypeComponent.class);
	    if (type != null) {
		switch (type.type) {
		case TypeComponent.ENEMY:
		    System.out.println("player hit enemy");
		    break;
		case TypeComponent.SCENERY:
		    System.out.println("player hit scenery");
		    break;
		case TypeComponent.OTHER:
		    System.out.println("player hit other");
		    break;
		case TypeComponent.BEAT:
		   System.out.println("Player hit a beat!");
		}

		cc.collisionEntity = null; // collision handled reset component
	    }
	}
    }
}
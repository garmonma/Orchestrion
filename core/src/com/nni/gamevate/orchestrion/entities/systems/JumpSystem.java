package com.nni.gamevate.orchestrion.entities.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.nni.gamevate.orchestrion.entities.components.JumpComponent;
import com.nni.gamevate.orchestrion.entities.components.MovementComponent;
import com.nni.gamevate.orchestrion.entities.components.TransformComponent;
import com.nni.gamevate.orchestrion.entities.components.InputComponent;

public class JumpSystem extends IteratingSystem {

	private ComponentMapper<TransformComponent> tm = ComponentMapper.getFor(TransformComponent.class);
	private ComponentMapper<MovementComponent> mm = ComponentMapper.getFor(MovementComponent.class);
	private ComponentMapper<JumpComponent> jm = ComponentMapper.getFor(JumpComponent.class);
	private ComponentMapper<InputComponent> um = ComponentMapper.getFor(InputComponent.class);

	public JumpSystem() {
		super(Family.all(TransformComponent.class, MovementComponent.class, JumpComponent.class, InputComponent.class)
				.get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		TransformComponent transform = tm.get(entity);
		MovementComponent movement = mm.get(entity);
		JumpComponent jump = jm.get(entity);
		InputComponent userInput = um.get(entity);

		if (userInput.jump) {


		}
	}

}

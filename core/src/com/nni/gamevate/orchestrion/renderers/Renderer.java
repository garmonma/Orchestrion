package com.nni.gamevate.orchestrion.renderers;

public interface Renderer {
	
	void init();
	void render(float delta);
	void resize(int width, int height);
}
package com.nni.gamevate.orchestrion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.nni.gamevate.orchestrion.Orchestrion;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		Settings settings = new Settings();
//		settings.maxWidth = 512;
//		settings.maxHeight = 512;
//		TexturePacker.process(settings, "../images", "../game-android/assets", "game");
		new LwjglApplication(new Orchestrion(), config);
	}
}

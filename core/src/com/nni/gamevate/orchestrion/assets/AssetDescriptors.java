package com.nni.gamevate.orchestrion.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class AssetDescriptors {

	public static final AssetDescriptor<Texture> SPLASH_BACKGROUND =
            new AssetDescriptor<Texture>(AssetPaths.SPLASH_BACKGROUND, Texture.class);
	
	public static final String LEVEL_SELECTOR_MUSIC = null;
	
	public static final AssetDescriptor<Music> FUR_ELISE =
            new AssetDescriptor<Music>(AssetPaths.FUR_ELISE, Music.class);
	

}

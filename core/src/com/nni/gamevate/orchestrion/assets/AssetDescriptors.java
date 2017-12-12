package com.nni.gamevate.orchestrion.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetDescriptors {
    
    		//Texture Atlas
  	public static final AssetDescriptor<TextureAtlas> TEMPI =
              new AssetDescriptor<TextureAtlas>(AssetPaths.TEMPI, TextureAtlas.class);

	public static final AssetDescriptor<Texture> SPLASH_BACKGROUND =
            new AssetDescriptor<Texture>(AssetPaths.SPLASH_BACKGROUND, Texture.class);
	
	public static final String LEVEL_SELECTOR_MUSIC = null;
	
	public static final AssetDescriptor<Music> FUR_ELISE =
            new AssetDescriptor<Music>(AssetPaths.FUR_ELISE, Music.class);

	//CHARACTERS
	public static final AssetDescriptor<Texture> TEMPI_RUN = 
		new AssetDescriptor<Texture>(AssetPaths.TEMPI_RUN, Texture.class);

	

}

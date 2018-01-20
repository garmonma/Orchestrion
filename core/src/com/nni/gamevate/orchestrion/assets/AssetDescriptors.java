package com.nni.gamevate.orchestrion.assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetDescriptors {
    
    //Texture Atlas
  	public static final AssetDescriptor<TextureAtlas> TEMPI =
              new AssetDescriptor<TextureAtlas>(AssetPaths.TEMPI_RUN_ATLAS, TextureAtlas.class);
  	
  	public static final AssetDescriptor<TextureAtlas> RY =
  			new AssetDescriptor<TextureAtlas>(AssetPaths.RY_RUN_ATLAS, TextureAtlas.class);
  	
	//CHARACTERS
	public static final AssetDescriptor<Texture> TEMPI_RUN = 
		new AssetDescriptor<Texture>(AssetPaths.TEMPI_RUN, Texture.class);
	
	public static final AssetDescriptor<Texture> RY_RUN = 
			new AssetDescriptor<Texture>(AssetPaths.RY_RUN, Texture.class);
	
	
	//Background
	public static final AssetDescriptor<Texture> SPLASH_BACKGROUND =
            new AssetDescriptor<Texture>(AssetPaths.SPLASH_BACKGROUND, Texture.class);
	
	public static final AssetDescriptor<Texture> STAGE_ONE_BACKGROUND =
            new AssetDescriptor<Texture>(AssetPaths.STAGE_ONE_BACKGROUND, Texture.class);
	
	public static final AssetDescriptor<Texture> STAGE_TWO_BACKGROUND =
            new AssetDescriptor<Texture>(AssetPaths.STAGE_TWO_BACKGROUND, Texture.class);


	
	//MISC
	public static final String LEVEL_SELECTOR_MUSIC = null;
	
	public static final AssetDescriptor<Music> FUR_ELISE =
            new AssetDescriptor<Music>(AssetPaths.FUR_ELISE, Music.class);
	
}
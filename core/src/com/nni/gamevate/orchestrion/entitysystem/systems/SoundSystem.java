package com.nni.gamevate.orchestrion.entitysystem.systems;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class SoundSystem {
    int channel = 14; // 0 is a piano, 9 is percussion, other channels are for
		     // other instruments

    int volume = 80; // between 0 et 127
    int duration = 200; // in milliseconds

    public SoundSystem() {
	try {
	    Synthesizer synth = MidiSystem.getSynthesizer();
	    
	    synth.open();
	    MidiChannel[] channels = synth.getChannels();

	    channels[channel].noteOn(60, volume); // C note
	    Thread.sleep(duration);
	    channels[channel].noteOff(60);
	    
	    channels[channel].noteOn(60, volume); // C note
	    Thread.sleep(duration);
	    channels[channel].noteOff(60);
	    
	    channels[channel].noteOn(60, volume); // C note
	    Thread.sleep(duration);
	    channels[channel].noteOff(60);
	    
	    channels[channel].noteOn(60, volume); // C note
	    Thread.sleep(duration);
	    channels[channel].noteOff(60);
	    
	    channels[channel].noteOn(60, volume); // C note
	    Thread.sleep(duration);
	    channels[channel].noteOff(60);
	    
	    channels[channel].noteOn(60, volume); // C note
	    Thread.sleep(duration);
	    channels[channel].noteOff(60);
	    
	    channels[channel].noteOn(62, volume); // D note
	    Thread.sleep(duration);
	    channels[channel].noteOff(62);
	    
	    channels[channel].noteOn(62, volume); // D note
	    Thread.sleep(duration);
	    channels[channel].noteOff(62);
	    
	    channels[channel].noteOn(62, volume); // D note
	    Thread.sleep(duration);
	    channels[channel].noteOff(62);
	    
	    channels[channel].noteOn(62, volume); // D note
	    Thread.sleep(duration);
	    channels[channel].noteOff(62);
	    
	    channels[channel].noteOn(62, volume); // D note
	    Thread.sleep(duration);
	    channels[channel].noteOff(62);
	    
	    channels[channel].noteOn(62, volume); // D note
	    Thread.sleep(duration);
	    channels[channel].noteOff(62);
	    
	    channels[channel].noteOn(62, volume); // D note
	    Thread.sleep(duration);
	    channels[channel].noteOff(62);
	    
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);
	    
	    channels[channel].noteOn(64, volume); // E note
	    Thread.sleep(duration);
	    channels[channel].noteOff(64);

	} catch (MidiUnavailableException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) {
	SoundSystem s =  new SoundSystem();
	
    }

}

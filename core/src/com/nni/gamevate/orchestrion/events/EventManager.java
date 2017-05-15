package com.nni.gamevate.orchestrion.events;

import java.util.ArrayList;
import java.util.HashMap;

import com.nni.gamevate.orchestrion.events.Event.EventType;
import com.nni.gamevate.orchestrion.utils.Logger;

public class EventManager {
	
	public static HashMap<EventType, ArrayList<Subscriber>> subscribers;
	
	static{
		subscribers  = new HashMap<EventType, ArrayList<Subscriber>>();
		for(EventType t: EventType.values()){
			ArrayList<Subscriber> list = new ArrayList<Subscriber>();
			subscribers.put(t, list);
		}		
	}

	public static void addSubscriber(EventType t,Subscriber s){
		subscribers.get(t).add(s);
	}
	
	public static void publish(EventType t, Event e){
		Logger.log("Event: " + t);
		ArrayList<Subscriber> list = subscribers.get(t);
		for(Subscriber s : list){
			s.handleEvent(e);
		}
	}
	
}

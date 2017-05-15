package com.nni.gamevate.orchestrion.events;

public class Event {
	
	public enum EventType{
		ENEMY_ATTACKED, 
		JOINED_GROUP, 
		ENEMY_DEATH
	}
	
	public EventType _type;
	public String _message;
	public Event(EventType type, String message) {
		_type = type;
		_message = message;
		// TODO Auto-generated constructor stub
	}
	

}

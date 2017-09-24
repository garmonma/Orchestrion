package com.nni.gamevate.orchestrion.events;

public class Event {
	
	public enum EventType{
		PLAYER_JUMPED,
		
	}
	
	public EventType _type;
	public String _message;
	public Event(EventType type, String message) {
		_type = type;
		_message = message;
		// TODO Auto-generated constructor stub
	}
}
package com.sbt;

public enum Position {
	
	INDIRECT("Indirect"), 
	DIRECT("Direct"), 
	PROGRAM_MANAGER("Program Manager"),
	DIRECTOR("Director"), 
	EXECUTIVE("Executive");
	
	private String description;
	
	private Position(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Position getPosition(String description) {
		Position position = null;
		if(description != null && !description.trim().equals("")) {
			Position[] positions = Position.values();
			for(Position pos : positions) {
				if(pos.getDescription().equals(description)) {
					position = pos;
					break;
				}
			}
		}
		return position;
	}

}

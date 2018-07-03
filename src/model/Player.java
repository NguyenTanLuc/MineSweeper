package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private String score;
	public static List<Player> list = new ArrayList<>();
	public Player(String name, String string) {
		this.name = name;
		this.score = string;
	}
	public String getName() {
		return name;
	}
	public String getScore() {
		return score;
	}
	
	

}

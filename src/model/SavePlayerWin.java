package model;

public class SavePlayerWin {
	public Player player;
	public String list ="";
	public SavePlayerWin () {
		for (Player play : Player.list) {
			list += play.getName() +"\t" + play.getScore() +"\n";

		
	}
		
}
	public String getString() {
		return list;
	}
	
}
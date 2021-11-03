package model;

public class ScoreVO {

	private String clear_no;
	private String score;
	private String play_date;
	
	public ScoreVO (String clear_no, String score, String play_date) {
		this.clear_no = clear_no;
		this.score = score;
		this.play_date = play_date;
		
	}

	public String getClear_no() {
		return clear_no;
	}

	public String getScore() {
		return score;
	}

	public String getPlay_date() {
		return play_date;
	}
	
}

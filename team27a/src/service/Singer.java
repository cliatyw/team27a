package service;
public class Singer {
	private String singer_id;
	private String singer_name;
	
	public String getSinger_id() {
		return singer_id;
	}
	public void setSinger_id(String singer_id) {
		this.singer_id = singer_id;
	}
	public String getSinger_name() {
		return singer_name;
	}
	public void setSinger_name(String singer_name) {
		this.singer_name = singer_name;
	}
	public int getSinger_age() {
		return singer_age;
	}
	public void setSinger_age(int singer_age) {
		this.singer_age = singer_age;
	}
	private int singer_age;
}

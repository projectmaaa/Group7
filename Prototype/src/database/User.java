package database;

public class User {

	private String iD;
	private String passWord;
	private int logged;
	private String type;

	public User(String iD, String passWord, int logged, String type) {
		super();
		this.iD = iD;
		this.passWord = passWord;
		this.type = type;
		this.logged = logged;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int isLogged() {
		return logged;
	}

	public void setLogged(int logged) {
		this.logged = logged;
	}

	@Override
	public String toString() {
		return "User [iD=" + iD + ", passWord=" + passWord + ", type=" + type + ", logged=" + logged + "]";
	}

}

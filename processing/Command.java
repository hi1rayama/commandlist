package processing;

public class Command {
	private String command;
	private String explain;
	private String all;
	Command(String c, String e,String a) {

		this.command = c;
		this.explain = e;
		this.all=a;
	}

	public String getCommand() {
		return this.command;
	}

	public String getExplain() {
		return this.explain;
	}

	public String getAll() {
		// TODO 自動生成されたメソッド・スタブ
		return this.all;
	}

}

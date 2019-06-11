/**
 * フレームの定義とフレームチェンジを行う
 */
package frame;

/**
 * @author hirayamakai
 *
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main  extends JFrame {//フレーム（ウィンドウ）を作成するためのクラス
	public String[] PanelNames = { "start", "home", "register" ,"namechange","search","edit"};//パネル名の配列
	Start start = new Start(this, PanelNames[0]);
	Home home = new Home(this, PanelNames[1]);
	Register register = new Register(this, PanelNames[2]);
	NameChange namechange = new NameChange(this, PanelNames[3]);
	Search search = new Search(this, PanelNames[4]);
	Edit edit = new Edit(this, PanelNames[5]);
	public String title;
	public String no;


	public Main() {//全てのウィンドウを追加し、非表示にする

		this.add(start);
		start.setVisible(false);
		this.add(home);
		home.setVisible(false);
		this.add(register);
		register.setVisible(false);
		this.add(namechange);
		namechange.setVisible(false);
		this.add(search);
		search.setVisible(false);
		this.add(edit);
		edit.setVisible(false);
	}

	public void setTitle(String title) {
this.title=title;
	}

	public void setNo(String No) {
this.no=No;
	}

	public String getNo() {
		return this.no;
	}

	public void PanelChange(JPanel jp, String str, String title) {
		//パネルチェンジの処理をする。

		this.setTitle(title);
		String name = jp.getName();
		if (name == PanelNames[0]) {
			start = (Start) jp;
			start.setVisible(false);
		}

//パネルを非表示にする
		if (name ==PanelNames[1]) {

			home = (Home) jp;
			home.setVisible(false);
		}


		if (name == PanelNames[2]) {

			register = (Register) jp;
			register.setVisible(false);
		}

		if (name == PanelNames[3]) {

			namechange = (NameChange) jp;
			namechange.setVisible(false);
		}

		if (name == PanelNames[4]) {

			search = (Search) jp;
			search.setVisible(false);
		}

		if (name == PanelNames[5]) {

			edit = (Edit) jp;
			edit.setVisible(false);
		}


//次のパネルを表示する

		if (str == PanelNames[0]) {
			start.setVisible(true);
		}

		if (str == PanelNames[1]) {
			home.setVisible(true);
		}

		if (str == PanelNames[2]) {
			register.setVisible(true);
		}

		if (str == PanelNames[3]) {
			namechange.setVisible(true);
		}

		if (str == PanelNames[4]) {
			search.setVisible(true);
		}

		if (str == PanelNames[5]) {
			edit.setVisible(true);
		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//スタート画面を表示したいのでスタート画面のパネルを表示する


		Main mf = new Main();
		mf.setTitle("START");
		mf.setBounds(10, 10, 800, 400);
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.start.setVisible(true);
		mf.setVisible(true);

	}


}

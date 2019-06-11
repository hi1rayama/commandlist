/**
 * 登録画面の作成
 */
package frame;

import java.awt.Font;
/**
 * @author hirayamakai
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JPanel implements ActionListener{
	private JButton register_b,return_b;
	private JLabel command_name,explain;
	private JTextField text1,text2;
	public Main frame;
	 processing.CommandDB inst = new processing.CommandDB("1");

	public Register(Main m, String p_name) {//スタート画面の作成
		frame = m;
		this.setName(p_name);
		this.setLayout(null);
		this.setSize(800, 400);


		command_name = new JLabel("コマンド名：");
		command_name.setBounds(150, 100, 100, 20);
		command_name.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 14));

		explain = new JLabel("　説　明　：");
		explain.setBounds(150, 150, 100, 20);
		explain.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 14));

		text1 = new JTextField(null);
		text1.setBounds(250, 100, 200, 20);

		text2 = new JTextField(null);
		text2.setBounds(250, 150, 500, 20);


		register_b = new JButton("登録");
		register_b.setBounds(100, 300, 200, 60);

		return_b = new JButton("戻る");
		return_b.setBounds(500, 300, 200, 60);

		this.add(register_b);
		this.add(return_b);
		this.add(command_name);
		this.add(explain);
		this.add(text1);
		this.add(text2);

		register_b.addActionListener(this);
		return_b.addActionListener(this);



	}

	public void actionPerformed(ActionEvent e) {//ボタンが押された時の処理など

		if (e.getSource() == register_b) {
			processing.Register.write(text1.getText(), text2.getText(), frame.getNo());
			setNull();

		} else if (e.getSource() == return_b) {
			frame.PanelChange((JPanel) this, frame.PanelNames[1], frame.title);
			setNull();
            inst = new processing.CommandDB(frame.getNo());

            set();
		}

	}

	public void setNull() {
		//それぞれのテキストの値を空白にする
		text1.setText("");
		text2.setText("");


	}

	void set() {
		int i=0;
		Home.area.setText("");
		while(inst.command[i]!=null) {
			Home.area.append(inst.command[i].getAll());
			Home.area.append("\n");
			i++;
		}
	}

}

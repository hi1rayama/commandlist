/**
 * コマンド編集画面
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
public class Edit extends JPanel implements ActionListener{
	private JButton change_b,return_b;
	private JLabel command_name,explain;
	private JTextField text1,text2;
	public Main frame;



	public Edit(Main m, String p_name) {//コマンド編集画面の作成
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

		text1 = new JTextField(null);//編集対象のコマンドを入れている状態にする
		text1.setBounds(250, 100, 200, 20);

		text2 = new JTextField(null);//編集対象のコマンドに対する説明を入れている状態にする
		text2.setBounds(250, 150, 500, 20);


		change_b = new JButton("変更");
		change_b.setBounds(100, 300, 200, 60);

		return_b = new JButton("戻る");
		return_b.setBounds(500, 300, 200, 60);

		this.add(change_b);
		this.add(return_b);
		this.add(command_name);
		this.add(explain);
		this.add(text1);
		this.add(text2);

		change_b.addActionListener(this);
		return_b.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {//ボタンが押された時の処理など

		if (e.getSource() == change_b) {
			/*
			 * 変更処理のメソッドを入れる
			 */
		}else if(e.getSource()==return_b) {
			frame.PanelChange((JPanel)this,frame.PanelNames[4],"検索");
		}

	}

}

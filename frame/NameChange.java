/**
 * ホーム名変更画面の作成
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
public class NameChange extends JPanel implements ActionListener{
	private JButton namechange_b,return_b;
	private JLabel namechange_l;
	private JTextField text1;
	public Main frame;

	public NameChange(Main m, String p_name) {//ホーム名変更画面の作成
		frame = m;
		this.setName(p_name);
		this.setLayout(null);
		this.setSize(800, 400);

		namechange_l = new JLabel("名称：");
		namechange_l.setBounds(150, 100, 100, 20);
		namechange_l.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 14));

		text1 = new JTextField(null); //現在の名称を入れておく
		text1.setBounds(250, 100, 200, 20);

		namechange_b = new JButton("名称変更");
		namechange_b.setBounds(100, 300, 200, 60);

		return_b = new JButton("戻る");
		return_b.setBounds(500, 300, 200, 60);


		this.add(namechange_l);
		this.add(text1);
		this.add(namechange_b);
		this.add(return_b);


		namechange_b.addActionListener(this);
		return_b.addActionListener(this);


	}

	public void actionPerformed(ActionEvent e) {//ボタンが押された時の処理など


		if (e.getSource() == namechange_b) {
			/*
			 * 名前変更処理のメソッドを入れる
			 */
			processing.NameChange.change(text1.getText(),"1");
			frame.setTitle(text1.getText());
			frame.start.b1.setText(text1.getText());

		}else if(e.getSource()==return_b) {
			frame.PanelChange((JPanel)this,frame.PanelNames[1],frame.title);
		}

	}

}

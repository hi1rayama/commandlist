/**
 * ホーム画面の作成
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class Home extends JPanel implements ActionListener{
	private JButton register_b,search_b,namechange_b,return_b;
	 public static JTextArea area = new JTextArea("");
	JScrollPane scrollpane;
	public Main frame;



	public Home(Main m, String p_name) {//ホーム画面の作成
		frame = m;
		this.setName(p_name);
		this.setLayout(null);
		this.setSize(800, 400);
		register_b = new JButton("登録");
		register_b.setBounds(10, 300, 160, 40);

		search_b = new JButton("検索");
		search_b.setBounds(220, 300, 160, 40);

		namechange_b = new JButton("名称変更");
		namechange_b.setBounds(430, 300, 160, 40);

		return_b = new JButton("戻る");
		return_b.setBounds(640, 300, 160, 40);


	    scrollpane = new JScrollPane(area);
	    scrollpane.setBounds(30, 30, 730, 250);

	    area.setFont(new Font("Arial",Font.PLAIN, 15));


		this.add(register_b);
		this.add(search_b);
		this.add(namechange_b);
		this.add(return_b);
		this.add(scrollpane);

		register_b.addActionListener(this);
		search_b.addActionListener(this);
		namechange_b.addActionListener(this);
		return_b.addActionListener(this);


	}


	public void actionPerformed(ActionEvent e) {//ボタンが押された時の処理など
		if (e.getSource() == register_b) {
			//検索画面に移動する
			frame.PanelChange((JPanel)this,frame.PanelNames[2],register_b.getText());


		}else if(e.getSource()==search_b) {
			frame.PanelChange((JPanel)this,frame.PanelNames[4],search_b.getText());

		}else if( e.getSource() == namechange_b) {
			frame.PanelChange((JPanel)this,frame.PanelNames[3],namechange_b.getText());

		}
		else if(e.getSource()==return_b) {
			frame.PanelChange((JPanel)this,frame.PanelNames[0],"START");
		}

	}

}

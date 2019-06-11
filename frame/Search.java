/**
 * コマンド検索画面
 */
package frame;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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
public class Search extends JPanel implements ActionListener{
	private JButton left_b,right_b,edit_b,delete_b,return_b,search_b,copy;
	private JLabel search_word,command_name,explain,result;
	private JTextField text1,text2,text3;
	public Main frame;
	processing.CommandDB inst = new processing.CommandDB("1");

	public Boolean[] hantei = new Boolean[100];//指定された文字列が入っていた場合true,入っていない場合はfalseを格納する配列。添え字時はBookDBの配列Bookに対応している
	public int c = 0, d = 0, p = 0;
	int flag = 0;
	int i = 0;

	public Search(Main m, String p_name) {//スタート画面の作成
		frame = m;
		this.setName(p_name);
		this.setLayout(null);
		this.setSize(800, 400);

		search_word = new JLabel("検索語（部分一致）：");
		search_word.setBounds(100, 10, 200, 20);
		search_word.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 14));

		result=new JLabel("------------------------------結果------------------------------");
		result.setBounds(150, 80, 600, 20);

		command_name = new JLabel("コ マ ン ド 名：");
		command_name.setBounds(100, 120, 100, 20);
		command_name.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 14));

		explain = new JLabel("　説　明　：");
		explain.setBounds(100, 170, 100, 20);
		explain.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 14));

		text1 = new JTextField(null);
		text1.setBounds(250, 10, 200, 20);

		text2 = new JTextField(null);
		text2.setBounds(250, 120, 200, 20);

		text3 = new JTextField(null);
		text3.setBounds(250, 170, 500, 20);

		search_b = new JButton("検索");
		search_b.setBounds(500, 10, 160, 20);

		left_b = new JButton("＜");
		left_b.setBounds(10, 300, 50, 40);


		right_b = new JButton("＞");
		right_b.setBounds(100, 300, 50, 40);

		edit_b = new JButton("このコマンドを編集");
		edit_b.setBounds(200, 300, 160, 40);

		delete_b = new JButton("このコマンドを削除");
		delete_b.setBounds(400, 300, 160, 40);

		return_b = new JButton("戻る");
		return_b.setBounds(600, 300, 160, 40);

		copy=new JButton("コピー");
		copy.setBounds(500, 120, 100, 20);



		this.add(search_word);
		this.add(result);
		this.add(command_name);
		this.add(explain);
		this.add(text1);
		this.add(text2);
		this.add(text3);
		this.add(search_b);
		this.add(left_b);
		this.add(right_b);
		this.add(edit_b);
		this.add(return_b);
		this.add(delete_b);
		this.add(copy);

		left_b.addActionListener(this);
		right_b.addActionListener(this);
		edit_b.addActionListener(this);
		return_b.addActionListener(this);
		search_b.addActionListener(this);
		delete_b.addActionListener(this);
		return_b.addActionListener(this);
		copy.addActionListener(this);


		reset();


	}

	public void actionPerformed(ActionEvent e) {//ボタンが押された時の処理など
		inst = new processing.CommandDB(frame.getNo());
		System.out.println(frame.getNo());
		flag=0;
		i = 0;

		if (e.getSource() == left_b) {

			for (int j = (d - 1); 0 <= j; j--) {

				if (hantei[j] == true) {
					//j番に格納されている図書データに指定された文字列を含んでいたら、そのデータをそれぞれ表示する
					setText(j);
					d = j;
					c = j;
					p = j;

					break;
				}

			}

		}else if(e.getSource()==right_b) {
			for (int j = (c + 1); j < hantei.length; j++) {
				//j番に格納されている図書データが指定された文字列を含んでいたら、そのデータをそれぞれ表示する
				if (hantei[j] == true) {
					setText(j);
					c = j;
					d = j;
					p = j;

					break;
				}

			}

		}else if( e.getSource() == edit_b) {
			frame.PanelChange((JPanel)this,frame.PanelNames[5],"編集");

		}else if(e.getSource()==search_b) {//検索ボタンが押された時の処理
			reset();
			String gStr = text1.getText();//gStrにtxt１の値を格納

			while (true) {

				if (inst.search(gStr, i) == -3) {//全ての図書データが読み込まれたら処理を終了する
					if (flag == 0) {
						System.out.println("見つからない");//全ての図書データが読み込まれ、該当する図書データがなかった場合、”見つからない”というWindowを表示
					}
					break;
				} else if (inst.search(gStr, i) == -2) {
					//文字を入力しないで検索ボタンが押された場合、何も表示させず、処理を終了
					System.out.println("何もない");
					setNull();

					break;
				} else if (inst.search(gStr, i) != -1 && flag != 0) {
					//指定された文字列を含む図書データが2番目以降に見つかった場合、Book[i]も指定された文字列を含む図書データがあるため配列s[i]をtrueにする
					hantei[i] = true;
					flag++;
					i++;
					System.out.println("２見");
				} else if (inst.search(gStr, i) != -1 && flag == 0) {
					//指定された文字列を含む図書データが最初に見つかった場合、そのデータをそれぞれ表示する
					setText(i);
					c = i;
					hantei[i] = true;//Book[i]に指定された文字列を含む図書データがあるため、s[i]をtrueにする
					flag++;
					p = i;
					System.out.println("１見");
					i++;
				} else {
					i++;
				}
			}

			/*
			 * 検索処理のメソッドを入れる
			 */

		}else if( e.getSource() == delete_b) {
			/*
			 * コマンド消去処理のメソッドを入れる
			 */

		}
		else if(e.getSource()==return_b) {
			setNull();
			reset();
			frame.PanelChange((JPanel)this,frame.PanelNames[1],frame.title);
		}else if(e.getSource()==copy) {

			copyToClipboad(text2.getText());
		}


	}

	public static void copyToClipboad(String select) {//コピー処理をするメソッド
	    Clipboard clipboard = Toolkit.getDefaultToolkit()
	            .getSystemClipboard();
	    StringSelection selection = new StringSelection(select);
	    clipboard.setContents(selection, selection);
	}



	public void reset() {
		//指定された文字列を含む図書データを判断するための配列の初期化
		for (int j = 0; j < hantei.length; j++) {
			hantei[j] = false;
		}

	}

	public void setText(int num) {
		//指定された番地の図書データを表示する
		text2.setText(inst.command[num].getCommand());
		text3.setText(inst.command[num].getExplain());


	}

	public void setNull() {
		//それぞれのテキストの値を空白にする
		text1.setText("");
		text2.setText("");
		text3.setText("");


	}

}

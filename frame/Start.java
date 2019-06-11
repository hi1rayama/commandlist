/**
 * Start画面の作成
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
public class Start extends JPanel implements ActionListener{
   public JButton b1,b2,b3,exit,reset;
	private JLabel start_title;
    public Main frame;
    String str;
    processing.CommandDB inst = new processing.CommandDB("1");

	public Start(Main m, String p_name) {//スタート画面の作成
		frame = m;
		str = p_name;
		this.setName(p_name);
		this.setLayout(null);
		this.setSize(800, 400);


		 start_title = new JLabel("My Command List");
		start_title.setBounds(250, 20, 400, 100);
		start_title.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 32));

processing.NameChange.Name();
        b1 = new JButton(processing.NameChange.name[0]);
        b1.setBounds(40, 150, 200, 60);

        b2 = new JButton(processing.NameChange.name[1]);
        b2.setBounds(300, 150, 200, 60);

        b3 = new JButton(processing.NameChange.name[2]);
        b3.setBounds(560, 150, 200, 60);

        exit = new JButton("終了");
        exit.setBounds(400, 300, 200, 60);

        reset= new JButton("初期化");
        reset.setBounds(140, 300, 200, 60);

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(exit);
        this.add(reset);
        this.add(start_title);

    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	b3.addActionListener(this);
    	exit.addActionListener(this);
    	reset.addActionListener(this);


	}

	public void actionPerformed(ActionEvent e) {//ボタンが押された時の処理など

		if (e.getSource() == b1) {
    		//検索画面に移動する
            frame.PanelChange((JPanel)this,frame.PanelNames[1],b1.getText());
            frame.setTitle(b1.getText());
            frame.setNo("1");
            inst = new processing.CommandDB("1");
            set();


    	}else if(e.getSource()==b2) {
    		 frame.PanelChange((JPanel)this,frame.PanelNames[1],b2.getText());
    		 frame.setTitle(b2.getText());
             frame.setNo("2");
             inst = new processing.CommandDB("2");
             set();
    	}else if( e.getSource() == b3) {
    		 frame.PanelChange((JPanel)this,frame.PanelNames[1],b3.getText());
    		 frame.setTitle(b3.getText());
             frame.setNo("3");
             inst = new processing.CommandDB("3");
             set();
    	}
    	else if(e.getSource()==exit) {
    		//このボタンが押されたらこのアプリケーションを終了する
            System.exit(0);
    	}

	}

	void set() {
		int i=0;
		Home.area.setText("");
		while(inst.command[i]!=null) {
			Home.area.append(inst.command[i].getCommand()+"・・・・・・・");
			Home.area.append(inst.command[i].getExplain());
			Home.area.append("\n");
			i++;
		}
	}

}

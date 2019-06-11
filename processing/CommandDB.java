package processing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandDB {
	public Command[] command = new Command[100];

	public CommandDB(String NO) {
		{
			for (int i = 0; i < command.length; i++) {
				command[i] = null;
			}

			try {
				File br = new File("/Users/hirayamakai/Desktop/source_code/MyCommandList/MyCommandList/src/processing/"
						+ NO + ".csv");//brにファイルを格納
				BufferedReader fin = new BufferedReader(new InputStreamReader(
						new FileInputStream(br), "UTF-8"));//文字化けを避けるための処理とファイルの読み込み
				try {
					int i = 0;
					while (true) {//図書データを格納する処理
						String line = fin.readLine();//１行ずつ読み込む
						if (line == null) {//読み込んだ行に何も入っていなければ処理を終える

							break;

						}
						String[] splitStr = line.split(",");//読み込んだ行の文字列を”，”で分割

						command[i] = new Command(splitStr[0], splitStr[1],line);//それぞれのデータを格納する
System.out.println(line);
						i++;

					}
				} finally {
					fin.close();//ファイルをとじる
				}
			} catch (IOException e) {//エラー処理
				e.printStackTrace();
			}
		}
	}

	public int search(String str, int num) {//指定された文字列が格納された図書データに含まれているかを判断する処理

		if (command[num] == null) {//読み込んだ格納場所に図書データが入っていない時の判定
			return -3;
		} else if (str.equals("")) {//指定された文字列に何も入っていない場合つまり何も入力せずに検索ボタンが押された時の判定
			return -2;
		} else {

			String t = command[num].getAll();//指定された文字列が含まれていなかったら−1が入力される

			int index;
			index = t.indexOf(str);
			return index;
		}
	}



	public static void delite(int b,String NO) {
		//データ消去を行う
		CommandDB inst = new CommandDB(NO);
		try {
			File br = new File("/Users/hirayamakai/Desktop/source_code/MyCommandList/MyCommandList/src/processing/"
					+ NO + ".csv");//ファイルを開く

			BufferedWriter bw = new BufferedWriter(new FileWriter(br));//ファイルに上書きをする
			try {

				for (int i = 0; i < 100; i++) {
					if (i == b) {//iが指定された行なら何も書き込まない
						bw.write("");
					} else if (inst.command[i] == null) {//図書データがなかったら終了

						break;
					} else {//それ以外なら図書データを入力
						bw.write(inst.command[i].getAll());
						bw.newLine();
					}

				}
			} finally {
				bw.close();//ファイルをとじる

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}






}

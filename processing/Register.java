package processing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Register {


	public static void write(String name, String explain,String NO) {
		//データの書き込みを行う
		try {
			System.out.println(NO);
			File fout = new File("/Users/hirayamakai/Desktop/source_code/MyCommandList/MyCommandList/src/processing/"+NO+".csv");//ファイルを開く

			BufferedWriter bw = new BufferedWriter(new FileWriter(fout, true));

			bw.write(name + "," + explain );//データ入力
			bw.newLine();//改行する
			bw.close();//ファイルを閉じる

		} catch (IOException e) {//エラー処理
			e.printStackTrace();
		}
	}

}

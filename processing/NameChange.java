package processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameChange {
	public static String[] name=new String[3];





	public static void change(String after_name,String before_name) {

		//Fileオブジェクトを生成する
        File fOld = new File("/Users/hirayamakai/Desktop/"+before_name+".txt");
        File fNew = new File("/Users/hirayamakai/Desktop/"+after_name+".txt");

        //ファイル名変更実行
        fOld.renameTo(fNew);




	}



	public static void Name() {
		// TODO 自動生成されたメソッド・スタブ
		try {
			File br = new File("/Users/hirayamakai/Desktop/source_code/MyCommandList/MyCommandList/src/processing/Name");//brにファイルを格納
			BufferedReader fin = new BufferedReader(new InputStreamReader(
					new FileInputStream(br), "UTF-8"));//文字化けを避けるための処理とファイルの読み込み
			try {
				int i = 0;
				while (true) {//名前データを格納する処理
					String line = fin.readLine();//１行ずつ読み込む
					if (line==null) {//読み込んだ行に何も入っていなければ処理を終える

						break;

					}
					 name[i]=line;
					 System.out.println(name[i]);


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

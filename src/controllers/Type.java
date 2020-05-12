package controllers;

public class Type {

	public static String gettype(int type) {
		String result;
		if (type == 1){
			result = "仕事";


		} else if (type ==2){
			result = "プライベート";

		} else {
			result = "エラー";
		}

		return result;

	}
}

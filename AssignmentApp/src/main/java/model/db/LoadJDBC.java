package model.db;

public class LoadJDBC {
	public static String LoadingJDBC() {
		String message = "";
		try {
            Class.forName("com.mysql.jdbc.Driver");
            message = "JDBCドライバの読み込みに成功しました";
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
		return message;
	}
}

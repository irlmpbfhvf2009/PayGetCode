package init;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import com.sun.tools.javac.Main;
import java.io.InputStreamReader;

public class DatabaseManager {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "mps";
    static final String PASS = "mps123";

    protected static String getCommand(int id){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT command FROM sqlcommands WHERE id = " + id);
            String command = null;
            if (rs.next()) {
                command = rs.getString("command");
            }
            return command;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }

    public static void initData() {
        try {
            // 加载资源文件
            InputStream inputStream = new FileInputStream("src/main/resources/init_data.sql");

            // 连接数据库
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行 SQL 脚本
            Statement statement = connection.createStatement();
            statement.execute(inputStreamToString(inputStream));

            // 关闭连接和流
            statement.close();
            connection.close();
            inputStream.close();
        } catch (SQLException  | IOException e) {
            e.printStackTrace();
        }
    }

    // 将输入流转换为字符串
    private static String inputStreamToString(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }
}

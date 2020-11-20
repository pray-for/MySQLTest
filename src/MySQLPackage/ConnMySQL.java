package MySQLPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnMySQL {
    public static void main(String[] args) throws Exception {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/databasetest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        try(
                //用 DriverManager 获取数据库连接
                //返回的 Connection 就代表了 Java 程序和数据库的连接
                Connection conn = DriverManager.getConnection(url, user, password);

                //使用 Connection 来创建一个 Statement 对象
                Statement stmt = conn.createStatement();

                //执行 SQL 语句
                ResultSet rs = stmt.executeQuery("select * from student"))
        {
            while (rs.next()){
                String number = rs.getString("number");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(number + "---" + name + "---" + age);
            }
        }
    }
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private Connection cn;
    private String user = "jaeer";
    private String password = "jaeer2018";
    private String hostname = "localhost";
    private String port = "3306";
    private String database = "tienda_alibrand";
    private String url = "jdbc:mysql://" + hostname +":"+port+ "/" + database;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, password);
            System.out.println("COnectado");
        } catch (Exception e) {
            throw e;
        }
    }

    public void cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

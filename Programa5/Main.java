package Programa5;

import db.DB;
import db.DbException;
import db.DbIntegfrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {


        Connection conn = null;
        Statement st = null;
        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int linhas1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");


            int linhas2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");


            conn.commit();

            System.out.println("linhas1 " +linhas1);
            System.out.println("linhas2 " +linhas2);

        }
        catch (SQLException e) {
            try{
                conn.rollback();
                throw new DbException("Transação não concluida! " + e.getMessage());
            }catch (SQLException e1){
               throw new DbException("Error tentando voltar o rollback " + e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
    }


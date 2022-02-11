package lk.ijse.dep7.amazonclonebackend.api;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import jakarta.annotation.Resource;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = "/item-servlet", loadOnStartup = 0)
public class ItemServlet extends HttpServlet {

    @Resource(name= "java:comp/env/jdbc/amazon")
    private DataSource dataSource;


    public void init() {

        try {
            Connection con = dataSource.getConnection();
            System.out.println(con);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {



    }

    public void destroy() {
    }
}
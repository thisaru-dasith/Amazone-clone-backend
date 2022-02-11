package lk.ijse.dep7.amazonclonebackend.api;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import jakarta.annotation.Resource;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lk.ijse.dep7.amazonclonebackend.dto.ItemDTO;
import lk.ijse.dep7.amazonclonebackend.service.ItemService;

import javax.sql.DataSource;

@WebServlet(name = "helloServlet", value = "/items", loadOnStartup = 0)
public class ItemServlet extends HttpServlet {

    @Resource(name= "java:comp/env/jdbc/amazon")
    private DataSource dataSource;


    public void init() {

       /* try {
            Connection con = dataSource.getConnection();
            System.out.println(con);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // GET http://localhost:8080/amazon/items           <- All items
        // GET http://localhost:8080/amazon/items?code=I001 <- Item I001
        try {
            Connection con = dataSource.getConnection();
            ItemService itemService = new ItemService(con);
            Jsonb jsonb = JsonbBuilder.create();
            response.setContentType("application/json");

            String code = request.getParameter("code");
            System.out.println(code);
            if(code != null){
                ItemDTO item = itemService.getItem(code);
                if(item != null){
                    response.getWriter().println(jsonb.toJson(item));
                }else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            }else {
                List<ItemDTO> allItems = itemService.getAllItems();
                String s = jsonb.toJson(allItems);
                PrintWriter writer = response.getWriter();
                writer.println(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to obtain a new connection", e);
        }


    }

    public void destroy() {
    }
}
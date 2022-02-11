package lk.ijse.dep7.amazonclonebackend.service;

import lk.ijse.dep7.amazonclonebackend.dto.ItemDTO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemService {

    private Connection connection;

    public ItemService(Connection connection) {
        this.connection = connection;
    }

    public List<ItemDTO> getAllItems(){

        try {
            ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * FROM items");
            while (resultSet.next()){
                String id = resultSet.getString("code");
                String title = resultSet.getString("title");
                String image = resultSet.getString("image");
                String rating = resultSet.getString("rating");
                int qty = resultSet.getInt("qty");
                BigDecimal unit_price = resultSet.getBigDecimal("unit_price");
                String description = resultSet.getString("description");
                itemDTOS.add(new ItemDTO(id,title,image,rating,qty,unit_price,description));
                return  itemDTOS;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch items from the DB", e);
        }

        return null;

    }
}

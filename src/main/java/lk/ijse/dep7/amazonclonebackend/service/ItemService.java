package lk.ijse.dep7.amazonclonebackend.service;

import lk.ijse.dep7.amazonclonebackend.dto.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {

    private Connection connection;

    public ItemService(Connection connection) {
        this.connection = connection;
    }

    public List<ItemDTO> getAllItems(){

        try {
            ArrayList<ItemDTO> items= new ArrayList<>();
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
                items.add(new ItemDTO(id,title,image,rating,qty,unit_price,description));

            }
            return  items;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch items from the DB", e);
        }

    }

    public ItemDTO getItem(String code){
        try {
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM items WHERE code = ?");
            pst.setString(1,code);
            ResultSet rst = pst.executeQuery();
            if(rst.next()){
                return new ItemDTO(rst.getString("code"),
                        rst.getString("title"),
                        rst.getString("image"),
                        rst.getString("rating"),
                        rst.getInt("qty"),
                        rst.getBigDecimal("unit_price"),
                        rst.getString("description"));
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch the item " + code, e);
        }

    }

}

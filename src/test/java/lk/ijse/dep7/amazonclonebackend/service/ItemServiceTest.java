package lk.ijse.dep7.amazonclonebackend.service;

import lk.ijse.dep7.amazonclonebackend.dto.ItemDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    private ItemService itemService;
    private Connection connection;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dep7_amazon_clone","root","th15@rud@51th");
        this.itemService = new ItemService(connection);
    }

    @Test
    void getAllItems() {
        assertDoesNotThrow(()->{
            List<ItemDTO> allItems = itemService.getAllItems();
            allItems.forEach(System.out::println);
        });
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    void getItem() {
        ItemDTO item = itemService.getItem("I001");
        System.out.println(item);
        assertNotNull(item);
    }
}
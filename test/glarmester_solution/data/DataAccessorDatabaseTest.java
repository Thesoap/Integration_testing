/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glarmester_solution.data;

import glarmester_solution.logic.FrameType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tim
 */
public class DataAccessorDatabaseTest {

    public DataAccessorDatabaseTest() {
    }

    static Connection connection;
    static Connection badConnection;

    @BeforeClass
    public static void setUpClass() {
        try {
            connection = new DBConnector().getConnection();
            badConnection = new DBConnector().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(DataAccessorDatabaseTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getGlassprice method, of class DataAccessorDatabase.
     */
    @Test
    public void testGetGlassprice() {
        System.out.println("getGlassprice");
        DataAccessorDatabase instance = new DataAccessorDatabase();
        double expResult = 300;
        assertEquals(expResult, instance.getGlassprice(), 0.0);
    }

    /**
     * Test of getFramePrice method, of class DataAccessorDatabase.
     */
    @Test
    public void testGetFramePrice() {
        System.out.println("getFramePrice");
        DataAccessorDatabase instance = new DataAccessorDatabase();
        double exp = 100.00;
        assertEquals(exp, instance.getFramePrice(FrameType.Simple), 0.0);
    }

    @Test
    public void testGetFramePriceWrongType() {
        System.out.println("getFramePrice");
        DataAccessorDatabase instance = new DataAccessorDatabase();
        double a = instance.getFramePrice(FrameType.Test);
        assertEquals(true, Double.isNaN(a));
    }

}

package UGT_Controllers;

import UGT_Data.Brand;
import UGT_Data.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static UGT_Controllers.SearchController.search_Testing;

import static UGT_Controllers.populateProgram.*;
import static java.awt.SystemColor.text;
import static org.junit.jupiter.api.Assertions.*;



class SearchControllerTest {



   @BeforeEach
    void setUp() {
       brandMap.clear();
       Brand huf = new Brand("hug@email.com", "huf123","password","huf","this is a brand","path","instagramhuf","tiktokhuf","8943894849334983498");
       Brand wd = new Brand("wds@gmail.com","wd","pass123k","wds2","a brand","path","instagramWd","tiktokWd","8943894849334983498");
       Brand active = new Brand("active@gmail.com","active123","passactive100","active","a brand that is for active people","path","instagram active","tiktko active","34984398984439834988943498");
       Brand Obey = new Brand("OB@gmail.com", "OB","passobey", "obey", "a brand","pforpath","instagramobey","tiktokobey","8943894849334983498");
       brandMap.put("Huf", huf);
       brandMap.put("wd", wd);
       brandMap.put("active", active);
       brandMap.put("Obey", Obey);




       itemMap.clear();
       Item shirt = new Item("Tfortshirt","s", 20.00,"a description","black","path","item_id","brand_id");
       Item hoodie = new Item("COZYHOODIE","s", 20.00,"a description","black","path","item_id","brand_id");
       Item pants = new Item("WorkPants","s", 20.00,"a description","black","path","item_id","brand_id");

        itemMap.put("shirt", shirt);
        itemMap.put("hoodie", hoodie);
        itemMap.put("pants", pants);
   }



    @Test
    void Testing_Valid_search_brand(){
        System.out.println("Testing Valid input");
        //Brands in BrandMap:"Huf", "wd", "active", "Obey"
        //Input: Huf
        //Expected Output: True
       assertTrue(search_Testing("Huf"));
    }


    @Test
    void Testing_Valid_Search_lowercase_brand() {
        System.out.println("Testing Valid input");
        //Brands in BrandMap:"Huf", "wd", "active", "Obey"
        //Input: obey
        //Expected Output: True
        assertTrue( search_Testing("obey"));
    }




    @Test
    void Testing_Valid_Search_Uppercase_brand() {
        System.out.println("Testing Valid input");
        //Brands in BrandMap:"Huf", "wd", "active", "Obey"
        //Input: OBEY
        //Expected Output: True
        assertTrue(search_Testing("OBEY"));
    }





    @Test
    void Testing_InValid_Search_brand() {
        System.out.println("Testing InValid input");
        //Brands in BrandMap:"Huf", "wd", "active", "Obey"
        //Input: randombrand
        //Expected Output: False
        assertFalse( search_Testing("randombrand"));
    }











    @Test
    void Testing_Valid_Search1() {
        System.out.println("Testing Valid input");
        //Items in ItemMap: "Tfortshirt","COZYHOODIE","WorkPants"
        //Input: Tfortshirt
        //Expected Output: True
        assertTrue(search_Testing("Tfortshirt"));
    }



    @Test
    void Testing_Valid_Search2() {
        System.out.println("Testing Valid input");
        //Items in ItemMap: "Tfortshirt","COZYHOODIE","WorkPants"
        //Input: Tfortshirt
        //Expected Output: True
        assertTrue(search_Testing("COZYHOODIE"));
    }




    @Test
    void Testing_InValid_Search_ItemMap1() {
        System.out.println("Testing InValid input");
        //Items in ItemMap: "Tfortshirt","COZYHOODIE","WorkPants"
        //Input: cozyjacket
        //Expected Output: False
        assertFalse(search_Testing("cozyjacket"));
    }


    @Test
    void Testing_InValid_Search_ItemMap2() {
        System.out.println("Testing InValid input");
        //Items in ItemMap: "Tfortshirt","COZYHOODIE","WorkPants"
        //Input: " "
        //Expected Output: False
        assertFalse(search_Testing(" "));
    }


    @Test
    void Testing_InValid_Search_ItemMap3() {
        System.out.println("Testing InValid input");
        //Items in ItemMap: "Tfortshirt","COZYHOODIE","WorkPants"
        //Input: 3093430
        //Expected Output: False
        assertFalse(search_Testing("3093430"));
    }





}
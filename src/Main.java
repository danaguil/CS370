import UGT_Controllers.IDGenerator;
import UGT_Controllers.LoginController;
import UGT_Controllers.SettingsController;
import UGT_Data.Brand;
import UGT_Data.Customer;
import UGT_Data.Item;
import UGT_UI.*;
import javax.swing.*;
import UGT_Controllers.LoginController;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import static UGT_Controllers.populateProgram.brandMap;
import static UGT_Services.UserService.*;

public class Main extends JFrame {
    public static void main(String[] args) throws FileNotFoundException{

    //UndergroundThreads threads = new UndergroundThreads();

        //for buyers
        //updateEmail("2440426e-daea-40da-9726-6992f93e2e8b","mylitos@gmail.com");
       // updateEmail("55d0f219-9fb6-40ee-8cb2-bba0c0200545","ilovebarlos@gmail.com");
        //updateEmail("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","cforcarlitos@gmail.com");


        //updateUsername("181dfa4b-e9d6-4bf4-b582-64b16f28dc16", "carlitos");
        //updateUsername("62ffe17c-9927-45db-884d-22309f074b0a", "Santos");

        //updatePforPassword("2440426e-daea-40da-9726-6992f93e2e8b","abcdefg");
        //updatePforPassword("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","chewinggum!");



        //for brand
        //updateBrandUsername("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","barlos");

        //updateBrandemail("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","litos@gmail.com");
        //updateBrandPassword("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","notBarlo");
        //updateBrandBrandname("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","wds2");
        //updateBrandAboutBrand("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","a brand that cares");
        //updateBrandProfilePic("181dfa4b-e9d6-4bf4-b582-64b16f28dc16",);
        //updateBrandInstagramHandle("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","barlitosxcarlitos");
        //updateBrandTiktokHandle("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","bbbforbarlos");


        //updateBrandPassword("181dfa4b-e9d6-4bf4-b582-64b16f28dc16","pforpassword123");

        LoginController.initialize();
        new UndergroundThreads();


/*
        for (String key : brandMap.keySet()) {
            System.out.println("Brand Name: " + key);
        }

        System.out.println("size of hashmap: " +brandMap.size());


        File path = new File("/Users/dansir/Desktop/logoTest.jpg");
        Brand wds = new Brand("wds@gmail.com","wd_username","wd_password","worlddomination","wd_description",path,"wd_instagram","wd_tiktok","aaf176ae-39c8-4d25-a22f-5d133396a399");

        brandMap.put("wds",wds);



        System.out.println("size of hashmap: " +brandMap.size());



 */




    }
}

package UGT_UI;

import javax.swing.*;
import java.awt.*;

public class UndergroundThreads extends JFrame {



    //creating cards and maincard
    CardLayout cards;
    JPanel maincard;


    Buyer_Pages buyer_pages;
    Login login;
   // Brand_Pages brand_pages;




    //finna go from login to buyers
   public UndergroundThreads() {

        this.setTitle("UndergroundThreads");
        this.setSize(500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //will be cardlayout
        cards = new CardLayout();
        //this JPanel (maincard) will be used to hold all cards
        maincard = new JPanel();
        //setting up layout
        maincard.setLayout(cards);

        buyer_pages = new Buyer_Pages(this);
        login = new Login(this);
       // brand_pages = new Brand_Pages();


        maincard.add(login, "login_pages");
        maincard.add(buyer_pages, "buyer_pages");


        this.add(maincard, BorderLayout.CENTER);


        cards.show(maincard, "login_pages");
        System.out.println("it works"); //for testing


        this.setVisible(true);
    }



    //methods
    public void go_to_login_pages(){
        cards.show(maincard, "login_pages");
    }

    public void go_to_brand_pages(){
        cards.show(maincard, "brand_pages");
    }

    public void go_to_buyer_pages(){
        cards.show(maincard, "buyer_pages");
    }

}

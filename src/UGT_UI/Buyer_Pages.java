package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Buyer_Pages extends JPanel implements ActionListener {




    //footer buttons
    JButton button_search;
    JButton button_cart;
    JButton button_Home;
    JButton button_discover;
    JButton button_like;
    JButton button_settings;


    //creating cards and maincard
    CardLayout cards;
    JPanel maincard;

    //creating objects
    static Buyer_CartPage cartPage;
    static Buyer_SearchPage searchPage;
    static Buyer_HomePage homePage;
    static Buyer_DiscoverPage discoverPage;
    static Buyer_LikedPage likedPage;
    Buyer_settings settingsPage;




    //CONSTRUCTOR
    public Buyer_Pages(UndergroundThreads UGT) {
        this.setLayout(new BorderLayout());




        //creating footer
        Buyer_Footer footer = new Buyer_Footer();


        //will be cardlayout
        cards = new CardLayout();
        //this JPanel (maincard) will be used to hold all cards
        maincard = new JPanel();
        //setting up layout
        maincard.setLayout(cards);


        //init
        cartPage = new Buyer_CartPage();
        searchPage = new Buyer_SearchPage();
        homePage = new Buyer_HomePage();
        discoverPage = new Buyer_DiscoverPage();
        likedPage = new Buyer_LikedPage();

        settingsPage = new Buyer_settings(UGT);



        //adding cards to maincard
        maincard.add(discoverPage, "discoverPage");
        maincard.add(cartPage, "cartPage");
        maincard.add(searchPage, "searchPage");
        maincard.add(homePage, "homePage");

        maincard.add(likedPage, "likedPage");
        maincard.add(settingsPage, "settingsPage");


        //adding maincard to footer
        footer.add(maincard, BorderLayout.CENTER);



        //creating buttons from footer and adding action listener
        button_search = footer.getSearch_button();
        button_search.addActionListener(this);
        button_cart = footer.getCart_button();
        button_cart.addActionListener(this);
        button_Home = footer.getHome_button();
        button_Home.addActionListener(this);
        button_discover = footer.getDiscover_button();
        button_discover.addActionListener(this);
        button_like = footer.getLike_button();
        button_like.addActionListener(this);
        button_settings = footer.getSettings_button();
        button_settings.addActionListener(this);
        //adding footer
        this.add(footer, BorderLayout.CENTER);


        /*
        System.out.println("discover");
        //prints out grid
        discoverPage.print_discover_grid();
        //shows page
        cards.show(maincard, "discoverPage");

         */

       //////// this.setVisible(true);

        discoverPage.print_discover_grid();
        cards.show(maincard, "discoverPage");
    }


    public static Buyer_CartPage getCartPage() {
        return cartPage;
    }
    public static Buyer_LikedPage getLikePage(){ return likedPage;}
    public static Buyer_DiscoverPage getDiscoverPage(){ return discoverPage;}
    public static Buyer_HomePage getHomePage(){ return homePage;}
    public static Buyer_SearchPage getSearchPage(){ return searchPage;}



    //action for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_Home) {
            System.out.println("button_Home");
            //prints out grid
            homePage.print_following_grid();
            //shows page
            cards.show(maincard, "homePage");





        }
        if (e.getSource() == button_discover) {
            System.out.println("discover");
            //prints out grid
            discoverPage.print_discover_grid();
            //shows page
            cards.show(maincard, "discoverPage");



        }
        if (e.getSource() == button_like) {
            System.out.println("like");
            //prints out grid
            likedPage.print_liked_grid();
            //shows page
            cards.show(maincard, "likedPage");



        }
        if (e.getSource() == button_settings) {
            System.out.println("settings");
            //settingsPage.
            //shows page
            cards.show(maincard, "settingsPage");



        }
        if (e.getSource() == button_search) {
            System.out.println("search");
            //shows page
            cards.show(maincard, "searchPage");



        }
        if (e.getSource() == button_cart) {
            System.out.println("cart");
            //prints grid
            cartPage.print_cart_grid();
            //shows page
            cards.show(maincard, "cartPage");
        }

    }




}

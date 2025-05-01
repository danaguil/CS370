package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Buyer_Pages extends JFrame implements ActionListener {




    //footer buttons
    JButton button_search;
    JButton button_cart;
    JButton button_Home;
    JButton button_discover;
    JButton button_like;
    JButton button_settings;



    CardLayout cards;
    JPanel maincard;


    Buyer_CartPage cartPage;
    Buyer_SearchPage searchPage;
    Buyer_HomePage homePage;
    Buyer_DiscoverPage discoverPage;
    Buyer_LikedPage likedPage;
    Buyer_settings settingsPage;

    //CONSTRUCTOR
    public Buyer_Pages() {
        //frame
        this.setSize(500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLayout(new BorderLayout());




        Buyer_Footer footer = new Buyer_Footer();



        cards = new CardLayout();
        //this JPanel (maincard) will be used to hold all cards
        maincard = new JPanel();
        maincard.setLayout(cards);



        cartPage = new Buyer_CartPage();

        searchPage = new Buyer_SearchPage();

        homePage = new Buyer_HomePage();

        discoverPage = new Buyer_DiscoverPage();

        likedPage = new Buyer_LikedPage();

        settingsPage = new Buyer_settings();




        maincard.add(cartPage, "cartPage");
        maincard.add(searchPage, "searchPage");
        maincard.add(homePage, "homePage");
        maincard.add(discoverPage, "discoverPage");
        maincard.add(likedPage, "likedPage");
        maincard.add(settingsPage, "settingsPage");



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

        this.add(footer, BorderLayout.CENTER);
        this.setVisible(true);
    }







    //action for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_Home) {
            System.out.println("button_Home");
            homePage.print_following_grid();
            cards.show(maincard, "homePage");





        }
        if (e.getSource() == button_discover) {
            System.out.println("discover");
            discoverPage.print_discover_grid();
            cards.show(maincard, "discoverPage");



        }
        if (e.getSource() == button_like) {
            System.out.println("like");
            likedPage.print_liked_grid();
            cards.show(maincard, "likedPage");



        }
        if (e.getSource() == button_settings) {
            System.out.println("settings");
            cards.show(maincard, "settingsPage");



        }
        if (e.getSource() == button_search) {
            System.out.println("search");
            cards.show(maincard, "searchPage");



        }
        if (e.getSource() == button_cart) {
            System.out.println("cart");
            cartPage.print_cart_grid();
            cards.show(maincard, "cartPage");




        }

    }




}

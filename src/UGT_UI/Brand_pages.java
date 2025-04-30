package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Brand_pages extends JFrame implements ActionListener {



    //footer buttons
    JButton button_search;
    JButton button_cart;
    JButton button_Home;
    JButton button_discover;
    JButton button_like;
    JButton button_settings;

    //variables
    Buyer_HomePage home;
    Buyer_DiscoverPage discover;
    Buyer_LikedPage liked;
    Buyer_settings settings;
    Buyer_SearchPage search;
    Buyer_CartPage cart;



    CardLayout cards;
    JPanel maincard;

    //CONSTRUCTOR
    public Brand_pages(Buyer_HomePage home, Buyer_DiscoverPage discover, Buyer_LikedPage liked, Buyer_settings settings, Buyer_SearchPage search, Buyer_CartPage cart ) {
        //frame
        this.setTitle("Buyer Cart");
        this.setSize(500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        this.home = home;
        this.discover = discover;
        this.liked = liked;
        this.settings = settings;
        this.search = search;
        this.cart = cart;

        //create footer to use
        //adding footer to frame
        Buyer_Footer footer = new Buyer_Footer();
        add(footer, BorderLayout.CENTER);



        cards = new CardLayout();
        //this JPanel (maincard) will be used to hold all cards
        maincard = new JPanel();
        maincard.setLayout(cards);

        //adding cards to maincard (JPanels)
        maincard.add(home,"home");
        maincard.add(discover, "discover");
        maincard.add(liked, "liked");
        maincard.add(settings, "settings");
        maincard.add(search, "search");
        maincard.add(cart, "cart");

        //adding maincard to footer
        footer.add(maincard);


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
    }



    //action for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_Home) {
            home.print_following_grid();
            cards.show(maincard, "home");
        }
        if (e.getSource() == button_discover) {
            discover.print_discover_grid();
            cards.show(maincard, "discover");

        }
        if (e.getSource() == button_like) {
            liked.print_liked_grid();
            cards.show(maincard, "liked");

        }
        if (e.getSource() == button_settings) {
            //?????
            cards.show(maincard, "settings");

        }
        if (e.getSource() == button_search) {
            cards.show(maincard, "search");

        }
        if (e.getSource() == button_cart) {
            cart.print_cart_grid();
            cards.show(maincard, "cart");

        }

    }




}

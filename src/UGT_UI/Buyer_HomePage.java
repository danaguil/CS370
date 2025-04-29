package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buyer_HomePage extends JFrame implements ActionListener {

    //footer buttons
    JButton button_search;
    JButton button_cart;
    JButton button_Home;
    JButton button_discover;
    JButton button_like;
    JButton button_settings;


    //array list holds JPanels... the brands newest post "all_following_post"
    private final ArrayList<JPanel> all_following_post = new ArrayList<>();

    //JPanel that will hold all the brands (JPanels) the user follows
    JPanel following_grid;

    //adds a brand to following array list "all_following_post" ... user will now receive the brands newest post now
    public void  add_to_following_post(JPanel post) {
        all_following_post.add(post);
    }


    //constructor
    public Buyer_HomePage() {
        //frame
        this.setTitle("Buyer Home");
        this.setSize(500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //creating footer to use
        Buyer_Footer footer = new Buyer_Footer();

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


        //adding the footer to frame
        this.add(footer);



        //*



        //adding following_page() to footer
        footer.add(following_page(),BorderLayout.CENTER);
        //printing grid
        print_following_grid();
        //allows the frame to be seen
        this.setVisible(true);
    }








    //main page
    private JPanel following_page(){
        //creating following_page to hold all components
        JPanel following_page = new JPanel();
        //layout
        following_page.setLayout(new BoxLayout(following_page, BoxLayout.Y_AXIS));
        //size
        following_page.setPreferredSize(new Dimension(500,800));
        //color
        //following_page.setBackground(Color.RED);


        //this panel will hold the orders
        following_grid = new JPanel();
        //layout, all orders will be stacked
        following_grid.setLayout(new BoxLayout(following_grid, BoxLayout.Y_AXIS));

        //creating JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(following_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to following_page
        following_page.add(jsp);

        return following_page;
    }








    //print following_grid
    private void print_following_grid(){
        //clears all buttons from following_grid
        following_grid.removeAll();
        //if all_following_post has a post
        if( all_following_post != null && !all_following_post.isEmpty()) {



            for (int i = 0; i < all_following_post.size(); i++) {
                //creating JPanel
                JPanel post = all_following_post.get(i);
                //size
                post.setPreferredSize(new Dimension(500,460));
                //adding post (JPanel) to following_grid
                following_grid.add(post);
            }

        }else{
            System.out.println("you don't follow any one");

            //System.out.println("Sorry no brand found");
            //creating label
            JLabel text  = new JLabel("you don't follow any account yet");
            //text color
            text.setForeground(Color.RED);
            //adding to grid
            following_grid.add(text);
        }

        //relays components
        following_grid.revalidate();
        //visual refresh
        following_grid.repaint();
    }







    //actions for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        //Switch to Search page
        if(e.getSource() == button_search){
            System.out.println("your search button pressed");
            dispose();
            new Buyer_SearchPage();
        }
        //Switch to Cart page
        if(e.getSource() == button_cart){
            System.out.println("your cart button pressed");
            dispose();
            new Buyer_CartPage();
        }
        //Switch to Home page
        if(e.getSource() == button_Home){
            System.out.println("your home button pressed");
            dispose();
            new Buyer_HomePage();
        }
        //Switch to Discover button
        if(e.getSource() == button_discover){
            System.out.println("your discover button pressed");
            dispose();
            new Buyer_DiscoverPage();
        }
        //Switch to Like page
        if(e.getSource() == button_like){
            System.out.println("your like button pressed");
            dispose();
            new Buyer_LikedPage();

        }
        //Switch to Settings page
        if(e.getSource() == button_settings){
            System.out.println("your settings button pressed");
            dispose();
            new Buyer_settings();
        }

    }

}

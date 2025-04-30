package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buyer_DiscoverPage extends JFrame implements ActionListener {

    //footer buttons
    JButton button_search;
    JButton button_cart;
    JButton button_Home;
    JButton button_discover;
    JButton button_like;
    JButton button_settings;

    //arraylist that holds all post... that will be on the discover page
    private final ArrayList<JPanel> all_discover_post = new ArrayList<>();

    //JPanel that will hold all the post
    JPanel discover_grid;


    //constructor
    public Buyer_DiscoverPage() {
        //frame
        this.setTitle("Buyer Discover");
        this.setSize(500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //create footer to use
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

        //adding footer to frame
        this.add(footer);


        //*


        //adding discover_page() to footer
        footer.add(discover_page(),BorderLayout.CENTER);
        //printing grid
        print_discover_grid();
        this.setVisible(true);
    }


    //main page
    private JPanel discover_page(){
        //creating discover_page to hold everything
        JPanel discover_page = new JPanel(new BorderLayout());
        //size
        discover_page.setPreferredSize(new Dimension(500,800));
        //color
        //discover_page.setBackground(Color.RED);

        //this panel will hold the orders
        discover_grid = new JPanel();
        discover_grid.setPreferredSize(new Dimension(500,all_discover_post.size()/3*180));
        //layout
        discover_grid.setLayout(new FlowLayout(FlowLayout.LEFT));




        //craeing JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(discover_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to discover_page
        discover_page.add(jsp, BorderLayout.CENTER);

        return discover_page;
    }




    //prints discover_grid
    public void print_discover_grid(){
        //clears all buttons from discover_grid
        discover_grid.removeAll();
        //if all_discover_post has any post (JPanels)
        if( all_discover_post != null && !all_discover_post.isEmpty()) {


            for (int i = 0; i < all_discover_post.size(); i++) {
                //creating JPanel
                JPanel post = all_discover_post.get(i);
                //size
                post.setPreferredSize(new Dimension(160, 160));
                //adding post (JPanel) to discover_grid
                discover_grid.add(post);
            }

        }else{

            System.out.println("No posts found");
            //System.out.println("Sorry no brand found");
            //creating label
            JLabel text  = new JLabel("No posts found");
            //text color
            text.setForeground(Color.RED);
            //adding to grid
            discover_grid.add(text);
        }

        //relays components
        discover_grid.revalidate();
        //visual refresh
        discover_grid.repaint();
    }




    //action for footer buttons
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
            print_discover_grid();
            discover_grid.revalidate();
            discover_grid.repaint();


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

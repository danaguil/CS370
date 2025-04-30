package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buyer_SearchPage extends JFrame implements ActionListener  {

    //footer buttons
    JButton button_search;
    JButton button_cart;
    JButton button_Home;
    JButton button_discover;
    JButton button_like;
    JButton button_settings;

    //array to hold result if found... if what users are looking for is found it is place in here
    private final ArrayList<JButton> all_results = new ArrayList<>();

    //will panel that will hold the results
    JPanel search_grid;


    //testing
    ArrayList<String> random_brand_names = new ArrayList<>();



    //constructor
    public Buyer_SearchPage() {
        //frame
        this.setTitle("Buyer Search");
        this.setSize(500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        //Get Buyer Footer
        Buyer_Footer footer = new Buyer_Footer();

        //create/get footer buttons
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



        random_brand_names.add("AAA");
        random_brand_names.add("BBB");
        random_brand_names.add("CCC");
        random_brand_names.add("DDD");
        random_brand_names.add("EEE");
        random_brand_names.add("FFF");
        random_brand_names.add("GGG");
        random_brand_names.add("HHH");
        random_brand_names.add("III");

        //adding footer to the frame
        this.add(footer);
        //adding Search to footer
        footer.add(Search(random_brand_names),BorderLayout.CENTER);
        this.setVisible(true);
    }


    //main page
    public JPanel Search(ArrayList<String> brands){
        //search_page that will hold all components
        JPanel search_page = new JPanel();
        //layout
        search_page.setLayout(new BorderLayout());
        //search_page.setBackground(Color.orange);

        //hold the search components... textfield and button
        JPanel search_panel = new JPanel();
        //search_panel.setBackground(Color.MAGENTA);
        //size of search panel
        search_panel.setPreferredSize(new Dimension(500,40));
        //text field for user to enter the brand that user is looking for
        JTextField searchforthisbrand = new JTextField(20);
        //creating button
        JButton search_button = new JButton("search");



        //adding to search_panel
        //textfield
        search_panel.add(searchforthisbrand);
        //button
        search_panel.add(search_button);

        //creating grid that will hold results
        search_grid = new JPanel();
        //grid.setBackground(Color.YELLOW);


        //action for search_button
        search_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //System.out.println(":)");
                //the brand we are looking for grabbed from the JTextField
                String brand_name = searchforthisbrand.getText();
                //clear all_results
                all_results.clear();

                //looking for the brandname, if found will add a button to arraylist "all_results"
                for(int i = 0; i < brands.size(); i++){
                    if (brands.get(i).equals(brand_name)){
                        JButton result  = new JButton(brands.get(i));
                        //adding to arraylist
                        all_results.add(result);

                    }
                }
                //printing out grid
                print_search_grid();

            }
        });

        //adding to search_page
        //search_panel
        search_page.add(search_panel, BorderLayout.NORTH);
        //grid
        search_page.add(search_grid, BorderLayout.CENTER);

        return search_page;
    }









    //shows the newest grid
    private void print_search_grid(){
        //clears grid
        search_grid.removeAll();
        //if all_results has a button
        if(!all_results.isEmpty()) {

            for (JButton result_button : all_results) {
                //size
                result_button.setPreferredSize(new Dimension(500, 100));
                //adding to grid
                search_grid.add(result_button);
            }

        }else{
            //System.out.println("Sorry no brand found");
            //creating label
            JLabel text  = new JLabel("No results found");
            //text color
            text.setForeground(Color.RED);
            //adding to grid
            search_grid.add(text);

        }

        //relays component
        search_grid.revalidate();
        //visual refresh
        search_grid.repaint();
    }










/*
    private JButton convert_to_button(Brand user, JPanel profilepage){
        JButton button = new JButton(user.getBrand_name());


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,profilepage," ", JOptionPane.PLAIN_MESSAGE);
            }
        });

        return button;
    }

 */



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

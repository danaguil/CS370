package UGT_UI;

import UGT_Controllers.SearchController;
import UGT_Controllers.UserInteractions;
import UGT_Data.Brand;
import UGT_Data.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static UGT_Data.Brand.getBrandUsernameById;

public class Buyer_SearchPage extends JPanel implements ActionListener {


    //array to hold result if found... if what users are looking for is found it is place in here
    private final ArrayList<JButton> all_results = new ArrayList<>();

    //will panel that will hold the results
    JPanel search_grid;


    //testing
    ArrayList<String> random_brand_names = new ArrayList<>();


    //constructor
    public Buyer_SearchPage() {
        Buyer_SearchPage.setInstance(this);

        this.setLayout(new BorderLayout());


        random_brand_names.add("AAA");
        random_brand_names.add("BBB");
        random_brand_names.add("CCC");
        random_brand_names.add("DDD");
        random_brand_names.add("EEE");
        random_brand_names.add("FFF");
        random_brand_names.add("GGG");
        random_brand_names.add("HHH");
        random_brand_names.add("III");

        this.add(Search(random_brand_names), BorderLayout.CENTER);

    }
    static Item item2 = null;

    public static JPanel BrandPopUp(Brand brand) {
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));
        profilePanel.setBackground(Color.WHITE);
        profilePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Brand name (big header)
        JLabel brandNameLabel = new JLabel(brand.getBrand_name());
        brandNameLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        brandNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePanel.add(brandNameLabel);

        // Bio or description
        JTextArea bioArea = new JTextArea(brand.getBrand_description() != null ? brand.getBrand_description() : "No bio yet.");
        bioArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        bioArea.setLineWrap(true);
        bioArea.setWrapStyleWord(true);
        bioArea.setEditable(false);
        bioArea.setOpaque(false);
        bioArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        profilePanel.add(bioArea);

        // Divider
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(400, 1));
        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        profilePanel.add(separator);

        // Section title
        JLabel uploadsTitle = new JLabel("Recent Uploads:");
        uploadsTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
        uploadsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        profilePanel.add(uploadsTitle);

        // Display uploaded items (icons or names)
        JPanel itemsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemsPanel.setBackground(Color.WHITE);

        for (Item item : brand.getBrandItems()) {
            item2 = item;
            ImageIcon icon = new ImageIcon(item.getImagePath());
            Image scaledImg = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            JButton itemButton = new JButton(new ImageIcon(scaledImg));
            itemButton.setToolTipText(item.getName());
            itemButton.setPreferredSize(new Dimension(80, 80));
            itemButton.setBorder(BorderFactory.createEmptyBorder());
            itemButton.setContentAreaFilled(false);

            itemButton.addActionListener(e -> {
                String brandName = getBrandUsernameById(item.getBrandId());
                String desc = item.getDescription();
                String photoPath = item.getImagePath();
                String price = String.valueOf(item.getPrice());
                String size = item.getSize();

                JPanel itemPopUp = new Buyer_HomePage().PostPopUp(brandName, desc, photoPath, price, size, item);
                JOptionPane.showMessageDialog(null, itemPopUp, "Item Details", JOptionPane.PLAIN_MESSAGE);
            });

            itemsPanel.add(itemButton);
        }

        profilePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        profilePanel.add(itemsPanel);

        // Follow button
        JButton followButton = new JButton("Follow");
        followButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        followButton.addActionListener(e -> {
            // Insert logic to follow brand
            System.out.println("Followed brand: " + brand.getBrand_name());
            UserInteractions.followFunction(item2);
            Buyer_Pages.getHomePage().refreshHomePage();
        });
        profilePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        profilePanel.add(followButton);

        return profilePanel;
    }


    private static JTextField searchforthisbrand;

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
        searchforthisbrand = new JTextField(20);
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
        search_button.addActionListener(e -> {

            SearchController searchController = new SearchController();

            searchController.search();

            /*
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
            */
        });

        //adding to search_page
        //search_panel
        search_page.add(search_panel, BorderLayout.NORTH);
        //grid
        search_page.add(search_grid, BorderLayout.CENTER);

        return search_page;

    }


    public static String getSearchedText(){
        return searchforthisbrand.getText();
    }


    public static Buyer_SearchPage instance;

    public static void setInstance(Buyer_SearchPage page) {
        instance = page;
    }

    public static void clearResults() {
        if (instance != null) {
            instance.search_grid.removeAll();
            instance.search_grid.revalidate();
            instance.search_grid.repaint();
        }
    }

    public static void showSearchResult(JComponent resultComponent) {
        if (instance != null) {
            resultComponent.setPreferredSize(new Dimension(500, 100)); // adjust as needed
            instance.search_grid.add(resultComponent);
            instance.search_grid.revalidate();
            instance.search_grid.repaint();
        }
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




    }





}

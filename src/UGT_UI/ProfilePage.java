package UGT_UI;

import UGT_Controllers.*;
import UGT_Data.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ProfilePage extends JPanel implements ActionListener {


    // Brand Header Components
    JLabel brand_name_label;
    JTextArea brand_description_label;
    JLabel brand_insta_label;
    JLabel brand_tiktok_label;

    Brand currentBrand = programSession.getLoggedInBrand();


    public ProfilePage(){
        this.setLayout(new BorderLayout());
        this.add(getProfilePanel(), BorderLayout.CENTER);

        refreshProfilePage();
    }


    // ArrayList to hold all buttons
    ArrayList<JButton> all_myposts = new ArrayList<>();
    // Will hold all that all_post
    JLayeredPane post_grid;



    // Create the Profile Panel with all Brand Elements and Posts
    private JPanel getProfilePanel(){

        // Creates Profile Panel
        JPanel profile_panel = new JPanel();
        profile_panel.setSize(500,600);
        profile_panel.setLayout(new BorderLayout());
        profile_panel.setBackground(Color.WHITE);
        profile_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        profile_panel.add(getProfileHeader(), BorderLayout.NORTH);



        //-------------------------------------------------------post grid
        //JPanel to hold all the post made by brand
        //creating JPanel
        post_grid = new JLayeredPane();
        //Layout 0 = rows (dynamic) 3 = cols
        post_grid.setBounds(100, 100, 400, 400);
        post_grid.setBorder(BorderFactory.createLineBorder(Color.black));
        post_grid.setLayout(new GridLayout(0,3));

        //creating JScrollPane ---> jsp
        //making post_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(post_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //ADDING JSP TO CARDPROFILE
        profile_panel.add(jsp);

        return profile_panel;
    }

    // Panel that holds the Brand Profile Picture, Name, Social Link, and Description
    private JPanel getProfileHeader(){
        // Create Profile Header and set its Characteristics
        JPanel profile_header = new JPanel();
        profile_header.setSize(500, 200);
        profile_header.setBackground(Color.BLACK);
//        profile_header.setBorder(BorderFactory.createLineBorder(Color.black));
        profile_header.setLayout(new BorderLayout());

        profile_header.add(brandElements(currentBrand.getBrand_name(), currentBrand.getBrand_description(), currentBrand.getInstagram_name(), currentBrand.getTiktok_name()), BorderLayout.EAST);
        profile_header.add(brandPicture(currentBrand.getBrand_image()), BorderLayout.WEST);


        return profile_header;
    }

    // Panel to Hold the Brand Name, Social Link, and Description
    private JPanel brandElements(String name, String description, String instagram_link, String tiktok_link){
        JPanel elements = new JPanel();
        elements.setPreferredSize(new Dimension(300, 200));
        elements.setLayout(null);
        elements.setBackground(Color.WHITE);

        // Create Element Labels
        brand_name_label = new JLabel(name);
        brand_name_label.setBounds(10, 20, 210, 20);
        brand_name_label.setBackground(Color.WHITE);
        brand_name_label.setOpaque(true);

        brand_insta_label = new JLabel(instagram_link);
        brand_insta_label.setBounds(10, 50, 210, 20);
        brand_insta_label.setBackground(Color.WHITE);
        brand_insta_label.setOpaque(true);

        brand_tiktok_label = new JLabel(tiktok_link);
        brand_tiktok_label.setBounds(10, 80, 210, 20);
        brand_tiktok_label.setBackground(Color.WHITE);
        brand_tiktok_label.setOpaque(true);

        brand_description_label = new JTextArea(description);
        brand_description_label.setBounds(10, 100,210, 100);
        brand_description_label.setEditable(false);
        brand_description_label.setLineWrap(true);
        brand_description_label.setWrapStyleWord(true);
        brand_description_label.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        // Add Brand Elements to Element Panel
        elements.add(brand_name_label, BorderLayout.NORTH);
        elements.add(brand_insta_label, BorderLayout.CENTER);
        elements.add(brand_tiktok_label, BorderLayout.CENTER);
        elements.add(brand_description_label, BorderLayout.SOUTH);


        return elements;
    }

    // Panel that holds the Brand Profile Picture
    private JPanel brandPicture(String profile_picture_path){
        JPanel picture = new JPanel();
        picture.setPreferredSize(new Dimension(200, 250));
        picture.setLayout(new BorderLayout());
        picture.setBackground(Color.WHITE);

        ImageIcon brand_image = new ImageIcon(profile_picture_path);
        brand_image.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel image = new JLabel(brand_image);
        picture.add(image, BorderLayout.CENTER);

        return picture;
    }




    //---------------------------------------------------print_grid for post (buttons)
    public void print_grid(){

        //clears all buttons from post_grid
        post_grid.removeAll();
        //if all_posts has a post
        if( all_myposts != null && !all_myposts.isEmpty()) {
            for (int i = 0; i < all_myposts.size(); i++) {
                //creating JButton
                JButton post = all_myposts.get(i);
                //size
                post.setPreferredSize(new Dimension(100,100));
                //adding JButton (post) to post_grid
                post_grid.add(post);
            }

        }else{
            System.out.println("Sorry this brand has no post");
        }

        //relays componenets
        post_grid.revalidate();
        //visual refresh
        post_grid.repaint();


    }

    public void refreshProfilePage(){
        all_myposts.clear();
        // Gets all items from teh hashmap
        for(Item item : currentBrand.getBrandItems()){
            if(item.getClass() == Tops.class){
                String brand_name = currentBrand.getBrand_name();

                JButton postButton = topPost(item.getImagePath(), brand_name, item.getItemId());
                add_to_profile(postButton);

            } else if(item.getClass() == Bottoms.class){
                String brand_name = currentBrand.getBrand_name();

                JButton postButton = bottomPost(item.getImagePath(), brand_name, item.getItemId());
                add_to_profile(postButton);
            } else if(item.getClass() == Shoes.class){
                String brand_name = currentBrand.getBrand_name();

                JButton postButton = shoePost(item.getImagePath(), brand_name, item.getItemId());
                add_to_profile(postButton);
            }
        }
        print_grid();
    }

    private JButton topPost(String image_path, String brand_name, String itemID){
        JButton post = new JButton();
        ImageIcon path = new ImageIcon(image_path);
        JLabel image = new JLabel(path);
        post.add(image);

        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.getWindowAncestor(ProfilePage.this);
                JOptionPane.showMessageDialog(window, TopPopUp(brand_name, itemID), " ", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return post;
    }

    private JButton bottomPost(String image_path, String brand_name, String itemID){
        JButton post = new JButton();
        ImageIcon path = new ImageIcon(image_path);
        JLabel image = new JLabel(path);
        post.add(image);

        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.getWindowAncestor(ProfilePage.this);
                JOptionPane.showMessageDialog(window, BottomPopUp(brand_name, itemID), " ", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return post;
    }

    private JButton shoePost(String image_path, String brand_name, String itemID){
        JButton post = new JButton();
        ImageIcon path = new ImageIcon(image_path);
        JLabel image = new JLabel(path);
        post.add(image);

        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.getWindowAncestor(ProfilePage.this);
                JOptionPane.showMessageDialog(window, ShoePopUp(brand_name, itemID), " ", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return post;
    }



    //-----------------------------------------------------------------add_to_profile
    //adds a post (button) to all_myposts
    private void add_to_profile(JButton button){
        //adding post to all_post (list array)
        all_myposts.add(button);
    }

    private JPanel TopPopUp(String brandName, String itemID){
        // Creating a panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(300, 500);
        panel.setLayout(null);


        Tops top = populateProgram.topsItemMap.get(itemID);

        if(top != null){

            JLabel brand_name = new JLabel(brandName);
            brand_name.setBounds(100, 10, 100, 20);

            ImageIcon item_image = new ImageIcon(top.getImagePath());
            JLabel image_label = new JLabel(item_image);
            image_label.setBounds(25, 30, 250, 100);

            JLabel item_name = new JLabel("Name: " + top.getName());
            item_name.setBounds(25, 140, 100, 20);

            JLabel item_type = new JLabel("Item Type: " + top.getTopType());
            item_type.setBounds(150, 140, 100, 20);

            JLabel item_price = new JLabel("Price: " + top.getPrice());
            item_price.setBounds(150, 170, 100, 20);

            JLabel item_size = new JLabel("Size: " + top.getSize());
            item_size.setBounds(25, 170, 100, 20);

            JLabel item_color = new JLabel("Color: " + top.getColor());
            item_color.setBounds(25, 200, 100, 20);

            JLabel chest_size = new JLabel("Chest Size: " + top.getChest_size());
            chest_size.setBounds(150, 200, 100, 20);

            JLabel hem_size = new JLabel("Hem Size: " + top.getHemSize());
            hem_size.setBounds(25, 230, 100, 20);

            JLabel sleeve_length = new JLabel("Sleeve Length: " + top.getsleeveLength());
            sleeve_length.setBounds(150, 230, 100, 20);

            JLabel item_description = new JLabel("Description: " + top.getDescription());
            item_description.setBounds(25, 260, 225, 50);


            panel.add(image_label);
            panel.add(item_name);
            panel.add(item_type);
            panel.add(item_price);
            panel.add(item_size);
            panel.add(item_color);
            panel.add(chest_size);
            panel.add(hem_size);
            panel.add(sleeve_length);
            panel.add(item_description);
            panel.add(brand_name);

        }

        return panel;
    }

    private JPanel BottomPopUp(String brandName, String itemID){
        // Creating a panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(300, 500);
        panel.setLayout(null);


        Bottoms bottom = populateProgram.bottomsItemMap.get(itemID);

        if(bottom != null){
            JLabel brand_name = new JLabel(brandName);
            brand_name.setBounds(100, 10, 100, 20);

            ImageIcon item_image = new ImageIcon(bottom.getImagePath());
            JLabel image_label = new JLabel(item_image);
            image_label.setBounds(25, 30, 250, 100);

            JLabel item_name = new JLabel("Name: " + bottom.getName());
            item_name.setBounds(25, 140, 100, 20);

            JLabel item_type = new JLabel("Item Type: " + bottom.getBottomType());
            item_type.setBounds(150, 140, 100, 20);

            JLabel item_price = new JLabel("Price: " + bottom.getPrice());
            item_price.setBounds(150, 170, 100, 20);

            JLabel item_size = new JLabel("Size: " + bottom.getSize());
            item_size.setBounds(25, 170, 100, 20);

            JLabel item_color = new JLabel("Color: " + bottom.getColor());
            item_color.setBounds(25, 200, 100, 20);

            JLabel length = new JLabel("Length: " + bottom.getLength());
            length.setBounds(150, 200, 100, 20);

            JLabel waist_size = new JLabel("Waist Size: " + bottom.getWaistSize());
            waist_size.setBounds(25, 230, 100, 20);

            JLabel inseam_size = new JLabel("Inseam: " + bottom.getInseam());
            inseam_size.setBounds(150, 230, 100, 20);

            JLabel rise_size = new JLabel("Rise: " + bottom.getRise());
            rise_size.setBounds(25, 260, 100, 20);

            JLabel item_description = new JLabel(bottom.getDescription());
            item_description.setBounds(25, 290, 225, 50);


            panel.add(image_label);
            panel.add(item_name);
            panel.add(item_type);
            panel.add(item_price);
            panel.add(item_size);
            panel.add(item_color);
            panel.add(length);
            panel.add(waist_size);
            panel.add(inseam_size);
            panel.add(rise_size);
            panel.add(brand_name);

        }

        return panel;
    }

    private JPanel ShoePopUp(String brandName, String itemID){
        // Creating a panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(300, 500);
        panel.setLayout(null);


        Shoes shoes = populateProgram.shoesMap.get(itemID);

        if(shoes != null){
            JLabel brand_name = new JLabel(brandName);
            brand_name.setBounds(100, 10, 100, 20);

            ImageIcon item_image = new ImageIcon(shoes.getImagePath());
            JLabel image_label = new JLabel(item_image);
            image_label.setBounds(25, 30, 250, 100);

            JLabel item_name = new JLabel("Name: " + shoes.getName());
            item_name.setBounds(25, 140, 100, 20);

            JLabel item_type = new JLabel("Item Type: " + shoes.getshoesType());
            item_type.setBounds(150, 140, 100, 20);

            JLabel item_price = new JLabel("Price: " + shoes.getPrice());
            item_price.setBounds(150, 170, 100, 20);

            JLabel item_size = new JLabel("Size: " + shoes.getSize());
            item_size.setBounds(25, 170, 100, 20);

            JLabel item_color = new JLabel("Color: " + shoes.getColor());
            item_color.setBounds(25, 200, 100, 20);

            JLabel item_description = new JLabel(shoes.getDescription());
            item_description.setBounds(25, 230, 225, 50);



            panel.add(image_label);
            panel.add(item_name);
            panel.add(item_type);
            panel.add(item_price);
            panel.add(item_size);
            panel.add(item_color);
            panel.add(item_description);
            panel.add(brand_name);

        }

        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }








}
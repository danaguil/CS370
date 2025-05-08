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

    private JPanel TopPopUp(String brandName, String itemID) {
        Tops top = populateProgram.topsItemMap.get(itemID);
        if (top == null) return new JPanel(); // fallback

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Brand name header
        JLabel brandLabel = new JLabel(brandName);
        brandLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        brandLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(brandLabel);
        panel.add(Box.createVerticalStrut(10));

        // Image
        ImageIcon icon = new ImageIcon(top.getImagePath());
        Image scaled = icon.getImage().getScaledInstance(200, 260, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(imageLabel);
        panel.add(Box.createVerticalStrut(15));

        // Info labels
        panel.add(makeInfoLabel("Name: " + top.getName()));
        panel.add(makeInfoLabel("Type: " + top.getTopType()));
        panel.add(makeInfoLabel("Price: $" + top.getPrice()));
        panel.add(makeInfoLabel("Size: " + top.getSize()));
        panel.add(makeInfoLabel("Color: " + top.getColor()));
        panel.add(makeInfoLabel("Chest Size: " + top.getChest_size()));
        panel.add(makeInfoLabel("Hem Size: " + top.getHemSize()));
        panel.add(makeInfoLabel("Sleeve Length: " + top.getsleeveLength()));
        panel.add(Box.createVerticalStrut(10));

        // Description (wrap in JTextArea for multi-line)
        JTextArea descArea = new JTextArea("Description: " + top.getDescription());
        descArea.setWrapStyleWord(true);
        descArea.setLineWrap(true);
        descArea.setEditable(false);
        descArea.setOpaque(false);
        descArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(descArea);

        return panel;
    }

    // Helper for consistent label style
    private JLabel makeInfoLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.PLAIN, 13));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JPanel BottomPopUp(String brandName, String itemID) {
        Bottoms bottom = populateProgram.bottomsItemMap.get(itemID);
        if (bottom == null) return new JPanel(); // fallback panel

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Brand name
        JLabel brandLabel = new JLabel(brandName);
        brandLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        brandLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(brandLabel);
        panel.add(Box.createVerticalStrut(10));

        // Scaled item image
        ImageIcon icon = new ImageIcon(bottom.getImagePath());
        Image scaled = icon.getImage().getScaledInstance(200, 260, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(imageLabel);
        panel.add(Box.createVerticalStrut(15));

        // Info labels
        panel.add(makeInfoLabel("Name: " + bottom.getName()));
        panel.add(makeInfoLabel("Type: " + bottom.getBottomType()));
        panel.add(makeInfoLabel("Price: $" + bottom.getPrice()));
        panel.add(makeInfoLabel("Size: " + bottom.getSize()));
        panel.add(makeInfoLabel("Color: " + bottom.getColor()));
        panel.add(makeInfoLabel("Length: " + bottom.getLength()));
        panel.add(makeInfoLabel("Waist: " + bottom.getWaistSize()));
        panel.add(makeInfoLabel("Inseam: " + bottom.getInseam()));
        panel.add(makeInfoLabel("Rise: " + bottom.getRise()));
        panel.add(Box.createVerticalStrut(10));

        // Description
        JTextArea descArea = new JTextArea("Description: " + bottom.getDescription());
        descArea.setWrapStyleWord(true);
        descArea.setLineWrap(true);
        descArea.setEditable(false);
        descArea.setOpaque(false);
        descArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(descArea);

        return panel;
    }


    private JPanel ShoePopUp(String brandName, String itemID) {
        Shoes shoes = populateProgram.shoesMap.get(itemID);
        if (shoes == null) return new JPanel(); // fallback

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Brand name
        JLabel brandLabel = new JLabel(brandName);
        brandLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        brandLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(brandLabel);
        panel.add(Box.createVerticalStrut(10));

        // Scaled image
        ImageIcon icon = new ImageIcon(shoes.getImagePath());
        Image scaled = icon.getImage().getScaledInstance(250, 160, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(imageLabel);
        panel.add(Box.createVerticalStrut(15));

        // Shoe info labels
        panel.add(makeInfoLabel("Name: " + shoes.getName()));
        panel.add(makeInfoLabel("Type: " + shoes.getshoesType()));
        panel.add(makeInfoLabel("Price: $" + shoes.getPrice()));
        panel.add(makeInfoLabel("Size: " + shoes.getSize()));
        panel.add(makeInfoLabel("Color: " + shoes.getColor()));
        panel.add(Box.createVerticalStrut(10));

        // Description
        JTextArea descArea = new JTextArea("Description: " + shoes.getDescription());
        descArea.setWrapStyleWord(true);
        descArea.setLineWrap(true);
        descArea.setEditable(false);
        descArea.setOpaque(false);
        descArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
        panel.add(descArea);

        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }








}
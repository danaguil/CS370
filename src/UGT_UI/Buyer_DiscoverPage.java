package UGT_UI;

import UGT_Controllers.UserInteractions;
import UGT_Controllers.populateProgram;
import UGT_Data.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import java.util.List;

import static UGT_Data.Brand.getBrandUsernameById;

public class Buyer_DiscoverPage extends JPanel implements ActionListener {

    File barlitosPhoto = new File("src/barlitos.jpg");



    //arraylist that holds all post... that will be on the discover page
    //button... button can be pressed to show actual post
    private final ArrayList<JButton> all_discover_post = new ArrayList<>();

    //method to add JPanel to all_discover_post
    public void add_post_to_discover(JButton button) {
        all_discover_post.add(button);
    }


    //JPanel that will hold all the post
    JPanel discover_grid = null;

    //constructor
    //get img path
    public Buyer_DiscoverPage() {
        this.setLayout(new BorderLayout());

        this.add(discover_page(), BorderLayout.CENTER);

        refreshDiscoverPage();
    }


    public void refreshDiscoverPage() {
        all_discover_post.clear();
        // gets all items from the hashmap
        List<Item> allItems = new ArrayList<>(populateProgram.itemMap.values());
        Collections.shuffle(allItems); // shuffles them randomly

        int numberOfItems = Math.min(allItems.size(), 10); // 10 or fewer

        List<Item> randomItems = allItems.subList(0, numberOfItems); // gets the first 10 items

        //  Goes through the list of items and creates a button for each one.
        for (Item item : randomItems) {
            // gets information from the item class
            String brandName = getBrandUsernameById(item.getBrandId());
            String desc = item.getDescription();
            String photoPath = item.getImagePath(); // Assuming it's a path or ImageIcon source
            String price = String.valueOf(item.getPrice());

            // creates a button with the item's information
            JButton postButton = post(brandName, desc, photoPath, price,item);
            add_post_to_discover(postButton);
        }
        print_discover_grid();
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


    //will be using string for img path

    //prints discover_grid
    public void print_discover_grid(){
        //clears all buttons from discover_grid
        discover_grid.removeAll();
        //if all_discover_post has any post (JPanels)
        if( all_discover_post != null && !all_discover_post.isEmpty()) {


            for (int i = 0; i < all_discover_post.size(); i++) {
                //creating JButton.. user will be able to press button and see the actual post pop up
                JButton post = all_discover_post.get(i);
                //size
                post.setPreferredSize(new Dimension(160, 160));

                //adding post (button)
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



    private JButton post(String brandname, String description, String photo_path, String price, Item item){
        //creating button ---> post
        JButton post = new JButton();
        //adding the image to the button
        ImageIcon path = new ImageIcon(photo_path);
        JLabel img = new JLabel(path);
        //post is a button
        post.add(img);
        //allows users to click on post(button).. once user clicks on post additional information pops up (the actual post)





        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window parentWindow = SwingUtilities.getWindowAncestor(Buyer_DiscoverPage.this);
                JOptionPane.showMessageDialog(parentWindow,PostPopUp(brandname,description,photo_path,price, item)," ",JOptionPane.PLAIN_MESSAGE);

            }
        });

        return post;
    }




    //this will create the actual post (once the button (post) is clicked this pops up)
    private static JPanel PostPopUp(String brandname, String post_description, String photo_path, String price, Item item){

        //creating a panel
        JPanel makeapost = new JPanel();
        makeapost.setBackground(Color.GREEN);
        //makeapost.setBackground(Color.orange);
        //size of the post
        makeapost.setPreferredSize(new Dimension(250,400) );
        makeapost.setLayout(new BoxLayout(makeapost,BoxLayout.Y_AXIS));
        //
        JPanel brandname_banner = new JPanel();
        brandname_banner.setPreferredSize(new Dimension(250,50));
        brandname_banner.setLayout(new GridLayout(1,1));

        JButton brandname_button = new JButton(brandname);
        //so you wont see a rectangle
        brandname_button.setFocusable(false);






        brandname_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("this will show brand's profile");

            }
        });




        //adding the button to the panel
        brandname_banner.add(brandname_button);




        //getting photo
        ImageIcon photo = new ImageIcon(photo_path);
        //resizing photo to fit on photo panel
        Image scaledImage = photo.getImage().getScaledInstance(160,160, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);




        //creating photo label with scaled photo (scaledIcon)
        JLabel photo_label = new JLabel(scaledIcon);

        //creating jpanel for the photo
        JPanel clothing_photo_panel = new JPanel();
        //size of panel
        clothing_photo_panel.setPreferredSize(new Dimension(250,200));
        //clothing_photo_panel.setBackground(Color.green);
        //addint the photo_label to clothing_photo_panel
        clothing_photo_panel.add(photo_label);


        //to hold buttons
        //holds: like, AddCart, Follow
        JPanel button_panel = new JPanel();
        button_panel.setBackground(Color.WHITE);
        //so buttons sit nice, no gaps
        button_panel.setLayout(new GridLayout(1,3));
        //BUTTONS
        JButton like_button = new JButton("like");
        //gets rid of rectangle
        like_button.setFocusable(false);

        like_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserInteractions.likeDislikeFunction(item);

                System.out.println("you clicked like button");
            }
        });

        JButton add_to_cart_button = new JButton("AddCart");
        //gets rid of rectangle
        add_to_cart_button.setFocusable(false);
        //add_to_cart_button.setEnabled(false);


        add_to_cart_button.addActionListener(e -> {
            UserInteractions.addToCart(item);
            System.out.println("you clicked cart button");
        });


        JButton follow_button = new JButton("Follow");
        //gets rid of rectangle
        follow_button.setFocusable(false);








        follow_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserInteractions.followFunction(item);
                Buyer_Pages.getHomePage().refreshHomePage();
                System.out.println("you clicked follow button");
            }
        });


   // work on GUI bug, where item liked isn't removed from there


        //adding to button panel
        button_panel.add(like_button);
        button_panel.add(add_to_cart_button);
        button_panel.add(follow_button);

        //panel to hold description
        JPanel description_panel = new JPanel(); //will hold all the clothing item info
        //description_panel.setBackground(Color.BLUE);
        description_panel.setLayout(new BorderLayout());
        //size of panel
        description_panel.setPreferredSize(new Dimension(250,100));
        //creating JTextArea will hold the actual text
        JTextArea description = new JTextArea("Clothing details: " + post_description + "\n Price:$"+ price, 4,20);
        description.setLineWrap(true);
        description.setEditable(false);
        description.setEditable(false);

        //adding description to description_panel
        description_panel.add(description);


        //adding all objects to makaapost panel
        makeapost.add(brandname_banner);
        makeapost.add(clothing_photo_panel);
        makeapost.add(button_panel);
        makeapost.add(description_panel);


        return makeapost;
    }




    //action for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}

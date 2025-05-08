package UGT_UI;

import UGT_Controllers.UserInteractions;
import UGT_Controllers.populateProgram;
import UGT_Data.Brand;
import UGT_Data.Item;
import UGT_Data.programSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import static UGT_Controllers.populateProgram.brandMap;
import static UGT_Data.Brand.getBrandUsernameById;

public class Buyer_HomePage extends JPanel implements ActionListener {


    File barlitosPhoto = new File("src/barlitos.jpg");



    //array list holds JPanels... the brands newest post "all_following_post"
    private final ArrayList<JPanel> all_following_post = new ArrayList<>();

    //adds a brand to following array list "all_following_post" ... user will now receive the brands newest post now
    public void  add_to_following_post(JPanel post) {
        all_following_post.add(post);
    }


    //JPanel that will hold all the brands (JPanels) the user follows
    JPanel following_grid;


    //constructor
    public Buyer_HomePage() {
        this.setLayout(new BorderLayout());


/*
        for(int i = 0; i < 30; i++){
            JPanel post = PostPopUp("brandpost" + i, "a brand that cares about you", String.valueOf(barlitosPhoto),"89","Xll");
            add_to_following_post(post);
        }
*/

        this.add(following_page(), BorderLayout.CENTER);
    }


    public void refreshHomePage() {
        all_following_post.clear();  // Clear the current post-buttons

        // storing brand id in array
        ArrayList<String> allFollowedBrands = programSession.getLoggedInCustomer().getFollowedBrand();



        for (String brandId : allFollowedBrands) {
            String brandUsername = getBrandUsernameById(brandId);
            if (brandId == null) continue;

            Brand brandClass = brandMap.get(brandUsername);


            ArrayList<Item> brandItems = brandClass.getBrandItems(); // Assuming this method exists

            System.out.println("brandItems size: " + brandItems.size());

            for (Item item : brandItems) {
                System.out.println("brandItems size: " + brandItems.size());

                item = populateProgram.itemMap.get(item.getItemId());
                String brandName = getBrandUsernameById(item.getBrandId());
                String desc = item.getDescription();
                String photoPath = item.getImagePath();
                String price = String.valueOf(item.getPrice());
                String size = item.getSize();

                JPanel post = PostPopUp(brandName, desc, photoPath, price, size, item);
                add_to_following_post(post);
            }
        }
        print_following_grid();
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
        following_grid.setPreferredSize(new Dimension(500, all_following_post.size() *480));
        //layout, all orders will be stacked
        following_grid.setLayout(new FlowLayout(FlowLayout.LEFT));

        //creating JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(following_grid,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

// 👇 Add this line to boost scroll speed
        jsp.getVerticalScrollBar().setUnitIncrement(10);
        //adding jsp to following_page
        following_page.add(jsp);

        return following_page;
    }








    //print following_grid
    public void print_following_grid(){
        following_grid.setPreferredSize(new Dimension(500, all_following_post.size() * 480));

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




    //this will create the actual post (once the button (post) is clicked this pops up)
    public JPanel PostPopUp(String brandname, String post_description, String photo_path, String price, String size, Item item){

        //creating a panel
        JPanel makeapost = new JPanel();
        //makeapost.setBackground(Color.GREEN);
        //makeapost.setBackground(Color.orange);
        //size of the post
        makeapost.setPreferredSize(new Dimension(500,460) );
        makeapost.setLayout(new BoxLayout(makeapost,BoxLayout.Y_AXIS));

        JPanel brandname_banner = new JPanel();
        brandname_banner.setPreferredSize(new Dimension(500,50));
        brandname_banner.setLayout(new GridLayout(1,1));

        JButton brandname_button = new JButton(brandname);
        //so you won't see a rectangle
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
        Image scaledImage = photo.getImage().getScaledInstance(300,300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);


        //creating photo label with scaled photo (scaledIcon)
        JLabel photo_label = new JLabel(scaledIcon);

        //creating jpanel for the photo
        JPanel clothing_photo_panel = new JPanel();
        //size of panel
        clothing_photo_panel.setPreferredSize(new Dimension(300,300));
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
        //like_button.setEnabled(false);



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


        add_to_cart_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserInteractions.addToCart(item);
                System.out.println("you clicked cart button");

            }
        });



        JButton follow_button = new JButton("Follow");
        //gets rid of rectangle
        follow_button.setFocusable(false);
        //follow_button.setEnabled(false);


        follow_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserInteractions.followFunction(item);

                System.out.println("you clicked follow button");
            }
        });



        //adding to button panel
        button_panel.add(like_button);
        button_panel.add(add_to_cart_button);
        button_panel.add(follow_button);

        //panel to hold description
        JPanel description_panel = new JPanel(); //will hold all the clothing item info
        //description_panel.setBackground(Color.BLUE);
        description_panel.setLayout(new BorderLayout());
        //size of panel
        description_panel.setPreferredSize(new Dimension(500,200));
        //creating JTextArea will hold the actual text
        JTextArea description = new JTextArea("Clothing details: " + post_description +"\n Size:" +size + "\n Price:$"+ price, 4,20);
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






    //actions for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {



    }

}

package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;


public class Buyer_LikedPage extends JPanel implements ActionListener {



    File barlitosPhoto = new File("src/barlitos.jpg");



    //array list that hold all of user's liked post
    private final ArrayList<JButton> all_my_liked_post = new ArrayList<>();


    //adds post that user liked to arraylist "all_my_liked_post"
    public void  add_to_all_my_liked_post(JButton post) {
        all_my_liked_post.add(post);
    }



    //Jpanel that holds the grid of like post
    JPanel liked_grid;



    //constructor
    public Buyer_LikedPage() {
        this.setLayout(new BorderLayout());






        for (int i = 0; i < 10; i++) {

            JButton post = post("OBEY","OBEY is a brand founded by American street artist Shepard Fairey in 2001, primarily known for its streetwear and clothing line. ", String.valueOf(barlitosPhoto),"90","XLL");
            add_to_all_my_liked_post(post);


        }


        this.add(like_page(), BorderLayout.CENTER);

    }





    //Main page
    private JPanel like_page(){
        //creating like_page to hold everything
        JPanel like_page = new JPanel(new BorderLayout());
        //size
        like_page.setPreferredSize(new Dimension(500,800));
        //color
        //like_page.setBackground(Color.RED);


        //this panel will hold the orders
        liked_grid = new JPanel();
        liked_grid.setPreferredSize(new Dimension(500,all_my_liked_post.size()/3*180));
        //layout, all orders will be stacked
        //liked_grid.setLayout(new GridLayout(0,3));

        liked_grid.setLayout(new FlowLayout(FlowLayout.LEFT));

        //creating JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(liked_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to like_page
        like_page.add(jsp, BorderLayout.CENTER);

        return like_page;
    }






    //print liked_grid
    public void print_liked_grid(){
        //clears all buttons from liked_grid
        liked_grid.removeAll();
        //if all_my_liked_post has a post
        if( all_my_liked_post != null && !all_my_liked_post.isEmpty()) {


            for (int i = 0; i < all_my_liked_post.size(); i++) {
                //creating JPanel
                JButton post = all_my_liked_post.get(i);
                //size
                post.setPreferredSize(new Dimension(160,160));
                //adding post (JPanel) to liked_grid
                liked_grid.add(post);
            }

        }else{
            System.out.println("you have no liked posts");
            //creating label
            JLabel text  = new JLabel("No Liked Posts");
            //text color
            text.setForeground(Color.RED);
            //adding to grid
            liked_grid.add(text);
        }

        //relays components
        liked_grid.revalidate();
        //visual refresh
        liked_grid.repaint();
    }










    private JButton post(String brandname,String description ,String photo_path,String price,String size){
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
                Window parentWindow = SwingUtilities.getWindowAncestor(Buyer_LikedPage.this);
                JOptionPane.showMessageDialog(parentWindow,PostPopUp(brandname,description,photo_path,price,size)," ",JOptionPane.PLAIN_MESSAGE);

            }
        });

        return post;
    }









    //this will create the actual post (once the button (post) is clicked this pops up)
    private JPanel PostPopUp(String brandname,String post_description ,String photo_path,String price,String size){

        //creating a panel
        JPanel makeapost = new JPanel();
        //makeapost.setBackground(Color.GREEN);
        //makeapost.setBackground(Color.orange);
        //size of the post
        makeapost.setPreferredSize(new Dimension(250,400) );
        makeapost.setLayout(new BoxLayout(makeapost,BoxLayout.Y_AXIS));
        //
        JPanel brandname_banner = new JPanel();
        brandname_banner.setPreferredSize(new Dimension(250,50));
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
        //like_button.setEnabled(false);



        like_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("you clicked like button");

            }
        });





        JButton add_to_cart_button = new JButton("AddCart");
        //gets rid of rectangle
        add_to_cart_button.setFocusable(false);






        add_to_cart_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("you clicked cart button");

            }
        });





        JButton follow_button = new JButton("Follow");
        //gets rid of rectangle
        follow_button.setFocusable(false);




        follow_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        description_panel.setPreferredSize(new Dimension(250,100));
        //creating JTextArea will hold the actual text
        JTextArea description = new JTextArea("Clothing details: " + post_description  + "\n Size:" +size+ "\n Price:$"+ price, 4,20);
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





    //Action for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {




    }




}

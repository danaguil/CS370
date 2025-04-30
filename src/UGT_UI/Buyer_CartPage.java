package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buyer_CartPage extends JFrame implements ActionListener {

    //footer buttons
    JButton button_search;
    JButton button_cart;
    JButton button_Home;
    JButton button_discover;
    JButton button_like;
    JButton button_settings;

    //class buttons
    JButton buy_button;
    JButton remove_button;


    //Cart page constructor
    public Buyer_CartPage() {
        //frame
        this.setTitle("Buyer Cart");
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





        //adding Cart_page() to footer
        footer.add(Cart_page(),BorderLayout.CENTER);
        //printing grid
        print_cart_grid();
        this.setVisible(true);
    }



    //arraylist that holds the users items
    private final ArrayList<JPanel> all_items_in_cart = new ArrayList<>();

    //JPanel that will hold all items (JPanel)
    JPanel cart_grid;

    //method to add to arraylist "all_items_in_cart"
    private void add_to_cart(JPanel cart_item){
        all_items_in_cart.add(cart_item);
    }



    //main page
    private JPanel Cart_page(){
        //creating cart_page to hold all components
        JPanel cart_page = new JPanel();
        cart_page.setLayout(new BoxLayout(cart_page,BoxLayout.Y_AXIS));
        //size
        cart_page.setPreferredSize(new Dimension(500,800));
        //color
        //cart_page.setBackground(Color.RED);



        //creating cart_grid
        cart_grid = new JPanel();
        //layout, all items will be stacked
        cart_grid.setLayout(new BoxLayout(cart_grid, BoxLayout.Y_AXIS));
        //craeing JScrollpane ----> jsp
        //making cart_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(cart_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to cart_page
        cart_page.add(jsp);

        //creating JPanel to hold total information
        JPanel total_panel = new JPanel();
        total_panel.setBackground(Color.LIGHT_GRAY);
        total_panel.setPreferredSize(new Dimension(500,50));
        //creating a label...will hold how much all items are
        JLabel total_label = new JLabel("Total: $");
        //adding total_label to total panel
        total_panel.add(total_label);
        //creating button... so that the user can buy all items in cart
        buy_button = new JButton("buy");
        //adding button to total_panel
        total_panel.add(buy_button);

        //if arraylist contains items (JPanels) then display total_panel
        if(!all_items_in_cart.isEmpty()){
            cart_page.add(total_panel);
        }

        return cart_page;
    }


    //prints cart_grid
    public void print_cart_grid(){
        //clears all buttons from cart_grid
        cart_grid.removeAll();
        //if arraylist "all_items_in_cart" has an item (JPanel)
        if( all_items_in_cart != null && !all_items_in_cart.isEmpty()) {

            for (int i = 0; i < all_items_in_cart.size(); i++) {
                //creating JPanel
                JPanel item = all_items_in_cart.get(i);
                //size
                item.setPreferredSize(new Dimension(500,200));
                //adding item (JPanel) to cart_grid
                cart_grid.add(item);
            }

        }else{
            System.out.println("cart is empty");

            //System.out.println("Sorry no brand found");
            //creating label
            JLabel text  = new JLabel("cart is empty");
            //text color
            text.setForeground(Color.RED);
            //adding to cart_grid
            cart_grid.add(text);
        }

        //relays components
        cart_grid.revalidate();
        //visual refresh
        cart_grid.repaint();
    }




//String photo,String clothing_item, String color, String size, String price

    //String photooo
    public JPanel cart_item(){
        JPanel item_block = new JPanel();
        item_block.setLayout(new BorderLayout());
        //item_block.setLayout();
        item_block.setBackground(Color.MAGENTA);
        item_block.setPreferredSize(new Dimension(500,200));
        //JLabel TEXT = new JLabel("Item");
        //item_block.add(TEXT);



/*
        //getting photo
        ImageIcon photo = new ImageIcon(photooo);
        //resizing photo to fit on photo panel
        Image scaledImage = photo.getImage().getScaledInstance(250,200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
*/

/*
        //creating photo label with scaled photo (scaledIcon)
        JLabel photo_label = new JLabel(scaledIcon);

        //creating jpanel for the photo
        JPanel clothing_photo_panel = new JPanel();
        //size of panel
        clothing_photo_panel.setPreferredSize(new Dimension(250,200));
        //adding photo_label
        clothing_photo_panel.add(photo_label);
        //to the left side

     */

        JPanel clothing_photo_panel = new JPanel();
        clothing_photo_panel.setPreferredSize(new Dimension(250,200));
        clothing_photo_panel.setBackground(Color.MAGENTA);

        item_block.add(clothing_photo_panel,BorderLayout.WEST);


        JPanel right_panel = new JPanel();
        right_panel.setPreferredSize(new Dimension(250,200));
        right_panel.setLayout(new BoxLayout(right_panel,BoxLayout.Y_AXIS));

        //panels that will go inside of right panel


        JPanel remove_button_panel = new JPanel();
        remove_button_panel.setBackground(Color.green);
        remove_button_panel.setLayout(new GridLayout(1,1));
        remove_button_panel.setPreferredSize(new Dimension(250,30));
        remove_button = new JButton("remove");

        //remove_button.setPreferredSize(new Dimension(250,50));
        remove_button_panel.add(remove_button);
        right_panel.add(remove_button_panel);

        //panel to hold description
        JPanel description_panel = new JPanel(); //will hold all the clothing item info
        //description_panel.setBackground(Color.BLUE);
        description_panel.setLayout(new BorderLayout());
        //size of panel
        description_panel.setPreferredSize(new Dimension(250,100));
        //creating JTextArea will hold the actual text
        JTextArea description = new JTextArea("Clothing: " +  "\n Color: "  + "\nPrice: "  + "\nSize: ", 4,20);
        description.setEditable(false);
        description_panel.add(description);

        right_panel.add(description_panel);
        //adding right_panel to the right of item_block
        item_block.add(right_panel, BorderLayout.EAST);


        return item_block;
    }


    //footer buttons
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








        //class buttons
        if(e.getSource() == buy_button){
            System.out.println("buy button pressed");
        }
        //class button
        if(e.getSource() == remove_button){
            System.out.println("remove button pressed");
        }


    }

}

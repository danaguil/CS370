package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Buyer_CartPage extends JPanel implements ActionListener {


    //class buttons
    JButton buy_button;

    File barlitosPhoto = new File("src/barlitos.jpg");

    double total_price = 0.00;



    //Cart page constructor
    public Buyer_CartPage() {
        this.setLayout(new BorderLayout());





       JPanel posts = post("danny","a brand that cares", String.valueOf(barlitosPhoto), 10.00);
        add_to_cart(posts);



        JPanel postss = post("paulo","a brand that cares", String.valueOf(barlitosPhoto), 10.00);
        add_to_cart(postss);



        JPanel dayrel = post("carlitos","a brand that cares", String.valueOf(barlitosPhoto), 20.00);
        add_to_cart(dayrel);



        JPanel postssss = post("barlitos","a brand that cares", String.valueOf(barlitosPhoto), 10.00);
        add_to_cart(postssss);


        this.add(Cart_page(), BorderLayout.CENTER);
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
        cart_grid.setPreferredSize(new Dimension(500, all_items_in_cart.size() *220));
        //layout, all items will be stacked
        cart_grid.setLayout(new FlowLayout(FlowLayout.LEFT));
        //craeing JScrollpane ----> jsp
        //making cart_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(cart_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to cart_page
        cart_page.add(jsp);

        //creating JPanel to hold total information


        /*
        JPanel total_panel = new JPanel();
        total_panel.setBackground(Color.LIGHT_GRAY);
        total_panel.setPreferredSize(new Dimension(500,50));
        //creating a label...will hold how much all items are
        JLabel total_label = new JLabel("Total: $" + total_price);
        //adding total_label to total panel
        total_panel.add(total_label);
        //creating button... so that the user can buy all items in cart
        buy_button = new JButton("buy");
        //adding button to total_panel
        total_panel.add(buy_button);

         */






/*
        //if arraylist contains items (JPanels) then display total_panel
        if(!all_items_in_cart.isEmpty()){
            cart_page.add(total_panel);
        }

 */

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
                if (i == all_items_in_cart.size() - 1) {

                    JPanel total_panel = new JPanel();
                    total_panel.setBackground(Color.LIGHT_GRAY);
                    total_panel.setPreferredSize(new Dimension(500,50));
                    //creating a label...will hold how much all items are
                    JLabel total_label = new JLabel("Total: $" + total_price);
                    //adding total_label to total panel
                    total_panel.add(total_label);
                    //creating button... so that the user can buy all items in cart
                    buy_button = new JButton("buy");



                    buy_button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Window parentWindow = SwingUtilities.getWindowAncestor(Buyer_CartPage.this);
                            JOptionPane.showMessageDialog(parentWindow,thank_you()," ",JOptionPane.PLAIN_MESSAGE);
                            all_items_in_cart.clear();
                            System.out.println(all_items_in_cart.size());
                            print_cart_grid();
                            total_price = 0.00;
                        }
                    });






                    //adding button to total_panel
                    total_panel.add(buy_button);
                    cart_grid.add(total_panel);
                }
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


    private JPanel post(String brandname,String description ,String photo_path,double price){
        //creating button ---> post
        JPanel post = new JPanel();
        post.setLayout(new BorderLayout());
        post.setPreferredSize(new Dimension(500,200));




        //adding the image to the button
       // ImageIcon path = new ImageIcon(photo_path);


        //getting photo
        ImageIcon photo = new ImageIcon(photo_path);
        //resizing photo to fit on photo panel
        Image scaledImage = photo.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);


        //img.setPreferredSize(new Dimension(200,200));

        JLabel photo_label = new JLabel(scaledIcon);


        JPanel item_photo = new JPanel();
        item_photo.setPreferredSize(new Dimension(200,200));
        item_photo.add(photo_label);

        post.add(item_photo, BorderLayout.WEST);


        JPanel item_info_panel = new JPanel();
        //item_info_panel.setBackground(Color.GREEN);
       // item_info_panel.setMaximumSize(new Dimension(300,200));
        item_info_panel.setPreferredSize(new Dimension(300,200));

        item_info_panel.setLayout(new BoxLayout(item_info_panel, BoxLayout.Y_AXIS));
        post.add(item_info_panel, BorderLayout.EAST);



        //just a remove button
        JPanel remove_button_panel = new JPanel();
        //remove_button_panel.setBackground(Color.WHITE);
        //remove_button_panel.setMaximumSize(new Dimension(300,30));
        remove_button_panel.setPreferredSize(new Dimension(300,30));
        remove_button_panel.setLayout(new BorderLayout());
        JButton remove_item_button = new JButton("remove");
        remove_button_panel.add(remove_item_button, BorderLayout.CENTER);
       //adding remove_button_panel




        remove_item_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              all_items_in_cart.remove(post);
              print_cart_grid();
            }
        });



        item_info_panel.add(remove_button_panel);


        //will hold brandname + description + price
        JPanel description_panel = new JPanel();
        description_panel.setLayout( new BorderLayout());
        //description_panel.setMaximumSize(new Dimension(300,150));
        description_panel.setPreferredSize(new Dimension(300,150));
        description_panel.setBackground(Color.blue);
        JTextArea text = new JTextArea(brandname + ":" + "\n"+ description);
        text.setLineWrap(true);
        text.setEditable(false);
        //adding to item_info_panel
        description_panel.add(text, BorderLayout.CENTER);
        item_info_panel.add(description_panel);


        JPanel price_panel = new JPanel();
        price_panel.setBackground(Color.WHITE);
        price_panel.setPreferredSize(new Dimension(300,30));
        JLabel price_label = new JLabel("Price: $" + price);

        total_price += price;

        price_panel.add(price_label);
        item_info_panel.add(price_panel);


        post.add(item_info_panel);

        return post;
    }



    private JPanel thank_you(){
        JPanel thank_you_panel = new JPanel();
        thank_you_panel.setLayout(new BorderLayout());
        thank_you_panel.setBackground(Color.WHITE);
        thank_you_panel.setPreferredSize(new Dimension(175,50));


        JTextArea text = new JTextArea("Thank you for shopping with \n UnderGroundThreads :)");
        text.setLineWrap(true);
        text.setEditable(false);
        text.setEditable(false);

        thank_you_panel.add(text, BorderLayout.CENTER);
        return thank_you_panel;
    }




    //footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {



    }

}

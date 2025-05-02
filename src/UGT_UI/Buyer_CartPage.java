package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buyer_CartPage extends JPanel implements ActionListener {


    //class buttons
    JButton buy_button;
    JButton remove_button;


    //Cart page constructor
    public Buyer_CartPage() {
        this.setLayout(new BorderLayout());



        for(int i = 0; i < 30; i++){
            JPanel post = new JPanel();
            post.setBorder(BorderFactory.createLineBorder(Color.white));
            post.setBackground(new Color(i,i,120));
            add_to_cart(post);

        }





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
                item.setLayout(new BorderLayout());



                JPanel image_panel = new JPanel();
               // JLabel image_label = new JLabel(item.getBackground().toString());
                image_panel.setPreferredSize(new Dimension(200,200));
                image_panel.setBackground(Color.gray);

                item.add(image_panel, BorderLayout.WEST);





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



    //footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {

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

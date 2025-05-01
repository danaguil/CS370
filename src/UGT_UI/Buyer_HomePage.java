package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Random;

public class Buyer_HomePage extends JPanel implements ActionListener {




    //array list holds JPanels... the brands newest post "all_following_post"
    private final ArrayList<JPanel> all_following_post = new ArrayList<>();

    //JPanel that will hold all the brands (JPanels) the user follows
    JPanel following_grid;

    //adds a brand to following array list "all_following_post" ... user will now receive the brands newest post now
    public void  add_to_following_post(JPanel post) {
        all_following_post.add(post);
    }


    //constructor
    public Buyer_HomePage() {

        this.setLayout(new BorderLayout());
        this.add(following_page(), BorderLayout.CENTER);


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
        //layout, all orders will be stacked
        following_grid.setLayout(new BoxLayout(following_grid, BoxLayout.Y_AXIS));

        //creating JScrollpane ----> jsp
        //making order_grid scrollable
        //VERTICAL_SCROLLBAR_ALWAYS
        //HORIZONTAL_SCROLLBAR_NEVER
        JScrollPane jsp = new JScrollPane(following_grid, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //adding jsp to following_page
        following_page.add(jsp);

        return following_page;
    }








    //print following_grid
    public void print_following_grid(){
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







    //actions for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {



    }

}

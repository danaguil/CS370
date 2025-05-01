package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buyer_LikedPage extends JPanel implements ActionListener {



    //array list that hold all of user's liked post
    private final ArrayList<JPanel> all_my_liked_post = new ArrayList<>();


    //Jpanel that holds the grid of like post
    JPanel liked_grid;


    //adds post that user liked to arraylist "all_my_liked_post"
    public void  add_to_all_my_liked_post(JPanel post) {
        all_my_liked_post.add(post);
    }




    //constructor
    public Buyer_LikedPage() {

        this.setLayout(new BorderLayout());
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

        //craeing JScrollpane ----> jsp
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
                JPanel post = all_my_liked_post.get(i);
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





    //Action for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {




    }




}

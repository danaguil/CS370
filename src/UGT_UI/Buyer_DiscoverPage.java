package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buyer_DiscoverPage extends JPanel implements ActionListener {




    //arraylist that holds all post... that will be on the discover page
    private final ArrayList<JPanel> all_discover_post = new ArrayList<>();

    //JPanel that will hold all the post
    JPanel discover_grid;


    //constructor
    public Buyer_DiscoverPage() {
        //frame

        this.setSize(500, 800);

        this.setLayout(new BorderLayout());

        this.add(discover_page(), BorderLayout.CENTER);

        this.setVisible(true);
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




    //prints discover_grid
    public void print_discover_grid(){
        //clears all buttons from discover_grid
        discover_grid.removeAll();
        //if all_discover_post has any post (JPanels)
        if( all_discover_post != null && !all_discover_post.isEmpty()) {


            for (int i = 0; i < all_discover_post.size(); i++) {
                //creating JPanel
                JPanel post = all_discover_post.get(i);
                //size
                post.setPreferredSize(new Dimension(160, 160));
                //adding post (JPanel) to discover_grid
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




    //action for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}

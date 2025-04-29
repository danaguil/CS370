package UGT_UI;

import javax.swing.*;
import java.awt.*;

public class BuyerFooter extends JFrame {

    //Button Variables
    private final JButton buttonfollowing;
    private final JButton buttondiscover;
    private final JButton buttonsettings;
    private final JButton buttonlike;

    private final JButton buttonsearch; // just added these buttons
    private final JButton buttoncart; //just added these buttons


    public BuyerFooter() {


        this.setSize(500, 800);




        JPanel buttonpanel_header = new JPanel(); //flowlayout
        //buttonpanel_header.setBackground(Color.black);
        buttonpanel_header.setPreferredSize(new Dimension(50,50));
        buttonpanel_header.setLayout(new GridLayout(1,3));


        buttonsearch = new JButton();
        buttonsearch.setText("search");
        buttonsearch.setPreferredSize(new Dimension(10,10));
        buttonsearch.setFocusable(false);


        buttoncart = new JButton();
        buttoncart.setText("cart");
        buttoncart.setPreferredSize(new Dimension(10,10));
        buttoncart.setFocusable(false);


        JLabel minibannertext = new JLabel();
        minibannertext.setForeground(Color.WHITE);
        minibannertext.setText("UndergroundThreads");

        JPanel minibanner = new JPanel();
        minibanner.add(minibannertext);
        minibanner.setBackground(Color.DARK_GRAY);

        buttonpanel_header.add(minibanner);
        buttonpanel_header.add(buttonsearch);
        buttonpanel_header.add(buttoncart);

        this.add(buttonpanel_header, BorderLayout.NORTH);

        //by deafualt panels use flowlayout
        JPanel buttonpanel = new JPanel();
       // buttonpanel.setBackground(Color.yellow); //yellow will be hidden by the buttons
        buttonpanel.setLayout(new GridLayout(1, 4)); // 1 row with 5 columns
        buttonpanel.setPreferredSize(new Dimension(50,50)); //SINCE USING BORRDERLAYOUY 100X100 DOES NOT DO ANYTINGN


        //manipanel *use flowlayout buttons will just flow...


        //JButton
        //creating button
        buttonfollowing = new JButton();
        //adding text to button
        buttonfollowing.setText("following");
        //make it so that you won't be able to see rectangle
        buttonfollowing.setFocusable(false);


        buttondiscover = new JButton();
        buttondiscover.setText("discover");
        buttondiscover.setFocusable(false);


        buttonlike = new JButton();
        buttonlike.setText("liked");
        buttonlike.setFocusable(false);


        buttonsettings = new JButton();
        buttonsettings.setText("settings");
        buttonsettings.setFocusable(false);


        buttonpanel.add(buttonfollowing);
        buttonpanel.add(buttondiscover);
        buttonpanel.add(buttonlike);
        buttonpanel.add(buttonsettings);
        this.add(buttonpanel,BorderLayout.SOUTH);


        this.setVisible(true);
    }



    public JButton getFollowing_button() {
        return buttonfollowing;
    }
    public JButton getDiscover_button() {
        return buttondiscover;
    }
    public JButton getLike_button() {
        return buttonlike;
    }
    public JButton getSettings_button() {
        return buttonsettings;
    }
    public JButton getCart_button() {
        return buttoncart;
    }
    public JButton getSearch_button() {
        return buttonsearch;
    }


}

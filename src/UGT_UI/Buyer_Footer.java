package UGT_UI;

import javax.swing.*;
import java.awt.*;

public class Buyer_Footer extends JPanel {

    //Button Variables
    private final JButton buttonhome;
    private final JButton buttondiscover;
    private final JButton buttonsettings;
    private final JButton buttonlike;

    private final JButton buttonsearch; // just added these buttons
    private final JButton buttoncart; //just added these buttons


    public Buyer_Footer() {

        //this.setTitle("barlitos");
        this.setLayout(new BorderLayout());
        //this.setBackground(Color.YELLOW);
        this.setSize(500, 800);


        JPanel buttonpanel_TOP = new JPanel(); //flowlayout
        //buttonpanel_header.setBackground(Color.black);
        buttonpanel_TOP.setPreferredSize(new Dimension(50,50));
        buttonpanel_TOP.setLayout(new GridLayout(1,3));


        buttonsearch = new JButton();
        buttonsearch.setText("search");
        buttonsearch.setPreferredSize(new Dimension(10,10));
        buttonsearch.setFocusable(false);


        buttoncart = new JButton();
        buttoncart.setText("cart");
        buttoncart.setPreferredSize(new Dimension(10,10));
        buttoncart.setFocusable(false);


        JLabel minibannertext = new JLabel("UndergroundThreads", SwingConstants.CENTER);
        minibannertext.setForeground(Color.WHITE);


        JPanel minibanner = new JPanel();
        minibanner.setLayout(new BorderLayout());
        minibanner.add(minibannertext);
        minibanner.setBackground(Color.DARK_GRAY);

        buttonpanel_TOP.add(minibanner);
        buttonpanel_TOP.add(buttonsearch);
        buttonpanel_TOP.add(buttoncart);

        this.add(buttonpanel_TOP, BorderLayout.NORTH);

        //by deafualt panels use flowlayout
        JPanel buttonpanel_BOTTOM = new JPanel();
       // buttonpanel_BOTTOM.setBackground(Color.yellow); //yellow will be hidden by the buttons
        buttonpanel_BOTTOM.setLayout(new GridLayout(1, 4)); // 1 row with 5 columns
        buttonpanel_BOTTOM.setPreferredSize(new Dimension(50,50)); //SINCE USING BORRDERLAYOUY 100X100 DOES NOT DO ANYTINGN


        //manipanel *use flowlayout buttons will just flow...


        //JButton
        //creating button
        buttonhome = new JButton();
        //adding text to button
        buttonhome.setText("following");
        //make it so that you won't be able to see rectangle
        buttonhome.setFocusable(false);


        buttondiscover = new JButton();
        buttondiscover.setText("discover");
        buttondiscover.setFocusable(false);


        buttonlike = new JButton();
        buttonlike.setText("liked");
        buttonlike.setFocusable(false);


        buttonsettings = new JButton();
        buttonsettings.setText("settings");
        buttonsettings.setFocusable(false);


        buttonpanel_BOTTOM.add(buttonhome);
        buttonpanel_BOTTOM.add(buttondiscover);
        buttonpanel_BOTTOM.add(buttonlike);
        buttonpanel_BOTTOM.add(buttonsettings);
        this.add(buttonpanel_BOTTOM,BorderLayout.SOUTH);


        this.setVisible(true);
    }



    public JButton getHome_button() {
        return buttonhome;
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

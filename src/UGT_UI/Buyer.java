package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Buyer extends JFrame implements ActionListener {
    JButton buttonfollowing;
    JButton buttondiscover;
    JButton buttonsettings;
    JButton buttonlike;

    JButton buttonsearch; // just added these buttons
    JButton buttoncart; //just added these buttons

    CardLayout cards;
    JPanel maincard;

    public Buyer() { //start ......................................................................

        JFrame frame = new JFrame(); //by defeautl frames use borderlayout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("UnderGroundThreads");





//jnijnijnjinjinjinijnijnijnjninjinijnij
         cards = new CardLayout();
        //this JPanel (maincard) will be used to hold all cards
         maincard = new JPanel();
        maincard.setLayout(cards);

        maincard.add(Search(),"cardsearch");
        maincard.add(Cart(), "cardcart");
        maincard.add(Cardfollowing(),"cardfollowing");
        maincard.add(Carddiscover(),"carddiscover");
        maincard.add(Cardlike(),"cardlike");
        maincard.add(Cardsettings(), "cardsettings");


        frame.add(maincard);
        //add(maincard);  --->could also use this




        JPanel buttonpanel_header = new JPanel(); //flowlayout
        //buttonpanel_header.setBackground(Color.black);
        buttonpanel_header.setPreferredSize(new Dimension(50,50));
        buttonpanel_header.setLayout(new GridLayout(1,3));


        buttonsearch = new JButton();
        buttonsearch.setText("search");
        buttonsearch.setPreferredSize(new Dimension(10,10));
        buttonsearch.setFocusable(false);
        buttonsearch.addActionListener(this);

        buttoncart = new JButton();
        buttoncart.setText("cart");
        buttoncart.setPreferredSize(new Dimension(10,10));
        buttoncart.setFocusable(false);
        buttoncart.addActionListener(this);

        JLabel minibannertext = new JLabel();
        minibannertext.setText("UndergroundThreads");

        JPanel minibanner = new JPanel();
        minibanner.add(minibannertext);
        minibanner.setBackground(Color.DARK_GRAY);

        buttonpanel_header.add(minibanner);
        buttonpanel_header.add(buttonsearch);
        buttonpanel_header.add(buttoncart);

        frame.add(buttonpanel_header, BorderLayout.NORTH);

        //by deafualt panels use flowlayout
        JPanel buttonpanel = new JPanel();
        buttonpanel.setBackground(Color.yellow); //yellow will be hidden by the buttons
        buttonpanel.setLayout(new GridLayout(1, 4)); // 1 row with 5 columns
        buttonpanel.setPreferredSize(new Dimension(50,50)); //SINCE USING BORRDERLAYOUY 100X100 DOES NOT DO ANYTINGN


        //manipanel *use flowlayout buttons will just flow...


        //JButton
        buttonfollowing = new JButton();
        buttonfollowing.setText("following");
        buttonfollowing.setFocusable(false);
        buttonfollowing.addActionListener(this);

        buttondiscover = new JButton();
        buttondiscover.setText("discover");
        buttondiscover.setFocusable(false);
        buttondiscover.addActionListener(this);

        buttonlike = new JButton();
        buttonlike.setText("liked");
        buttonlike.setFocusable(false);
        buttonlike.addActionListener(this);

        buttonsettings = new JButton();
        buttonsettings.setText("settings");
        buttonsettings.setFocusable(false);
        buttonsettings.addActionListener(this);

        buttonpanel.add(buttonfollowing);
        buttonpanel.add(buttondiscover);
        buttonpanel.add(buttonlike);
        buttonpanel.add(buttonsettings);
        frame.add(buttonpanel,BorderLayout.SOUTH);


        frame.setVisible(true);
    }//end..................................................................................








    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonfollowing){
            cards.show(maincard, "cardfollowing");
        }else if(e.getSource() == buttondiscover){
            cards.show(maincard, "carddiscover");
        }else if(e.getSource() == buttonlike){
            cards.show(maincard, "cardlike");
        }else if(e.getSource() == buttonsettings){
            cards.show(maincard,"cardsettings");
        }else if(e.getSource() == buttonsearch){
            cards.show(maincard, "cardsearch");
        }else if(e.getSource() == buttoncart ){
            cards.show(maincard, "cardcart");
        }

    }



//..........................................................
    private JPanel Cardfollowing(){
        JPanel cardfollowing = new JPanel();

        cardfollowing.setBackground(Color.BLUE);
        return cardfollowing;
    }


    private JPanel Carddiscover(){
        JPanel carddiscover = new JPanel();
        //carddiscover.setLayout(new GridLayout(3,3));
        carddiscover.setBackground(Color.green);

        return carddiscover;
    }



    private JPanel Cardlike(){
        JPanel cardlike = new JPanel();
        //
        cardlike.setBackground(Color.black);
        return cardlike;
    }




    private JPanel Cardsettings(){
        JPanel cardsettings = new JPanel();
        cardsettings.setBackground(Color.red);
        return cardsettings;
    }




    private JPanel Search(){
        JPanel cardsettings = new JPanel();
        cardsettings.setBackground(Color.orange);
        return cardsettings;
    }

    private JPanel Cart(){
        JPanel cardsettings = new JPanel();
        //
        cardsettings.setBackground(Color.cyan);
        return cardsettings;
    }



}

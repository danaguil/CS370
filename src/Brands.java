import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Brands extends JFrame implements ActionListener {
    JButton buttonprofile;
    JButton buttonpost;
    JButton buttonsettings;



    CardLayout cards;
    JPanel maincard;


    Brands(){
        JFrame frame = new JFrame(); //by defeautl frames use borderlayout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("UnderGroundThreads");

        cards = new CardLayout();
        maincard = new JPanel();
        maincard.setLayout(cards);

        maincard.add(Cardprofile(),"profile");
        maincard.add(Cardpost(), "post");
        maincard.add(Cardsettings(), "settings");

        frame.add(maincard);

        JPanel buttonpanel = new JPanel();
        buttonpanel.setBackground(Color.yellow); //yellow will be hidden by the buttons
        buttonpanel.setLayout(new GridLayout(1, 4)); // 1 row with 5 columns
        buttonpanel.setPreferredSize(new Dimension(50,50)); //SINCE USING BORRDERLAYOUY 100X100 DOES NOT DO ANYTINGN

        //this is where the buttons come in

        buttonprofile = new JButton();
        buttonprofile.setText("profile");
        buttonprofile.setFocusable(false);
        buttonprofile.addActionListener(this);

        buttonpost = new JButton();
        buttonpost.setText("post");
        buttonpost.setFocusable(false);
        buttonpost.addActionListener(this);

        buttonsettings = new JButton();
        buttonsettings.setText("settings");
        buttonsettings.setFocusable(false);
        buttonsettings.addActionListener(this);

        //adding buttons to buttonpanel
        buttonpanel.add(buttonprofile);
        buttonpanel.add(buttonpost);
        buttonpanel.add(buttonsettings);
        frame.add(buttonpanel,BorderLayout.SOUTH);
        frame.setVisible(true);
    }





    private JPanel Cardprofile(){
        JPanel cardprofile = new JPanel();
        cardprofile.setBackground(Color.red);







        JPanel profile_banner = new JPanel();
        profile_banner.setBackground(Color.yellow);
        profile_banner.setPreferredSize(new Dimension(500,200));



        JPanel profile_photo = new JPanel();
        profile_photo.setBackground(Color.cyan);
        profile_photo.setPreferredSize(new Dimension(200,200));



        JPanel holder = new JPanel();
        holder.setBackground(Color.MAGENTA);
        holder.setPreferredSize(new Dimension(100,200));

        //adding panels on to panel
        profile_banner.add(profile_photo);
        profile_banner.add(holder);

        cardprofile.add(profile_banner);





















        return cardprofile;
    }






//CARD POST
    private JPanel Cardpost(){
        JPanel cardpost = new JPanel();
        cardpost.setBackground(Color.MAGENTA);






        return cardpost;
    }



// CARD SETTINGS

    private JPanel Cardsettings(){
        JPanel cardsettings = new JPanel();
        cardsettings.setBackground(Color.BLUE);







        return cardsettings;
    }




//CREATE A PROFILE
    private JPanel createaprofile(){
        JPanel createaprofile = new JPanel();








        return createaprofile;
    }





//MAKE A POST
    private JPanel makeapost(){
        JPanel makeapost = new JPanel();








        
        return makeapost;
    }









    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonprofile){

            cards.show(maincard, "profile");

        }else if(e.getSource() == buttonpost){

            cards.show(maincard, "post");

        }else if(e.getSource() == buttonsettings){

            cards.show(maincard, "settings");

        }else if(e.getSource() == buttonsettings){

            cards.show(maincard,"cardsettings");

        }
    }
}

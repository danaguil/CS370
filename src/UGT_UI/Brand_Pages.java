package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Brand_Pages extends JFrame implements ActionListener {

    //footer buttons
    JButton button_profile;
    JButton button_upload;
    JButton button_settings;


    CardLayout cards;
    JPanel maincard;

    ProfilePage profilePage;
    UploadPage uploadPage;
    SettingsPage settingsPage;


    public Brand_Pages() {

        this.setSize(500, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        BrandFooter footer = new BrandFooter();
        TitleHeader header = new TitleHeader();

        cards = new CardLayout();
        //this JPanel (maincard) will be used to hold all cards
        maincard = new JPanel();
        maincard.setLayout(cards);

        profilePage = new ProfilePage();
        uploadPage = new UploadPage();
        settingsPage = new SettingsPage();

        maincard.add(profilePage, "profile");
        maincard.add(uploadPage, "upload");
        maincard.add(settingsPage, "settings");


        this.add(maincard, null);


        button_profile = footer.getProfile_btn();
        button_profile.addActionListener(this);
        button_upload = footer.getUpload_btn();
        button_upload.addActionListener(this);
        button_settings = footer.getSettings_btn();
        button_settings.addActionListener(this);

        this.add(footer,BorderLayout.SOUTH);
        this.add(header,BorderLayout.NORTH);
        this.setVisible(true);
    }




    //action for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_profile) {
            System.out.println("button profile");
            profilePage.print_grid();
            cards.show(maincard, "profile");



        }
        if (e.getSource() == button_upload) {
            System.out.println("button post");
            cards.show(maincard, "upload");



        }
        if (e.getSource() == button_settings) {
            System.out.println("button settings");
            cards.show(maincard, "settings");



        }



    }



}

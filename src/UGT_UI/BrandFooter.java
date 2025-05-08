package UGT_UI;

import javax.swing.*;
import java.awt.*;

public class BrandFooter extends JLayeredPane {
    /*
        The BrandFooter class is responsible for creating the default footer for all Brand Pages (pages seen by Brand Users)
        It must include the 3 buttons: Profile, Upload, and Settings respectively.
        It must also return each button so that other pages that use this footer can set which buttons are usable for the user.
     */

    // Button Variables
    private final JButton profile_btn;
    private final JButton upload_btn;
    private final JButton settings_btn;


    // BrandFooter Constructor
    public BrandFooter() {
        // Create the panel to fix the footer on and its properties
        this.setSize(600, 60);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        this.setBackground(Color.WHITE);
        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Create footer buttons
        profile_btn = new JButton("Profile");
        upload_btn = new JButton("Upload");
        settings_btn = new JButton("Settings");

        // Add their properties
        profile_btn.setPreferredSize(new Dimension(125, 50));
        profile_btn.setFocusable(false);

        upload_btn.setPreferredSize(new Dimension(125, 50));
        upload_btn.setFocusable(false);

        settings_btn.setPreferredSize(new Dimension(125, 50));
        settings_btn.setFocusable(false);

        // Add Buttons to the footer
        this.add(profile_btn);
        this.add(upload_btn);
        this.add(settings_btn);

    }


    // Getters for each button
    public JButton getProfile_btn() {
        return profile_btn;
    }

    public JButton getUpload_btn() {
        return upload_btn;
    }

    public JButton getSettings_btn() {
        return settings_btn;
    }
}

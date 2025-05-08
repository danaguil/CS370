package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPage extends JPanel implements ActionListener {

    JButton button = new JButton("Logout");
    UndergroundThreads UGT;

    // Settings Page Constructor
    public SettingsPage(UndergroundThreads u) {

        this.setLayout(new BorderLayout());
        this.add(getSettingsPanel(), BorderLayout.CENTER);

        UGT = u;


    }

    private JButton getLogoutButton(JButton button) {
        button.setBounds(200, 200, 100, 20);
        button.addActionListener(this);

        return button;
    }

    private JPanel getSettingsPanel() {
        JPanel settings_panel = new JPanel();
        settings_panel.setBackground(Color.WHITE);
        settings_panel.setLayout(null);
        settings_panel.add(getLogoutButton(button));

        return settings_panel;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println("Logging out of Brand Account");
            UGT.go_to_login_pages();
        }
    }
}

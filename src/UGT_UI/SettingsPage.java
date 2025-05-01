package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPage extends JPanel implements ActionListener {

    // Settings Page Constructor
    public SettingsPage() {

        this.setLayout(new BorderLayout());
        this.add(getSettingsPanel(), BorderLayout.CENTER);



    }

    private JPanel getSettingsPanel() {
        JPanel settings_panel = new JPanel();
        settings_panel.setBackground(Color.WHITE);

        return settings_panel;
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

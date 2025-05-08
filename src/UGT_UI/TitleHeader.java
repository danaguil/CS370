package UGT_UI;

import javax.swing.*;
import java.awt.*;

public class TitleHeader extends JPanel {

    /*
        The Title Header will be displayed across the software and simply displays "UnderGround Threads"
     */

    public TitleHeader() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setSize(600, 50); // Spans the width of every frame/panel and takes up 50 vertical pixels

        JLabel titleLabel = new JLabel("UnderGround Threads");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setSize(600, 50);

        add(titleLabel);
    }

}

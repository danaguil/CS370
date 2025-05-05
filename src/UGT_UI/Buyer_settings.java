package UGT_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buyer_settings extends JPanel implements ActionListener {


    //class button
    JButton save_changes_button;
    JButton logout_button;

  UndergroundThreads UGT;

    //constructor
    public Buyer_settings (UndergroundThreads UGT) {


        this.UGT = UGT;


        //this.setLayout(new BorderLayout());
        //this.add(settings_page("username", "password",  "first_name", "last_name", "name_on_card", "card_number", "card_month_exp", "card_year_exp", "card_cvv", "address","email"),BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.add(all_settings_pages(UGT));



    }


    //to be placed in the constructor
    //this includes all pages that make up the settings... settingspage, report, logout
    private JPanel all_settings_pages(UndergroundThreads UGT) {

        //creating panel to hold everything
        JPanel settings_page = new JPanel();
        settings_page.setBackground(Color.cyan);
        settings_page.setPreferredSize(new Dimension(300,800));
        settings_page.setLayout(new BorderLayout());

        //cardlayout
        CardLayout cards = new CardLayout();
        //creating JPanel maincard to hold all the cards, so that we can call specific card within action listener
        JPanel maincard = new JPanel(cards);

        //adding maincard to settings_page
        settings_page.add(maincard);

        //adding cards sto maincard
        maincard.add(settings_page("username1","password123","Danny","Dan'slastname","3449MoragaRd","ihaveacat@gamil.com"),"settings");
        maincard.add(report_page(), "report");
        maincard.add(logout_page(UGT), "logout");

        //creating buttonpanel to hold buttons
        JPanel buttonpanel = new JPanel();
        buttonpanel.setBackground(Color.lightGray);
        //buttonpanel.setBackground(Color.orange);



        JButton settings_button = new JButton("account");
        settings_button.addActionListener(this);
        JButton report_button = new JButton("report");
        report_button.addActionListener(this);
        JButton logout_button = new JButton("Logout");
        logout_button.addActionListener(this);

        buttonpanel.add(settings_button);
        buttonpanel.add(report_button);
        buttonpanel.add(logout_button);


        settings_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "settings");
            }
        });

        report_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "report");
            }
        });

        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cards.show(maincard, "logout");
            }
        });


        settings_page.add(buttonpanel, BorderLayout.NORTH);
        return settings_page;
    }










    private JPanel report_page(){
        //creating panel
        JPanel report_page = new JPanel();
        //size
        report_page.setSize(500,200);
        //color
        //report_page.setBackground(Color.green);
        //layout
        report_page.setLayout(new BoxLayout(report_page, BoxLayout.Y_AXIS));
        //creating bug_report_panel to hold all objects: label, textarea
        JPanel bug_report_panel = new JPanel();
        JLabel bug_report_label = new JLabel("Report a brand:");
        JTextField report_brand_text_field = new JTextField(20);
        //report_brand_text_field.setText();
        bug_report_panel.add(bug_report_label);
        bug_report_panel.add(report_brand_text_field);
        //adding bug_report_panel to report_page
        report_page.add(bug_report_panel);

        //creating button_panel to hold button
        JPanel button_panel = new JPanel();
        //creating button submit_report
        JButton submit_report = new JButton("report");

        //ACTION LISTENER
        submit_report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("you submitted your bug report!!!!!");
            }
        });

        //adding submit_report to button_panel
        button_panel.add(submit_report);
        //adding button_panel to report_page
        report_page.add(button_panel);





        return report_page;
    }
    private JPanel logout_page(UndergroundThreads UGT) {
        //creating logout_panel to hold everything
        JPanel logout_panel = new JPanel();
        logout_panel.setLayout(null);

        //creating button
        logout_button = new JButton("logout");
        logout_button.setBounds(200,250,100,30);
        logout_button.addActionListener(this);
        //ACTION LISTENER
        logout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("you been logged out :(");
                UGT.go_to_login_pages();

            }
        });

        //adding button (logout_button) to logout_panel
        logout_panel.add(logout_button);

        return logout_panel;
    }







    //settings_page variables
    private static JTextField usernmae_j;
    private static JTextField password_j;
    private static JTextField first_name_j;
    private static JTextField last_name_j;

    private static JTextField address_j;
    private static JTextField email_j;

    //settins_page getters
    public static String get_username_TextField() {
        return usernmae_j.getText();
    }
    public static String get_password_TextField() {
        return password_j.getText();
    }
    public static String get_first_name_TextField() {
        return first_name_j.getText();
    }
    public static String get_last_name_TextField() {
        return last_name_j.getText();
    }
    public static String get_address_TextField() {
        return address_j.getText();
    }
    public static String get_email_TextField() {
        return email_j.getText();
    }





    //main page
    private JPanel settings_page(String username, String password, String first_name, String last_name, String address, String email ){
        JPanel settings_page = new JPanel();
        //settings_page.setBackground(Color.red);
        settings_page.setLayout(new BoxLayout(settings_page, BoxLayout.Y_AXIS));
        //banner to help out user
        JPanel banner = new JPanel();
        banner.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
        banner.setBackground(Color.cyan);
        JLabel text_for_banner = new JLabel("fill in any new changes then press save :)");
        banner.add(text_for_banner);
        settings_page.add(banner);

        JPanel change_username_panel = new JPanel();
        //change_username_panel.setPreferredSize(new Dimension(300,10));
        change_username_panel.setBackground(Color.MAGENTA);
        change_username_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        JLabel username_label = new JLabel("username:");
        usernmae_j = new JTextField(20);
        change_username_panel.add(username_label);
        change_username_panel.add(usernmae_j);
        //adding to settings_page
        settings_page.add(change_username_panel);


        JPanel change_password_panel = new JPanel();
        //change_password_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JLabel password_label = new JLabel("password:");
        password_j = new JTextField(20);
        change_password_panel.add(password_label);
        change_password_panel.add(password_j);
        //adding to settings_page
        settings_page.add(change_password_panel);

        JPanel change_first_and_last_name_panel = new JPanel();
        change_first_and_last_name_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        change_first_and_last_name_panel.setLayout(new BoxLayout(change_first_and_last_name_panel, BoxLayout.Y_AXIS));

        JPanel first_name_panel = new JPanel();
        JLabel first_name_label = new JLabel("1st name:");
        first_name_j = new JTextField(20);
        first_name_panel.add(first_name_label);
        first_name_panel.add(first_name_j);
        change_first_and_last_name_panel.add(first_name_panel);
        //lastname
        JPanel last_name_panel = new JPanel();
        JLabel last_name_label = new JLabel("last name:");
        last_name_j = new JTextField(20);
        last_name_panel.add(last_name_label);
        last_name_panel.add(last_name_j);
        change_first_and_last_name_panel.add(last_name_panel);
        //adding both 1stname and lastname to change_first_and_last_name_panel
        settings_page.add(change_first_and_last_name_panel);




        JPanel change_address_panel = new JPanel();
        change_address_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JLabel addresss_label = new JLabel("address:");
        address_j = new JTextField(20);
        change_address_panel.add(addresss_label);
        change_address_panel.add(address_j);
        //adding to settings_page
        settings_page.add(change_address_panel);


        JPanel change_email_panel = new JPanel();
        change_email_panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        JLabel email_label = new JLabel("email:");
        email_j = new JTextField(20);
        change_email_panel.add(email_label);
        change_email_panel.add(email_j);
        //adding to settings_page
        settings_page.add(change_email_panel);

        JPanel button_panel = new JPanel();
        save_changes_button = new JButton("save changes");
        save_changes_button.addActionListener(this);
        button_panel.add(save_changes_button);
        //adding to settings_page
        settings_page.add(button_panel);


        return settings_page;
    }




    //actions for footer buttons
    @Override
    public void actionPerformed(ActionEvent e) {




        if(e.getSource() == save_changes_button){

            System.out.println("save changes");


        }

    }


    public void savehanges(){

    }

}


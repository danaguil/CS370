package UGT_UI;

import UGT_Controllers.UploadController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class UploadPage extends JPanel implements ActionListener {

    // Buttons used throughout the Upload Page
    JButton tops_btn; // Button used to display top data input fields
    JButton bottoms_btn; // Button used to display bottom data input fields
    JButton shoes_btn; // Button used to display shoes data input fields
    JButton upload_post_btn1 = new JButton(); // Button used to upload a top to the system
    JButton upload_post_btn2 = new JButton(); // Button used to upload a bottom to the system
    JButton upload_post_btn3 = new JButton(); // Button used to upload a shoe to the system
    JButton image_upload_btn1 = new JButton(); // Button used to upload a picture for tops
    JButton image_upload_btn2 = new JButton(); // Button used to upload a picture for bottoms
    JButton image_upload_btn3 = new JButton(); // Button used to upload a picture for shoes
    JButton back_btn; // Used to go back to the item selection screen

    // Used to determine what type of entry fields to display and what type of item to create
    CardLayout cards;
    JPanel maincard;

    UploadController uploadController = new UploadController();

    // Arrays for Combo Boxes
    String [] top_type_array = {"", "Shirt", "Sweater", "Jacket", "Fleece", "Tank Top", "Coat", "Vest"};
    String[] size_array = {"", "XS", "S", "M", "L", "XL", "XX", "XXL"};
    String[] measurement_array = {"", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
            , "32", "33", "34", "35", "36", "37", "38", "39","40", "41","42", "43", "44", "45", "46", "47", "48", "49", "50", "51"};
    String [] color_array = {"", "Red", "Blue", "Green", "Yellow", "Orange", "Light Blue", "Dark Blue", "Purple", "Violet", "Cyan", "Black", "White", "Gray", "Light Gray"};
    String [] bottom_type_array = {"", "Jeans", "Sweatpants", "Shorts", "Skirt", "Leggings"};
    String [] rise_array = {"", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
    String [] shoes_type_array = {"", "Sneakers", "Sandals", "Slippers", "Boots", "Socks", "Tennis Shoes"};
    String [] shoes_size_array = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};

    // General Combo Boxes
    JComboBox<String> length_combo = new JComboBox<>(measurement_array);
    JComboBox<String> color_combo_box1 = new JComboBox<>(color_array); // Used for tops
    JComboBox<String> color_combo_box2 = new JComboBox<>(color_array); // Used for bottoms
    JComboBox<String> color_combo_box3 = new JComboBox<>(color_array); // Used for shoes
    JComboBox<String> size_combo1 = new JComboBox<>(size_array); // Used for tops
    JComboBox<String> size_combo2 = new JComboBox<>(size_array); // Used for bottoms
    // Tops Combo Boxes
    JComboBox<String> top_type_combo = new JComboBox<>(top_type_array);
    JComboBox<String> chest_size_combo = new JComboBox<>(measurement_array);
    JComboBox<String> hem_size_combo = new JComboBox<>(measurement_array);
    JComboBox<String> sleeve_length_combo = new JComboBox<>(measurement_array);


    // Bottoms Combo Boxes
    JComboBox<String> bottom_type_combo = new JComboBox<>(bottom_type_array);
    JComboBox<String> inseam_combo = new JComboBox<>(measurement_array);
    JComboBox<String> rise_combo = new JComboBox<>(rise_array);
    JComboBox<String> waist_size_combo = new JComboBox<>(measurement_array);


    // Shoes Combo Boxes
    JComboBox<String> shoes_type_combo = new JComboBox<>(shoes_type_array);
    JComboBox<String> shoes_size_combo = new JComboBox<>(shoes_size_array);

    JTextField price_text1 = new JTextField();
    JTextField price_text2 = new JTextField();
    JTextField price_text3 = new JTextField();

    JTextArea description_text1 = new JTextArea();
    JTextArea description_text2 = new JTextArea();
    JTextArea description_text3 = new JTextArea();

    JTextField item_name_text1 = new JTextField();
    JTextField item_name_text2 = new JTextField();
    JTextField item_name_text3 = new JTextField();

    // Files for saving the Item Image
    BufferedImage image_file;
    File selected_file; // Stores the currently selected file from the FileChooser
    String newFileName;
    String outputFilePath;

    ProfilePage profile;


    // Upload Page Constructor
    public UploadPage() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        // Create the maincard panel and add the UploadPage panel components to it
        maincard = new JPanel();
        cards = new CardLayout();
        maincard.setLayout(cards);

        maincard.add(getUploadPanel(), "item_select");
        maincard.add(getTopsPanel(), "tops_panel");
        maincard.add(getBottomsPanel(), "bottoms_panel");
        maincard.add(getShoesPanel(), "shoes_panel");

        // Add Maincard to JPanel and Footer and Header
        this.add(maincard, BorderLayout.CENTER);


    }

    // Buffers for BorderLayout whitespace
    private JPanel buffer_panel(boolean has_back) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(75, 500));
        panel.setBackground(Color.WHITE);

        if (has_back) {
            back_btn = new JButton("Back");
            back_btn.setBounds(10, 10, 80, 30);
            panel.add(back_btn);
            back_btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Back button pressed");
                    cards.show(maincard, "item_select");
                }
            });
        }

        return panel;
    }



    private JPanel getUploadPanel() {
        // The panel that all visual components will be fixed on
        JPanel upload_panel = new JPanel();
        upload_panel.setLayout(null);
        upload_panel.setSize(600,700);
        upload_panel.setBackground(Color.WHITE);
        upload_panel.setLayout(null);

        upload_panel.add(itemTypePanel()); // By default, the upload page will always ask you to make an item type selection


        return upload_panel;
    }

    private JLayeredPane itemTypePanel(){
        // Create the Panel to be added to the Upload Panel
        JLayeredPane itemTypePanel = new JLayeredPane();
        itemTypePanel.setBackground(Color.WHITE);
        itemTypePanel.setBounds(100, 175, 300, 300);
        itemTypePanel.setLayout(new BoxLayout(itemTypePanel, BoxLayout.Y_AXIS));
        itemTypePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        JLabel itemTypeLabel = new JLabel("Select Item Type to Upload");
        itemTypeLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        itemTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        tops_btn = new JButton("Tops");
        tops_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        tops_btn.addActionListener(this);

        bottoms_btn = new JButton("Bottoms");
        bottoms_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        bottoms_btn.addActionListener(this);

        shoes_btn = new JButton("Shoes");
        shoes_btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        shoes_btn.addActionListener(this);

        itemTypePanel.add(itemTypeLabel);
        itemTypePanel.add(tops_btn);
        itemTypePanel.add(bottoms_btn);
        itemTypePanel.add(shoes_btn);

        return itemTypePanel;
    }


    // The Layered Panel used to show the price

    private JLayeredPane price_panel(JTextField price_text) {
        // Create the pricePanel
        JLayeredPane price_panel = new JLayeredPane();
        price_panel.setLayout(null);
        price_panel.setBackground(Color.WHITE);
        price_panel.setPreferredSize(new Dimension(300, 30));
//        price_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel priceLabel = new JLabel("Enter Price:");
        priceLabel.setBounds(30, 10, 180, 20);


        price_text.setBounds(150, 10, 160, 20);
        price_text.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        price_panel.add(priceLabel);
        price_panel.add(price_text);
        return price_panel;
    }
//
//
    // The LayeredPane to show the item description TextArea

    private JLayeredPane description_panel(JTextArea description_text) {
        // Create the descriptionPanel
        JLayeredPane description_panel = new JLayeredPane();
        description_panel.setLayout(null);
        description_panel.setBackground(Color.WHITE);
        description_panel.setPreferredSize(new Dimension(300, 70));
//        description_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel descriptionLabel = new JLabel("Enter Description:");
        descriptionLabel.setBounds(30, 10, 180, 20);

        description_text.setWrapStyleWord(true);
        description_text.setLineWrap(true);
        description_text.setBounds(30, 30, 285, 60);
        description_text.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        description_panel.add(descriptionLabel);
        description_panel.add(description_text);
        return description_panel;
    }
//

     JLayeredPane item_name_panel(JTextField item_name_text) {
         // Create the itemNamePanel
         JLayeredPane itemNamePanel = new JLayeredPane();
         itemNamePanel.setLayout(null);
         itemNamePanel.setBackground(Color.WHITE);
         itemNamePanel.setPreferredSize(new Dimension(300, 30));
//         itemNamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

         // Create the JLabel
         JLabel itemNameLabel = new JLabel("Enter Item Name:");
         itemNameLabel.setBounds(30, 10, 120, 20);

         // Create the TextField
         item_name_text.setBounds(150, 10, 160, 20);
         item_name_text.setBorder(BorderFactory.createLineBorder(Color.BLACK));

         itemNamePanel.add(itemNameLabel);
         itemNamePanel.add(item_name_text);
         return itemNamePanel;
     }

     private JLayeredPane data_panes(JComboBox<String> combo_box, String label){
         JLayeredPane data_panes = new JLayeredPane();
         data_panes.setLayout(null);
         data_panes.setBackground(Color.WHITE);
         data_panes.setPreferredSize(new Dimension(300, 30));
//         data_panes.setBorder(BorderFactory.createLineBorder(Color.BLACK));

         // Create the label
         JLabel dataLabel = new JLabel(label);
         dataLabel.setBounds(30, 2, 180, 20);

         // Create the combobox bounds
         combo_box.setBounds(160, 0, 155, 30);
//         combo_box.setBorder(BorderFactory.createLineBorder(Color.BLACK));

         data_panes.add(dataLabel);
         data_panes.add(combo_box);
         return data_panes;
     }


     private JLayeredPane image_btn(JButton button){
        JLayeredPane image_btn_panel = new JLayeredPane();
        image_btn_panel.setLayout(null);
        image_btn_panel.setBackground(Color.WHITE);
        image_btn_panel.setPreferredSize(new Dimension(300, 40));
//        image_btn_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        button.setText("Select Item Image");
        button.setBounds(100, 10,150, 30);
        button.addActionListener(this);

        image_btn_panel.add(button);
        return image_btn_panel;
    }

    // Upload Post Button
    private JLayeredPane getUploadPostButton(JButton button) {
        JLayeredPane upload_post_panel = new JLayeredPane();
        upload_post_panel.setLayout(null);
        upload_post_panel.setBackground(Color.WHITE);
        upload_post_panel.setPreferredSize(new Dimension(300, 40));
//        upload_post_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        button.setText("Upload Post");
        button.setBounds(100, 10, 150, 40);
        button.addActionListener(this);
        button.setEnabled(false);

        upload_post_panel.add(button);
        return upload_post_panel;
    }





    // Data Input Fields for Top Item
    private JPanel getTopsPanel() {
        JPanel tops_panel = new JPanel();
        tops_panel.setLayout(new BorderLayout());
        tops_panel.setBackground(Color.WHITE);
        tops_panel.setSize(500,700);
//        tops_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        // Create the Panel that the data input fields lie on
        JPanel tops_inputs = new JPanel();
        tops_inputs.setLayout(new BoxLayout(tops_inputs, BoxLayout.Y_AXIS));
        tops_inputs.setBackground(Color.WHITE);
        tops_inputs.setPreferredSize(new Dimension(300,500));
        tops_inputs.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add the data input fields
        tops_inputs.add(item_name_panel(item_name_text1));
        tops_inputs.add(data_panes(top_type_combo, "Enter Top Type:"));
        tops_inputs.add(data_panes(color_combo_box1, "Enter Top Color:"));
        tops_inputs.add(data_panes(size_combo1, "Enter Top Size:"));
        tops_inputs.add(data_panes(chest_size_combo, "Enter Chest Size:"));
        tops_inputs.add(data_panes(hem_size_combo, "Enter Hem Size:"));
        tops_inputs.add(data_panes(sleeve_length_combo, "Enter Sleeve Length:"));
        tops_inputs.add(description_panel(description_text1));
        tops_inputs.add(price_panel(price_text1));
        tops_inputs.add(image_btn(image_upload_btn1));
        tops_inputs.add(getUploadPostButton(upload_post_btn1));


        tops_panel.add(buffer_panel( true), BorderLayout.WEST);
        tops_panel.add(buffer_panel( false), BorderLayout.EAST);

        tops_panel.add(tops_inputs, BorderLayout.CENTER);

        return tops_panel;
    }

    // Data Input Fields for Bottom Item
    private JPanel getBottomsPanel() {
         JPanel bottoms_panel = new JPanel();
         bottoms_panel.setLayout(new BorderLayout());
         bottoms_panel.setBackground(Color.WHITE);
         bottoms_panel.setSize(500,700);
//         bottoms_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

         // Create the panel that the all the data inputs lie on
         JPanel bottoms_inputs = new JPanel();
         bottoms_inputs.setLayout(new BoxLayout(bottoms_inputs, BoxLayout.Y_AXIS));
         bottoms_inputs.setBackground(Color.WHITE);
         bottoms_inputs.setPreferredSize(new Dimension(300,500));
         bottoms_inputs.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add the data input fields
        bottoms_inputs.add(item_name_panel(item_name_text2));
        bottoms_inputs.add(data_panes(bottom_type_combo, "Enter Bottom Type:"));
        bottoms_inputs.add(data_panes(color_combo_box2, "Enter Bottom Color:"));
        bottoms_inputs.add(data_panes(size_combo2, "Enter Bottom Size:"));
        bottoms_inputs.add(data_panes(waist_size_combo, "Enter Waist Size:"));
        bottoms_inputs.add(data_panes(length_combo, "Enter Bottom Length:"));
        bottoms_inputs.add(data_panes(inseam_combo, "Enter Inseam Length:"));
        bottoms_inputs.add(data_panes(rise_combo, "Enter Rise Length:"));
        bottoms_inputs.add(description_panel(description_text2));
        bottoms_inputs.add(price_panel(price_text2));
        bottoms_inputs.add(image_btn(image_upload_btn2));
        bottoms_inputs.add(getUploadPostButton(upload_post_btn2));


         bottoms_panel.add(buffer_panel( true), BorderLayout.WEST);
         bottoms_panel.add(buffer_panel( false), BorderLayout.EAST);
         bottoms_panel.add(bottoms_inputs, BorderLayout.CENTER);

         return bottoms_panel;
    }


    private JPanel getShoesPanel(){
        JPanel shoes_panel = new JPanel();
        shoes_panel.setLayout(new BorderLayout());
        shoes_panel.setBackground(Color.WHITE);
        shoes_panel.setSize(500,700);
//        shoes_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Create the Panel that the shoe data inputs sit on
        JPanel shoes_inputs = new JPanel();
        shoes_inputs.setLayout(new BoxLayout(shoes_inputs, BoxLayout.Y_AXIS));
        shoes_inputs.setBackground(Color.WHITE);
        shoes_inputs.setPreferredSize(new Dimension(300,500));
        shoes_inputs.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add the data input fields
        shoes_inputs.add(item_name_panel(item_name_text3));
        shoes_inputs.add(data_panes(shoes_type_combo, "Enter Shoes Type:"));
        shoes_inputs.add(data_panes(color_combo_box3, "Enter Shoe Color:"));
        shoes_inputs.add(data_panes(shoes_size_combo, "Enter Shoe Size:"));
        shoes_inputs.add(description_panel(description_text3));
        shoes_inputs.add(price_panel(price_text3));
        shoes_inputs.add(image_btn(image_upload_btn3));
        shoes_inputs.add(getUploadPostButton(upload_post_btn3));

        shoes_panel.add(buffer_panel( true), BorderLayout.WEST);
        shoes_panel.add(buffer_panel( false), BorderLayout.EAST);
        shoes_panel.add(shoes_inputs, BorderLayout.CENTER);

        return shoes_panel;
    }








    // Action Performers
    @Override
    public void actionPerformed(ActionEvent e) {

        // User selects which item type to upload
        if(e.getSource() == tops_btn) {
            System.out.println("Showing top item data fields.");
            cards.show(maincard, "tops_panel");
//            resetTopFields();
        }

        if (e.getSource() == bottoms_btn) {
            System.out.println("Showing bottom item data fields.");
            cards.show(maincard, "bottoms_panel");
//            resetBottomFields();
        }

        if(e.getSource() == shoes_btn) {
            System.out.println("Showing shoes item data fields.");
            cards.show(maincard, "shoes_panel");
//            resetShoeFields();
        }



        // Check Top Inputs to see if upload_post_btn should be enabled
        if(e.getSource() == top_type_combo){
            checkTopFields();
        } if (e.getSource() == chest_size_combo){
            checkTopFields();
        } if (e.getSource() == hem_size_combo){
            checkTopFields();
        } if (e.getSource() == sleeve_length_combo){
            checkTopFields();
        } if (e.getSource() == size_combo1){
            checkTopFields();
        } if (e.getSource() == color_combo_box1){
            checkTopFields();
        }


        // Check Bottom Fields to see if upload_post_btn should be enabled
        if (e.getSource() == waist_size_combo){
            checkBottomFields();
        } if (e.getSource() == rise_combo){
            checkBottomFields();
        } if (e.getSource() == inseam_combo) {
            checkBottomFields();
        } if (e.getSource() == bottom_type_combo){
            checkBottomFields();
        } if(e.getSource() == color_combo_box2){
            checkBottomFields();
        } if(e.getSource() == size_combo2){
            checkBottomFields();
        } if (e.getSource() == length_combo){
            checkBottomFields();
        }

        // Check Shoes Fields to see if upload_post_btn should be enabled
        if(e.getSource() == shoes_type_combo || e.getSource() == color_combo_box3 || e.getSource() == shoes_size_combo) {
            checkShoeFields();
        }



        if(e.getSource() == upload_post_btn1) {

            // Verify Price, Name, and Description
            if(uploadController.verifyName(item_name_text1.getText()) && uploadController.verifyPrice(price_text1.getText()) && uploadController.verifyDescription(description_text1.getText())){

                try {
                    writeToImages();
                    uploadController.uploadTop(item_name_text1.getText(), getSelected(top_type_combo), getSelected(color_combo_box1),
                            getSelected(size_combo1), getSelected(chest_size_combo), getSelected(hem_size_combo),
                            getSelected(sleeve_length_combo), price_text1.getText(), description_text1.getText(), outputFilePath);
                    resetTopFields();
                    profile.refreshProfilePage();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(maincard, ex.getMessage(), "Something went wrong.", JOptionPane.ERROR_MESSAGE);
                    upload_post_btn1.setEnabled(false);
                }
            } else {
                upload_post_btn1.setEnabled(false);
            }


        } if (e.getSource() == upload_post_btn2) {
            // Verify Price, Name, and Description
            if(uploadController.verifyName(item_name_text2.getText()) && uploadController.verifyPrice(price_text2.getText()) && uploadController.verifyDescription(description_text2.getText())){

                try{
                    writeToImages();
                    uploadController.uploadBottom(item_name_text2.getText(), getSelected(bottom_type_combo), getSelected(color_combo_box2),
                            getSelected(size_combo2), getSelected(waist_size_combo), getSelected(length_combo), getSelected(inseam_combo),
                            getSelected(rise_combo), price_text2.getText(), description_text2.getText(), outputFilePath);
                    resetBottomFields();
                    profile.refreshProfilePage();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(maincard, ex.getMessage(), "Something went wrong.", JOptionPane.ERROR_MESSAGE);
                    upload_post_btn2.setEnabled(false);
                }
            } else {
                upload_post_btn2.setEnabled(false);
            }


        } if (e.getSource() == upload_post_btn3) {
            // Verify Price, Name, and Description
            System.out.println(item_name_text3.getText());
            System.out.println(price_text3.getText());
            System.out.println(description_text3.getText());
            if(uploadController.verifyName(item_name_text3.getText()) && uploadController.verifyPrice(price_text3.getText()) && uploadController.verifyDescription(description_text3.getText())){

                try{
                    writeToImages();
                    uploadController.uploadShoe(item_name_text3.getText(), getSelected(shoes_type_combo), getSelected(shoes_size_combo)
                        , price_text3.getText(), getSelected(color_combo_box3), description_text3.getText(), outputFilePath);
                    resetShoeFields();
                    profile.refreshProfilePage();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(maincard, ex.getMessage(), "Something went wrong.", JOptionPane.ERROR_MESSAGE);
                    upload_post_btn3.setEnabled(false);
                }
            } else {
                upload_post_btn3.setEnabled(false);
            }
        }


        if (e.getSource() == image_upload_btn1) {
            createFileChooser(upload_post_btn1);
        } if(e.getSource() == image_upload_btn2){
            createFileChooser(upload_post_btn2);
        } if (e.getSource() == image_upload_btn3) {
            createFileChooser(upload_post_btn3);
        }

    }

    private void createFileChooser(JButton button){
        // Create a JFileChooser for taking in item image
        JFileChooser fileChooser = getJFileChooser();

        int returnVal = fileChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            selected_file = fileChooser.getSelectedFile();

            try{
                image_file = ImageIO.read(selected_file);
                button.setEnabled(true);
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, "Error loading image.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String getSelected(JComboBox<String> combo){
        Object selectedItem = combo.getSelectedItem();
        return selectedItem != null ? selectedItem.toString() : "";
    }


    // Function used to write an uploaded picture to the Images package
    private void writeToImages() {
        File imagesDir = new File("src/UGT_Data/Images");

        // Generate a unique file name to prevent overwrites
        String originalFilename = selected_file.getName();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        newFileName = "image_" + System.currentTimeMillis() + extension;
        File outputFile = new File(imagesDir, newFileName);
        outputFilePath = "src/UGT_Data/Images/" + newFileName;
        try {
            // Save the image
            ImageIO.write(image_file, extension.substring(1), outputFile);
            JOptionPane.showMessageDialog(null,
                    "Image saved successfully to: Images",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving image",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Creates and Filters the FileChooser
    private static JFileChooser getJFileChooser() {
        JFileChooser fileChooser = new JFileChooser();

        // Set File Filter to only allow files ending in .jpeg, .jpg, and .png
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                String name = f.getName().toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || f.isDirectory();
            }
            public String getDescription() {
                return "Image files: *.jpg, *.jpeg, *.png";
            }
        });
        return fileChooser;
    }




    // Check all the Top Item data entries in order to enable upload_post_btn
    private void checkTopFields(){
        // Check if all size fields do not equal null
        boolean check_top_type = top_type_combo.getSelectedIndex() != 0;
        boolean check_size = size_combo1.getSelectedIndex() != 0;
        boolean check_chest_size = chest_size_combo.getSelectedIndex() != 0;
        boolean check_hem_size = hem_size_combo.getSelectedIndex() != 0;
        boolean check_sleeve_length = sleeve_length_combo.getSelectedIndex() != 0;
        boolean check_color = color_combo_box1.getSelectedIndex() != 0;
        boolean check_description = !description_text1.getText().isEmpty();
        boolean check_price = !price_text1.getText().isEmpty();

        if(check_top_type && check_size && check_chest_size && check_hem_size && check_sleeve_length && check_color && check_description && check_price){
            System.out.println("YIPPEE");
            upload_post_btn1.setEnabled(true);
        }

    }

    // Check all the Bottom Item data entries in order to enable upload_post_btn
    private void checkBottomFields(){
        boolean check_bottom_type = bottom_type_combo.getSelectedIndex() != 0;
        boolean check_size = size_combo2.getSelectedIndex() != 0;
        boolean check_waist_size = waist_size_combo.getSelectedIndex() != 0;
        boolean check_inseam_size = inseam_combo.getSelectedIndex() != 0;
        boolean check_rise_size = rise_combo.getSelectedIndex() != 0;
        boolean check_length = length_combo.getSelectedIndex() != 0;
        boolean check_color = color_combo_box2.getSelectedIndex() != 0;
        boolean check_description = !description_text2.getText().isEmpty();
        boolean check_price = !price_text2.getText().isEmpty();

        if(check_bottom_type && check_size && check_inseam_size && check_waist_size && check_rise_size && check_length &&  check_color && check_description && check_price){
            System.out.println("YIPPEE");
            upload_post_btn2.setEnabled(true);
        }
    }


//     Check all Shoe Item data entries in order to enable upload_post_btn
    private void checkShoeFields(){
        boolean check_shoes_type = shoes_type_combo.getSelectedIndex() != 0;
        boolean check_shoe_size = shoes_size_combo.getSelectedIndex() != 0;
        boolean check_color = color_combo_box3.getSelectedIndex() != 0;
        boolean check_description = !description_text3.getText().isEmpty();
        boolean check_price = !price_text3.getText().isEmpty();

        if(check_shoes_type && check_shoe_size &&  check_color && check_description && check_price){
            System.out.println("YIPPEE");
            upload_post_btn3.setEnabled(true);
        }

    }

    // Reset all the data inputs
    private void resetTopFields(){
         item_name_text1.setText("");
         top_type_combo.setSelectedIndex(0);
         color_combo_box1.setSelectedIndex(0);
         size_combo1.setSelectedIndex(0);
         chest_size_combo.setSelectedIndex(0);
         hem_size_combo.setSelectedIndex(0);
         sleeve_length_combo.setSelectedIndex(0);
         price_text1.setText("");
         description_text1.setText("");
         upload_post_btn1.setEnabled(false);
    }

    private void resetBottomFields(){
         bottom_type_combo.setSelectedIndex(0);
         size_combo2.setSelectedIndex(0);
         color_combo_box2.setSelectedIndex(0);
         length_combo.setSelectedIndex(0);
         rise_combo.setSelectedIndex(0);
         inseam_combo.setSelectedIndex(0);
         waist_size_combo.setSelectedIndex(0);
         description_text2.setText("");
         price_text2.setText("");
         item_name_text2.setText("");
         upload_post_btn2.setEnabled(false);
    }

    private void resetShoeFields(){
         shoes_type_combo.setSelectedIndex(0);
         shoes_size_combo.setSelectedIndex(0);
         color_combo_box3.setSelectedIndex(0);
         item_name_text3.setText("");
         description_text3.setText("");
         price_text3.setText("");
         upload_post_btn3.setEnabled(false);
    }


}

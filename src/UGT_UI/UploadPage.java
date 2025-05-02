package UGT_UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

//change out JFrame to JPanel

public class UploadPage extends JPanel implements ActionListener {

    // Buttons used throughout the Upload Page
    /*
    JButton profile_btn; // Profile Button for the footer (cannot be used on this page)
    JButton upload_btn;
    JButton settings_btn;

     */



    JButton tops_btn; // Button used to display top data input fields
    JButton bottoms_btn; // Button used to display bottom data input fields
    JButton shoes_btn; // Button used to display shoes data input fields
    JButton upload_post_btn; // Button used to upload a post to the system
    JButton image_upload_btn; // Button used to upload a picture for the item

    // Used to determine what type of entry fields to display and what type of item to create
    private final int selected;
    private final int top_selected;
    private final int bottom_selected;
    private final int shoes_selected;

    // Arrays for Combo Boxes
    String [] top_type_array = {"", "Shirt", "Sweater", "Jacket", "Fleece", "Tank Top", "Coat", "Vest"};
    String[] size_array = {"", "XS", "S", "M", "L", "XL", "XX", "XXL"};
    String[] measurement_array = {"", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
            , "32", "33", "34", "35", "36", "37", "38", "39","40", "41","42", "43", "44", "45", "46", "47", "48", "49", "50", "51"};
    String [] top_material_array = {"", "Cotton", "Silk", "Wool", "Polyester", "Denim"};
    String [] color_array = {"", "Red", "Blue", "Green", "Yellow", "Orange", "Light Blue", "Dark Blue", "Purple", "Violet", "Cyan", "Black", "White", "Gray", "Light Gray"};
    String [] bottom_type_array = {"", "Jeans", "Sweatpants", "Shorts", "Skirt", "Leggings"};
    String [] rise_array = {"", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
    String [] shoes_type_array = {"", "Sneakers", "Sandals", "Slippers", "Boots", "Socks", "Tennis Shoes"};
    String [] shoes_material_array = {"", "Leather", "Braided", "Canvas", "Cork", "Nylon", "Foam", "Velvet", "Rubber"};
    String [] shoes_size_array = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};

    // General Combo Boxes
    JComboBox<String> length_combo = new JComboBox<>(measurement_array);
    JComboBox<String> material_1_combo = new JComboBox<>(top_material_array);
    JComboBox<String> material_2_combo = new JComboBox<>(top_material_array);
    JComboBox<String> material_3_combo =  new JComboBox<>(top_material_array);
    JComboBox<String> color_combo = new JComboBox<>(color_array);
    JComboBox<String> size_combo = new JComboBox<>(size_array);

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
    JComboBox<String> thigh_size_combo = new JComboBox<>(measurement_array);

    // Shoes Combo Boxes
    JComboBox<String> shoes_type_combo = new JComboBox<>(shoes_type_array);
    JComboBox<String> shoes_material1_combo = new JComboBox<>(shoes_material_array);
    JComboBox<String> shoes_material2_combo = new JComboBox<>(shoes_material_array);
    JComboBox<String> shoes_material3_combo = new JComboBox<>(shoes_material_array);
    JComboBox<String> shoes_size_combo = new JComboBox<>(shoes_size_array);

    // Files for saving the Item Image
    BufferedImage image_file;
    File selected_file; // Stores the currently selected file from the FileChooser
    ImageIcon item_image; // The actual image to be added to the softwarre


    // Upload Page Constructor
    public UploadPage(int selected, int top_selected, int bottom_selected, int shoes_selected) {
        // The frame that all panel components will be fixed on
        JFrame upload_frame = new JFrame();
        upload_frame.setTitle("UnderGround Threads");
        upload_frame.setSize(600, 800);
        //upload_frame.setLayout(cardLayout);
        this.selected = selected;
        this.top_selected = top_selected;
        this.bottom_selected = bottom_selected;
        this.shoes_selected = shoes_selected;

        // Add Upload Panel to the frame
        upload_frame.add(getUploadPanel());


        upload_frame.setLocationRelativeTo(null);
        upload_frame.setResizable(false);
        upload_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        upload_frame.setVisible(true);
    }



    private JPanel getUploadPanel() {
        // The panel that all visual components will be fixed on
        JPanel upload_panel = new JPanel();
        upload_panel.setBackground(Color.WHITE);
        upload_panel.setLayout(null);
        upload_panel.setPreferredSize(new Dimension(600, 800));


        /*
        // Get Brand Footer
        BrandFooter footer_panel = new BrandFooter();

        // Create/Get the 3 Footer buttons and give them ActionListeners
        upload_btn = footer_panel.getUpload_btn();
        upload_btn.setEnabled(false);

        profile_btn = footer_panel.getProfile_btn();
        profile_btn.addActionListener(this);

        // Settings Button for the footer
        settings_btn = footer_panel.getSettings_btn();
        settings_btn.addActionListener(this);

         */


        // Add Footer and Header Components to the Upload Panel
        upload_panel.add(new TitleHeader());
        //upload_panel.add(footer_panel);


        // If no item type has been Selected
        if (selected == 0) {
            upload_panel.add(itemTypePanel());
        }
        // If Top Item has been Selected
        else if (top_selected == 1) {
            upload_panel.add(getTopsPanel());
        }
        // If Bottom Item has been Selected
        else if (bottom_selected == 1) {
            upload_panel.add(getBottomsPanel());
        }
        // If Shoes Item has been Selected
        else if (shoes_selected == 1) {
            upload_panel.add(getShoesPanel());
        }

        return upload_panel;
    }

    private JLayeredPane itemTypePanel(){
        // Create the Panel to be added to the Upload Panel
        JLayeredPane itemTypePanel = new JLayeredPane();
        itemTypePanel.setBackground(Color.WHITE);
        itemTypePanel.setBounds(200, 250, 200, 210);
        itemTypePanel.setPreferredSize(new Dimension(200, 200));
        itemTypePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // itemTypePanel.setLayout(new GridLayout(3, 1));

        JLabel itemTypeLabel = new JLabel("Select Item Type to Upload");
        itemTypeLabel.setBounds(16, 3, 200, 17);

        tops_btn = new JButton("Tops");
        tops_btn.setBounds(25, 20, 150, 60);
        tops_btn.addActionListener(this);

        bottoms_btn = new JButton("Bottoms");
        bottoms_btn.setBounds(25, 80, 150, 60);
        bottoms_btn.addActionListener(this);

        shoes_btn = new JButton("Shoes");
        shoes_btn.setBounds(25, 140, 150, 60);
        shoes_btn.addActionListener(this);

        itemTypePanel.add(itemTypeLabel);
        itemTypePanel.add(tops_btn);
        itemTypePanel.add(bottoms_btn);
        itemTypePanel.add(shoes_btn);

        return itemTypePanel;
    }


    // The Layered Panel used to show the price
    JTextField price_text;
    private JLayeredPane price_panel(int y){
        JLabel price_label;
        price_text = new JTextField();

        JLayeredPane price_panel = new JLayeredPane();
        price_panel.setLayout(null);
        price_panel.setBounds(90, y, 310, 32);
//        price_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        price_label = new JLabel("Enter Price:");
        price_label.setBounds(10 ,0, 100, 30);

        price_text.setBounds(156, 2, 150, 30);

        price_panel.add(price_label);
        price_panel.add(price_text);

        return price_panel;
    }


    // The LayeredPane to show the item description TextArea
    JTextArea description_text;
    private JLayeredPane description_panel(int y){
        JLayeredPane description_panel = new JLayeredPane();
        description_panel.setLayout(null);
        description_panel.setBounds(90, y, 310, 107);
//        description_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel description_label;
        description_label = new JLabel("Enter Description:");
        description_label.setBounds(10 ,0, 150, 30);

        description_text = new JTextArea();
        description_text.setBounds(10, 24, 290, 75);
        description_text.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        description_text.setLineWrap(true);
        description_text.setWrapStyleWord(true);



        description_panel.add(description_label);
        description_panel.add(description_text);

        return description_panel;
    }

    JTextField item_name_text;
    JLayeredPane item_name_panel(){
        JLayeredPane item_name_panel = new JLayeredPane();
        item_name_text = new JTextField();

        item_name_panel.setLayout(null);
        item_name_panel.setBounds(90, 10, 310, 32);
//        item_name_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel item_name_label;
        item_name_label = new JLabel("Enter Item Name:");
        item_name_label.setBounds(10 ,0, 120, 30);


        item_name_text.setBounds(156, 2, 150, 30);


        item_name_panel.add(item_name_label);
        item_name_panel.add(item_name_text);

        return item_name_panel;
    }

    // Upload Post Button
    private JButton getUploadPostButton() {
        upload_post_btn = new JButton("Upload Post");
        upload_post_btn.setBounds(185, 600, 126, 50);
        upload_post_btn.setFocusable(Boolean.FALSE);
        upload_post_btn.setEnabled(false);
        upload_post_btn.addActionListener(this);

        return upload_post_btn;
    }


    private JLayeredPane image_btn(int y){
        JLayeredPane image_btn_pane = new JLayeredPane();
        image_btn_pane.setLayout(null);
        image_btn_pane.setBounds(90, y, 310, 32);



        image_upload_btn = new JButton("Upload Image");
        image_upload_btn.setBounds(82, 0, 153, 30);
        image_upload_btn.setFocusable(false);
        image_upload_btn.addActionListener(this);

        image_btn_pane.add(image_upload_btn);

        return image_btn_pane;
    }


    // General function for creating a LayeredPanel with label and Combo box
    private JLayeredPane data_pane(JComboBox<String> comboBox, String label_text, int panel_y)
    {
        // Set Pane characteristics
        JLayeredPane data_pane = new JLayeredPane();
        data_pane.setLayout(null);
        data_pane.setBounds(90, panel_y, 310, 32);
//        data_pane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Set up the Label parameters
        JLabel label = new JLabel(label_text);
        label.setBounds(10, 0, 150, 30);

        // Set up the ComboBox and its dimensions
        comboBox.setBounds(156, 2, 150, 30);
        comboBox.setFocusable(false);
        comboBox.addActionListener(this);

        data_pane.add(label);
        data_pane.add(comboBox);

        return data_pane;
    }


    // Data Input Fields for Top Item
    private JLayeredPane getTopsPanel() {
        JLayeredPane tops_panel = new JLayeredPane();
        tops_panel.setBounds(50, 50, 500, 660);
        tops_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        tops_panel.add(item_name_panel());
        tops_panel.add(data_pane(top_type_combo, "Select Top:", 42), 0, 0); // Item Type LP (LayeredPane)
        tops_panel.add(data_pane(size_combo, "Select Top Size:",74), 1, 0); // General Size LP
        tops_panel.add(data_pane(chest_size_combo, "Select Chest Size:" ,106), 2, 0); // Chest Size LP
        tops_panel.add(data_pane(length_combo, "Select Top Length:", 138), 0, 1); // Length LP
        tops_panel.add(data_pane(hem_size_combo, "Select Hem Size:", 170), 1, 1); // Hem Size LP
        tops_panel.add(data_pane(sleeve_length_combo, "Select Sleeve Length:", 202), 2, 1); // Sleeve Length LP
        tops_panel.add(data_pane(material_1_combo, "Select Material:", 234), 3, 1); // Material 1 LP
        tops_panel.add(data_pane(material_2_combo, "Select Material:", 266), 0, 2); // Material 2 LP
        tops_panel.add(data_pane(material_3_combo, "Select Material:", 298), 1, 2); // Material 3 LP
        tops_panel.add(data_pane(color_combo, "Select Color:", 330), 0, 3); // Color Lp
        tops_panel.add(price_panel(362), 1, 4);
        tops_panel.add(description_panel(394), 0, 4);
        tops_panel.add(getUploadPostButton(), 0, 5);
        tops_panel.add(image_btn(508), 0, 6);



        return tops_panel;
    }

    // Data Input Fields for Bottom Item
    private JLayeredPane getBottomsPanel() {
        JLayeredPane bottoms_panel = new JLayeredPane();
        bottoms_panel.setBounds(50, 50, 500, 660);
        bottoms_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Add Data Panes to the Bottom Panel
        bottoms_panel.add(item_name_panel());
        bottoms_panel.add(data_pane(bottom_type_combo, "Select Bottoms:", 42), 0, 0);
        bottoms_panel.add(data_pane(size_combo, "Select Bottom Size:", 74), 1, 0);
        bottoms_panel.add(data_pane(waist_size_combo, "Select Waist Size:", 106), 2, 0);
        bottoms_panel.add(data_pane(inseam_combo, "Select Inseam Size:", 138), 0, 1);
        bottoms_panel.add(data_pane(rise_combo, "Select Rise Size:", 170), 2, 1);
        bottoms_panel.add(data_pane(thigh_size_combo, "Select Thigh Size:", 202), 0, 2);
        bottoms_panel.add(data_pane(length_combo, "Select Length:", 234), 2, 1);
        bottoms_panel.add(data_pane(material_1_combo, "Select Material:", 266), 0, 3);
        bottoms_panel.add(data_pane(material_2_combo, "Select Material:", 298), 1, 3);
        bottoms_panel.add(data_pane(material_3_combo, "Select Material:", 330), 2, 3);
        bottoms_panel.add(data_pane(color_combo, "Select Color:", 362), 0, 4);
        bottoms_panel.add(price_panel(394), 0, 5);
        bottoms_panel.add(description_panel(426), 0, 6);
        bottoms_panel.add(image_btn(540), 0, 6);
        bottoms_panel.add(getUploadPostButton(), 0, 7);


        return bottoms_panel;
    }

    private JLayeredPane getShoesPanel(){
        JLayeredPane shoes_panel = new JLayeredPane();
        shoes_panel.setBounds(50, 50, 500, 660);
        shoes_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        shoes_panel.add(item_name_panel());
        shoes_panel.add(data_pane(shoes_type_combo, "Select Shoes:", 42), 0, 0);
        shoes_panel.add(data_pane(shoes_size_combo, "Select Shoes Size: ", 74), 1, 0);
        shoes_panel.add(data_pane(shoes_material1_combo, "Select Material:", 106), 0, 2);
        shoes_panel.add(data_pane(shoes_material2_combo, "Select Material:", 138), 2, 1);
        shoes_panel.add(data_pane(shoes_material3_combo, "Select Material:", 170), 2, 1);
        shoes_panel.add(data_pane(color_combo, "Select Color:", 202), 0, 3);
        shoes_panel.add(price_panel(234), 0, 5);
        shoes_panel.add(description_panel(266), 0, 6);
        shoes_panel.add(getUploadPostButton(), 0, 7);
        shoes_panel.add(image_btn(380), 0, 6);


        return shoes_panel;
    }








    // Action Performers
    @Override
    public void actionPerformed(ActionEvent e) {

        // Switch to Profile Page
        /*
        if (e.getSource() == profile_btn) {
            dispose();
            new ProfilePage();
        }

         */

        // User selects which item type to upload
        if(e.getSource() == tops_btn) {

            new UploadPage(1, 1, 0, 0);
        }

        if (e.getSource() == bottoms_btn) {

            new UploadPage(1, 0, 1, 0);

        }

        if(e.getSource() == shoes_btn) {

            new UploadPage(1, 0, 0, 1);
        }

        // Check Top Inputs to see if upload_post_btn should be enabled
        if(e.getSource() == top_type_combo){
            upload_post_btn.setEnabled(false);
            checkTopFields();
        }

        if (e.getSource() == chest_size_combo){
            upload_post_btn.setEnabled(false);
            checkTopFields();
        }

        if (e.getSource() == hem_size_combo){
            upload_post_btn.setEnabled(false);
            checkTopFields();
        }
        if (e.getSource() == sleeve_length_combo){
            upload_post_btn.setEnabled(false);
            checkTopFields();
        }


        // Check Bottom Fields to see if upload_post_btn should be enabled
        if (e.getSource() == waist_size_combo){
            upload_post_btn.setEnabled(false);
            checkBottomFields();
        }

        if (e.getSource() == thigh_size_combo){
            upload_post_btn.setEnabled(false);
            checkBottomFields();
        }

        if (e.getSource() == rise_combo){
            upload_post_btn.setEnabled(false);
            checkBottomFields();
        }

        if (e.getSource() == inseam_combo){
            upload_post_btn.setEnabled(false);
            checkBottomFields();
        }

        if (e.getSource() == bottom_type_combo){
            upload_post_btn.setEnabled(false);
            checkBottomFields();
        }

        // Check shared inputs to see if upload_post_btn is enabled
        if (e.getSource() == size_combo){
            upload_post_btn.setEnabled(false);
            if(top_selected == 1){
                checkTopFields();
            } else if(bottom_selected == 1){
                checkBottomFields();
            }
        }

        if (e.getSource() == length_combo){
            upload_post_btn.setEnabled(false);
            if(top_selected == 1){
                checkTopFields();
            } else if(bottom_selected == 1){
                checkBottomFields();
            }
        }

        if (e.getSource() == material_1_combo){
            upload_post_btn.setEnabled(false);
            if(top_selected == 1){
                checkTopFields();
            } else if(bottom_selected == 1){
                checkBottomFields();
            }
        }

        if (e.getSource() == material_2_combo){
            upload_post_btn.setEnabled(false);
            if(top_selected == 1){
                checkTopFields();
            } else if(bottom_selected == 1){
                checkBottomFields();
            }
        }

        if (e.getSource() == material_3_combo){
            upload_post_btn.setEnabled(false);
            if(top_selected == 1){
                checkTopFields();
            } else if(bottom_selected == 1){
                checkBottomFields();
            }
        }

        if (e.getSource() == color_combo){
            upload_post_btn.setEnabled(false);
            if(top_selected == 1){
                checkTopFields();
            } else if(bottom_selected == 1){
                checkBottomFields();
            }
        }

        if (e.getSource() == description_text){
            upload_post_btn.setEnabled(false);
            if (!description_text.getText().isEmpty()){
                if(top_selected == 1){
                    checkTopFields();
                } else if(bottom_selected == 1){
                    checkBottomFields();
                }
            }
        }

        if (e.getSource() == price_text){
            upload_post_btn.setEnabled(false);
            if (!price_text.getText().isEmpty()){
                if(top_selected == 1){
                    checkTopFields();
                } else if(bottom_selected == 1){
                    checkBottomFields();
                }
            }
        }


        if(e.getSource() == upload_post_btn) {
            System.out.println("Item Successfully uploaded!");

            File imagesDir = new File("src/UGT_Data/Images");
            if(!imagesDir.exists()){
                imagesDir.mkdir();
            }

            // Generate a unique file name to prevent overwrites
            String originalFilename = selected_file.getName();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = "image_" + System.currentTimeMillis() + extension;
            File outputFile = new File(imagesDir, newFileName);

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


            new ProfilePage();
        }

        if (e.getSource() == image_upload_btn) {
            // Create a JFileChooser for taking in item image
            JFileChooser fileChooser = getJFileChooser();

            int returnVal = fileChooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                selected_file = fileChooser.getSelectedFile();

                try{
                    image_file = ImageIO.read(selected_file);
                    upload_post_btn.setEnabled(true);
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, "Error loading image.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

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
        boolean check_size = size_combo.getSelectedIndex() != 0;
        boolean check_chest_size = chest_size_combo.getSelectedIndex() != 0;
        boolean check_length = length_combo.getSelectedIndex() != 0;
        boolean check_hem_size = hem_size_combo.getSelectedIndex() != 0;
        boolean check_sleeve_length = sleeve_length_combo.getSelectedIndex() != 0;
        boolean check_material_1 = material_1_combo.getSelectedIndex() != 0;
        boolean check_material_2 = material_2_combo.getSelectedIndex() != 0;
        boolean check_material_3 = material_3_combo.getSelectedIndex() != 0;
        boolean check_color = color_combo.getSelectedIndex() != 0;
        boolean check_description = !description_text.getText().isEmpty();
        boolean check_price = !price_text.getText().isEmpty();

        if(check_top_type && check_size && check_chest_size && check_length && check_hem_size && check_sleeve_length && check_material_1 && check_material_2 && check_material_3 && check_color && check_description && check_price){
            System.out.println("YIPPEE");
            upload_post_btn.setEnabled(true);
        }

    }









    // Check all the Bottom Item data entries in order to enable upload_post_btn
    private void checkBottomFields(){
        boolean check_bottom_type = bottom_type_combo.getSelectedIndex() != 0;
        boolean check_size = size_combo.getSelectedIndex() != 0;
        boolean check_waist_size = waist_size_combo.getSelectedIndex() != 0;
        boolean check_inseam_size = inseam_combo.getSelectedIndex() != 0;
        boolean check_rise_size = rise_combo.getSelectedIndex() != 0;
        boolean check_thigh_size = thigh_size_combo.getSelectedIndex() != 0;
        boolean check_length = length_combo.getSelectedIndex() != 0;
        boolean check_material_1 = material_1_combo.getSelectedIndex() != 0;
        boolean check_material_2 = material_2_combo.getSelectedIndex() != 0;
        boolean check_material_3 = material_3_combo.getSelectedIndex() != 0;
        boolean check_color = color_combo.getSelectedIndex() != 0;
        boolean check_description = !description_text.getText().isEmpty();
        boolean check_price = !price_text.getText().isEmpty();

        if(check_bottom_type && check_size && check_inseam_size && check_waist_size && check_rise_size && check_thigh_size && check_length && check_material_1 && check_material_2 && check_material_3 && check_color && check_description && check_price){
            System.out.println("YIPPEE");
            upload_post_btn.setEnabled(true);
        }
    }









    // Check all Shoe Item data entries in order to enable upload_post_btn
    private void checkShoeFields(){
        boolean check_shoes_type = shoes_type_combo.getSelectedIndex() != 0;
        boolean check_shoe_size = shoes_size_combo.getSelectedIndex() != 0;
        boolean check_material_1 = shoes_material1_combo.getSelectedIndex() != 0;
        boolean check_material_2 = shoes_material2_combo.getSelectedIndex() != 0;
        boolean check_material_3 = shoes_material3_combo.getSelectedIndex() != 0;
        boolean check_color = color_combo.getSelectedIndex() != 0;
        boolean check_description = !description_text.getText().isEmpty();
        boolean check_price = !price_text.getText().isEmpty();

        if(check_shoes_type && check_shoe_size && check_material_1 && check_material_2 && check_material_3 && check_color && check_description && check_price){
            System.out.println("YIPPEE");
            upload_post_btn.setEnabled(true);
        }

    }



}

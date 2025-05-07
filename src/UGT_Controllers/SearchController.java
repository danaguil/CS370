package UGT_Controllers;

import UGT_Data.Brand;
import UGT_Data.Item;
import UGT_UI.Buyer_HomePage;
import UGT_UI.Buyer_SearchPage;
import UGT_Services.UserService;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

import static UGT_Controllers.populateProgram.brandMap;
import static UGT_Controllers.populateProgram.itemMap;
import static UGT_Data.Brand.getBrandUsernameById;

public class SearchController {

    public void search() {
        String searchedText = Buyer_SearchPage.getSearchedText().toLowerCase().trim();

        if (!UserService.Validator.verifySingleInfo(searchedText, "search")) return;

        boolean foundAny = false;

        Buyer_SearchPage.clearResults(); // Clear previous results

        // Search Brands
        for (Map.Entry<String, Brand> entry : brandMap.entrySet()) {
            String brandName = entry.getKey().toLowerCase();
            if (brandName.contains(searchedText)) {
                JButton brandBtn = new JButton("Brand: " + entry.getKey());
                brandBtn.addActionListener(e -> {
                    System.out.println("Clicked brand: " + entry.getKey());
                    // Optional: Show brand profile here
                });

                Buyer_SearchPage.showSearchResult(brandBtn);
                foundAny = true;
            }
        }

        // Search Items
        for (Map.Entry<String, Item> entry : itemMap.entrySet()) {
            Item item = entry.getValue();
            String itemName = item.getName().toLowerCase();

            if (itemName.contains(searchedText)) {
                JButton itemBtn = new JButton("Item: " + item.getName());
                itemBtn.addActionListener(e -> {
                    // Use your PostPopUp from Buyer_HomePage
                    String brandname = getBrandUsernameById(item.getBrandId());
                    String description = item.getDescription();
                    String photoPath = item.getImagePath();
                    String price = String.valueOf(item.getPrice());
                    String size = item.getSize();

                    JPanel popup = new Buyer_HomePage().PostPopUp(brandname, description, photoPath, price, size, item);

                    JOptionPane.showMessageDialog(null, popup, "Item Details", JOptionPane.PLAIN_MESSAGE);
                });

                Buyer_SearchPage.showSearchResult(itemBtn);
                foundAny = true;
            }
        }

        if (!foundAny) {
            JLabel noResults = new JLabel("No results found for: " + searchedText);
            noResults.setForeground(Color.RED);
            Buyer_SearchPage.showSearchResult(noResults);
        }
    }
}

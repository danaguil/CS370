package UGT_Controllers;

import UGT_Data.Brand;
import UGT_Data.Item;
import UGT_Services.UserService;
import UGT_UI.Buyer_SearchPage;

import static UGT_Controllers.populateProgram.brandMap;
import static UGT_Controllers.populateProgram.itemMap;

/**
 * Controller for the search page, going to be used to search for items in the database or brands
 */

import java.util.Map;

public class SearchController {

    public void search() {
        String searchedText = Buyer_SearchPage.getSearchedText().toLowerCase().trim();

        if (!UserService.Validator.verifySingleInfo(searchedText, "search")) return;

        boolean foundAny = false;

        // Search Brands
        for (Map.Entry<String, Brand> entry : brandMap.entrySet()) {
            String brandName = entry.getKey().toLowerCase();
            if (brandName.contains(searchedText)) {
                System.out.println("Found Brand Match: " + entry.getKey());
                entry.getValue().displayInfo();
                foundAny = true;
            }
        }

        // Search Items
        for (Map.Entry<String, Item> entry : itemMap.entrySet()) {
            String itemName = entry.getValue().getName().toLowerCase();
            if (itemName.contains(searchedText)) {
                System.out.println("Found Item Match: " + entry.getValue().getName());
                entry.getValue().displayInfo();
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println("No results found for: " + searchedText);
        }
    }
}


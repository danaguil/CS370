package UGT_Controllers;

import java.util.UUID;

// Finished adding the new id generator in each customer, brand, and brandItems.txt, does user need one?

/**
 * Utility class for generating unique identifiers with a specified prefix.
 * This class provides a method to append a given prefix to a UUID, allowing for easy generation of
 * unique identifiers that can be prefixed with specific strings to indicate context or categorization.
 */
public class IDGenerator {

    /**
     * Generates a unique identifier
     * @return a unique identifier
     */
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

}

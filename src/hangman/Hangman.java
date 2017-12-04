package hangman;

import hangman.data.JSONReader;
import java.util.List;

/**
 *
 * @author johnny
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testReader();
    }
    
    private static void testReader() {
        JSONReader reader = new JSONReader();
        
        // This is an array list of Categories
        List<String> categories = reader.getCategories();
        
        // For each String (category) in categories...
        for (String category : categories) {
            // Print a header with the Category name...
            System.out.println("-------- " + category + " --------");
        
            // Get an array list of words from the current Category...
            List<String> words = reader.getWordsFromCategory(category);
            
            // For each String (word) in words...
            for (String word : words)
                // Print the word.
                System.out.println(word);
            
            System.out.println();
        }
    }
    
}

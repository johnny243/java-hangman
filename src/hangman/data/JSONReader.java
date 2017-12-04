package hangman.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author johnny
 */
public class JSONReader {
    private final String filePath = "src/hangman/data/";
    private final String fileName = "Dictionary.json";
    
    /**
     * readFile
     * 
     * A function to get the contents of our JSON files.
     * 
     * @return the contents of the file.
     * @throws IOException 
     */
    private String readFile() throws IOException {
        String file = this.filePath + this.fileName;
        
        return new String(Files.readAllBytes(Paths.get(file)));
    }
    
    /**
     * getJSONObject
     * 
     * Parses a String and returns a JSONObject.
     * 
     * @param fileContents represents a string in JSON syntax.
     * @return JSONObject
     */
    public JSONObject getJSONObject(String fileContents) {
        JSONParser parser = new JSONParser();
        
        try {
            return (JSONObject) parser.parse(fileContents);
        } catch(ParseException ex) {
            System.out.println("Error reading Categories.json file: " + ex);
        }
        
        return null;
    }
    
    /**
     * getCategories
     * 
     * Gets a list of Categories.
     * 
     * @return List<String>
     */
    public List<String> getCategories() {
        try {
            String fileContents = this.readFile();
            
            JSONObject obj = this.getJSONObject(fileContents);
            
            List<String> categories = new ArrayList<>();
            
            for (Object category : obj.keySet())
                categories.add(category.toString());
            
            return categories;
        } catch(IOException ex) {
            System.out.println("Error reading file: " + ex);
        }
        
        return null;
    }
    
    /**
     * getWordsFromCategory
     * 
     * Gets all words in a given category.
     * 
     * @param category
     * @return List<String>
     */
    
    public List<String> getWordsFromCategory(String category) {
        try {
            String fileContents = this.readFile();
            
            JSONObject obj = this.getJSONObject(fileContents);
            
            List<String> words = new ArrayList<>();
            
            for (Object word : (JSONArray) obj.get(category))
                words.add(word.toString());
            
            return words;
        } catch(IOException ex) {
            System.out.println("Error reading file: " + ex);
        }
        
        return null;
    }
}

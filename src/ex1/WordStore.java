package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordStore {

    private static final String[] ORDER = {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten"
    };
    List<String> words = new ArrayList<>();
    public void add(String numberAsWord) {
        words.add(numberAsWord);
    }

    public List<String> getStoredWords() {

        Collections.sort(words, (a,b) -> compare(a,b));
        return words;
    }

    public int compare(String a, String b) {
        return indexFinder(a) - indexFinder(b);
    }

    public int indexFinder(String element){
        int index = 0;
        for (int i = 0; i < ORDER.length; i++) {
            if(ORDER[i] == element){
                index = i;
            }
        }
        return index;
    }
}

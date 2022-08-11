package ex1.ex2;

import java.util.ArrayList;
import java.util.List;

public class NumberRepository {

    private String[] simpleNumberData = "2, 4, 6, 2, 9, 10".split(", ");
    private String[] scientificNumberData = "2e3, 2e4, 6e3".split(", ");


    public List<SimpleNumber> getSimpleNumbers() {
        List<SimpleNumber> allSimpleNumbers = new ArrayList<>();
        for (String num : simpleNumberData) {
            allSimpleNumbers.add(new SimpleNumber(Integer.parseInt(num)));
        }
        return allSimpleNumbers;
    }

    public List<ScientificNumber> getScientificNumbers() {
        List<ScientificNumber> allScientificNumbers = new ArrayList<>();
        for (String num : scientificNumberData) {
            allScientificNumbers.add(new ScientificNumber(Integer.parseInt(String.valueOf(num.charAt(0))), Integer.parseInt(String.valueOf(num.charAt(2)))));
        }
        return allScientificNumbers;
    }

    public List<Number> getAllNumbers() {
        List<Number> allNumbers = new ArrayList<>();
        for (String data : simpleNumberData) {
                 allNumbers.add(new SimpleNumber(Integer.parseInt(data)));
        }
        for (String data : scientificNumberData) {
            allNumbers.add(new ScientificNumber(Integer.parseInt(String.valueOf(data.charAt(0))), Integer.parseInt(String.valueOf(data.charAt(2)))));
        }
        return allNumbers;
    }

}

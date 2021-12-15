package company;


public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        String Up_word = word.toUpperCase();
        if (Up_word.equals(word)) {
            return true;
        }
        String Low_word = word.toLowerCase();
        if (Low_word.equals(word)) {
            return true;
        }
        String new_word = ""+Up_word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            new_word+=Low_word.charAt(i);
        }
        return new_word.equals(word);
    }

    public static void main(String[] args) {
        System.out.println(new DetectCapitalUse().detectCapitalUse("FlaG"));
    }
}

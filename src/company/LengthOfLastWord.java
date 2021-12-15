package company;

/**
 * @author 王波
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] a = s.split(" ");
        return a[a.length-1].length();
    }
}

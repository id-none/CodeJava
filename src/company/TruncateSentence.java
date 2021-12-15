package company;

/**
 * @author 王波
 */
public class TruncateSentence {
    String truncateSentence(String s, int k) {
        String[] ans = s.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sBuilder.append(ans[i]);
        }
        return sBuilder.toString();
    }
}

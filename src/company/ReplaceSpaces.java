package company;

public class ReplaceSpaces {
    public String replaceSpaces(StringBuffer str) {
        String ans = str.toString().replace(" ", "%20");
        return ans;
    }

    public boolean in_items(int i) {
        for (char c : (i + "").toCharArray()) {
            if (c == '2' || c == '0' || c == '9' || c == '1') {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int one = 1;
        int two = 1;
        int third = 1;
        int res = 3;
        for (int i = 4; i <= 20190324; i++) {
            res = (one + two + third) % 10000;
            one = two % 10000;
            two = third % 10000;
            third = res;
        }
        System.out.println(res);
    }

}

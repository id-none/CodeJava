package company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.next();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Integer.toOctalString(Integer.valueOf(arr[i], 16)));
        }
    }
}



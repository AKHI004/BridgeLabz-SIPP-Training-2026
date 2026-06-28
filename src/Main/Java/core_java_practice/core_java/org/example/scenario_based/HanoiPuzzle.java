package Main.Java.core_java_practice.core_java.org.example.scenario_based;

import java.util.Scanner;

public class HanoiPuzzle {

    static int moves = 0;

    static void towerOfHanoi(int n, char from, char aux, char to) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            moves++;
            return;
        }

        towerOfHanoi(n - 1, from, to, aux);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        moves++;
        towerOfHanoi(n - 1, aux, from, to);
    }

    static int binarySearch(int[] arr, int left, int right, int key) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == key)
            return mid;

        if (key < arr[mid])
            return binarySearch(arr, left, mid - 1, key);

        return binarySearch(arr, mid + 1, right, key);
    }

    static int sumOfDigits(int n) {
        if (n == 0)
            return 0;

        return n % 10 + sumOfDigits(n / 10);
    }

    static String reverse(String s) {
        if (s.length() == 0)
            return "";

        return reverse(s.substring(1)) + s.charAt(0);
    }

    static boolean balanced(String s, int index, int count) {
        if (count < 0)
            return false;

        if (index == s.length())
            return count == 0;

        if (s.charAt(index) == '(')
            return balanced(s, index + 1, count + 1);

        if (s.charAt(index) == ')')
            return balanced(s, index + 1, count - 1);

        return balanced(s, index + 1, count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        towerOfHanoi(n, 'A', 'B', 'C');
        System.out.println("Total Moves = " + moves);

        int[] prices = {100, 200, 300, 400, 500, 600};

        System.out.print("Enter price to search: ");
        int key = sc.nextInt();

        int pos = binarySearch(prices, 0, prices.length - 1, key);

        if (pos == -1)
            System.out.println("Price not found");
        else
            System.out.println("Price found at index " + pos);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Sum of digits = " + sumOfDigits(num));

        sc.nextLine();

        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Reversed = " + reverse(str));

        System.out.print("Enter parentheses string: ");
        String p = sc.nextLine();

        if (balanced(p, 0, 0))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");

        sc.close();
    }
}

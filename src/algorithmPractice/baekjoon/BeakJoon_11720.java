package algorithmPractice.baekjoon;

import java.util.Scanner;

public class BeakJoon_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String numbers = sc.next();
        System.out.println(count);
        int counter = 0;
        int[] array = new int[count];
        while (counter < count) {
            array[counter] = Character.getNumericValue(numbers.toCharArray()[counter]);
            counter++;
        }
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        System.out.println(sum);
    }
}

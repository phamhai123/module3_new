import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("enter number [" + i + "] : ");
            int input = scanner.nextInt();
            list.add(input);
        }
        int min = list.get(0);
        for (Integer integer : list) {
            if (min >= integer){
                min = integer;
            }
        }
        System.out.println("Smallest number :" + min);
    }

}

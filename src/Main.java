import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner myObj = new Scanner(System.in);
        String line = myObj.nextLine();
        String[] arr = line.split(" ");
        int[] numbers = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] operators = {"+", "-", "*", "/"};
        int x = 0, y = 0;
        if (arr.length != 3) {
            throw new IOException("Формат математической операции не удовлетворяет заданию: два операнда и один оператор (+, -, /, *)");
        }

        try {
            x = Integer.parseInt(arr[0]);
            y = Integer.parseInt(arr[2]);
        } catch (NumberFormatException e) {
            System.out.println("Один или оба операнда не являются цифрой");
        }

        boolean flag = false;

        for (int number: numbers) {
            if (x == number) {
                for (int number2 : numbers) {
                    if (y == number2) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (!flag) {
            throw new IOException("Операнды должны быть в пределах от -10 до 10");
        }

        switch (arr[1]) {
            case "+":
                System.out.println(x + y);
                break;
            case "-":
                System.out.println(x - y);
                break;
            case "*":
                System.out.println(x * y);
                break;
            case "/":
                try {
                    System.out.println(x / y);
                    break;
                } catch (ArithmeticException e) {
                    System.out.println("Ну ты чего Валера! На 0 делить нельзя!");
                    break;
                }
            default:
                throw new IOException("Неизвестный оператор");
        }



    }

}
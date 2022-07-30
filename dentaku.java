import java.util.*;

public class dentaku {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        out : while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String[] arr = line.split(" ");

            double total = 0;

            if (arr.length < 3 || ((arr.length != 3) && (arr.length % 3 != 2))) {

                System.out.println("入力が不正です。空白区切りで入力してください。");
                continue;

            } else {

                if (checkNum(arr[0])) {

                    total = Double.parseDouble(arr[0]);

                }

                for (int i = 0; i <= ((arr.length - 3) / 2); i++) {

                    if (checkOperator(arr[i * 2 + 1]) && checkNum(arr[i * 2 + 2])) {

                        switch (arr[i * 2 + 1]) {

                            case "+":
                            total = total + Double.parseDouble(arr[i * 2 + 2]);
                            break;

                            case "-":
                            total = total - Double.parseDouble(arr[i * 2 + 2]);
                            break;

                            case "*":
                            total = total * Double.parseDouble(arr[i * 2 + 2]);
                            break;

                            case "/":
                            total = total / Double.parseDouble(arr[i * 2 + 2]);
                            break;

                        }

                    } else {
                        System.out.println("入力が不正です。空白区切りで入力してください。");
                        continue out;
                    }

                }

                System.out.println(total);
            }
        }

        sc.close();
    }

    private static boolean checkNum(String str) {

        try {

            Double.parseDouble(str);

        } catch (NumberFormatException e) {

            return false;

        }

        return true;

    }

    private static boolean checkOperator(String str) {

        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        } else {
            return false;
        }

    }

}

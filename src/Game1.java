import java.util.Random;
import java.util.Scanner;

public class Game1 {
    static String[][] field;

    public static void main(String[] args) {
        initFeld();
        showField();

        while (!isFinishedGame()) {
            movePl();
            showField();
            movePCo();
            showField();


        }
    }

    public static void initFeld() {
        field = new String[3][3];
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[0].length; j++)
                field[i][j] = ".";
    }

    public static void showField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void movePl() {
        Scanner sc = new Scanner(System.in);
        boolean inNotFinishedMove = true;

        while (inNotFinishedMove) {
            System.out.println("Выберите строку и столбец куда нужно ходить");
            try {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                if (x >= 0 && x < field.length && y >= 0 && y < field.length) {
                    if (!field[x][y].equals("X") && !field[x][y].equals("O")) {
                        field[x][y] = "X";
                        inNotFinishedMove = false;
                    } else {
                        System.out.println("Тут сделан ход");
                    }
                } else {
                    System.out.println("Вы ушли за пределами поля");
                }
            } catch (Exception e){
                System.out.println("Вы ввели неправильные данные");
            }
        }

    }

    public static boolean isFinishedGame() {
        int countFreeSpace = 0;
        for (String[] arr : field)
            for (String elem : arr)
                if (elem.equals("."))
                    countFreeSpace += 1;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++)
                if (field[i][0].equals("X") && field[i][1].equals("X") && field[i][2].equals("X")
                        || (field[0][j].equals("X") && field[1][j].equals("X") && field[2][j].equals("X"))
                        || (field[0][0].equals("X") && field[1][1].equals("X") && field[2][2].equals("X"))
                        || (field[0][2].equals("x") && field[1][1].equals("X") && field[2][0].equals("X"))
                )     {

                    System.out.println("Игрок победил");
                    return true;
                }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][0].equals("O") && field[i][1].equals("O") && field[i][2].equals("O")
                         || (field[0][j].equals("O") && field[1][j].equals("O") && field[2][j].equals("O"))
                         || (field[0][0].equals("O") && field[1][1].equals("O") && field[2][2].equals("O"))
                         || (field[0][2].equals("O") && field[1][1].equals("O") && field[2][0].equals("O"))
                ) {
                        System.out.println("Компьютер победил");
                       return true;
                }
                }
            }
        if (countFreeSpace == 0) {
            System.out.println("Ничья");
                return true;
        }
        else {
                return false;
        }
    }

    public static void movePCo() {
        Random random = new Random();
        boolean inNotFinishedMove = true;

        while (inNotFinishedMove) {
            int x = random.nextInt(field.length);
            int y = random.nextInt(field.length);
            if (!field[x][y].equals("X") && !field[x][y].equals("O")) {
                field[x][y] = "O";
                inNotFinishedMove = false;

            }
        }
        {
            System.out.println("Компьютер сделал ход");
        }



    }
}




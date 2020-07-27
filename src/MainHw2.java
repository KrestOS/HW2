import java.util.Arrays;

public class MainHw2 {
    public static void main(String[] args) {

        //№1 Задание
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("До = " + Arrays.toString(arr1));
        replaceArrElement(arr1);
        System.out.println("После = " + Arrays.toString(arr1));

        //№2 Задание
        int[] arr2 = new int[8];
        fillArray(arr2);
        System.out.println(Arrays.toString(arr2));

        //№3 Задание
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        x2Array(arr3);
        System.out.println(Arrays.toString(arr3));

        //№4 Задание
        int[][] arr4 = new int[5][5];
        fillDiagonal2dArray(arr4);
        print2dArray(arr4);

        //№5 Задание
        int[] arr5 = {1, 5, 20, 2, 11, 79, 5, 2, 4, 18, 9, 1};
        System.out.println("Минимальный элемент массива = " + minElementArray(arr5));
        System.out.println("Максимальный элемент массива = " + maxElementArray(arr5));

        //№6 Задание
        int[] arr6 = {1,1,1,2,2,3};
        System.out.println("CheckBalance = " + checkBalanceArray(arr6));

        //№7 Задание
        int[] arr7 = {1,2,3};
        int n = -2;
        offsetElementsArray(arr7,n);

    }



    /*1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;*/

    public static void replaceArrElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }

    /*2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;*/
    public static void fillArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = arr[i - 1] + 3;
            }
        }

    }

    /*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;*/
    public static void x2Array(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
    }

    /*4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/
    public static void print2dArray(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void fillDiagonal2dArray(int[][] arr) {
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j || i + j == arr.length - 1) {
                    arr[i][j] = 1;
                }
            }

        }
    }

    /*5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);*/
    public static int minElementArray(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int maxElementArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.*/
    public static int sumArray(int[] arr){
        int sum = 0;
        for (int i = -1; i < arr.length-1; i++) {
            sum = sum + arr[i+1];
        }
        return sum;
    }
    public static boolean checkBalanceArray(int[] arr){
        int sumL = 0;
        for (int i = -1; i < arr.length-2; i++) {
           sumL = sumL + arr[i+1];
           if (sumL == sumArray(arr) - sumL){
               return true;
           }
        }
        return false;
    }

    /*7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.*/
    public static void offsetElementsArray(int[] arr,int n){
        int buffer;
        int curIndex;
        int moveIndex;
        for (int i = 0; i < greatCommonDivisor(n,arr.length); i++){
            buffer = arr[i];
            curIndex = i;
            if (n > 0){
                while (true) {
                    moveIndex = curIndex + n;
                    if (moveIndex >= arr.length) {
                        moveIndex = moveIndex - arr.length;
                    }
                    if (moveIndex == i) {
                        break;
                    }
                    arr[curIndex] = arr[moveIndex];
                    curIndex = moveIndex;
                    System.out.println(Arrays.toString(arr));
                }
            }else if (n < 0){
                while (true) {
                    moveIndex = curIndex + n;
                    if (moveIndex < 0) {
                        moveIndex = arr.length + moveIndex;
                    }
                    if (moveIndex == i) {
                        break;
                    }
                    arr[curIndex] = arr[moveIndex];
                    curIndex = moveIndex;
                    System.out.println(Arrays.toString(arr));
                }
            }
        arr[curIndex] = buffer;
        System.out.println(Arrays.toString(arr));
        }

    }
    public static int greatCommonDivisor(int a, int b){
        if (b == 0)
            return a;
        else
            return greatCommonDivisor(b, a % b);
    }
}



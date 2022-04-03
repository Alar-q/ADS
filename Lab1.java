import java.util.Scanner;

public class Lab1 {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args){

    }

    /** task 1 */
    public static int findMin(int[] arr){
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }


    /** task 2 */
    public static double findAverage(int[] arr){
        double res = 0;
        for(int i=0; i<arr.length; i++){
            res += arr[i];
        }
        return res / arr.length;
    }


    /** task 3 */
    public static void isPrime(int n ) {
        int c = 0;
        for (int i = 2; i < (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                c++;
            }
        }
        if (c > 0) {
            System.out.println("Composite");
        } else {
            System.out.println("Prime");
        }
    }


    /** task 4 */
    public static int factorial(int n) {
        int res = 1;
        if (n == 1 || n == 0) {
            return res;
        }
        res = n * factorial(n-1);
        return res;
    }


    /** task 5 */
    public static int fibonacci(int n) {
        if (n <=1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    /** task 6 */
    public static int square(int a , int n){
        if(n == 1){
            return a;
        }
        return a * square(a, n-1);
    }


    /** task 7 */
    public static void reverse(){
        int n = in.nextInt();
        reverse(n);
    }
    public static void reverse(int n){
        if(n < 1)
            return;
        int a = in.nextInt();
        reverse(n-1);
        System.out.println(a);
    }


    /** task 8 */
    public static void allDigits(String str){
        char[] arr = str.toCharArray();
        if(allDigits(arr, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    public static boolean allDigits(char[] arr, int i){
        if(i >= arr.length)
            return true;
        else if(!Character.isDigit(arr[i]))
            return false;
        else
            return allDigits(arr, i+1);
    }


    /** task 9 */
    public static int binomialCoefficient(int n, int k){
        return factorial(n) / (factorial(k) * factorial(n-k));
    }


    /** 10 */
    public static int GCD(int a, int b){
        // a = q*b + r
        int r = a % b;
        if(r == 0)
            return b;
        return GCD(b, r);
    }
}

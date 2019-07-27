public class Main {
    public static void main(String[] args) {
        //8 primitive data types
        byte b1 = 0; // from -128 to 127 (not 128, because 0 is a number too)
        short s1 = 31999; //from -32768 to 32767
        int i1 = -33000; //from 2147483648 to 2147483647
        long l1 = 323243232; //from 9223372036854775808 to 9223372036854775807

        float f1 = 31.24f; //from ~1,4*10^-45 to ~3,4*10^38 (used when floating part isn't important)
        double d1 = 3.14159; //from ~4,9*10^-324 to ~1,8*10^308

        char c1 = 'c'; //16bit Unicode
        boolean bool1 = true; //logic, true or false

        //non-primitive data types
        String myStr = "Hello, world!"; //used to store a sequence of characters (text)

        isLeapYear(2004);
    }

    //A method that takes a, b, c and d and returns a result of an expression a * (b + (c / d))
    public static int expression(int a, int b, int c, int d) {
        int res = a * (b + (c / d));
        return res;
    }

    //A method that takes a and b and check whether their sum between 10 and 20 and returns true, otherwise it returns false
    public static boolean tenToTwenty(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    //A method that checks whether the parameter is positive or negative
    public static void posOrNeg(int a) {
        if (a >= 0) {
            System.out.println("The number is positive!");
        } else {
            System.out.println("The number is negative!");
        }
    }

    //A method that returns true if the parameter is negative
    public static boolean isItNegative(int a) {
        if(a < 0) {
            return true;
        } else {
            return false;
        }
    }

    //A method that says "hello, name" to the user
    public static void helloUser(String str) {
        System.out.println("Hello, " + str);
    }

    //A method that check whether the year is a leap-year or common year
    public static void isLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0) {
            System.out.println("It is a leap-year");
        } else {
            if(year % 400 == 0) {
                System.out.println("It is a leap-year");
            } else {
                System.out.println("It is a common year");
            }
        }
    }
}
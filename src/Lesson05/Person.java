package Lesson05;

public class Person {
    String fullName;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Person(String fullName, String position, String email,
                  String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println(fullName + " " + position + " " + email + " " + phoneNumber + " " + salary + " " + age);
    }
}

class Main {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com",
                "892312312", 30000, 41);
        persArray[1] = new Person("Pankratova Elena", "HR", "elena@mail.com",
                "89124756613", 25000, 23);
        persArray[2] = new Person("Belov Sergei", "Security", "belovs@yandex.ru",
                "89342378812", 20000, 57);
        persArray[3] = new Person("Voloshin Vladimir", "Intern", "vovovo2001@mail.ru",
                "89457384425", 17000, 19);
        persArray[4] = new Person("Khlebnikov Oleg", "CEO", "oleg@59000.ru",
                "89814501619", 75000, 24);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40) {
                persArray[i].info();
            }
        }
    }
}
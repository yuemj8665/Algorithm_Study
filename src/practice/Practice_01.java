package practice;

import java.util.Scanner;

public class Practice_01 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PeopleVO people = new PeopleVO();
        String name;
        String age;
        String address;
        String number;

        people.setName(sc.next());
        people.setAge(sc.next());
        people.setAddress(sc.next());
        people.setNumber(sc.next());

        people.ToString();


    }
}

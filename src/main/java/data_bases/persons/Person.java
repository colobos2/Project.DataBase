package data_bases.persons;

import java.util.ArrayList;

public class Person {
    public int id;
    public String name;
   public String phone;
   public String email;
   public static ArrayList<Person> listP;

    public Person(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
   public static void createPersonList(){
       listP = new ArrayList<>();
        listP.add(new Person(1,"Иван", "+78889991111", "1111@mail.ru"));
       listP.add(new Person(2,"Андрей", "+79993334444", "3333@mail.ru"));
       listP.add(new Person(3,"Николай", "+77778887766", "7777@mail.ru"));

    }

    public static void main(String[] args) {
        createPersonList();
    }
}

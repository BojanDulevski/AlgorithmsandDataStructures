import java.util.Scanner;
import java.util.*;



class Person {
    String name;
    String surname;
    int budget;
    String ip;
    String time;
    String city;
    int price;

    Person(String name, String surname, int budget, String ip, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.ip = ip;
        this.time = time;
        this.city = city;
        this.price = price;
    }
}

public class Zadaca3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        int N=Integer.parseInt(sc.nextLine());

        for(int i=0;i<N;i++){
            String line=sc.nextLine();
            String[]parts=line.split("\\s+");
            String name=parts[0];
            String surname=parts[1];
            int budget=Integer.parseInt(parts[2]);
            String ip=parts[3];
            String time=parts[4];
            String city=parts[5];
            int price=Integer.parseInt(parts[6]);

            persons.add(new Person(name,surname,budget,ip,time,city,price));

        }

        sc.nextLine();

        while(sc.hasNextLine()){
            String line=sc.nextLine().trim();
            if(persons.isEmpty())continue;
            String[]parts=line.split("\\s+");
            String testCity=parts[5];


            int counter=0;
            int maxPaid=-1;
            Person maxPersons=null;


            for(Person p: persons){
                if(p.city.equals(testCity) && p.budget>=p.price){
                    counter++;
                    if(p.price>maxPaid){
                        maxPaid=p.price;
                        maxPersons=p;
                    }
                }
            }
            System.out.println(counter+" "+maxPersons.name+" "+maxPersons.surname);
        }

    }
}
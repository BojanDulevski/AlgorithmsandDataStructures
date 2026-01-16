import java.util.*;
import java.util.HashMap;


class Employee {
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "<" + name + ", " + age + ">";
    }

    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee) obj;
        return name.equals(e.name) && age == e.age;
    }

    @Override
    public int hashCode() {
        return age * name.charAt(0);
    }
}

class Project {
    int time;
    int rate;

    Project(int time, int rate) {
        this.time = time;
        this.rate = rate;
    }

    int totalSalary(){
        return time * rate;
    }

    @Override
    public String toString() {
        return "<" + time + ", " + rate + ">";
    }

}

public class Zadaca2  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        HashMap<Employee,Project>map = new HashMap<>();

        int N=sc.nextInt();

        for(int i=0;i<N;i++){
            String name= sc.next();
            int age=sc.nextInt();
            int time=sc.nextInt();
            int rate=sc.nextInt();

            Employee emp=new Employee(name,age);
            Project p=new Project(time,rate);

            if(!map.containsKey(emp)){
                map.put(emp,p);
            }else{
                Project old=map.get(emp);
                if(p.totalSalary()>old.totalSalary()){
                    map.put(emp,p);
                }
            }
        }

        for(int i=0; i<10; i++){
            System.out.print(i + ":");
            for(Employee e : map.keySet()){
                int bucket = Math.abs(e.hashCode()) % 10;
                if(bucket == i){
                    System.out.print("<" + e + "," + map.get(e) + ">");
                }
            }

            System.out.println();

        }
    }
}
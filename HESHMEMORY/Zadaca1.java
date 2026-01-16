import java.util.*;
import java.util.HashMap;





public class Zadaca1 {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();

        HashMap<String,Integer>map=new HashMap<>();


        for(int i=0;i<n;i++){
            String ip=sc.nextLine();
            String[]parts=ip.split("\\.");

            String network= parts[0]+"."+parts[1]+"."+parts[2];
            map.put(network, map.getOrDefault(network,0)+1);

        }

        int M=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<M;i++){
            String ip=sc.nextLine();
            String[]parts=ip.split("\\.");

            String network=parts[0]+"."+parts[1]+"."+parts[2];

            System.out.println(map.getOrDefault(network,0));
        }
    }
}


Znaci imame ip gi delime site ip na 3 okteti od ko ce gi podelime gi stavame potoa prajme pak for ciklus  za
        da viidme koj ip treba da se vmetnat i kad e izdavame uste ipina koj treba da se vnesta i na krajo ako pripajga
        vlezot vo network go odi nagore ako ne 0 e
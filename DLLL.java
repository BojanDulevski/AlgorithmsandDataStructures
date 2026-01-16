

import java.util.Scanner;

class DLL{
    int value;
    DLL next;
    DLL prev;

    DLL(int value){
        this.value = value;
    }
}

class Double{
    DLL head;
    DLL tail;

    void add(int value){
        DLL temp= new DLL(value);

        if(head==null) {
            head = tail = temp;
        }else{
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
        }
    }

    int sum(){
        int s=0;
        DLL temp=head;

        while(temp!=null){
            s+=temp.value;
            temp=temp.next;
        }
        return s;
    }
}







public class DLLL {


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int M=sc.nextInt();
        int N=sc.nextInt();

        Double[]lists=new Double[N];

        for(int i=0;i<N;i++){
            lists[i]=new Double();
            for(int j=0;j<M;j++){
                lists[i].add(sc.nextInt());
            }
        }
        long products=1;

        for(int i=0;i<N;i++){
            products*=lists[i].sum();
        }
        System.out.println(products);
    }

}

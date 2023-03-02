import java.awt.*;
import java.lang.reflect.Array;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        Integer[] ar = createArray(sc);
        do{
            System.out.println("Was wollen Sie tun? 1) add values; 2) show all values; 3) double the array; 4) get element at index x; 5) replace element");
            Integer task = sc.nextInt();
            if(task == 1){
                ar = addValues(ar, sc);
            }
            else if(task == 2){
                showValues(ar);
            }
            else if(task == 3){
                Integer[] zAr = doubleAarray(ar);
                ar = null;
                ar = zAr;
                System.out.println(ar.length);
                showValues(zAr);
                System.out.println("#####################################################");
                showValues(ar);
            }
            else if(task == 4){
                Integer posi = sc.nextInt();
                sc.nextLine();
                showSingelValue(ar, posi);
            }
            else if(task == 5){
                ar = replaceValue(ar, sc);
            }
        }while(run == true);
    }
    public static Integer[] createArray(Scanner sc){
        System.out.println("Wie lang soll das Array sein?");
        Integer length = sc.nextInt();
        sc.nextLine();
        Integer[] newArray = new Integer[length];
        return newArray;
    }
    public static Integer[] addValues(Integer[] ar, Scanner sc){
        Integer lastWrittenValue = 0;
        for(Integer y = 0; y < ar.length; y++){
            if(ar[y] != null){
                lastWrittenValue = y;
            }
        }
        for(Integer i=lastWrittenValue; i<ar.length; i++){
            System.out.println("Fügen Sie eine Zahl zu dem Array hinzu: ");
            Integer number = sc.nextInt();
            ar[i] = number;
            sc.nextLine();
            System.out.println("Weiter Zahl hinzufügen? j um weiter zu machen");
            String again = sc.nextLine();
            if(!again.contentEquals("j")){
                break;
            }
        }
        System.out.println("Ende des Arrays erreicht.");
        return ar;
    }
    public static void showValues(Integer[] ar){
        for(Integer i : ar){
            System.out.println(i);
        }
    }
    public static void showSingelValue(Integer[] ar, Integer posi){
        System.out.println(ar[posi]);
    }

    public static Integer[] doubleAarray(Integer[] ar){
        Integer[] newAr = new Integer[ar.length*2];
        for(Integer i = 0; i<ar.length; i++){
            newAr[i] = ar[i];
        }
        return newAr;
    }
    public static Integer[] replaceValue(Integer[] ar, Scanner sc) {
        System.out.println("Nach Wert oder Index?");
        String valueOrIndex = sc.nextLine();
        if(valueOrIndex.equals("Index")){
            System.out.println("Welche Stelle wollen Sie ersetzen? ");
            Integer number = sc.nextInt();
            System.out.println("Welchen Wert wollen Sie stattdessen einfügen?");
            Integer newNum = sc.nextInt();
            sc.nextLine();
            ar[number] = newNum;
        }
        else if(valueOrIndex.equals("Wert")) {
            System.out.println("Welchen Wert wollen Sie ersetzen: ");
            Integer value = sc.nextInt();
            for(Integer i=0; i<ar.length; i++){
                if(ar[i] == value){
                    System.out.println("Geben Sie den neuen Wert ein: ");
                    Integer newVal = sc.nextInt();
                    ar[i] = newVal;
                    sc.nextLine();
                }
            }
        }
        return ar;
    }
}
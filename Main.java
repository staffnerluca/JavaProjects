import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        do{
            System.out.println("Was wollen Sie tun? 1) Werte hinzufügen, 2) alle Werte ausgeben, 3) Wert an Index x ausgeben, 4) Wert löschen");
            Integer task = sc.nextInt();
            if(task == 1){
                li = addValues(li, sc);
            }
            else if(task == 2){
                showAllValues(li);
            }
            else if(task == 3){
                showAtIndex(li, sc);
            }
            else if(task == 4){
                li = deleteValue(li, sc);
            }
        }while (run);
    }

    public static ArrayList<Integer> addValues(ArrayList<Integer> li, Scanner sc){
        boolean run = true;
        do{
            System.out.println("Welchen Wert wollen Sie hinzufügen? ");
            li.add(sc.nextInt());
            sc.nextLine();
            System.out.println("Noch einmal, dann geben Sie j ein");
            String again = sc.nextLine();
            if(!again.equals("j")){
                run = false;
            }
        }while(run);
        return li;
    }
    public static void showAllValues(ArrayList<Integer> li){
        for(Integer i : li){
            System.out.println(i);
        }
    }
    public static void showAtIndex(ArrayList<Integer> li, Scanner sc){
        System.out.println("Index? ");
        Integer index = sc.nextInt();
        System.out.println(li.get(index));
    }
    public static ArrayList deleteValue(ArrayList<Integer> li, Scanner sc){
        System.out.println("0) Wert oder 1) Index? ");
        Integer valueOrIndex = sc.nextInt();
        if(valueOrIndex == 0){
            System.out.println("Gib den Wert ein: ");
            Integer value = sc.nextInt();
            li.remove(li.indexOf(value));
            }
        else if(valueOrIndex == 1){
            System.out.println("Index: ");
            Integer ind = sc.nextInt();
            li.remove(ind);
        }
        return li;
        }
    }
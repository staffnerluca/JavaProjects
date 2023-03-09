import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie soll die neue Datei heißen/welche Datei wollen Sie verwenden??");
        String name = sc.nextLine();
        File f = new File(name);
        createFile(sc, f);
        boolean run = true;
        while(run) {
            System.out.println("Was wollen Sie tun? 1) in die Datei schreiben; 2) den Inhalt der Datei ausgeben; 3) Datei öffnen; 4) Datei löschen; 5) Programm beenden");
            String toDo = sc.nextLine();
            if (toDo.equals("1")) {
                writeToFile(sc, f);
            }
            else if (toDo.equals("2")) {
                readFile(f);
            }
            else if(toDo.equals("3")){
                f = null;
                f = openFile(sc);
            }
            else if (toDo.equals("4")) {
                deleteFile(f);
            }
            else if(toDo.equals("5")){
                run = false;
            }

        }
    }
    public static void createFile(Scanner sc, File f){
        try{
            f.createNewFile();
        }catch (Exception ex){
            System.out.println("Erstellen nicht erfolgreich.");
        }
    }
    public static void writeToFile(Scanner sc, File f){
        try{
            FileWriter fw = new FileWriter(f.getAbsolutePath(), true);
            String text = sc.nextLine();
            fw.write(text);
            fw.flush();
        }catch (Exception ex){
            System.out.println("Error Error Error");
        }
    }
    public static void readFile(File f){
        try{
            Scanner r = new Scanner(f);
            while(r.hasNextLine()){
                System.out.println(r.nextLine());
            }
            r.close();
        }catch(Exception ex){
            System.out.println("File nicht gefunden.");
        }
    }
    public static void deleteFile(File f){
        try {
            f.delete();
        } catch (Exception ex) {
            System.out.println("Datei konnte nicht gelöscht werden.");
        }
    }
    public static File openFile(Scanner sc){
        System.out.println("Name: ");
        try{
            String name = sc.nextLine();
            File f = new File(name);
            return f;
        }catch (Exception ex){
            System.out.println("Öffnen fehlgeschlagen");
            return null;
        }
    }
}
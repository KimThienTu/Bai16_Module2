import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "Reader.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            String line;
            while ((line = br.readLine()) != null){
                String[] country = line.split(",");
                int id = Integer.parseInt(country[0]);
                String code = country[1].replaceAll("\"","");
                String name = country[2].replaceAll("\"","");

                System.out.println("ID: " + id);
                System.out.println("Code: " + code);
                System.out.println("Name: " + name);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

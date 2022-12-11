import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Advent01 {
    public static void main(String[] args) {
        String fileName = "01/input.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            System.out.println(line.replaceAll("\\)", "").length() - line.replaceAll("\\(", "").length());
            for(int x = 0; x < line.length(); x++) {
                if(-1 == line.substring(0,x).replaceAll("\\)", "").length() - line.substring(0,x).replaceAll("\\(", "").length()) {
                    System.out.println(x);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Advent03 {
    public static void main(String[] args) {
        String fileName = "03/input.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            HashSet<Point> visited = new HashSet<>();
            int x = 0, y = 0; // santa
            int xr = 0, yr = 0; // robot santa
            visited.add(new Point(x,y));
            for(int s = 0; s < line.length(); s++) {
                switch (line.charAt(s)) {
                    case '^' -> y++;
                    case 'v' -> y--;
                    case '>' -> x++;
                    case '<' -> x--;
                }
                visited.add(new Point(x, y));
                s++;
                switch (line.charAt(s)) {
                    case '^' -> yr++;
                    case 'v' -> yr--;
                    case '>' -> xr++;
                    case '<' -> xr--;
                }
                visited.add(new Point(xr, yr));
            }
            System.out.println("visited: " + visited.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
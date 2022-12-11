import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Advent05 {
    public static void main(String[] args) {
        String fileName = "05/input.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int nice1 = 0;
            int nice2 = 0;
            ArrayList<String> disallowed = new ArrayList<>();
            disallowed.add("ab");
            disallowed.add("cd");
            disallowed.add("pq");
            disallowed.add("xy");
            while (line != null) {
                if(disallowed.stream().noneMatch(line::contains) && numVowels(line) > 2 && repeatingLetter(line)) nice1++;
                if(repeatingLettersNonOverlap(line) && repeatingLettersOneBetween(line)) nice2++;
                line = reader.readLine();
            }
            System.out.println("nice1 = "+nice1);
            System.out.println("nice2 = "+nice2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int numVowels(@NotNull String s) {
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int num = 0;
        for(char c:s.toCharArray()) {
            for(char v:vowels){
                if(v==c) num++;
            }
        }
        return num;
    }
    private static boolean repeatingLetter(@NotNull String s) {
        for(int x=0;x<s.length()-1;x++) {
            if(s.charAt(x)==s.charAt(x+1)) return true;
        }
        return false;
    }
    private static boolean repeatingLettersNonOverlap(@NotNull String s) {
        for(int x = 0;x<s.length()-1;x++) {
            String concat = s.substring(0, x).concat("__").concat(s.substring(x + 2));
            if(concat.contains(s.substring(x,x+2))) return true;
        }
        return false;
    }
    private static boolean repeatingLettersOneBetween(@NotNull String s) {
        for(int x = 0;x<s.length()-2;x++) {
            if(s.charAt(x)==s.charAt(x+2)) return true;
        }
        return false;
    }
}
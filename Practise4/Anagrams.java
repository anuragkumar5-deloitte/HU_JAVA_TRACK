package Practise4;
import java.util.*;

public class Anagrams {
        public static void main(String[] args) {
            Scanner scanner =  new Scanner(System.in);
            System.out.println("Enter 1st String:");
            String str1 = scanner.nextLine();
            System.out.println("Enter 2nd String:");
            String str2 = scanner.nextLine();
            str1 = str1.replaceAll( "\\s","").toLowerCase();
            str2 = str2.replaceAll( "\\s","").toLowerCase();
            if(Anagram_str(str1,str2)) {
                System.out.println("Strings " +str1+" and "+str2 +" are Anagrams");
            } else {
                System.out.println("Strings "+str1 +" and "+str2 +" are not Anagrams");
            }
            scanner.close();
        }
        public static boolean Anagram_str(String str1,String str2) {
            Map<Character,Integer> str_Map = new HashMap<Character,Integer>();
            Map<Character,Integer> str_1Map = new HashMap<Character,Integer>();
            Character ch;
            for(int i=0;i<str1.length();i++) {
                ch = str1.charAt(i);
                if(str_Map.get(ch)==null) {
                    str_Map.put(ch,1);
                } else {
                    str_Map.put(ch,str_Map.get(ch)+1);
                }
            }
            for(int i =0;i<str2.length();i++) {
                ch = str2.charAt(i);
                if(str_1Map.get(ch)==null) {
                    str_1Map.put(ch,1);
                } else {
                    str_1Map.put(ch,str_1Map.get( ch)+1);
                }
            }
            return str_Map.equals(str_1Map);
        }
    }


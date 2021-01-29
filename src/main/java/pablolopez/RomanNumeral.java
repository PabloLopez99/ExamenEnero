package pablolopez;
import java.util.TreeMap;


public class RomanNumeral {
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>(){{
        put(1000, "M");put(900, "CM");put(500, "D");put(400, "CD");put(100, "C");put(90, "XC");
        put(50, "L");put(40, "XL");put(10, "X");put(9, "IX");put(5, "V");put(4, "IV");put(1, "I");
    }};
    private final static TreeMap<String, Integer> map2 = new TreeMap<String, Integer>(){{
        put("I",1);put("V",5);put("X",10);put("L",50);put("C",100);put("D",500);put("M",1000);
    }};
    private static boolean isValidRoman(String num) {
        if(num.equals("")){
            return false;
        }
        for (int k = 0; k < num.length(); k++) {
            if (checkChars(num, k)) return false;
        }
        return true;
    }
    private static boolean checkChars(String num, int k) {
        if (num.charAt(k) != 'I' && num.charAt(k) != 'V' && num.charAt(k) != 'X' && num.charAt(k) != 'L' &&
            num.charAt(k) != 'C' && num.charAt(k) != 'D' && num.charAt(k) != 'M') {
            return true;
        }
        return false;
    }
    public static String toArabic(String s){
        if(isValidRoman(s)){
            int Arabic = 0;
            int last_digit = 0;
            int current_digit = 0;
            for (int i = 0; i < s.length(); i++) {
                current_digit = getCurrent_digit(s, current_digit, i);
                if (last_digit < current_digit && last_digit != 0) {
                    current_digit -= last_digit;
                    Arabic -= last_digit;
                    Arabic += current_digit;
                    last_digit = current_digit;
                } else {
                    last_digit = current_digit;
                    Arabic += current_digit;
                }
                current_digit = 0;
            }

            return String.valueOf(Arabic);
        }else{
            return null;
        }

    }
    public static String toRoman(int num){
        if (isValidArabic(num)){
            int l =  map.floorKey(num);
            return num == map.floorKey(num) ? map.get(num) : map.get(l) + toRoman(num - l);
        }else{
            return null;
        }

    }
    private static boolean isValidArabic(int num) {
        return num > 0;
    }
    private static int getCurrent_digit(String s, int current_digit, int i) {
        for (String key : map2.keySet()) current_digit = getCurrent_digit(s, current_digit, i, key);
        return current_digit;
    }
    private static int getCurrent_digit(String s, int current_digit, int i, String key) {
        if(String.valueOf(s.charAt(i)).equals(key))current_digit =(map2.get(key));
        return current_digit;
    }
}

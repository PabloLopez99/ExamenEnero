package pablolopez;

import java.util.List;
import java.util.TreeMap;

public class RomanNumeral {

    public static void main(String[] args) {
        System.out.println(toRoman(1999));
        System.out.println(toArabic("X"));
    }
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }
    private static boolean isValidRoman(String num) {

        for (int k = 0; k < num.length(); k++) {
            if (num.charAt(k) != 'I' &&
                    num.charAt(k) != 'V' &&
                    num.charAt(k) != 'X' &&
                    num.charAt(k) != 'L' &&
                    num.charAt(k) != 'C' &&
                    num.charAt(k) != 'D' &&
                    num.charAt(k) != 'M') {
                return false;
            }
        }
        return true;
    }

    public static String toArabic(String s) {

        if (isValidRoman(s)) {

            int Arabic = 0;
            int last_digit = 0;
            int current_digit = 0;

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == 'I') {
                    current_digit = 1;
                }
                if (s.charAt(i) == 'V') {
                    current_digit = 5;
                }
                if (s.charAt(i) == 'X') {
                    current_digit = 10;
                }
                if (s.charAt(i) == 'L') {
                    current_digit = 50;
                }
                if (s.charAt(i) == 'C') {
                    current_digit = 100;
                }
                if (s.charAt(i) == 'D') {
                    current_digit = 500;
                }
                if (s.charAt(i) == 'M') {
                    current_digit = 1000;
                }



                if (last_digit < current_digit && last_digit != 0) {
                    current_digit -= last_digit;
                    Arabic -= last_digit;
                    Arabic += current_digit;
                    last_digit = current_digit;
                    current_digit = 0;
                } else {
                    last_digit = current_digit;
                    Arabic += current_digit;
                    current_digit = 0;
                }
            }


            return String.valueOf(Arabic);

        }else{
            return null;	
        }
    }


    public static String toRoman(int num){
        int l =  map.floorKey(num);
        if (num == l ) {
            return map.get(num);
        }
        return map.get(l) + toRoman(num-l);
    }
}

import org.junit.Before;
import org.junit.Test;
import pablolopez.RomanNumeral;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class RomanNumeralTest {

    @Test
    public void testToArabic(){
        assertTrue(RomanNumeral.toArabic("X").equals("10"));
        assertTrue(RomanNumeral.toArabic("MMMDCCXXIV").equals("3724"));
        assertTrue(RomanNumeral.toArabic("MMXXI").equals("2021"));
        assertTrue(RomanNumeral.toArabic("ASDF")==null);
        assertTrue(RomanNumeral.toArabic("")==null);
    }


    @Test
    public void testToRoman(){
        assertTrue(RomanNumeral.toRoman(10)=="X");
        assertTrue(RomanNumeral.toRoman(1999).equals("MCMXCIX"));
        assertTrue(RomanNumeral.toRoman(-21)==null);
        assertTrue(RomanNumeral.toRoman(0)==null);
    }



}

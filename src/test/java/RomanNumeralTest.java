import org.junit.Before;
import org.junit.Test;
import pablolopez.RomanNumeral;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class RomanNumeralTest {

    @Test
    public void testToArabic(){
        assertTrue(RomanNumeral.toArabic("X").equals("10"));
    }


    @Test
    public void testToRoman(){
        assertTrue(RomanNumeral.toRoman(10)=="X");
        assertTrue(RomanNumeral.toRoman(1999).equals("MCMXCIX"));
    }



}

package cloud.leetCode;

import java.util.HashMap;
import java.util.Map;

public class num13 {

    public static Map<String, Integer> getMap(){
        Map<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        return map;
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = getMap();
        int val = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Integer integer = map.get(String.valueOf(s.charAt(i)));
            Integer integer2 = map.get(String.valueOf(s.charAt(i + 1)));
            if(integer >= integer2){
                val += integer;
            }else {
                val -= integer;
            }
        }
        return val += map.get(String.valueOf(s.charAt(s.length() - 1)));
    }

    public static int romanToInt2(String s) {
        int val = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Integer integer = getValue(s.charAt(i));
            Integer integer2 = getValue(s.charAt(i + 1));
            if(integer >= integer2){
                val += integer;
            }else {
                val -= integer;
            }
        }
        return val += getValue(s.charAt(s.length() - 1));
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        int i1 = romanToInt("LVIII");
        System.out.println(i1);

        int i2 = romanToInt("MCMXCIV");
        System.out.println(i2);

        int i3 = romanToInt("IX");
        System.out.println(i3);
    }
}

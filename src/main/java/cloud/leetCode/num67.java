package cloud.leetCode;

public class num67 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int div = 0;
        for (int i =  Math.min(a.length(), b.length())  - 1; i >= 0; i--) {
            int ai = 0;
            int bi = 0;
            if(i < a.length()){
                ai = Integer.parseInt(String.valueOf(a.charAt(i)));
            }
            if(i < b.length()){
                bi = Integer.parseInt(String.valueOf(b.charAt(i)));
            }
            int i2 = ai + bi + div;
            div = 0;
            System.out.println("ai: " + ai + "bi: " + bi);
            System.out.println(i2);
            if (i2 == 2){
                div = 1;
                i2 = 0;
            }
            sb.append(i2);
        }
        if(div != 0){
            sb.append(1);
        }

/*        if(a.length() != b.length()){
            for (int i = Math.abs(a.length() - b.length()); i >= 0; i--) {

            }
        }*/

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a1 = "110";
        String b1 = "1001";
        String s1 = addBinary(a1, b1);
        System.out.println(s1);
    }
}

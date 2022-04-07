package cloud.leetCode;

public class num69 {
    public static int mySqrt(int x) {

        int start = 0;
        int end = x;
        while (start <= end){

            int mid = (start + end)/2 + 1;
            /*x/(mid + 1) > (mid +1)*/
            if(mid == 0){
                return end;
            }
            if(mid == start){
                return start;
            }
            if(x/mid > mid){
                start = mid;
            }else if (x/mid < mid) {
                end = mid;
            }else{
                return mid;
            }
        }

        return start;
    }

    public int mySqrt2(int x) {
        long a = x;
        if(x == 0){
            return x;
        }
        while (x/a < a) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }


    public static void main(String[] args) {

        int i1 = mySqrt(5);
        System.out.println(i1);

        int i2 = mySqrt(11);
        System.out.println(i2);

        int i3 = mySqrt(19);
        System.out.println(i3);

        int i4 = mySqrt(1);
        System.out.println(i4);

        int i5 = mySqrt(2);
        System.out.println(i5);

        int i6 = mySqrt(3);
        System.out.println(i6);
    }
}


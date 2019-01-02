package rare.arrayTest;

import java.util.Arrays;

public class FindStrFromArray {
    public static void main(String[] args) {
        String[] array = {"1","4" ,"2", "3","5"};

        /**
         * 二分法查找
         * 优点：效率快捷
         * 缺点：数组必须是有序的，如果不是有序的，使用此方式是无用的
         * 返回：该值在数组所在的索引值
         */
        int index = -1;

        index = Arrays.binarySearch(array, "1");
        System.out.println("index："+ index);

        index = Arrays.binarySearch(array, "6");
        System.out.println("index:"+index);

        index = Arrays.binarySearch(array, "4");
        System.out.println("index:"+index);

        Arrays.sort(array);
        index = Arrays.binarySearch(array, "4");
        System.out.println("index:"+index);
    }
}

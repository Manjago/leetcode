public class Solution350 {
    private static final int MAX = 1000;

    public int[] intersect(int[] nums1, int[] nums2) {

        int[] content2 = new int[MAX];
        for(int i=0; i < nums2.length; ++i) {
            ++content2[nums2[i]];
        }

        // делаем структуру [число - количество вхождений], поглядывая на структуру из второго массива
        int counter = 0;
        int[] content1 = new int[MAX];
        for(int i=0; i < nums1.length; ++i) {
            int probe = nums1[i];
            if (content2[probe] > 0) {
                --content2[probe];
                ++content1[probe];
                ++counter;
            }
        }

        // перекодируем [число - количество вхождений] в простой массив
        int[] result = new int[counter];
        int pos = 0;
        for(int i=0; i<content1.length; ++i) {
            while(content1[i] > 0) {
                --content1[i];
                result[pos++] = i;
            }
        }

        return result;
    }
}

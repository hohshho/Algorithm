public class num605 {
    static class Solution {
        static boolean[] checked;
        static int flowerbedLen;

        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            flowerbedLen = flowerbed.length;

            checked = new boolean[flowerbedLen];

            if(n==0) return true;

            for(int i=0; i < flowerbedLen; i++) {
                if(flowerbed[i] == 0 && check(i, flowerbed)) {
                    flowerbed[i] = 1;
                    n -= 1;
                }

                if(n == 0) return true;
            }

            return false;
        }

        public static boolean check(int cur, int[] flowerbed) {
            int start = cur - 1 < 0 ? 0 : cur - 1;
            int finish = cur + 1 >= flowerbedLen ? flowerbedLen - 1 : cur + 1;
            for(int i = start; i <= finish; i++) {
                if(flowerbed[i] == 1) return false;
            }
            return true;
        }
    }
}

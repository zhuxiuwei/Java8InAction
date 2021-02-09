package xiuwei_test.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 21-02-09 p107
 * 利用iterate/generate生成无限流的例子。
 */
public class 斐波那契元组序列 {
    public static void main(String[] args) {
        /**
         * 斐波那契数是的经典编程题。如： 0, 1, 1,
         * 2, 3, 5, 8, 13, 21, 34, 55…开始的两个数是0和1，后面的每个数都是前两个数之和。
         * 斐波那契元组序类似，是数列中数字和其后续数字组成的元组构成的序列： (0, 1),
         * (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21) …
         * 你的͉任务是用iterate方法生成元组序列中的前20个元素。
         */

        System.out.println("//用iterate生成");
        Stream.iterate(new int[]{0,1} , x -> new int[]{x[1], x[0] + x[1]})
                .limit(20)
                .forEach(x -> System.out.println(Arrays.toString(x)));

        System.out.println("//用generate生成");
        final Pair pair = new Pair(0, 1);   //lambda里的变量，是final的。所以这里借助了Pair类，用其field来跟踪变化。
        Stream.generate(() -> {
            int old_first = pair.first, old_second = pair.second;
            int[] res = new int[]{old_first, old_second};
            //利用final的pair对象，更新新值。
            pair.first = old_second;
            pair.second = old_first + old_second;
            return res;
        }).limit(20).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    private static class Pair{
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

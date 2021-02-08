package xiuwei_test.chap05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 210201
 */
public class MapAndFlatMap {
    public static void main(String[] args) {
        System.out.println("//map");
        List<String> words = Arrays.asList("hello", "world");
        List<String[]> ss = words.stream()  //注意返回类型是 List<String[]>
                .map(x -> x.split(""))
                .collect(toList());
        ss.forEach( x -> System.out.println(Arrays.toString(x)));


        System.out.println("//数组流");
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        System.out.println(streamOfwords.collect(toSet()));


        System.out.println("//！！！！！！！！！！！！！！！flatmap");
        List<String> ss2 = words.stream()  //注意返回类型是 List<String>
                .map(x -> x.split(""))
                .flatMap(x -> Arrays.stream(x))     //！！！！！！关键在这行（感觉比scala的别扭不少。）
                .collect(toList());
        System.out.println(ss2);

        System.out.println("//测验5.2: 给一个数组，如何返回一个由每个数的平方构成的列表呢？例如，给[1, 2, 3, 4,5 ]，应该返回[1, 4, 9, 16, 25]");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> res = numbers.stream()
                .map(x -> x * x)
                .collect(toList());
        System.out.println(res);

        System.out.println("//测验5.2: 给两个数字列表，如何返回所有的数对呢？例如，给列表[1, 2, 3]和表[3, 4]，" +
                "应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代表数对。");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        System.out.println("   --- map操作");
        List<List<int[]>> paris1 = numbers1.stream().
                map(i -> numbers2.stream()
                        .map(j -> new int[]{i, j})
                        .collect(toList()))     //注意需要多一个collect，否则最里面元素不是数字数组，而是stream
                .collect(toList()); //返回的是([[1, 3], [1, 4]], [[2, 3], [2, 4]], [[3, 3], [3, 4]])
        paris1.forEach(x -> System.out.println(Arrays.deepToString(x.toArray())));
        System.out.println("   --- ！！！！！！！！！！！！！！！！！flatMap操作");
        List<int[]> paris2 = numbers1.stream().
                flatMap(i -> numbers2.stream()
//                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(toList()); //返回的是拍平的([1, 3], [1, 4], [2, 3], [2, 4], [3, 3], [3, 4])
        paris2.forEach(x -> System.out.println(Arrays.toString(x)));

        //21-02-08
        //map和flatMap还是不熟！！！！！！
        //用Map/flatMap打印数字对。
        List<List<int[]>> l1 = IntStream.rangeClosed(1, 100).boxed()
                .map(a -> IntStream.rangeClosed(a, 100).boxed()
                        .map(b -> new int[] {a, b})
                        .collect(toList())
                ).collect(toList());
        l1.forEach(x -> x.forEach(y -> System.out.println(Arrays.toString(y))));
        List<int[]> l2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100).boxed()
                        .map(b -> new int[] {a, b})
                ).collect(toList());
        l2.forEach(x -> System.out.println(Arrays.toString(x)));

    }
}

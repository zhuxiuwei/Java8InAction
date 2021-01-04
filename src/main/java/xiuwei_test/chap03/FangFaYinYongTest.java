package xiuwei_test.chap03;

import java.util.Arrays;
import java.util.List;

//方法引用相关 p53
public class FangFaYinYongTest {
    public static void main(String[] args) {
        String s = "a";
        List<String> str = Arrays.asList("a","b","A","B");
        /** 方法引用 */
        str.sort(String::compareToIgnoreCase);  //等价： str.sort((a, b) -> a.compareToIgnoreCase(b));
        System.out.println(str);    //[a, A, b, B]

        //下面这个写法，应该就不能调用方法引用了。
        str.sort((a, b) -> b.compareToIgnoreCase(a));
        System.out.println(str);    //[b, B, a, A]

    }
}

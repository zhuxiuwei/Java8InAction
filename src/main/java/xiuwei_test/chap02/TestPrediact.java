package xiuwei_test.chap02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPrediact {

    static List<String>  filter(List<String> ss, ZxwPrediacte prediacte){
        List<String> res = new ArrayList<>();
        for(String s: ss){
            if (prediacte.test(s))
                res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> ss = Arrays.asList("a","ab","c");
        List<String> res = filter(ss, (String s) -> s.startsWith("a"));
        System.out.println(res);  //[a, ab]
    }
}


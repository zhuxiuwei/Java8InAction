package xiuwei_test.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionInterfaceZxw2_Client {
    //调用函数接口
    public <T, R>  List<R> callIt(List<T> things, FunctionInterfaceZxw2<T, R> fiZwxTest){
        List<R> res = new ArrayList<>();
        for(T t: things){
            R r = fiZwxTest.apply(t);
            res.add(r);
        }
        return res;
    }

    //效果等同使用java8内置函数接口 Function<T, R>
    public <T, R>  List<R> callIt2(List<T> things, Function<T, R> c){
        List<R> res = new ArrayList<>();
        for(T t: things){
            res.add(c.apply(t));  //行为参数化
        }
        return res;
    }

    public static void main(String[] args) {
        FunctionInterfaceZxw2_Client c = new FunctionInterfaceZxw2_Client();
        List<Integer> res = c.callIt(Arrays.asList("ghg", "123d", "fsasdsadsa"), (String s) -> s.length());
        System.out.println(res);    //[3, 4, 10]
        List<String> res2 = c.callIt(Arrays.asList("ghg", "123d", "fsasdsadsa"), (String s) -> s.toUpperCase());
        System.out.println(res2);   //[GHG, 123D, FSASDSADSA]

        System.out.println(c.callIt2(Arrays.asList("ghg", "123d", "fsasdsadsa"), (String s) -> s.length()));
        System.out.println(c.callIt2(Arrays.asList("ghg", "123d", "fsasdsadsa"), (String s) -> s.toUpperCase()));
    }

}

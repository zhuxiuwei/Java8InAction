package xiuwei_test.chap03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionInterfaceZxw_Client {
    //调用函数接口
    public <T>  void callIt(List<T> things, FunctionInterfaceZxw<T> fiZwxTest){
        for(T t: things){
            fiZwxTest.Hehe(t);  //行为参数化
        }
    }

    //效果等同使用java8内置函数接口 Consumer<T>
    public <T>  void callIt2(List<T> things, Consumer<T> c){
        for(T t: things){
            c.accept(t);  //行为参数化
        }
    }

    public static void main(String[] args) {
        FunctionInterfaceZxw_Client c = new FunctionInterfaceZxw_Client();
        c.callIt(Arrays.asList("ghg", "123d", "fsasdsadsa"), (String s) -> System.out.println(s.length()));
        c.callIt(Arrays.asList("ghg", "123d", "fsasdsadsa"), (String s) -> System.out.println(s.toUpperCase()));

        c.callIt2(Arrays.asList("ghg", "123d", "fsasdsadsa"), (String s) -> System.out.println(s.length()));
        c.callIt2(Arrays.asList("ghg", "123d", "fsasdsadsa"), (String s) -> System.out.println(s.toUpperCase()));
    }

}

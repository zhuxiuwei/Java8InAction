package xiuwei_test.chap03;

//函数式接口，效果和Function<T, R>一样。
@FunctionalInterface
public interface FunctionInterfaceZxw2<T, R> {
    R apply(T t);
}

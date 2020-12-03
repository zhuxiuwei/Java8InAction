package xiuwei_test.chap02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppSelect {
    public static void main(String[] args) {
        List<AppleZXW> apples = Arrays.asList(new AppleZXW(100, "red"), new AppleZXW(160, "green"),new AppleZXW(200, "yellow"));
        List<AppleZXW> selected = apples.stream().filter((AppleZXW a) -> a.color.equals("green") && a.weight > 100).collect(Collectors.toList());
        System.out.println(selected);
    }
}

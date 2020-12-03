package xiuwei_test.chap02;

public class AppleZXW {
    int weight;
    String color;

    public AppleZXW(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return "AppleZXW{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}

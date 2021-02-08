package xiuwei_test.chap05;

import lambdasinaction.chap5.Trader;
import lambdasinaction.chap5.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 21-02-07
 * P97 5.5付诸实践
 * 没难度
 * 主要问题：对用方法引用，不熟。
 */
public class Practise {
    public static void main(String[] args) {
        // 数据
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//        (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> t2011 = transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted((x, y) -> x.getValue() - y.getValue())
                .collect(Collectors.toList());
        System.out.println(t2011);

//        (2) 交易员都在哪些不同的ۡ市工作过？
        List<String> traderCities = transactions.stream()
                .map( x -> x.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(traderCities);

//        (3) 查找所有来自于Cambridge的交易员，并按name排序。
        List<Trader> tradersFromCambridge = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(x -> x.getTrader())
                .distinct()
                .sorted((x, y) -> x.getName().compareTo(y.getName()))
                .collect(Collectors.toList());
        System.out.println(tradersFromCambridge);

//        (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        List<String> traderNames = transactions.stream()
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted((x, y) -> x.compareTo(y))
                .collect(Collectors.toList());
        System.out.println(traderNames);

//        (5) 有没有交易员是在Milan工作的？
        boolean isTraderInMilan = transactions.stream()
                .anyMatch(x -> x.getTrader().getCity().equals("Milan"));
        System.out.println(isTraderInMilan);


//        (6) 打印生活在Cambridge的交易员的所有交易额。
        int tradersFromCambridgeValueSum = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(x -> x.getValue())
                .reduce(0, (x, y) -> x + y);
        System.out.println(tradersFromCambridgeValueSum);

//        (7) 所有交易中，最高的交易额是多少？
        int maxTradeValue = transactions.stream()
                .map(x -> x.getValue())
                .reduce(0, (x, y) -> x > y ? x: y);
        System.out.println(maxTradeValue);

//        (8) 找到交易额最小的交易
        Optional<Transaction> minValueTrade = transactions.stream()
                .reduce( (x, y) -> x.getValue() < y.getValue() ? x: y);
        System.out.println(minValueTrade.get());
        /** 方式2： 直接用min函数 */
        minValueTrade = transactions.stream()
                .min((x, y) -> x.getValue() - y.getValue());
        System.out.println(minValueTrade.get());
    }
}

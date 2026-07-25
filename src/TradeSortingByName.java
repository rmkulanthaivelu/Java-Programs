import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TradeSortingByName {
    public static void main(String[] args) {
       // Map<String, Integer> studentMap = new HashMap<>();
        List<TradeDTO> tradeDTOSList = new ArrayList<>();
        tradeDTOSList.add(new TradeDTO("TCS", 80,150));
        tradeDTOSList.add(new TradeDTO("FB", 10,100));
        tradeDTOSList.add(new TradeDTO("TCS", 70,150));
        tradeDTOSList.add(new TradeDTO("Oracle", 30,10));
        tradeDTOSList.add(new TradeDTO("BNY", 50,400));
        tradeDTOSList.add(new TradeDTO("Amazon", 100,300));
        tradeDTOSList.add(new TradeDTO("FB", 20,100));
        tradeDTOSList.add(new TradeDTO("Flipkart", 20,500));
        tradeDTOSList.add(new TradeDTO("Amazon", 120,300));
        System.out.println("--------------Student Name Sorting ------------------");
        tradeDTOSList.stream().collect(Collectors.groupingBy(TradeDTO::getSymbol,Collectors.summingDouble(TradeDTO::getTotal)))
                        .entrySet().stream().sorted(Comparator.comparing(Map.Entry<String,Double>::getValue).reversed())
                .limit(3)
                .forEach(e->System.out.println(e));
    }
}
class TradeDTO{
    private String symbol;
    private int stockQty;
    private long price;
    private double total;
    public TradeDTO(String symbol, int stockQty,long price) {
        this.symbol = symbol;
        this.stockQty = stockQty;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public long getPrice() {
        return  price;
    }

    public double getTotal() {
        return stockQty * price;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
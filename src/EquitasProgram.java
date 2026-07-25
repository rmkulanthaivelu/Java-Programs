import java.util.*;
import java.util.stream.Collectors;

public class EquitasProgram {
    public static void main(String args[]){
        List<Transaction> list = Arrays.asList(
                new Transaction(101,"aa",1000),
                new Transaction(101,"ee",8000),
                new Transaction(101,"cc",7000),
                new Transaction(101,"dd",3000),
                new Transaction(101,"bb",5000)
        );
        List<Transaction> listAmount  = list.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .limit(3).collect(Collectors.toList());

        Map<String,Transaction> map = new HashMap();
        Map<Object,Object> finalMap = new HashMap<>();
        Map<Object,Object> TopMap = new HashMap<>();
        int k = 0;
        for(Transaction t:listAmount){
            map.put("Top"+(k++)+" Amount",new Transaction(t.getCustId(),t.getCustName(),t.getAmount()));
        }
        TopMap.put("TopAmount",map);
        TopMap.put("Transactions",list);
        finalMap.put("Last10Transactions",TopMap);
        System.out.println(finalMap);
    }
}

class Transaction{
    private int custId;
    private String custName;
    private int amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Transaction(int custId, String custName, int amount) {
        this.custId = custId;
        this.custName = custName;
        this.amount = amount;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
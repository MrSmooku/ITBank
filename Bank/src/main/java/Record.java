import java.util.Date;

/**
 * Created by marcinkarmelita on 16/03/17.
 */
public abstract class Record implements Printable {
    String id;
    Date date;
    BankingOperation.BankingOperationType type;

    public Record(String id, Date date, BankingOperation.BankingOperationType type) {
        this.id = id;
        this.date = date;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public BankingOperation.BankingOperationType getType() {
        return type;
    }

}

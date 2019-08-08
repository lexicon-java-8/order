package se.lexicon.order.component.domain;

import com.so4it.common.util.object.Required;
import com.so4it.common.util.object.ValueObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author Magnus Poromaa {@literal <mailto:magnus.poromaa@so4it.com/>}
 */
public class Order extends ValueObject implements Serializable {

    private static final long serialVersionUID = 2L;

    //@Allowed(minMaxValue = "Auto generated by GS",types = {Allowed.Type.NULLABLE})
    private String id;

    private OrderBooks orderBooks;

    private BigDecimal amount;

    private String ssn;

    // Timestamp from core system when the order was made
    private Instant insertionTimestamp;

    private Order() {
    }

    private Order(Builder builder) {
        this.id = builder.id;
        this.amount = Required.notNull(builder.amount,"amount");
        this.orderBooks = builder.orderBooks;
        this.ssn = Required.notNull(builder.ssn,"ssn");
        this.insertionTimestamp = Required.notNull(builder.insertionTimestamp,"insertionTimestamp");
    }


    public String getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public OrderBooks getOrderBooks() { return orderBooks; }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getInsertionTimestamp() { return insertionTimestamp; }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{id, amount, orderBooks, ssn, insertionTimestamp};
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements com.so4it.common.builder.Builder<Order>{

        private String id;

        private OrderBooks orderBooks;

        private BigDecimal amount;

        private String ssn;

        private Instant insertionTimestamp;

        public Builder withId(String id){
            this.id = id;
            return this;
        }

        public Builder withOrderBookId(OrderBooks orderBookId){
            this.orderBooks = orderBookId;
            return this;
        }

        public Builder withAmount(BigDecimal amount){
            this.amount = amount;
            return this;
        }

        public Builder withSsn(String ssn){
            this.ssn = ssn;
            return this;
        }

        public Builder withInsertionTimestamp(Instant insertionTimestamp){
            this.insertionTimestamp = insertionTimestamp;
            return this;
        }

        @Override
        public Order build() {
            return new Order(this);
        }
    }
}
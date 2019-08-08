package se.lexicon.order.component.entity;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.so4it.annotation.Allowed;
import com.so4it.common.util.object.Required;
import com.so4it.component.entity.AbstractEntityBuilder;
import com.so4it.component.entity.IdEntity;
import se.lexicon.order.component.domain.OrderBooks;

import java.math.BigDecimal;
import java.time.Instant;

/**
 *
 * @author Magnus Poromaa {@literal <mailto:magnus.poromaa@so4it.com/>}
 */
@SpaceClass
public class OrderEntity extends IdEntity<String> {

    @Allowed(value = "Auto generated by GS", types = {Allowed.Type.NULLABLE})
    private String id;

    private String ssn;

    private BigDecimal amount;

    private Instant insertionTimestamp;

    //private OrderBooks orderBookId;

    private OrderEntity() {
    }

    private OrderEntity(Builder builder) {
        this.id = builder.id;
        this.ssn = Required.notNull(builder.ssn,"ssn",builder.isTemplate());
        this.amount = Required.notNull(builder.amount,"amount",builder.isTemplate());
        this.insertionTimestamp = Required.notNull(builder.insertionTimestamp,"insertionTimestamp",builder.isTemplate());
        //this.orderBookId = Required.notNull(builder.orderBookId,"orderBookId",builder.isTemplate());
    }

    @Override
    @SpaceId(autoGenerate = true)
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    @SpaceRouting
    public String getSsn() {
        return ssn;
    }

    private void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getInsertionTimestamp() {
        return insertionTimestamp;
    }

    private void setInsertionTimestamp(Instant insertionTimestamp) {
        this.insertionTimestamp = insertionTimestamp;
    }

    public static Builder builder() {
        return new Builder(false);
    }

    public static Builder templateBuilder() {
        return new Builder(true);
    }


    public static class Builder extends AbstractEntityBuilder<OrderEntity> {

        private String id;

        //The arrangement id of this order balance
        private String ssn;

        // Unique id for the posting
        private BigDecimal amount;

        private Instant insertionTimestamp;

        //private OrderBooks orderBookId;

        public Builder(boolean template) {
            super(template);
        }

        public OrderEntity.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public OrderEntity.Builder withSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }

        public OrderEntity.Builder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public OrderEntity.Builder withInsertionTimestamp(Instant insertionTimestamp) {
            this.insertionTimestamp = insertionTimestamp;
            return this;
        }

//        public OrderEntity.Builder withOrderBookId(OrderBooks orderBookId) {
//            this.orderBookId = orderBookId;
//            return this;
//        }


        @Override
        public OrderEntity build() {
            return new OrderEntity(this);
        }
    }
}
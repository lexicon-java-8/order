package se.lexicon.order.component.entity;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceFifoGroupingProperty;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.so4it.annotation.Allowed;
import com.so4it.common.util.object.Required;
import com.so4it.component.entity.AbstractEntityBuilder;
import com.so4it.component.entity.IdEntity;
import se.lexicon.order.component.domain.Money;
import se.lexicon.order.component.domain.OrderPriceType;
import se.lexicon.order.component.domain.Side;

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

    // original order
    private String instrument;

    private Integer noOfItems;

    private Money minMaxValue; //Money minValue if SELL, maxValue if BUY;

    private Side side;         // Sell or Buy

    private OrderPriceType orderPriceType; // BUY/SELL at MARKET or LIMITED price

    private String orderBookId;

    private OrderEntity() {
    }

    private OrderEntity(Builder builder) {
        this.id = builder.id;
        this.ssn = Required.notNull(builder.ssn,"ssn",builder.isTemplate());
        this.amount = Required.notNull(builder.amount,"amount",builder.isTemplate());
        this.insertionTimestamp = Required.notNull(builder.insertionTimestamp,"insertionTimestamp",builder.isTemplate());
        this.instrument = Required.notNull(builder.instrument,"instrument",builder.isTemplate());
        this.noOfItems = Required.notNull(builder.noOfItems,"noOfItems",builder.isTemplate());
        this.minMaxValue = Required.notNull(builder.minMaxValue,"minMaxValue",builder.isTemplate());
        this.side = Required.notNull(builder.side,"side",builder.isTemplate());
        this.orderPriceType = Required.notNull(builder.orderPriceType,"orderPriceType",builder.isTemplate());
        this.orderBookId = Required.notNull(builder.orderBookId,"orderBookId",builder.isTemplate());
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
    @SpaceFifoGroupingProperty
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

    public String getInstrument() {
        return instrument;
    }

    private void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Integer getNoOfItems() {
        return noOfItems;
    }

    private void setNoOfItems(Integer noOfItems) {
        this.noOfItems = noOfItems;
    }

    public Money getMinMaxValue() {
        return minMaxValue;
    }

    private void setMinMaxValue(Money minMaxValue) {
        this.minMaxValue = minMaxValue;
    }

    public Side getSide() {
        return side;
    }

    private void setSide(Side side) {
        this.side = side;
    }

    public OrderPriceType getOrderPriceType() {
        return orderPriceType;
    }

    private void setOrderPriceType(OrderPriceType orderPriceType) {
        this.orderPriceType = orderPriceType;
    }

    public String getOrderBookId() {
        return orderBookId;
    }

    private void setOrderBookId(String orderBookId) {
        this.orderBookId = orderBookId;
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

        private String instrument;

        private Integer noOfItems;

        private Money minMaxValue; //Money minValue if SELL, maxValue if BUY;

        private Side side;         // Sell or Buy

        private OrderPriceType orderPriceType;

        private String orderBookId;

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

        public OrderEntity.Builder withInstrument(String instrument) {
            this.instrument = instrument;
            return this;
        }

        public OrderEntity.Builder withNoOfItems(Integer noOfItems) {
            this.noOfItems = noOfItems;
            return this;
        }

        public OrderEntity.Builder withMinMaxValue(Money minMaxValue) {
            this.minMaxValue = minMaxValue;
            return this;
        }

        public OrderEntity.Builder withSide(Side side) {
            this.side = side;
            return this;
        }

        public OrderEntity.Builder withOrderPriceType(OrderPriceType orderPriceType) {
            this.orderPriceType = orderPriceType;
            return this;
        }

        public OrderEntity.Builder withOrderBookId(String orderBookId) {
            this.orderBookId = orderBookId;
            return this;
        }

        @Override
        public OrderEntity build() {
            return new OrderEntity(this);
        }
    }
}

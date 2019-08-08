package se.lexicon.order.component.entity;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.so4it.annotation.Allowed;
import com.so4it.common.util.object.Required;
import com.so4it.component.entity.AbstractEntityBuilder;
import com.so4it.component.entity.IdEntity;
import se.lexicon.order.component.domain.Money;
import se.lexicon.order.component.domain.Phase;

/**
 *
 * @author Magnus Poromaa {@literal <mailto:magnus.poromaa@so4it.com/>}
 */
@SpaceClass
public class OrderBookEntity extends IdEntity<String> {

    @Allowed(value = "Auto generated by GS", types = {Allowed.Type.NULLABLE})
    private String id;
    private String orderId;
    private String ssn;

    private String instrument;
    private Integer noOfItems;

    private Money minMaxValue;
    //Money minValue if SELL, maxValue if BUY;

    private Phase phase = Phase.UNKNOWN;

    private Boolean sellOrder; // Sell or Buy

    @Allowed(types = {Allowed.Type.NULLABLE})
    private String matchingOrderId;

    private OrderBookEntity() {
    }

    private OrderBookEntity(Builder builder) {
        this.id = builder.id;
        this.orderId = Required.notNull(builder.orderId,"orderId",builder.isTemplate());
        this.ssn = Required.notNull(builder.ssn,"ssn",builder.isTemplate());
        this.instrument = Required.notNull(builder.instrument,"instrument",builder.isTemplate());
        this.noOfItems = Required.notNull(builder.noOfItems,"noOfItems",builder.isTemplate());
        this.minMaxValue = Required.notNull(builder.minMaxValue,"minValue",builder.isTemplate());
        this.phase = Required.notNull(builder.phase,"phase",builder.isTemplate());
        this.sellOrder = Required.notNull(builder.sellOrder,"sellOrder",builder.isTemplate());
        this.matchingOrderId = builder.matchingOrderId;
    }

    @Override
    @SpaceId(autoGenerate = true)
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    private void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @SpaceRouting
    public String getSsn() {
        return ssn;
    }

    private void setSsn(String ssn) {
        this.ssn = ssn;
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

    public Phase getPhase() {
        return phase;
    }

    private void setPhase(Phase phase) {
        this.phase = phase;
    }

    public Boolean getSellOrder() {
        return sellOrder;
    }

    private void setSellOrder(Boolean sellOrder) {
        this.sellOrder = sellOrder;
    }

    public String getMatchingOrderId() {
        return matchingOrderId;
    }

    private void setMatchingOrderId(String matchingOrderId) {
        this.matchingOrderId = matchingOrderId;
    }

    public static Builder builder() {
        return new Builder(false);
    }

    public static Builder templateBuilder() {
        return new Builder(true);
    }

    @Override
    public String toString() {
        return "OrderBookEntity{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", ssn='" + ssn + '\'' +
                ", instrument='" + instrument + '\'' +
                ", noOfItems=" + noOfItems +
                ", minMaxValue=" + minMaxValue +
                ", phase=" + phase +
                ", sellOrder=" + sellOrder +
                ", matchingOrderId='" + matchingOrderId + '\'' +
                '}';
    }

    public static class Builder extends AbstractEntityBuilder<OrderBookEntity> {

        private String id;

        private String orderId;

        //The arrangement id of this order balance
        private String ssn;

        String instrument;
        Integer noOfItems;

        Money minMaxValue;
        //Money max or min Value;

        Phase phase = Phase.UNKNOWN;

        Boolean sellOrder; // Sell or Buy

        String matchingOrderId;

        public Builder(boolean template) {
            super(template);
        }

        public OrderBookEntity.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public OrderBookEntity.Builder withOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBookEntity.Builder withSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }

        public OrderBookEntity.Builder withInstrument(String instrument) {
            this.instrument = instrument;
            return this;
        }

        public OrderBookEntity.Builder withNoOfItems(Integer noOfItems) {
            this.noOfItems = noOfItems;
            return this;
        }

        public OrderBookEntity.Builder withMinMaxValue(Money value) {
            this.minMaxValue = value;
            return this;
        }

        public OrderBookEntity.Builder withPhase(Phase phase) {
            this.phase = phase;
            return this;
        }

        public OrderBookEntity.Builder withSellOrder(Boolean sellOrder) {
            this.sellOrder = sellOrder;
            return this;
        }

        public OrderBookEntity.Builder withMatchingOrderId(String matchingOrderId) {
            this.matchingOrderId = matchingOrderId;
            return this;
        }

        @Override
        public OrderBookEntity build() {
            return new OrderBookEntity(this);
        }
    }
}
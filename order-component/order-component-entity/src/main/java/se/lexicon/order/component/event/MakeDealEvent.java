package se.lexicon.order.component.event;

import com.gigaspaces.annotation.pojo.SpaceFifoGroupingProperty;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.so4it.annotation.Allowed;
import com.so4it.common.util.object.Required;
import com.so4it.component.entity.AbstractEntityBuilder;
import com.so4it.component.entity.IdEntity;
import se.lexicon.order.component.entity.OrderDealEntity;

public class MakeDealEvent extends IdEntity<String> {

    @Allowed(value = "Auto generated by GS", types = {Allowed.Type.NULLABLE})
    private String id;

    private String ssn;

    private OrderDealEntity orderDealEntity;

    private Integer counter;

    private MakeDealEvent() {
    }

    private MakeDealEvent(Builder builder) {
        this.id = builder.id;
        this.ssn = Required.notNull(builder.ssn,"ssn",builder.isTemplate());
        this.orderDealEntity = Required.notNull(builder.orderDealEntity,"orderDealEntity",builder.isTemplate());
        this.counter = Required.notNull(builder.counter,"counter",builder.isTemplate());
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
    public String getSsn() { return ssn; }

    private void setSsn(String ssn) { this.ssn = ssn; }

    public OrderDealEntity getOrderDealEntity() {
        return orderDealEntity;
    }

    private void setOrderEntity(OrderDealEntity orderDealEntity) {
        this.orderDealEntity = orderDealEntity;
    }

    public Integer getCounter() {
        return counter;
    }

    private void setCounter(Integer counter) {
        this.counter = counter;
    }

    public static Builder builder() {
        return new Builder(false);
    }

    public static Builder templateBuilder() {
        return new Builder(true);
    }


    public static class Builder extends AbstractEntityBuilder<MakeDealEvent> {

        private String id;

        private String ssn;

        private OrderDealEntity orderDealEntity;

        private Integer counter;

        public Builder(boolean template) {
            super(template);
        }

        public MakeDealEvent.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public MakeDealEvent.Builder withSsn(String ssn) {
            this.ssn = ssn;
            return this;
        }

        public MakeDealEvent.Builder withOrderDealEntity(OrderDealEntity orderDealEntity) {
            this.orderDealEntity = orderDealEntity;
            return this;
        }

        public MakeDealEvent.Builder withCounter(Integer counter) {
            this.counter = counter;
            return this;
        }

        @Override
        public MakeDealEvent build() {
            return new MakeDealEvent(this);
        }
    }
}
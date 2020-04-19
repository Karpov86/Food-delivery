package by.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "date")
    private LocalDateTime localDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public static class Builder {

        private Order order;

        public Builder() {
            order = new Order();
        }

        public Builder setId(Long id) {
            order.setId(id);
            return this;
        }

        public Builder setDateTime(LocalDateTime localDate) {
            order.localDate = localDate;
            return this;
        }

        public Builder setUser(User user) {
            order.user = user;
            return this;
        }

        public Builder setDish(Dish dish) {
            order.dish = dish;
            return this;
        }

        public Order build() {
            return order;
        }
    }
}

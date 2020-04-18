package by.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "dishes")
public class Dish extends BaseEntity {

    @Column(name = "price")
    private Float price;

    @Column(name = "sale")
    private Boolean isSale = false;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Order> orders;

    public static class Builder {

        private Dish dish;

        public Builder() {
            dish = new Dish();
        }

        public Builder setId(Long id) {
            dish.setId(id);
            return this;
        }

        public Builder setPrice(Float price) {
            dish.price = price;
            return this;
        }

        public Builder setSale(Boolean isSale) {
            dish.isSale = isSale;
            return this;
        }

        public Builder setName(String name) {
            dish.name = name;
            return this;
        }

        public Builder setCategory(Category category) {
            dish.category = category;
            return this;
        }

        public Builder setUsersList(List<Order> orders) {
            dish.orders = orders;
            return this;
        }

        public Dish build() {
            return dish;
        }
    }
}

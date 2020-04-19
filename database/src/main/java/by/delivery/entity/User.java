package by.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString


@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "home_city")),
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "work_city")),
            @AttributeOverride(name = "street", column = @Column(name = "work_street"))
    })
    private Address workAddress;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Order> orders;

    public static class Builder {

        private User user;

        public Builder() {
            user = new User();
        }

        public Builder setId(Long id) {
            user.setId(id);
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            user.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setName(String name) {
            user.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            user.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            user.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            user.password = password;
            return this;
        }

        public Builder setHomeAddress(Address homeAddress) {
            user.homeAddress = homeAddress;
            return this;
        }

        public Builder setWorkAddress(Address workAddress) {
            user.workAddress = workAddress;
            return this;
        }

        public Builder setDishesList(List<Order> orders) {
            user.orders = orders;
            return this;
        }

        public User build() {
            return user;
        }

    }

}

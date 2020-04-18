package by.delivery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Setter
@Getter
@NoArgsConstructor
@ToString

@Embeddable
public class Address {

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}

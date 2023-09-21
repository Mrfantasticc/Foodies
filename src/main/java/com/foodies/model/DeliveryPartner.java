package com.foodies.model;

import com.foodies.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery_partner")
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column()
    String mobileNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "deliveryPartner",cascade = CascadeType.ALL)
    List<OrderEntity> orders=new ArrayList<>();


}

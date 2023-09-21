package com.foodies.model;

import com.foodies.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Size(min = 2,max = 20,message = "Name should be greater than 2 character and less than 40 character")
    String name;

    @Email
    @Column(unique = true)
    String email;

    String address;

    @Column(unique = true,nullable = false)
    @Size(min = 10,max = 10,message = "Wrong Mobile No.")
    String mobileNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    List<OrderEntity> orders=new ArrayList<>();
}

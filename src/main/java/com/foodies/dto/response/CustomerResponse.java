package com.foodies.dto.response;



import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    String name;

    String address;

    String mobileNo;

    CartResponse cart;
}

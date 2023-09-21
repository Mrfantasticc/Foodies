package com.foodies.dto.request;

import com.foodies.Enum.Gender;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    String name;

    String email;

    String address;

    String mobileNo;

    Gender gender;
}

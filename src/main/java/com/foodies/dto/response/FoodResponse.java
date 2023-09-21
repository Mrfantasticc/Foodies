package com.foodies.dto.response;

import com.foodies.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponse {

    String dishName;

    double price;

    boolean veg;

    FoodCategory foodCategory;
}

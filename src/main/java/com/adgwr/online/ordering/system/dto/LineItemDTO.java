package com.adgwr.online.ordering.system.dto;

import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Shoppingcart;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Administrator
 */
@Data
public class LineItemDTO {
    private Food food;
    private Shoppingcart shoppingcart;
    private BigDecimal totalPrice;
}

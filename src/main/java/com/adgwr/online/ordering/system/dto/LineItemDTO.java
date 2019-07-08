package com.adgwr.online.ordering.system.dto;

import com.adgwr.online.ordering.system.domain.Food;
import com.adgwr.online.ordering.system.domain.Lineitem;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class LineItemDTO {
    private Food food;
    private Lineitem lineitem;
}

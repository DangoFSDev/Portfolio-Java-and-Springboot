package com.ecos.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductRequest {

    private Long id;
    private String productCode;
    private String productName;
    private Byte status;

}

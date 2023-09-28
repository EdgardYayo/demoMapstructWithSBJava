package com.edydev.mapStructLombokDemo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProduct {
    
    private Long productId;
    private String productName;
    private String creationDate;
    private GetCategory category;
    private String price;
   
}

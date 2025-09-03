package com.projects.shopapp.responses;

import lombok.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {

    private List<ProductResponse> productList;

    private int totalPage;

}

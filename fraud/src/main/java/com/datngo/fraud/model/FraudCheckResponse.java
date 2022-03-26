package com.datngo.fraud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FraudCheckResponse {
    private boolean isFraudulentCustomer;
}

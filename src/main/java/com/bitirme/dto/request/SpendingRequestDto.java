package com.bitirme.dto.request;

import com.bitirme.enums.SpendingType;
import com.bitirme.enums.TaxRate;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SpendingRequestDto {

    private Long userId;

    private SpendingType spendingType;

    private Long spendingAmount;

    private String receiptDate;

    private TaxRate taxRate;

    private String spendingDefinition;

    private Long spendingId;
}

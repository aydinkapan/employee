package com.bitirme.mapper;

import com.bitirme.dto.request.SpendingRequestDto;
import com.bitirme.dto.response.SpendingResponseDto;
import com.bitirme.entity.Spending;
import com.bitirme.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SpendingMapper {

    public Spending createSpending(SpendingRequestDto spendingRequestDto) {

        return Spending.builder().user(User.builder().userId(spendingRequestDto.getUserId()).build())
                .spendingType(spendingRequestDto.getSpendingType())
                .spendingAmount(spendingRequestDto.getSpendingAmount())
                .receiptDate(spendingRequestDto.getReceiptDate())
                .taxRate(spendingRequestDto.getTaxRate())
                .spendingDefinition(spendingRequestDto.getSpendingDefinition()).build();
    }

    public SpendingResponseDto createDto(Spending spending) {
        SpendingResponseDto spendingResponseDto = new SpendingResponseDto();
        spendingResponseDto.setUserId(spending.getUser().getUserId());
        spendingResponseDto.setSpendingType(spending.getSpendingType());
        spendingResponseDto.setSpendingAmount(spending.getSpendingAmount());
        spendingResponseDto.setReceiptDate(spending.getReceiptDate());
        spendingResponseDto.setTaxRate(spending.getTaxRate());
        spendingResponseDto.setSpendingDefinition(spending.getSpendingDefinition());
        return spendingResponseDto;

    }
}

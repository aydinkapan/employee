package com.bitirme.service;

import com.bitirme.dto.request.SpendingRequestDto;
import com.bitirme.dto.response.SpendingResponseDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SpendingService {

    SpendingResponseDto saveSpending(SpendingRequestDto spendingRequestDto);

    List<SpendingResponseDto> findAllSpending();

    SpendingResponseDto findSpendingById(Long spendId);

    void deleteSpending(@PathVariable Long speendingId);

    SpendingResponseDto updateSpending(SpendingRequestDto spendingRequestDto, Long id);
}

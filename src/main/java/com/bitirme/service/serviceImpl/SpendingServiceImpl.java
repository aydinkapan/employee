package com.bitirme.service.serviceImpl;

import com.bitirme.dto.request.SpendingRequestDto;
import com.bitirme.dto.response.SpendingResponseDto;
import com.bitirme.entity.Spending;
import com.bitirme.exception.CustomerNotFoundException;
import com.bitirme.mapper.SpendingMapper;
import com.bitirme.repository.SpendingRepository;
import com.bitirme.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SpendingServiceImpl implements SpendingService {

    private final SpendingMapper spendingMapper;
    private final SpendingRepository spendingRepository;

    @Override
    public SpendingResponseDto saveSpending(SpendingRequestDto spendingRequestDto) {
        Spending spending = spendingMapper.createSpending(spendingRequestDto);
        return spendingMapper.createDto(spendingRepository.save(spending));

    }

    @Override
    public List<SpendingResponseDto> findAllSpending() {
        return spendingRepository.findAllSpendings();
    }

    @Override
    public SpendingResponseDto findSpendingById(Long spendId) {
        return spendingRepository.findSpendingById(spendId);
    }

    @Override
    public void deleteSpending(Long spendingId) {
        spendingRepository.deleteById(spendingId);

    }

    @Override
    public SpendingResponseDto updateSpending(SpendingRequestDto spendingRequestDto, Long id) {
        Optional<Spending> spendingOptional = spendingRepository.findById(id);
        spendingOptional.ifPresent(spending -> {
            spending.setSpendingType(spendingRequestDto.getSpendingType());
            spending.setSpendingAmount(spendingRequestDto.getSpendingAmount());
            spending.setReceiptDate(spendingRequestDto.getReceiptDate());
            spending.setTaxRate(spendingRequestDto.getTaxRate());
            spending.setSpendingDefinition(spendingRequestDto.getSpendingDefinition());
            spendingRepository.save(spending);
        });
        return spendingOptional.map(spendingMapper::createDto)
                .orElseThrow(() -> new CustomerNotFoundException("expense not found!"));
    }


}

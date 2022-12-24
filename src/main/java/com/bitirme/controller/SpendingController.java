package com.bitirme.controller;

import com.bitirme.dto.request.SpendingRequestDto;
import com.bitirme.dto.response.SpendingResponseDto;
import com.bitirme.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping(value = "/spending")
public class SpendingController {
    private final SpendingService spendingService;

    @PostMapping
    ResponseEntity<SpendingResponseDto> createSpending(@RequestBody SpendingRequestDto spendingRequestDto) {
        return ResponseEntity.ok(spendingService.saveSpending(spendingRequestDto));
    }

    @GetMapping
    List<SpendingResponseDto> getAllSpending() {
        return spendingService.findAllSpending();
    }

    @GetMapping("/{spendId}")
    SpendingResponseDto getSpendingById(@PathVariable Long spendId) {
        return spendingService.findSpendingById(spendId);
    }

    @DeleteMapping("/{spendingId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteSpending(@PathVariable Long spendingId) {

        spendingService.deleteSpending(spendingId);
    }

    @PutMapping("/{spendingId}")
    ResponseEntity<SpendingResponseDto> updateSpending(@Valid @RequestBody SpendingRequestDto spendingRequestDto, @PathVariable Long spendingId) {
        return ResponseEntity.ok(spendingService.updateSpending(spendingRequestDto, spendingId));
    }
}

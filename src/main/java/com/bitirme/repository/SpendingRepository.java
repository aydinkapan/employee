package com.bitirme.repository;


import com.bitirme.dto.response.SpendingResponseDto;
import com.bitirme.entity.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SpendingRepository extends JpaRepository<Spending, Long> {

    @Query(value = """
                        select new com.bitirme.dto.response.SpendingResponseDto(
                            s.user.userId,
                            s.spendingType,
                            s.spendingAmount,
                            s.receiptDate,
                            s.taxRate,
                            s.spendingDefinition,
                            s.spendId
                        )
                        FROM Spending s
            """)
    List<SpendingResponseDto> findAllSpendings();

    @Query(value = """
                        select new com.bitirme.dto.response.SpendingResponseDto(
                            s.user.userId,
                            s.spendingType,
                            s.spendingAmount,
                            s.receiptDate,
                            s.taxRate,
                            s.spendingDefinition,
                            s.spendId
                        )
                        FROM Spending s
                        where s.spendId=:spendId
            """)
    SpendingResponseDto findSpendingById(@PathVariable("userId") Long spendId);
}

package com.bitirme.entity;

import com.bitirme.enums.SpendingType;
import com.bitirme.enums.TaxRate;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "spending")
public class Spending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "spend_id")
    private Long spendId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "spending_type")
    @Enumerated
    private SpendingType spendingType;

    @Column(name = "spending_amount")
    private Long spendingAmount;

    @Column(name = "receipt_date")
    private String receiptDate;

    @Column(name = "tax_rate")
    @Enumerated
    private TaxRate taxRate;

    @Column(name = "permission_definition")
    private String spendingDefinition;

}

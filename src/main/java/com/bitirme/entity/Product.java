package com.bitirme.entity;

import lombok.*;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Immutable
@Table(name ="products")
public class Product {
    @Id
    private Long id;
    private String title;
    private String name;
    private String lastName;
    private double averageRating;
    private Integer totalComments;
    private String files;
    private String categories;
    private String packages;
}

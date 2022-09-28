package com.lioncompany.fastfoods.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FAST_FOOD")
@Data
public class FastFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Date createdDate;
    private Date updatedDate;
}

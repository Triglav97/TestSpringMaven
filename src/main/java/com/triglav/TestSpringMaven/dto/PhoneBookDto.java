package com.triglav.TestSpringMaven.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "phonesbook")
public class PhoneBookDto {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "phonesbookIdSeq", sequenceName = "phonesbook_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phonesbookIdSeq")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientDto clientDto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="phone_id", nullable = false)
    private PhoneEntity phoneEntity;
}

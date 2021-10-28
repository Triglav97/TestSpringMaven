package com.triglav.TestSpringMaven.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "clients")
public class ClientDto {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "clientIdSeq", sequenceName = "client_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientIdSeq")
    private long id;

    @Column(name = "client", nullable = false)
    private String client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private Set<PhoneEntity> phoneEntity;

}

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
@Table(name = "phones")
public class PhoneEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "phonesIdSeq", sequenceName = "phones_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phonesIdSeq")
    private long id;

    @Column(name = "phone", nullable = false)
    private long phone;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientDto client;



    /*@NotNull
    @Column(name = "person")
    @JsonProperty("name")
    private String user;*/


    /*public PhoneEntity() {
    }

    public PhoneEntity(int phone, String user) {
        this.phone = phone;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return "Test [id=" + id + ", phone=" + phone + ", user=" + user + "]";
    }*/
}

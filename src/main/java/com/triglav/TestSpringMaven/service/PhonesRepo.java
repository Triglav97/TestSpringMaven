package com.triglav.TestSpringMaven.service;

import com.triglav.TestSpringMaven.dto.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PhonesRepo extends JpaRepository<PhoneEntity, Long> {
//    List<PhoneEntity> findByPhone(int phone);
//
//    List<PhoneEntity> getAllById(long id);
}

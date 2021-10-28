package com.triglav.TestSpringMaven.service;

import com.triglav.TestSpringMaven.dto.PhoneEntity;

import java.util.List;

public interface PhonesService {
    boolean create(PhoneEntity phoneEntity) throws Exception;

    List<PhoneEntity> readAll();

    PhoneEntity read(long id);

    boolean update(PhoneEntity phoneEntity, long id);

    boolean delete(long id);
}

package com.triglav.TestSpringMaven.service;

import com.triglav.TestSpringMaven.dto.PhoneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PhoneBookService implements PhonesService{
    /*private static final Map<Integer, PhoneEntity> PHONE_BOOK_DTO_MAP = new HashMap<>();

    private static final AtomicInteger PHONE_BOOK_DTO_ID = new AtomicInteger();

    @Override
    public void create(PhoneEntity phoneBookDto) {
        final int phoneBookId = PHONE_BOOK_DTO_ID.incrementAndGet();
        phoneBookDto.setId(phoneBookId);
        PHONE_BOOK_DTO_MAP.put(phoneBookId, phoneBookDto);
    }

    @Override
    public List<PhoneEntity> readAll() {
        return new ArrayList<>(PHONE_BOOK_DTO_MAP.values());
    }

    @Override
    public PhoneEntity read(int id) {
        return PHONE_BOOK_DTO_MAP.get(id);
    }

    @Override
    public boolean update(PhoneEntity phoneBookDto, int id) {
        if (PHONE_BOOK_DTO_MAP.containsKey(id)){
            phoneBookDto.setId(id);
            PHONE_BOOK_DTO_MAP.put(id, phoneBookDto);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return PHONE_BOOK_DTO_MAP.remove(id) != null;
    }*/
    @Autowired
    private PhonesRepo phonesRepo;

    @Transactional
    @Override
    public boolean create(PhoneEntity phoneEntity) throws Exception {
        if(!phonesRepo.existsById(phoneEntity.getId())){
            phonesRepo.save(phoneEntity);
//            throw new IOException();
            return true;
        }
        return false;
    }

    @Override
    public List<PhoneEntity> readAll(){
        return phonesRepo.findAll();
    }

    @Override
    public PhoneEntity read(long id){
        return phonesRepo.getById(id);
    }

    @Override
    public boolean update(PhoneEntity phoneEntity, long id){
        if (phonesRepo.existsById(id)){
            phoneEntity.setId(id);
            phonesRepo.save(phoneEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id){
        if (phonesRepo.existsById(id)){
            phonesRepo.deleteById(id);
            return true;
        }
        return false;
    }
}

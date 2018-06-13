package com.example.dao;

import com.example.domain.Address;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    private Map<Integer, Address> addressMap = new HashMap<>();
    private Integer index = 0;

    @PostConstruct
    private void defaultValue() {
        addAdress(new Address("Lozova", "64600"));
        addAdress(new Address("Kharkiv", "61144"));
    }

    private void addAdress(Address address) {
        address.setId(++index);
        addressMap.put(address.getId(), address);
    }

    @Override
    public Address findById(Integer id) {
        return addressMap.get(id);
    }
}

package com.example.service;

import com.example.dao.AddressRepository;
import com.example.domain.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address getAddress(Integer id) {
        return addressRepository.findById(id);
    }
}

package com.example.dao;

import com.example.domain.Address;

public interface AddressRepository {

    Address findById(Integer id);

}

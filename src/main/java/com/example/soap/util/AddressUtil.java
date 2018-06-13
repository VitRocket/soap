package com.example.soap.util;

import com.example.domain.Address;
import com.example.soap.model.AddressModel;

public class AddressUtil {

    public static AddressModel domainToModel(Address address) {
        AddressModel addressModel = new AddressModel();
        addressModel.setId(address.getId());
        addressModel.setCountry(address.getCountry());
        addressModel.setZip(address.getZip());
        return addressModel;
    }
}

package com.example.soap;

import com.example.domain.Address;
import com.example.service.AddressService;
import com.example.soap.model.AddressModel;
import com.example.soap.model.AddressRequest;
import com.example.soap.model.AddressResponse;
import com.example.soap.util.AddressUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class AddressEndpoint {

    private final AddressService addressService;

    @PayloadRoot(namespace = "http://example.com/soap/model", localPart = "AddressRequest")
    @ResponsePayload
    public AddressResponse getAddress(@RequestPayload AddressRequest request) {
        Address address = addressService.getAddress(request.getId());
        AddressModel addressModel = AddressUtil.domainToModel(address);
        AddressResponse response = new AddressResponse();
        response.setAddress(addressModel);
        return response;
    }


}
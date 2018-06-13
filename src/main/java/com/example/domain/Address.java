package com.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Address {
    private Integer id;
    @NonNull
    private String country;
    @NonNull
    private String zip;

}

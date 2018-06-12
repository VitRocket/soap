package com.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String email;
}

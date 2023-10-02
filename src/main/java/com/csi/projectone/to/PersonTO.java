package com.csi.projectone.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonTO {
    private long id;
    private String name;
    private String address;
    private int age;
}

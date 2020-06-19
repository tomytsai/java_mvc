package com.chtti.springbooot.demo.Demo7JPADocker.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CustomerForm {
    @NotNull
    @Size(min=3, max=64)
    private String firstName;
    @NotNull
    @Size(min=2, max=64)
    private String lastName;
}

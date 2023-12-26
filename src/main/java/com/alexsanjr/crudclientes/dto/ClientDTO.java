package com.alexsanjr.crudclientes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @NotBlank(message = "Campo requirido")
    private String name;
    @Size(min = 11, max = 11, message = "Campo deverá ter 11 dígitos")
    private String cpf;
    @PositiveOrZero(message = "O campo deve ser positivo ou igual a zero")
    private Double income;
    @PastOrPresent(message = "Somente datas passadas ou presente")
    private LocalDate birthDate;
    @PositiveOrZero(message = "O campo deve ser positivo ou igual a zero")
    private Integer children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}

package com.facturacion.apifacturacion.dto;

import com.facturacion.apifacturacion.models.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClienteRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @Email
    private String email;

    @Pattern(regexp = "^3[0-9]{9}$", message = "El telefono no tiene el formato correcto")
    private String telefono;

    public Cliente toDomainModel() {
        return new Cliente(
                this.nombre,
                this.apellido,
                this.email,
                this.telefono
        );
    }
}

package com.example.PokemonAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del pokemon es requerido")
    @Size(min=2,max=100,message="El nombre debe teber entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El tipo de pokemon es requerido")
    private String tipo;

    @NotNull(message="El nivel del pokemon es requerido")
    @Min(value=0,message="El nivel no puede ser negativo")
    @Max(value=100,message = "El nivel no puede ser mayor a 100")
    private Integer nivel;

    @Min(value=0,message="El ataque no puede ser negativo")
    private Integer ataque;

    @Min(value=0,message="La defensa no puede ser negativo")
    private Integer defensa;

    @Size(max=255,message="La descripcion ni puede exceder los 255 caracteres")
    private String descripcion;

    @URL(message="La imagen debe ser una URL")
    private String imagenUrl;

    @Email(message = "El formato del correo no es valido")
    private String correoEntrenador;

    @PastOrPresent(message = "La fecha de naimiento no puede ser futura")
    private LocalDate fechaNacimiento;

    @Positive(message="El peso debe de ser positivo")
    private Double peso;

    @Pattern(regexp="^\\\\d{10}$",message="El formato del telefono no es valido")
    private String telefono;

    @AssertTrue(message="El pokemon debe de estar sano")
    private Boolean estaSano;



}

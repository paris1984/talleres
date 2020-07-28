package es.pc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class VehiculoEntity {
    private String tipo;
    private String matricula;
}

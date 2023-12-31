package grupo1.FlySky.Dto.Responses;

import grupo1.FlySky.Entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String email;
    private String telefono;
    private Roles.Rol rol;
}

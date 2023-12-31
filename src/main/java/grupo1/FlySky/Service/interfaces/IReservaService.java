package grupo1.FlySky.Service.interfaces;

import grupo1.FlySky.Dto.request.ReservaSaveDto;
import grupo1.FlySky.Dto.response.ReservaDto;

import java.util.List;

public interface IReservaService {
    ReservaDto nuevaReserva(ReservaSaveDto reserva);

    List<ReservaDto> devolverTodos();

    List<ReservaDto> reservasPorUsuario(Long id_usuario);
}

package grupo1.FlySky.Controller;

import grupo1.FlySky.Dto.request.ReservaSaveDto;
import grupo1.FlySky.Service.interfaces.ICompraService;
import grupo1.FlySky.Service.interfaces.IReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {

    private IReservaService service;

    public ReservaController(IReservaService service) {
        this.service = service;
    }

    @PostMapping("/reserve/new")
    public ResponseEntity<?> nuevaReserva(@RequestBody ReservaSaveDto reserva) {
        return new ResponseEntity<>(service.nuevaReserva(reserva), HttpStatus.OK);
    }
}
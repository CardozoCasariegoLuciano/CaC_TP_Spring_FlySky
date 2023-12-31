package grupo1.FlySky.Service;

import grupo1.FlySky.Dto.EstadisticasDTO;
import grupo1.FlySky.Dto.response.ReservaDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class AdminServiceImp implements IAdminService{

    private final ModelMapper mapper = new ModelMapper();
    private final VueloService vueloService;
    private final ReservaServiceImp reservaService;


    public AdminServiceImp(VueloService vueloService, ReservaServiceImp reservaService){
        this.vueloService = vueloService;
        this.reservaService = reservaService;
    }
    @Override
    public EstadisticasDTO dailyStatus(LocalDate date) {
        //procesamos las estadisticas para mostrar datos relevantes

        //cant asientos reservados
        //reserva con mas asientos
        //reserva mas cara
        ArrayList<ReservaDto> reservas = (ArrayList<ReservaDto>) reservaService.reservaPorFecha(date);
        int cantAsientos = 0;
        float sumaDiaria = 0;

        int asientosReservaMax = 0;
        Long asientosReservaMaxId = 0L;

        Long reservaMasCaraId = 0L;
        float reservaMasCara = 0F;

        for (ReservaDto reserva : reservas) {
            cantAsientos += reserva.getCantAsientos();
            sumaDiaria += reserva.getPrecioFinal();
            if (reserva.getCantAsientos() > asientosReservaMax) {
                asientosReservaMax = reserva.getCantAsientos();
                asientosReservaMaxId = reserva.getId();
            }
            if (reserva.getPrecioFinal() > reservaMasCara) {
                reservaMasCara = reserva.getPrecioFinal();
                reservaMasCaraId = reserva.getId();
            }
        }

        //cantidad reservas
        int cantReservas = reservaService.reservaPorFecha(date).size();

        //vuelo mas reservado??

        return new EstadisticasDTO(cantAsientos,asientosReservaMax,asientosReservaMaxId,asientosReservaMaxId,
                reservaMasCara,cantReservas,sumaDiaria);
    }
}
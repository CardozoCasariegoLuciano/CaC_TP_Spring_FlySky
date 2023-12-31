package grupo1.FlySky.Repository;

import grupo1.FlySky.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUserByEmail(String email);
}

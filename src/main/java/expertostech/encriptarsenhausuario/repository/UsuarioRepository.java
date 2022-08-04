package expertostech.encriptarsenhausuario.repository;

import expertostech.encriptarsenhausuario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    public Optional<UsuarioEntity> findByLogin(String login);

}

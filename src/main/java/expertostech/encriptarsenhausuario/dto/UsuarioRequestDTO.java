package expertostech.encriptarsenhausuario.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UsuarioRequestDTO {

    private String login;
    private String password;

}

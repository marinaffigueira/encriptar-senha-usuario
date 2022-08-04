package expertostech.encriptarsenhausuario.mapper;

import expertostech.encriptarsenhausuario.dto.UsuarioRequestDTO;
import expertostech.encriptarsenhausuario.dto.UsuarioResponseDTO;
import expertostech.encriptarsenhausuario.entity.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioEntity usuarioRequestDTOtoUsuarioEntity(UsuarioRequestDTO usuarioRequestDTO);

    UsuarioResponseDTO usuarioEntityToUsuarioResponseDto(UsuarioEntity usuarioEntity);
}

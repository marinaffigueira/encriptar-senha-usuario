package expertostech.encriptarsenhausuario.controller;

import expertostech.encriptarsenhausuario.dto.UsuarioRequestDTO;
import expertostech.encriptarsenhausuario.dto.UsuarioResponseDTO;
import expertostech.encriptarsenhausuario.entity.UsuarioEntity;
import expertostech.encriptarsenhausuario.mapper.UsuarioMapper;
import expertostech.encriptarsenhausuario.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    private final UsuarioMapper mapper;

    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder, UsuarioMapper mapper) {
        this.repository = repository;
        this.encoder = encoder;
        this.mapper = mapper;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<UsuarioEntity>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());

    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioResponseDTO> salvar(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioRequestDTO.setPassword(encoder.encode(usuarioRequestDTO.getPassword()));

        var usuarioEntity = mapper.usuarioRequestDTOtoUsuarioEntity(usuarioRequestDTO);

        var resource = repository.save(usuarioEntity);

        var usuarioResponseDto = mapper.usuarioEntityToUsuarioResponseDto(resource);

        return ResponseEntity.ok(usuarioResponseDto);
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String password) {

        Optional<UsuarioEntity> optUsuario = repository.findByLogin(login);
//        if(optUsuario.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
//        }

//        boolean valid = encoder.matches(password, optUsuario.get().getPassword());

//        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return null;

    }
}

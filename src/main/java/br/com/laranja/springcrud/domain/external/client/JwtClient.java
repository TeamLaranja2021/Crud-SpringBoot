package br.com.laranja.springcrud.domain.external.client;

import br.com.laranja.springcrud.domain.dto.usuario.UsuarioRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("jwt")
public interface JwtClient {
    @PostMapping("/auth")
    public String token(UsuarioRequest usuarioRequest);
}

package co.edu.eci.blueprints.api;

import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blueprints")
public class BlueprintController {

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_blueprints.read')")
    @io.swagger.v3.oas.annotations.Operation(
        summary = "Listar blueprints de ejemplo",
        description = "Devuelve una lista de blueprints de ejemplo. Requiere scope blueprints.read."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Consulta exitosa")
    })
    public List<Map<String, String>> list() {
        return List.of(
            Map.of("id", "b1", "name", "Casa de campo"),
            Map.of("id", "b2", "name", "Edificio urbano")
        );
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_blueprints.write')")
    @io.swagger.v3.oas.annotations.Operation(
        summary = "Crear blueprint de ejemplo",
        description = "Crea un blueprint de ejemplo. Requiere scope blueprints.write."
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Creado")
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Datos del blueprint",
        required = true,
        content = @io.swagger.v3.oas.annotations.media.Content(
            mediaType = "application/json"
        )
    )
    public Map<String, String> create(@RequestBody Map<String, String> in) {
        return Map.of("id", "new", "name", in.getOrDefault("name", "nuevo"));
    }
}

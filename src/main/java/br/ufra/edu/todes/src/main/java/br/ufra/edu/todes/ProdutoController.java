package br.ufra.edu.todes;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; // Importação alterada

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    // GET /produtos
    @GetMapping
    public List<ApiProduto> listarProdutos() {
        return repository.findAll();
    }

    // GET /produtos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ApiProduto> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /produtos/{id}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiProduto criarProduto(@Validated @RequestBody ApiProduto produto) { // @Valid substituído por @Validated
        return repository.save(produto);
    }

    // PUT /produtos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ApiProduto> atualizarProduto(@PathVariable Long id,
                                                       @Validated @RequestBody ApiProduto dadosAtualizados) { // @Valid substituído por @Validated
        return repository.findById(id)
                .map(produto -> {
                    produto.setNome(dadosAtualizados.getNome());
                    produto.setPreco(dadosAtualizados.getPreco());
                    produto.setQuantidade(dadosAtualizados.getQuantidade());
                    return ResponseEntity.ok(repository.save(produto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /produtos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirProduto(@PathVariable Long id) {
        return repository.findById(id)
                .map(produto -> {
                    repository.delete(produto);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

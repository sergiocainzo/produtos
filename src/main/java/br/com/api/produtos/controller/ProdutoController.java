package br.com.api.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.service.ProdutoService;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class ProdutoController {
    
    @Autowired
    private ProdutoService ps;

    // Confirmação da Rota Ativa da API
    @GetMapping("/")
    public String rota(){
        return "API de produtos funcionando!!";
    }

    // Listagem dos produtos
    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
        return ps.listar();
    }

    // Cadastro de Produto
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "cadastrar");
    }

    // Alteração de Produto
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");
    }

    // Exclusão de Produto
    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<RespostaModelo> excluir(@PathVariable long codigo){
        return ps.remover(codigo);
    }




}

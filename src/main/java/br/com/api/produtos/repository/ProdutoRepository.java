package br.com.api.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.modelo.ProdutoModelo;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModelo, Long> {
    
}
 
package com.alertou.sboot_atom_produto.repository;

import com.alertou.sboot_atom_produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface ProdutoRepository extends JpaRepository<Produto,Long> {
}

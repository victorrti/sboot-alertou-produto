package com.alertou.sboot_atom_produto.service;

import com.alertou.sboot_atom_produto.dto.ProdutoDto;
import com.alertou.sboot_atom_produto.mapper.ProdutoMapper;
import com.alertou.sboot_atom_produto.model.Produto;
import com.alertou.sboot_atom_produto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper mapper;

    public Produto criarProduto(ProdutoDto dto) {
        Produto produto = mapper.toEntity(dto);
        return produtoRepository.save(produto);
    }
}

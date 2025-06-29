package com.alertou.sboot_atom_produto.mapper;

import com.alertou.sboot_atom_produto.dto.ProdutoDto;
import com.alertou.sboot_atom_produto.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto toEntity(ProdutoDto dto);

    ProdutoDto toDto(Produto entity);
}

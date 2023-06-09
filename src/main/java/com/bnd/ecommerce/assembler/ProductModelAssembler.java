package com.bnd.ecommerce.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.bnd.ecommerce.dto.ProductDto;
import com.bnd.ecommerce.restcontroller.ProductRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ProductModelAssembler
    implements RepresentationModelAssembler<ProductDto, EntityModel<ProductDto>> {
  @Override
  public EntityModel<ProductDto> toModel(ProductDto entity) {
    EntityModel<ProductDto> productEntityModel = EntityModel.of(entity);
    productEntityModel.add(
        linkTo(methodOn(ProductRestController.class).getOne(entity.getId())).withSelfRel());
    productEntityModel.add(
        linkTo(methodOn(ProductRestController.class).getProducts())
            .withRel(IanaLinkRelations.COLLECTION));
    return productEntityModel;
  }
}

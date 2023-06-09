package com.bnd.ecommerce.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.bnd.ecommerce.dto.api.ProductFilterDTO;
import com.bnd.ecommerce.restcontroller.ProductRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ProductRestAPIModelAssembler
    implements RepresentationModelAssembler<ProductFilterDTO, EntityModel<ProductFilterDTO>> {
  @Override
  public EntityModel<ProductFilterDTO> toModel(ProductFilterDTO entity) {
    EntityModel<ProductFilterDTO> productEntityModel = EntityModel.of(entity);
    productEntityModel.add(
        linkTo(methodOn(ProductRestController.class).getProducts())
            .withRel(IanaLinkRelations.COLLECTION)
            .withType("GET"));
    return productEntityModel;
  }
}

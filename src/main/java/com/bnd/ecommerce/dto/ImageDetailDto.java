package com.bnd.ecommerce.dto;

import com.bnd.ecommerce.entity.CreateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ImageDetailDto extends CreateTimestamp {

  private long id;

  private String url;

  private String name;

  private float size;

  private String description;

  @JsonIgnore
  private ProductDto productDto;

  private long productId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getSize() {
    return size;
  }

  public void setSize(float size) {
    this.size = size;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductDto getProductDto() {
    return productDto;
  }

  public void setProductDto(ProductDto productDto) {
    this.productDto = productDto;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }
}

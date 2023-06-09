package com.bnd.ecommerce.mapper;

import com.bnd.ecommerce.dto.*;
import com.bnd.ecommerce.entity.*;
import com.bnd.ecommerce.entity.customer.Customer;
import com.bnd.ecommerce.entity.customer.CustomerAddress;
import com.bnd.ecommerce.entity.employee.Employee;
import com.bnd.ecommerce.entity.stock.Stock;
import com.bnd.ecommerce.entity.stock.Warehouse;
import java.util.Set;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

  EmployeeUpdateDto employeeToEmployeePostDto(Employee employee);

  Employee employeeUpdateDtoToEmployee(EmployeeUpdateDto employeeUpdateDto);

  Employee employeeCreateDtoToEmployee(EmployeeCreateDto employeeCreateDto);

  Brand brandDtoToBrand(BrandDto brandDto);

  BrandDto brandToBrandDto(Brand brand);

  @InheritInverseConfiguration(name = "productDtoToProduct")
  ProductDto productToProductDto(Product product);

  Category categoryDtoToCategory(CategoryDto categoryDto);

  CategoryDto categoryToCategoryDto(Category category);

  @Mapping(source = "categoryDtoSet", target = "categorySet")
  @Mapping(source = "imageDetailDtoSet", target = "imageDetailSet")
  @Mapping(source = "brandDto", target = "brand")
  Product productDtoToProduct(ProductDto productDto);

  @InheritInverseConfiguration(name = "phoneDtoToPhone")
  PhoneDto phoneToPhoneDto(Phone phone);

  @InheritConfiguration(name = "productDtoToProduct")
  Phone phoneDtoToPhone(PhoneDto phoneDto);

// @Mapping(source = "productDto", target = "product")
  ImageDetail imageDetailDtoToImageDetail(ImageDetailDto imageDetailDto);

//  @Mapping(source = "product", target = "productDto")
  ImageDetailDto imageDetailToImageDetailDto(ImageDetail imageDetail);

  Stock stockDtoToStock(StockDto stockDto);

  StockDto stockToStockDto(Stock stock);

  Warehouse wareHouseDtoToWareHouse(WarehouseDto warehouseDto);

  WarehouseDto wareHouseToWareHouseDto(Warehouse warehouse);

  @InheritConfiguration(name = "productToProductDto")
  LaptopDto laptopToLaptopDto(Laptop laptop);

  @InheritInverseConfiguration(name = "laptopToLaptopDto")
  Laptop laptopDtoToLaptop(LaptopDto laptopDto);

  Tablet tabletDtoToTablet(TabletDto tabletDto);

  TabletDto tabletToTabletDto(Tablet tablet);


  @Mapping(source = "parentCategory", target = "parentCategoryDto")
  Set<Category> categoryDtoSetToCategorySet(Set<CategoryDto> categoryDtoSet);

  @InheritInverseConfiguration(name = "categoryDtoSetToCategorySet")
  Set<CategoryDto> categorySetToCategoryDtoSet(Set<Category> categorySet);

  @Mapping(source = "customerAddressDtoSet", target = "customerAddressSet")
  @Mapping(source = "genderEnum", target = "genderEnum")
  Customer customerDtoToCustomer(CustomerDto customerDto);

  @InheritInverseConfiguration(name = "customerDtoToCustomer")
  CustomerDto customerToCustomerDto(Customer customer);

//  @Mapping(source = "customerDto", target = "customer")
  CustomerAddress customerAddressDtoToCustomerAddress(CustomerAddressDto customerAddressDto);

//  @InheritInverseConfiguration(name = "customerAddressDtoToCustomerAddress")
  CustomerAddressDto customerAddressToCustomerAddressDto(CustomerAddress customerAddress);
}

package tin.dev.com.tss.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import tin.dev.com.tss.dto.request.CategoryCreationRequest;
import tin.dev.com.tss.dto.request.CategoryUpdateRequest;
import tin.dev.com.tss.dto.response.CategoryResponse;
import tin.dev.com.tss.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryCreationRequest request);

    CategoryResponse toCategoryResponse(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategory(@MappingTarget Category category, CategoryUpdateRequest request);
}

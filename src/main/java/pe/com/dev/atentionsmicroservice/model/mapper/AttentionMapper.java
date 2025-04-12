package pe.com.dev.atentionsmicroservice.model.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import pe.com.dev.atentionsmicroservice.model.domain.Attention;
import pe.com.dev.atentionsmicroservice.model.dto.AttentionDto;

@Mapper
public interface AttentionMapper {
    AttentionMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(AttentionMapper.class);
    AttentionDto toDto(Attention attention);
    Attention toEntity(AttentionDto attentionDto);

}

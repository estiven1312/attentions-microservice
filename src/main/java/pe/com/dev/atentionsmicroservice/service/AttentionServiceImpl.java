package pe.com.dev.atentionsmicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.com.dev.atentionsmicroservice.model.domain.Attention;
import pe.com.dev.atentionsmicroservice.model.dto.AttentionDto;
import pe.com.dev.atentionsmicroservice.model.filter.AttentionFilter;
import pe.com.dev.atentionsmicroservice.model.mapper.AttentionMapper;
import pe.com.dev.atentionsmicroservice.repository.AttentionRepository;

@Service
@RequiredArgsConstructor
public class AttentionServiceImpl implements AttentionService {
    private final AttentionRepository attentionRepository;
    @Override
    public Page<Attention> filterAttentions(AttentionFilter filter, Pageable pageable) {
        return attentionRepository.findByFilter(
                filter.getYear(),
                filter.getMonth(),
                filter.getRegion(),
                filter.getProvince(),
                filter.getDistrictUbigeo(),
                filter.getExecutingUnitCode(),
                filter.getIpressCode(),
                pageable
        );
    }

    @Override
    public AttentionDto findById(Long id) {
        Attention attention = attentionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attention not found"));
        return AttentionMapper.INSTANCE.toDto(attention);
    }

    @Override
    public Attention save(AttentionDto attention) {
        Attention attentionEntity = AttentionMapper.INSTANCE.toEntity(attention);
        attentionEntity = attentionRepository.save(attentionEntity);
        return attentionEntity;
    }
}

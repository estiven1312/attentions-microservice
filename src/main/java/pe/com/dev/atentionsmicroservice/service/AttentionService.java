package pe.com.dev.atentionsmicroservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.com.dev.atentionsmicroservice.model.domain.Attention;
import pe.com.dev.atentionsmicroservice.model.dto.AttentionDto;
import pe.com.dev.atentionsmicroservice.model.filter.AttentionFilter;

public interface AttentionService {
    Page<Attention> filterAttentions(AttentionFilter filter, Pageable pageable);
    AttentionDto findById(Long id);
    Attention save(AttentionDto attention);
}

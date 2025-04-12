package pe.com.dev.atentionsmicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pe.com.dev.atentionsmicroservice.model.domain.Attention;
import pe.com.dev.atentionsmicroservice.model.dto.AttentionDto;
import pe.com.dev.atentionsmicroservice.model.filter.AttentionFilter;
import pe.com.dev.atentionsmicroservice.service.AttentionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atentions")
public class AttentionController {
    private final AttentionService attentionService;
    @PostMapping("/create")
    public Attention createSummerSchool(@RequestBody AttentionDto summerSchool) {
        return attentionService.save(summerSchool);
    }

    @GetMapping("/{id}")
    public AttentionDto getSummerSchoolById(@PathVariable Long id) {
        return attentionService.findById(id);
    }

    @GetMapping("/api/v1/schools")
    public Page<Attention> getSummerSchools(
            @ModelAttribute AttentionFilter filter,
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return attentionService.filterAttentions(
                filter,
                pageable
        );
    }
}

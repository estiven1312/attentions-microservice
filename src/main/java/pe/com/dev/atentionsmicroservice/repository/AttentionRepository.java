package pe.com.dev.atentionsmicroservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.dev.atentionsmicroservice.model.domain.Attention;

public interface AttentionRepository extends JpaRepository<Attention, Long> {
    @Query("SELECT a FROM Attention a " +
            "WHERE (:year IS NULL OR a.year = :year) " +
            "AND (:month IS NULL OR a.month = :month) " +
            "AND (:region IS NULL OR a.region = :region) " +
            "AND (:province IS NULL OR a.province = :province) " +
            "AND (:districtUbigeo IS NULL OR a.districtUbigeo = :districtUbigeo) " +
            "AND (:executingUnitCode IS NULL OR a.executingUnitCode = :executingUnitCode) " +
            "AND (:ipressCode IS NULL OR a.ipressCode = :ipressCode)")
    Page<Attention> findByFilter(
            @Param("year") Integer year,
            @Param("month") Integer month,
            @Param("region") String region,
            @Param("province") String province,
            @Param("districtUbigeo") String districtUbigeo,
            @Param("executingUnitCode") Integer executingUnitCode,
            @Param("ipressCode") String ipressCode,
            Pageable pageable
    );
}

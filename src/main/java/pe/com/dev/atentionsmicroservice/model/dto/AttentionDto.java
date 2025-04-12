package pe.com.dev.atentionsmicroservice.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AttentionDto {
    private Long id;

    private Integer year;

    private Integer month;

    private String region;

    private String province;

    private String districtUbigeo;

    private String district;

    private Integer executingUnitCode;

    private String executingUnitDescription;

    private String ipressCode;

    private String ipress;

    private String healthFacilityLevel;

    private String insurancePlan;

    private String serviceCode;

    private String serviceDescription;

    private String gender;

    private String ageGroup;

    private Integer attentions;
}

package pe.com.dev.atentionsmicroservice.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "healthcare_attentions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;
    private Integer month;

    private String region;
    private String province;

    @Column(name = "district_ubigeo")
    private String districtUbigeo;

    private String district;

    @Column(name = "executing_unit_code")
    private Integer executingUnitCode;

    @Column(name = "executing_unit_description")
    private String executingUnitDescription;

    @Column(name = "ipress_code")
    private String ipressCode;

    private String ipress;

    @Column(name = "health_facility_level")
    private String healthFacilityLevel;

    @Column(name = "insurance_plan")
    private String insurancePlan;

    @Column(name = "service_code")
    private String serviceCode;

    @Column(name = "service_description")
    private String serviceDescription;

    private String gender;

    @Column(name = "age_group")
    private String ageGroup;

    private Integer attentions;
}

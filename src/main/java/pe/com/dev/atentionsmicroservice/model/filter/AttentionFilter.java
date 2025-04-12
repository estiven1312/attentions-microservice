package pe.com.dev.atentionsmicroservice.model.filter;

import lombok.Data;

@Data
public class AttentionFilter {
    private Integer year;

    private Integer month;

    private String region;

    private String province;

    private String districtUbigeo;

    private Integer executingUnitCode;

    private String ipressCode;
}

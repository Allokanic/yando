package dev.allokanic.yando.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.allokanic.yando.validation.annotation.IsISO8601;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ItemsImportRequest {

    @NotNull
    @JsonProperty(required = true)
    private List<@Valid ItemImport> items;

    @NotBlank
    @IsISO8601
    @JsonProperty(required = true)
    private String updateDate;
}

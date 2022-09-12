package dev.allokanic.yando.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.allokanic.yando.validation.annotation.IsISO8601;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class ItemsImportRequest {

    @NotNull
    @JsonProperty(required = true)
    private List<@Valid ItemImport> items;

    @NotBlank
    @IsISO8601
    @JsonProperty(required = true)
    private String updateDate;
}

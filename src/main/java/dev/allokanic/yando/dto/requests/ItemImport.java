package dev.allokanic.yando.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.allokanic.yando.dto.FileType;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ItemImport {
    @NotBlank
    @JsonProperty(required = true)
    private String id;
    @JsonProperty(required = true)
    private String url;
    @JsonProperty(required = true)
    private String parentId;
    @JsonProperty(required = true)
    private FileType type;
    @JsonProperty(required = true)
    @Min(0)
    private int size;
}

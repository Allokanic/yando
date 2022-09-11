package dev.allokanic.yando.entity;

import dev.allokanic.yando.dto.FileType;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "entries")
@Data
@Accessors(chain = true)
public class Entry {
    @Id
    private String id;
    private FileType type;
    private String url;
    private LocalDateTime time;
    @Column(name = "parent_id")
    private String parentId;
    private int size;
}

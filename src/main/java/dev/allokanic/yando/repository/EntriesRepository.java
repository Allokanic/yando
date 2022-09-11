package dev.allokanic.yando.repository;

import dev.allokanic.yando.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EntriesRepository extends JpaRepository<Entry, String> {

    List<Entry> findAllByParentId(String parentId);
    List<Entry> findAllByTimeBetween(LocalDateTime from, LocalDateTime to);
}

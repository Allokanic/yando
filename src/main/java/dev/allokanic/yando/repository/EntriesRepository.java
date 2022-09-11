package dev.allokanic.yando.repository;

import dev.allokanic.yando.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntriesRepository extends JpaRepository<Entry, String> {
}

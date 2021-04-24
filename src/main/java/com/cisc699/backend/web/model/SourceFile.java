package com.cisc699.backend.web.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("files")
public class SourceFile {
    @Id
    @Column("file_id")
    private Long id;

    @Column("file_name")
    private String name;

    @Column("file_type")
    private String type;

    @Column("created_at")
    private LocalDateTime timestamp;

    public SourceFile(String name, String type) {
        this.name = name;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }
}

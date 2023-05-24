package com.example.notes.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @SequenceGenerator(name = "notes_id_seq",
            sequenceName = "notes_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "notes_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Importance importance;
    private String text;

    private Timestamp timestamp;


}

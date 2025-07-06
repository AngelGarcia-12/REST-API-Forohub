CREATE TABLE IF NOT EXISTS cursos (
    id        BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre    VARCHAR(255)    NOT NULL,
    categoria ENUM('EDUCACION',
                   'TECNOLOGIA',
                   'SOLUCIONES',
                   'CULTURA',
                   'COLABORACION') NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS topicos (
    id              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    titulo          VARCHAR(255)    NOT NULL,
    mensaje         TEXT            NOT NULL,
    fecha_creacion  DATETIME        DEFAULT CURRENT_TIMESTAMP,   -- opcional
    status_topico   BOOLEAN, -- opcional
    autor           VARCHAR(255)    NOT NULL,
    curso_id        BIGINT UNSIGNED NOT NULL,

    PRIMARY KEY (id),

    INDEX idx_topicos_curso (curso_id),

    CONSTRAINT fk_topicos_curso
        FOREIGN KEY (curso_id)
        REFERENCES cursos(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;


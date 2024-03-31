package com.fan.jpa.dto;

import java.io.Serializable;

import com.fan.jpa.enums.Sex;

/**
 * DTO for {@link com.fan.jpa.entity.Author}
 */
public record AuthorDto(
        Long id,


        Sex sex
) implements Serializable {
}
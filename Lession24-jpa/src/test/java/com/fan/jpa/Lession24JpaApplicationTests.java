package com.fan.jpa;

import com.fan.jpa.dto.AuthorDto;
import com.fan.jpa.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.fan.jpa.convert.AuthorMapper;
import com.fan.jpa.rep.AuthorRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;

@SpringBootTest
class Lession24JpaApplicationTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;
    @Test
    @Transactional
    @Commit
    void contextLoads() {
//        Author entity = authorMapper.toEntity(new AuthorDto(null, Sex.WOMAN));
//        authorRepository.save(entity);

        Optional<Author> byId = authorRepository.findById(2L);
        Author author = byId.get();
        AuthorDto dto = authorMapper.toDto(author);
        System.out.println(dto);

    }

}

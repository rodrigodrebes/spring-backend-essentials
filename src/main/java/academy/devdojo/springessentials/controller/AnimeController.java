package academy.devdojo.springessentials.controller;

import academy.devdojo.springessentials.domain.Anime;
import academy.devdojo.springessentials.service.AnimeService;
import academy.devdojo.springessentials.util.DateUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

// classe que contém os endpoints
@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    //localhost:8080/anime/list
    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable long id){
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
        public ResponseEntity<Void> delete(@PathVariable long id){
            animeService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


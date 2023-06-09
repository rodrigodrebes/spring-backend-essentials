package academy.devdojo.springessentials.service;

import academy.devdojo.springessentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

// classe esponsável pelas regras/lógica de negócio
@Service
public class AnimeService {

    private List<Anime> animes = List.of(new Anime(1L,"Dragon Ball Z"), new Anime(2L,"One Piece"));

    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> Objects.equals(anime.getId(), id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

}
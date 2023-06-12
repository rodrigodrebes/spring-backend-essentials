package academy.devdojo.springessentials.service;

import academy.devdojo.springessentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

// classe esponsável pelas regras/lógica de negócio
@Service
public class AnimeService {

    private static List<Anime> animes;

    static {

        animes = new ArrayList<>(List.of(new Anime(1L, "Dragon Ball Z"), new Anime(2L, "One Piece")));

    }

    public static List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes.stream()
                .filter(anime -> Objects.equals(anime.getId(), id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 100000));
    animes.add(anime);
    return anime;
    }

    public void delete(long id) {
        animes.remove(findById(id));
    }

    public void replace(Anime anime) {
        delete(anime.getId());
        animes.add(anime);
    }
}
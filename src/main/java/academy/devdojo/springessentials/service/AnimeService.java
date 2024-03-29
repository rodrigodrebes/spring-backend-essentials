package academy.devdojo.springessentials.service;

import academy.devdojo.springessentials.domain.Anime;
import academy.devdojo.springessentials.mapper.AnimeMapper;
import academy.devdojo.springessentials.repository.AnimeRepository;
import academy.devdojo.springessentials.requests.AnimePostRequestBody;
import academy.devdojo.springessentials.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// classe esponsável pelas regras/lógica de negócio
@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findById(long id) {
        return animeRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));

    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {

     return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findById(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        findById(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                .id(animePutRequestBody.getId())
                .name(animePutRequestBody.getName()).build();
        animeRepository.save(anime);
    }
}
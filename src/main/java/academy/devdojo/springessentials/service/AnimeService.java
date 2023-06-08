package academy.devdojo.springessentials.service;

import academy.devdojo.springessentials.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

// classe esponsável pelas regras/lógica de negócio
@Service
public class AnimeService {
    public List<Anime> listAll() {
        return List.of(new Anime(1L, "Dragon Ball Z"), new Anime(2L, "One Piece"));
    }
}

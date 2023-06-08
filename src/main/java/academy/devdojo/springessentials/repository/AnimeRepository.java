package academy.devdojo.springessentials.repository;

import java.util.List;
import academy.devdojo.springessentials.domain.Anime;

// conexão com o banco de dados
public interface AnimeRepository {
 List<Anime> listAll();
}

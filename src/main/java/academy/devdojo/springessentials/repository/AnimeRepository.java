package academy.devdojo.springessentials.repository;

import java.util.List;

import academy.devdojo.springessentials.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

// conexão com o banco de dados
public interface AnimeRepository extends JpaRepository<Anime, Long> {
}

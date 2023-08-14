package academy.devdojo.springessentials.mapper;

import academy.devdojo.springessentials.domain.Anime;
import academy.devdojo.springessentials.requests.AnimePostRequestBody;
import academy.devdojo.springessentials.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}

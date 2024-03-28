package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the IPokemonMetadataProvider interface.
 * @see IPokemonMetadataProvider
 * list of pokemons metadata
 */

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    List<PokemonMetadata> pokemonsMetadata;

    /**
     * Default constructor.
     */
    public PokemonMetadataProvider() {
        pokemonsMetadata = new ArrayList<>();
        pokemonsMetadata.add(new PokemonMetadata(0, "Bulbasaur", 126, 126,
                90));
        //pickachu
        pokemonsMetadata.add(new PokemonMetadata(25, "Pikachu", 112, 101,
                70));

    }
    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <code>index</code>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <code>index</code> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index >= 151)
        {
            throw new PokedexException("Invalid index");
        }
        else
        {
            for (PokemonMetadata pokemonMetadata : pokemonsMetadata) {
                if (pokemonMetadata.getIndex() == index) {
                    return pokemonMetadata;
                }
            }
        }
        throw new PokedexException("PokemonMetaData not found");
    }
}
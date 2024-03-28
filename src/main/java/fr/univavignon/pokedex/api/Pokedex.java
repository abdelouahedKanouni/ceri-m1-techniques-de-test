package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of the IPokedex interface.
 * @see IPokedex
 */
public class Pokedex implements IPokedex{

    private final List<Pokemon> pokemonList = new ArrayList<>();

    private IPokemonMetadataProvider metadataProvider;

    private IPokemonFactory pokemonFactory;

    public Pokedex() {
    }

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return pokemonList.size();
    }

    /**
     * Add the given pokemon to this pokedex.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of the added pokemon.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return this.size();
    }

    /**
     * Returns the pokemon at the given index in this pokedex.
     * @param id Unique pokedex relative identifier.
     * @return
     * @throws PokedexException
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {

        Pokemon pokemon;
        try {
            pokemon = pokemonList.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("Invalid given index");
        }
        return pokemon;
    }

    /**
     * Returns the list of pokemons in this pokedex.
     *
     * @return List of pokemons in this pokedex.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemonList);
    }

    /**
     * Returns the list of pokemons in this pokedex sorted by the given comparator.
     *
     * @param order Comparator to use for sorting the pokemons.
     * @return List of pokemons in this pokedex sorted by the given comparator.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemonList = new ArrayList<>(pokemonList);
        sortedPokemonList.sort(order);
        return Collections.unmodifiableList(sortedPokemonList);
    }
    /**
     * Creates a pokemon instance.
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return new PokemonFactory().createPokemon(index,cp,hp,dust,candy);
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
        return new PokemonMetadataProvider().getPokemonMetadata(index);
    }
}
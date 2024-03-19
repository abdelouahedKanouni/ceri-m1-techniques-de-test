package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokedexTest {

    private IPokedex pokedex;
    private List<Pokemon> pokemonList;

    @Before
    public void setUp() throws PokedexException {
        pokedex = new Pokedex();
        pokemonList = new ArrayList<>();
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 4000, 4, 100);
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
    }

    @Test
    public void testSize() {
        for (Pokemon pokemon : pokemonList) {
            pokedex.addPokemon(pokemon);
        }
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(index, pokemon.getIndex());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        for (Pokemon pokemon : pokemonList) {
            pokedex.addPokemon(pokemon);
        }
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertNotNull(retrievedPokemon);
        assertEquals(0, retrievedPokemon.getIndex());
    }

    @Test
    public void testGetPokemons() {
        for (Pokemon pokemon : pokemonList) {
            pokedex.addPokemon(pokemon);
        }
        List<Pokemon> retrievedPokemons = pokedex.getPokemons();
        assertEquals(pokemonList, retrievedPokemons);
    }

    @Test
    public void testGetPokemonsWithComparator() {
        for (Pokemon pokemon : pokemonList) {
            pokedex.addPokemon(pokemon);
        }
        List<Pokemon> retrievedPokemons = pokedex.getPokemons(Comparator.comparingInt(PokemonMetadata::getIndex));
        assertEquals(pokemonList, retrievedPokemons);
    }
}

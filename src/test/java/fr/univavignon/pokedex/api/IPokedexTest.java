package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private IPokedex pokedex = Mockito.mock(IPokedex.class);
    List<Pokemon> PokemonList = new ArrayList<Pokemon>();

    @Before
    public void setUp() throws PokedexException {

        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 4000, 4, 100);
        PokemonList.add(pokemon1);
        PokemonList.add(pokemon2);
    }

    @Test
    public void testSize()  {
        when(pokedex.size()).thenAnswer(invocation -> PokemonList.size());
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon()  {
        // Création d'un Pokemon à ajouter au Pokedex
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

        // Ajout du Pokemon au Pokedex
        int index = pokedex.addPokemon(pokemon);

        // Vérification de l'index retourné
        assertEquals(index, pokemon.getIndex());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        try {
            when(pokedex.getPokemon(anyInt())).thenAnswer(new Answer<Pokemon>() {
                @Override
                public Pokemon answer(InvocationOnMock invocation) throws Throwable {
                    // Récupération de l'index passé en argument
                    Object[] args = invocation.getArguments();
                    int indexToFind = (int) args[0];
                    // Parcourir la liste des Pokémon pour trouver celui avec l'index spécifié
                    for (Pokemon pokemon : PokemonList) {
                        if (pokemon.getIndex() == indexToFind) {
                            return pokemon; // Retourner le Pokémon trouvé
                        }
                    }
                    return null; // Retourner null si aucun Pokémon n'est trouvé
                }
            });
            // Appel de la méthode getPokemon avec un index existant dans la liste des Pokémon
            Pokemon retrievedPokemon = pokedex.getPokemon(0);
            // Vérification si le Pokémon retourné correspond à celui attendu
            assertNotNull(retrievedPokemon);
            assertEquals(0, retrievedPokemon.getIndex());

        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPokemons() {
        when(pokedex.getPokemons()).thenAnswer(invocation -> PokemonList);
        assertEquals(PokemonList, pokedex.getPokemons());
    }

    @Test
    public void testGetPokemonsWithComparator() {
        when(pokedex.getPokemons(Mockito.any())).thenAnswer(invocation -> {
            List<Pokemon> pokemons = new ArrayList<>(PokemonList);
            pokemons.sort((Comparator<Pokemon>) invocation.getArguments()[0]);
            return pokemons;
        });
        List<Pokemon> pokemons = pokedex.getPokemons(Comparator.comparingInt(PokemonMetadata::getIndex));
        assertEquals(PokemonList, pokemons);
    }



}

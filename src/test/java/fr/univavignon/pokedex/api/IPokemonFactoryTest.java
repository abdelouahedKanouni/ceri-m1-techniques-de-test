package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // Créer un mock pour IPokemonFactory
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        // Index, CP, HP, Dust et Candy pour un Pokémon Bulbizarre
        int expectedIndex = 0;
        int expectedCp = 613;
        int expectedHp = 64;
        int expectedDust = 4000;
        int expectedCandy = 4;

        // Créer un Pokémon Bulbizarre simulé
        Pokemon expectedPokemon = new Pokemon(expectedIndex, "Bulbizarre", 45, 49, 49, expectedCp, expectedHp, expectedDust, expectedCandy, 0.56);

        // Configurer le mock pour retourner le Pokémon simulé
        when(pokemonFactory.createPokemon(expectedIndex, expectedCp, expectedHp, expectedDust, expectedCandy))
                .thenReturn(expectedPokemon);

        // Appel de la méthode à tester
        Pokemon actualPokemon = pokemonFactory.createPokemon(expectedIndex, expectedCp, expectedHp, expectedDust, expectedCandy);

        // Vérification du résultat
        assertNotNull(actualPokemon);
        assertEquals(expectedIndex, actualPokemon.getIndex());
        assertEquals(expectedCp, actualPokemon.getCp());
        assertEquals(expectedHp, actualPokemon.getHp());
        assertEquals(expectedDust, actualPokemon.getDust());
        assertEquals(expectedCandy, actualPokemon.getCandy());
    }
}
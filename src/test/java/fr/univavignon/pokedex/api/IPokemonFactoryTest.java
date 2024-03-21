package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        // Index, CP, HP, Dust et Candy pour un Pokémon Bulbizarre
        int expectedIndex = 0;
        int expectedCp = 613;
        int expectedHp = 64;
        int expectedDust = 4000;
        int expectedCandy = 4;

        // Créer un Pokémon Bulbizarre simulé
        PokemonFactory pokemonFactory = new PokemonFactory();
        Pokemon expectedPokemon = pokemonFactory.createPokemon(expectedIndex, expectedCp, expectedHp, expectedDust, expectedCandy);

        // Vérifier que le Pokemon est correctement créé
        assertNotNull(expectedPokemon);
        assertEquals(expectedIndex, expectedPokemon.getIndex());
        assertEquals(expectedCp, expectedPokemon.getCp());
        assertEquals(expectedHp, expectedPokemon.getHp());
        assertEquals(expectedDust, expectedPokemon.getDust());
        assertEquals(expectedCandy, expectedPokemon.getCandy());
        assertEquals(0, expectedPokemon.getIv(), 0); // Assurez-vous que l'IV est correct
    }
}

package fr.univavignon.pokedex.api;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IPokemonFactoryTest {

    private IPokemonFactory iPokemonFactory;


    public void setUp() {
        // Création d'un mock pour PokemonMetadataProvider
        this.iPokemonFactory = new PokemonFactory();
    }

    // Test la création d'un pokemon avec les bonnes valeurs
    @Test
    public void createPokemonTest() throws PokedexException {
        // Utilisation du mock dans la création du Pokemon
        Pokemon pokemon = this.iPokemonFactory.createPokemon(0, 613, 64,
                4000, 4);

        // Vérification des valeurs récupérées
        assertEquals(0, pokemon.getIndex());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());

    }
}
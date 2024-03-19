package fr.univavignon.pokedex.api;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider iPokemonMetadataProvider;


    public void setUp() {
        // Création d'une instance réelle de PokemonMetadataProviderImpl
        this.iPokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void getPokemonMetadataBulbasaurTest() throws PokedexException {
        // Vérification des informations récupérées pour Bulbizarre
        PokemonMetadata pokemonMetadata = this.iPokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbasaur", pokemonMetadata.getName());
        assertEquals(126, pokemonMetadata.getAttack());
        assertEquals(126, pokemonMetadata.getDefense());
        assertEquals(90, pokemonMetadata.getStamina());
    }

    @Test
    public void getPokemonMetadataPikachuTest() throws PokedexException {
        PokemonMetadata pokemonMetadata = this.iPokemonMetadataProvider.getPokemonMetadata(25);
        assertEquals("Pikachu", pokemonMetadata.getName());
        assertEquals(112, pokemonMetadata.getAttack());
        assertEquals(101, pokemonMetadata.getDefense());
        assertEquals(70, pokemonMetadata.getStamina());
    }

}
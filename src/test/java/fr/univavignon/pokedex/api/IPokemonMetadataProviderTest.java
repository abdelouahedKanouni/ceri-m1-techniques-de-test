package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokemonMetadataProviderTest {

    private PokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadata_ValidIndex() throws PokedexException {
        // Index d'un Pokémon existant dans la liste
        int index = 25; // Pikachu
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

        // Vérifier si les métadonnées retournées sont correctes
        assertNotNull(metadata);
        assertEquals(index, metadata.getIndex());
        assertEquals("Pikachu", metadata.getName());
        assertEquals(112, metadata.getAttack());
        assertEquals(101, metadata.getDefense());
        assertEquals(70, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadata_InvalidIndex() throws PokedexException {
        // Index invalide
        int invalidIndex = 151;
        metadataProvider.getPokemonMetadata(invalidIndex); // Cela devrait lancer une exception
    }
}

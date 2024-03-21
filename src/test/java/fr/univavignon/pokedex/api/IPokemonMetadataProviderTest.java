package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() throws PokedexException {
        // Création d'un mock pour l'objet cible
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        // Configuration du comportement du mock pour retourner les métadonnées de Bulbizarre
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0))
                .thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {

        // Appel de la méthode à tester pour obtenir les métadonnées de Bulbizarre
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);

        // Vérification du résultat
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }
}
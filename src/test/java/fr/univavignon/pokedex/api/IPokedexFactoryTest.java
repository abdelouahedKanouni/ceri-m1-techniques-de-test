package fr.univavignon.pokedex.api;

import org.junit.*;
import org.mockito.Mockito;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp(){

        this.pokedexFactory = new PokedexFactory();

    }

    @Test
    public void CreatePokedexTest(){

        IPokemonMetadataProvider pokemonMetadataProvider= Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        Assert.assertNotNull(pokedex);
    }
}
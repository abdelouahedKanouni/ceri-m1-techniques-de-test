package fr.univavignon.pokedex.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider pokemonMetadataProvider= Mockito.mock(IPokemonMetadataProvider.class);
    IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

    public void setUp(){
        this.pokedexFactory = new PokedexFactory();

    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }

}
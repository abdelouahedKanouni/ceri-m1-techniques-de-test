package fr.univavignon.pokedex.api;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonTrainerFactoryTest {


    IPokemonTrainerFactory pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    IPokedex pokedex = mock(IPokedex.class);
    Pokemon pokemon =new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

    @Before
    public void init() {

        when(pokemonTrainerFactory.createTrainer(
                anyString(), any(), any()
        )).thenAnswer(new Answer<PokemonTrainer>() {
            public PokemonTrainer answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                String name = (String) args[0];
                Team team = (Team) args[1];
                when(pokedex.size()).thenReturn(0);
                return new PokemonTrainer(name, team, pokedex);
            }
        });
    }


    @Test
    public void creationPokemonTrainerTest() throws PokedexException {

        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("ABDELOUAHED", Team.MYSTIC, pokedexFactory);
        pokemonTrainer.getPokedex().addPokemon(pokemon);
        assertEquals("ABDELOUAHED", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertNotNull(pokemonTrainer.getPokedex());
        assertEquals(0, pokemonTrainer.getPokedex().size());
    }
}
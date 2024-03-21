package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class IPokemonTrainerFactoryTest {

    private PokemonTrainerFactory trainerFactory;

    @Before
    public void setUp() {
        trainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        // Configuration des mocks pour les dépendances
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);

        // Configuration des dépendances dans la factory
        trainerFactory.setMetadataProvider(metadataProvider);
        trainerFactory.setPokemonFactory(pokemonFactory);

        // Création d'un trainer avec la factory
        String name = "Ash";
        Team team = Team.MYSTIC;
        PokemonTrainer trainer = trainerFactory.createTrainer(name, team, pokedexFactory);

        // Vérification si le trainer est correctement créé
        assertNotNull(trainer);
        assertEquals(name, trainer.getName());
        assertEquals(team, trainer.getTeam());
    }
}

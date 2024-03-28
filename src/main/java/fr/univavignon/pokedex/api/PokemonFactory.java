package fr.univavignon.pokedex.api;

/**
 * Implementation of the IPokemonFactory interface.
 * create a half created Pokemon object.
 * @see IPokemonFactory
 */
public class PokemonFactory implements IPokemonFactory{

    /**
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        //on commence a créer le pokemon, puis en continue dans PokedexImplement
        return new Pokemon(index, "", 0, 0, 0, cp,
                hp, dust,candy ,0);
    }
}
package me.nickimpact.gts.reforged.text;

import com.google.common.collect.Maps;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import me.nickimpact.gts.api.listings.Listing;
import me.nickimpact.gts.reforged.entries.EnumPokemonFields;
import me.nickimpact.gts.reforged.entries.ReforgedEntry;
import me.nickimpact.gts.sponge.Translator;
import me.nickimpact.gts.sponge.text.TokenHolder;
import org.spongepowered.api.text.Text;

import java.util.Map;
import java.util.Optional;

public class PokemonTokens implements TokenHolder {
	private static Map<String, Translator> tokens = Maps.newHashMap();

	static {
		tokens.put("pokemon", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.NAME)));
		tokens.put("nickname", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.NICKNAME)));
		tokens.put("ability", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.ABILITY)));
		tokens.put("gender", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.GENDER)));
		tokens.put("nature", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.NATURE)));
		tokens.put("growth", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.GROWTH)));
		tokens.put("level", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.LEVEL)));
		tokens.put("evs_percent", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_PERCENT)));
		tokens.put("evs_total", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_TOTAL)));
		tokens.put("evhp", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_HP)));
		tokens.put("evatk", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_ATK)));
		tokens.put("evdef", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_DEF)));
		tokens.put("evspatk", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_SPATK)));
		tokens.put("evspdef", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_SPDEF)));
		tokens.put("evspeed", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.EV_SPEED)));
		tokens.put("ivs_percent", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_PERCENT)));
		tokens.put("ivs_total", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_TOTAL)));
		tokens.put("ivhp", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_HP)));
		tokens.put("ivatk", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_ATK)));
		tokens.put("ivdef", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_DEF)));
		tokens.put("ivspatk", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_SPATK)));
		tokens.put("ivspdef", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_SPDEF)));
		tokens.put("ivspeed", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.IV_SPEED)));
		tokens.put("form", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.FORM)));
		tokens.put("shiny", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.SHINY)));
		tokens.put("shiny_state", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.SHINY_STATE)));
		tokens.put("texture", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.TEXTURE)));
		tokens.put("special_texture", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.SPECIAL_TEXTURE)));
		tokens.put("clones", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.CLONES)));
		tokens.put("clones_remaining", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.CLONES_REMAINING)));
		tokens.put("enchanted", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.ENCHANTED)));
		tokens.put("hidden_power", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.HIDDEN_POWER)));
		tokens.put("moves_1", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.MOVES_1)));
		tokens.put("moves_2", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.MOVES_2)));
		tokens.put("moves_3", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.MOVES_3)));
		tokens.put("moves_4", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.MOVES_4)));
		tokens.put("ivs_stat", (p, v, m) -> {
			if (getPokemonFromVariableIfExists(m) != null) {
				return Optional.of(Text.of("IV"));
			}

			return Optional.empty();
		});
		tokens.put("evs_stat", (p, v, m) -> {
			if (getPokemonFromVariableIfExists(m) != null) {
				return Optional.of(Text.of("EV"));
			}

			return Optional.empty();
		});
		tokens.put("pokerus", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.POKERUS)));
		tokens.put("pokerus_state", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.POKERUS_STATE)));
		tokens.put("unbreedable", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.UNBREEDABLE)));
		tokens.put("pokeball_name", (p, v, m) -> Optional.of(getPokemonInfo(getPokemonFromVariableIfExists(m), EnumPokemonFields.POKE_BALL_NAME)));
	}

	public Map<String, Translator> getTokens() {
		return tokens;
	}

	private static Pokemon getPokemonFromVariableIfExists(Map<String, Object> m) {
		Optional<Object> optPoke = m.values().stream().filter(val -> val instanceof Listing || val instanceof Pokemon).findAny();
		if (optPoke.isPresent()) {
			if(optPoke.get() instanceof Listing) {
				if(((Listing) optPoke.get()).getEntry() instanceof ReforgedEntry) {
					return (((ReforgedEntry) ((Listing) optPoke.get()).getEntry())).getEntry();
				}
			} else {
				return (Pokemon) optPoke.get();
			}
		}

		return null;
	}

	private static Text getPokemonInfo(Pokemon pokemon, EnumPokemonFields field) {
		if (pokemon != null) {
			return Text.of(field.function.apply(pokemon));
		}
		return Text.EMPTY;
	}
}

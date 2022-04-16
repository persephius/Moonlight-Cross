package moonlight_cross.battle;

public abstract class Item {
	protected String name;
	protected String description;
	protected String function;
	protected String type;

	protected double effect_amount;
	
	public String get_name() {
		return name;
	}
	public String get_description() {
		return description;
	}
	public String get_function(){
		return function;
	}
	public String get_type(){
		return type;
	}
	
	public void set_name(String new_name) {
		name = new_name;
	}
	public void set_description(String new_description) {
		description = new_description;
	}
	public void set_function(String new_function){
		function = new_function;
	}
	public void set_type(String new_type){
		type = new_type;
	}
}

// Item types

// For potions, maybe if you set the amount to negative, they'll
// turn into damage items! ... Maybe.
abstract class HealingItem extends Item {
	public void heal(BattleEntity target) {
		target.HP += effect_amount;
		System.out.println(target.NAME + " was healed by [" + effect_amount + "]!");
	}
}

// For setting buffs
abstract class BuffingItem extends Item {
	// The duration is set to a minimum of zero, being the current turn.
	int duration = 0;
	public void buff(BattleEntity target, Double mod, String stat) {
		target.setMod(stat, mod, duration);
	}
}

// ITEMS BELOW
/*
* Note to self:
* I'll turn all the classes into interfaces later on, so
* it's less dependant on inheritance and follows a more
* composition based design.
*/
class Potion extends HealingItem {
	public Potion () {
		name = "Potion";
		description = "A simple potion";
		function = "Heals a small amount of HP.";
		type = "Healing";
		effect_amount = 15;
	}
}

class Elixir extends HealingItem {
	public Elixir () {
		name = "Elixir of Vitality";
		description = "A golden colored liquid, surely it's not...?";
		function = "Heals a moderate amount of HP";
		type = "Healing";
		effect_amount = 30;
	}
}

class StrengthPotion extends BuffingItem {
	public StrengthPotion () {
		name = "Fortifier";
		description = "A concoction made for temporarily increasing your strength, it won't give you muscles though.";
		function = "Increases ATK attribute for [" + duration + "] turns.";
		type = "Utility";
		effect_amount = 30;
		duration = 2;
	}
}
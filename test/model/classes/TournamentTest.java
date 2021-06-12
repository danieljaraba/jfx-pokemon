package model.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentTest {
    private Tournament tournament;
    private PokemonTrainer trainer;

    public void setUpScenary1(){
        Pokedex x = new Pokedex("x",99999);
        Bag firstOponentBag = new Bag("x",22,22,x);
        Attack[] squirtleAttack = new Attack[4];
        squirtleAttack[0] = new Attack("Water pulse",60,30,20);
        squirtleAttack[1] = new Attack("Bubble",20,10,30);
        Pokeball first = new Pokeball("",88,new WaterPokemon("img/pokemon/pokemon_sprites/Squirtle.gif_.gif","Squirtle",150,1,166.9,89.5,false,"water",squirtleAttack,true));
        firstOponentBag.getUsedPokeballs().add(first);
        trainer = new PokemonTrainer(0.0,0.0,"MisterTrainer",firstOponentBag,"img/character/trainers_Battle/trainer5.png","blue");
        trainer.getGymMedals().add("");
        tournament = new Tournament(trainer);
    }

    public void setUpScenary2(){
        Pokedex x = new Pokedex("x",99999);
        Bag firstOponentBag = new Bag("x",22,22,x);
        Attack[] squirtleAttack = new Attack[4];
        squirtleAttack[0] = new Attack("Water pulse",60,30,20);
        squirtleAttack[1] = new Attack("Bubble",20,10,30);
        Pokeball first = new Pokeball("",88,new WaterPokemon("img/pokemon/pokemon_sprites/Squirtle.gif_.gif","Squirtle",150,1,166.9,89.5,false,"water",squirtleAttack,true));
        firstOponentBag.getUsedPokeballs().add(first);
        trainer = new PokemonTrainer(0.0,0.0,"MisterTrainer",firstOponentBag,"img/character/trainers_Battle/trainer5.png","blue");
        trainer.getGymMedals().add("");
        tournament = new Tournament(trainer);
        tournament.getRootTrainer().setRigthTrainer(trainer);
    }

    @Test
     public void addChampion() {
        setUpScenary1();
        tournament.addChampion(trainer);
        PokemonTrainer result;
        if(tournament.getRootTrainer().getLeftTrainer()!=null){
              result = tournament.getRootTrainer().getLeftTrainer();
        }else {
            result = tournament.getRootTrainer().getRigthTrainer();
        }
        assertNotNull(result);

      }


    @Test
     public void getNextOponet() {
        setUpScenary2();
       PokemonTrainer test = tournament.getNextOponet(tournament.getRootTrainer());
       assertNotNull(test);

    }
}
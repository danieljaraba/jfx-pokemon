package model.classes;

import java.io.Serializable;

import exception.IsWinnerException;
import model.abstractClasses.Pokemon;
import model.interfaces.Autoplaying;
import thread.PokemonBattleThread;


/**
 * The type Tournament.
 */
public class Tournament implements Autoplaying , Serializable {

    private PokemonTrainer rootTrainer;
    private PokemonBattle currentBattle;
    private PokemonBattle oponetBattle;
    private PokemonTrainer newParticipant;



    public Tournament(PokemonTrainer newParticpant) {
        this.newParticipant = newParticpant;
        Pokedex x = new Pokedex("x",99999);
        Bag firstOponentBag = new Bag("x",22,22,x);
        Attack[] squirtleAttack = new Attack[4];
        squirtleAttack[0] = new Attack("Water pulse",60,30,20);
        squirtleAttack[1] = new Attack("Bubble",20,10,30);
        Pokeball first = new Pokeball("",88,new WaterPokemon("img/pokemon/pokemon_sprites/Squirtle.gif_.gif","Squirtle",150,1,166.9,89.5,false,"water",squirtleAttack,true));
        firstOponentBag.getUsedPokeballs().add(first);
        rootTrainer = new PokemonTrainer(0.0,0.0,"MisterTrainer",firstOponentBag,"img/character/trainers_Battle/trainer5.png","blue");
    }


    public PokemonTrainer getRootTrainer() {
        return rootTrainer;
    }

    public void addChampion(PokemonTrainer winner){
        if (rootTrainer==null){
            rootTrainer = winner;
        }else {
            addChampion(rootTrainer,winner);
        }
    }

    private void addChampion(PokemonTrainer rootTrainer, PokemonTrainer winner){
        if (winner.getGymMedals().size()<=rootTrainer.getGymMedals().size()){
            if(winner.getLeftTrainer()==null){
               rootTrainer.setLeftTrainer(winner);
              winner.setParentTrainer(rootTrainer);
            }else {
                addChampion(rootTrainer.getLeftTrainer(),winner);
            }
        }else {
            if(winner.getRigthTrainer()==null){
                rootTrainer.setRigthTrainer(winner);
                winner.setParentTrainer(rootTrainer);
            }else {
                addChampion(rootTrainer.getRigthTrainer(),winner);
            }

        }

    }

   public void startTournament(PokemonTrainer posibleOponet, Pokemon userElection) throws IsWinnerException {
        if(posibleOponet.isClashWon()){
            throw new IsWinnerException();
        }else {
            currentBattle = new PokemonBattle(userElection,posibleOponet);
            oponetBattle = new PokemonBattle(currentBattle.getAttacker(),currentBattle.getUser());
        }

   }

   public void figth(PokemonBattle currentBattle, boolean lose, int attack){
        if(!lose){
            currentBattle.userAttack(attack);
            iaTrainner(oponetBattle);
        }

   }



    public PokemonTrainer getNextOponet(PokemonTrainer from){
       if (from!=null){
           if(from.getLeftTrainer()!=null){
               return from.getLeftTrainer();
           }else if(from.getRigthTrainer()!=null){
               return from.getRigthTrainer();
           }else {
               return null;
           }
       }else {
           return null;
       }
    }

    public PokemonBattle getOponetBattle() {
        return oponetBattle;
    }

    public void setOponetBattle(PokemonBattle oponetBattle) {
        this.oponetBattle = oponetBattle;
    }

    @Override
    public void iaTrainner(PokemonBattle iaBattle) {
        PokemonBattleThread pbtTourNament = new PokemonBattleThread(iaBattle);
        pbtTourNament.start();
    }
}

package thread;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import model.classes.PokemonBattle;
import ui.classes.MasterGUI;

public class PokemonBattleThread extends Thread{
    private PokemonBattle pokemonBattle;
    private  double atkHealth;
    private double defHealth;
    private String attack;
    private MasterGUI masterGUI;
    public PokemonBattleThread(PokemonBattle pokemonBattle, MasterGUI masterGUI, double atkHealth , double defHealth) {
        this.pokemonBattle = pokemonBattle;
        attack = "usted es un marcica";
        this.masterGUI = masterGUI;
        this.atkHealth = atkHealth;
        this.defHealth = defHealth;
    }

    public PokemonBattleThread(PokemonBattle pokemonBattle){
        this.pokemonBattle = pokemonBattle;
        atkHealth = pokemonBattle.getAtkHealth();
        defHealth = pokemonBattle.getDefHealth();
    }




    public void run(){
        Platform.runLater(new Thread(() -> {
            pokemonBattle.setDefHealth(defHealth);
            pokemonBattle.setAtkHealth(atkHealth);
            int ramdomAttack = (int) (Math.random()*2)+1;
            pokemonBattle.userAttack(ramdomAttack);
            masterGUI.updateGui(pokemonBattle.getUser().getPokemonAttacks()[ramdomAttack-1].getName(),pokemonBattle.getDefHealth(),pokemonBattle.getAtkHealth());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("An attack !");
            alert.setHeaderText(null);
            alert.setContentText(pokemonBattle.getUser().getName()+" uses: "+pokemonBattle.getUser().getPokemonAttacks()[ramdomAttack-1].getName());
            alert.showAndWait();


        }));

    }

    public double getAtkHealth() {
        return pokemonBattle.getAtkHealth();
    }

    public void setAtkHealth(double atkHealth) {
        this.atkHealth = atkHealth;
    }

    public double getDefHealth() {
        return pokemonBattle.getDefHealth();
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public void setDefHealth(double defHealth) {
        this.defHealth = defHealth;
    }
}

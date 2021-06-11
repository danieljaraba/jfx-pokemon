package model.classes;
import java.io.*;

public class Game implements Serializable{



    //Para archivo de texto plano SOLO PARA POKEMONS
    public static final String PATH_FIRE_POKEMON_TXT = "data/plainTextFiles/pokemonsData/FIRE.txt";
    public static final String PATH_WATER_POKEMON_TXT = "data/plainTextFiles/pokemonsData/WATER.txt";
    public static final String PATH_PLANT_POKEMON_TXT = "data/plainTextFiles/pokemonsData/PLANT.txt";
    public static final String PATH_ELECTRIC_POKEMON_TXT = "data/plainTextFiles/pokemonsData/ELECTRIC.txt";
    public static final String PATH_PSIQUIC_POKEMON_TXT = "data/plainTextFiles/pokemonsData/PSIQUIC.txt";
    public static final String PATH_ROCK_POKEMON_TXT = "data/plainTextFiles/pokemonsData/ROCK.txt";

    //Para archivos serializables
    private static final String PATH_GAME ="data/serializableFiles/games_saved" ;
    private static final String FILE_EXTENSION = ".poke";
    private PokemonTrainer currentTrainer;
    private Village currentVillage;
    private Game next;


    public Game(){

    }

    public void saveGame(String gameName) throws IOException {
        //se supone que crea un archivo de este tipo: partidaDeJaraba.poke
        File savedGameFile = new File(PATH_GAME+"/"+gameName+FILE_EXTENSION);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedGameFile));
        oos.writeObject(this);
        oos.close();
    }

    //file chooser no mamen ya estoy muy viejo para pensar otra cosa
    public Game loadPreviousGame(String fileName) throws IOException, ClassNotFoundException {
        File f = new File(fileName);
        Game lastGame = null;
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
             lastGame = (Game) ois.readObject();
             ois.close();
        }
        return lastGame;
    }



    public PokemonTrainer getCurrentTrainer() {
        return currentTrainer;
    }

    public void setCurrentTrainer(PokemonTrainer currentTrainer) {
        this.currentTrainer = currentTrainer;
    }



    public Village getCurrentVillage() {
        return currentVillage;
    }

    public void setCurrentVillage(Village currentVillage) {
        this.currentVillage = currentVillage;
    }

    public Game getNext() {
        return next;
    }

    public void setNext(Game next) {
        this.next = next;
    }
}

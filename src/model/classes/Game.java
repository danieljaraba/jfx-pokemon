package model.classes;
import java.io.*;

/**
 * The type Game.
 */
public class Game implements Serializable{
    private  static final long serialVersionUID = 2;

    /**
     * The constant PATH_FIRE_POKEMON_TXT.
     */
//Para archivo de texto plano SOLO PARA POKEMONS
    public static final String PATH_FIRE_POKEMON_TXT = "data/plainTextFiles/pokemonsData/FIRE.txt";
    /**
     * The constant PATH_WATER_POKEMON_TXT.
     */
    public static final String PATH_WATER_POKEMON_TXT = "data/plainTextFiles/pokemonsData/WATER.txt";
    /**
     * The constant PATH_PLANT_POKEMON_TXT.
     */
    public static final String PATH_PLANT_POKEMON_TXT = "data/plainTextFiles/pokemonsData/PLANT.txt";
    /**
     * The constant PATH_ELECTRIC_POKEMON_TXT.
     */
    public static final String PATH_ELECTRIC_POKEMON_TXT = "data/plainTextFiles/pokemonsData/ELECTRIC.txt";
    /**
     * The constant PATH_PSIQUIC_POKEMON_TXT.
     */
    public static final String PATH_PSIQUIC_POKEMON_TXT = "data/plainTextFiles/pokemonsData/PSIQUIC.txt";
    /**
     * The constant PATH_ROCK_POKEMON_TXT.
     */
    public static final String PATH_ROCK_POKEMON_TXT = "data/plainTextFiles/pokemonsData/ROCK.txt";

    //Para archivos serializables
    private static final String PATH_GAME ="data/serializableFiles/games_saved" ;
    private static final String FILE_EXTENSION = ".poke";
    private PokemonTrainer currentTrainer;
    private Village currentVillage;
    private Tournament localTournaMent;


    /**
     * Instantiates a new Game.
     */
    public Game(){

    }

    /**
     * Save game.
     *
     * @param gameName the game name
     * @throws IOException the io exception
     */
    public void saveGame(String gameName) throws IOException {
        //se supone que crea un archivo de este tipo: partidaDeJaraba.poke
        File savedGameFile = new File(PATH_GAME+"/"+gameName+FILE_EXTENSION);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedGameFile));
        oos.writeObject(this);
        oos.close();
    }

    /**
     * Load previous game game.
     *
     * @param fileName the file name
     * @return the game
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     */
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


    /**
     * Gets current trainer.
     *
     * @return the current trainer
     */
    public PokemonTrainer getCurrentTrainer() {
        return currentTrainer;
    }

    /**
     * Sets current trainer.
     *
     * @param currentTrainer the current trainer
     */
    public void setCurrentTrainer(PokemonTrainer currentTrainer) {
        this.currentTrainer = currentTrainer;
    }


    /**
     * Gets current village.
     *
     * @return the current village
     */
    public Village getCurrentVillage() {
        return currentVillage;
    }

    /**
     * Sets current village.
     *
     * @param currentVillage the current village
     */
    public void setCurrentVillage(Village currentVillage) {
        this.currentVillage = currentVillage;
    }

    public Tournament getLocalTournaMent() {
        return localTournaMent;
    }

    public void setLocalTournaMent(Tournament localTournaMent) {
        this.localTournaMent = localTournaMent;
    }
}

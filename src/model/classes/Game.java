package model.classes;
import java.io.*;



/**
 * The type Game.
 * Esta clase quedaria mejor como clase principal del modelo en lugar de village ¿?
 * Esta clase la uso para cargar y guardar los archivos
 * La idea es repartir responsabilidades en esta clase para que no quede  todas las cosas en la clase gui
 */
public class Game implements Serializable{



    //Para archivo de texto plano SOLO PARA POKEMONS SALVAJES
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
    public boolean loadPreviousGame(String fileName) throws IOException, ClassNotFoundException {
        File f = new File(fileName);
        boolean loaded = false;
        if(f.exists()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            currentTrainer = (PokemonTrainer) ois.readObject();
            currentVillage = (Village)ois.readObject();
            ois.close();
            loaded = true;
        }
        return loaded;
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
}

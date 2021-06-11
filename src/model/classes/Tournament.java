package model.classes;

import java.io.Serializable;
import java.util.ArrayList;

import model.interfaces.Autoplaying;
import thread.PokemonTrainnerThread;

public class Tournament implements Autoplaying , Serializable {

    private ArrayList<PokemonTrainer> participants;
    private PokemonTrainnerThread thread;
    private PokemonTrainer rootTrainer;

    public Tournament(ArrayList<PokemonTrainer> participants, PokemonTrainnerThread thread) {
        this.participants = participants;
        this.thread = thread;
    }

    public ArrayList<PokemonTrainer> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<PokemonTrainer> participants) {
        this.participants = participants;
    }

    public PokemonTrainnerThread getThread() {
        return thread;
    }

    public PokemonTrainer getRootTrainer() {
        return rootTrainer;
    }

    public void setRootTrainer(PokemonTrainer rootTrainer) {
        this.rootTrainer = rootTrainer;
    }
}

package model.classes;

import java.io.Serializable;
import java.util.ArrayList;

import model.interfaces.Autoplaying;
import thread.PokemonTrainnerThread;

/**
 * The type Tournament.
 */
public class Tournament implements Autoplaying , Serializable {

    private ArrayList<PokemonTrainer> participants;
    private PokemonTrainnerThread thread;
    private PokemonTrainer rootTrainer;

    /**
     * Instantiates a new Tournament.
     *
     * @param participants the participants
     * @param thread       the thread
     */
    public Tournament(ArrayList<PokemonTrainer> participants, PokemonTrainnerThread thread) {
        this.participants = participants;
        this.thread = thread;
    }

    /**
     * Gets participants.
     *
     * @return the participants
     */
    public ArrayList<PokemonTrainer> getParticipants() {
        return participants;
    }

    /**
     * Sets participants.
     *
     * @param participants the participants
     */
    public void setParticipants(ArrayList<PokemonTrainer> participants) {
        this.participants = participants;
    }

    /**
     * Gets thread.
     *
     * @return the thread
     */
    public PokemonTrainnerThread getThread() {
        return thread;
    }

    public PokemonTrainer getRootTrainer() {
        return rootTrainer;
    }

    public void setRootTrainer(PokemonTrainer rootTrainer) {
        this.rootTrainer = rootTrainer;

    }
    /**
     * Sets thread.
     *
     * @param thread the thread
     */
    public void setThread(PokemonTrainnerThread thread) {
        this.thread = thread;
    }


    @Override
    public void iaPokemon(PokemonBattle pokemon) {

    }

    @Override
    public void iaTrainner(PokemonTrainer trainer) {

    }
}

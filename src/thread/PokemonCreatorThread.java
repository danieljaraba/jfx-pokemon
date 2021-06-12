package thread;

import model.classes.*;

import java.util.ArrayList;

/**
 * The type Pokemon creator thread. <br>
 * Pokemons <br>
 *
 * Pokemons de fuego:<br>
 * "img/pokemon/pokemon_sprites/Charizard.gif_.gif" charizad Index = 0 <br>
 * "img/pokemon/pokemon_sprites/59.gif_.gif" Arcanie  Index = 1 <br>
 *
 * Pokemons Tipo Agua:<br>
 * "img/pokemon/pokemon_sprites/Blastoise.gif_.gif" Blastoide  Index = 2 <br>
 * "img/pokemon/pokemon_sprites/Squirtle.gif_.gif" Squirt    Index = 3 <br>
 *
 * Pokemons Tipo Planta:<br>
 * "img/pokemon/pokemon_sprites/Venusaur.gif_.gif" Venasur Index = 4 <br>
 * "img/pokemon/pokemon_sprites/Grovyle.gif_.gif" grovyle Index = 5 <br>
 *
 * Pokemons tipo roca: <br>
 * "img/pokemon/pokemon_sprites/Onix.gif_.gif" Onix  Index = 6 <br>
 * "img/pokemon/pokemon_sprites/Geodude.gif_.gif" Geodude Index = 7 <br>
 *
 * Pokemons tipo electrico: <br>
 * "img/pokemon/pokemon_sprites/Pikachu.gif_.gif" Pikachu Index = 8 <br>
 * "img/pokemon/pokemon_sprites/Zapdos.gif_.gif" Zapdos   Index = 9 <br>
 *
 * Pokemons tipo mental: <br>
 * "img/pokemon/pokemon_sprites/Psyduck.gif_.gif" Pysduck Index = 10 <br>
 * "img/pokemon/pokemon_sprites/Mewtwo.gif_.gif" Mewtwo  Index = 11 <br>
 */
public class PokemonCreatorThread extends Thread{

    private int maxFire;
    private int maxWater;
    private int maxRock;
    private int maxPlant;
    private int maxElectric;
    private int maxPsiquic;
    private Village [] villages;
    private ArrayList<String> imgs;

    public PokemonCreatorThread(Village [] villages) {
        this.villages = villages;
        this.maxElectric = 2;
        this.maxFire = 2;
        this.maxWater = 2;
        this.maxPlant = 2;
        this.maxRock = 2;
        this.maxPsiquic = 2;
        imgs = new ArrayList<>();

    }

    //de momento los pokemons salvajes se tienen dos ataques
    public void run(){
        int wasHere = 0;
        setImages();
            for (Village village : villages) {
                for (int j = 0; j < village.getLocalPokemons().length; j++) {
                    if(village.getLocalPokemons()[j]==null){
                        if (maxFire!=0){
                            if (wasHere==0){
                                Attack[] charizadAttak = new Attack[4];
                                charizadAttak[0] = new Attack("Dragon Rage",40,20,10);
                                charizadAttak[1] = new Attack("Fire spin",35,18,15);
                                village.getLocalPokemons()[j] = new FirePokemon(imgs.get(0),"Charizad",300,1,142.5,99,false,"fire",charizadAttak);
                                wasHere = 1;
                                maxFire-=1;
                                System.out.println("Se ha creado un pokemon tipo: "+ village.getLocalPokemons()[j].getType()+" en el pueblo: "+village.getName());

                            }else{
                                Attack [] arcanineAttaks = new Attack[4];
                                arcanineAttaks[0] = new Attack("Bite",60,30,25);
                                arcanineAttaks[1] = new Attack("Flame Thrower",95,47,15);
                                village.getLocalPokemons()[j] = new FirePokemon(imgs.get(1),"Arcanine",200,2,234.8,67,false,"fire",arcanineAttaks);
                                wasHere = 0;
                                maxFire-=1;
                                System.out.println("Se ha creado un pokemon tipo: "+ village.getLocalPokemons()[j].getType()+" en el pueblo: "+village.getName());
                            }

                         }else if(maxWater!=0){
                            if (wasHere==0){
                                maxWater-=1;
                                wasHere = 1;
                                Attack[] blastoideAttacks = new Attack[4];
                                blastoideAttacks[0] = new Attack("Water gun",40,20,25);
                                blastoideAttacks[1] = new Attack("Bubble",20,10,30);
                                village.getLocalPokemons()[j] = new WaterPokemon(imgs.get(2),"Blastoide",200,2,145.4,77,false,"water",blastoideAttacks,false);
                            }else {
                                Attack[] squirtleAttack = new Attack[4];
                                maxWater-=1;
                                wasHere = 0;
                                squirtleAttack[0] = new Attack("Water pulse",60,30,20);
                                squirtleAttack[1] = new Attack("Bubble",20,10,30);
                                village.getLocalPokemons()[j] = new WaterPokemon(imgs.get(3),"Squirtle",150,1,166.9,89.5,false,"water",squirtleAttack,true);


                            }
                            System.out.println("Se ha creado un pokemon tipo: "+ village.getLocalPokemons()[j].getType()+" en el pueblo: "+village.getName());
                        }else if(maxPlant!=0){
                            if (wasHere==0){
                                wasHere = 1;
                                maxPlant-=1;
                                Attack[] venasurAttacls = new Attack[4];
                                venasurAttacls[0] = new Attack("Razor Leaf",55,27.5,25);
                                venasurAttacls[1] = new Attack("Bullet seed",10,5,10);
                                village.getLocalPokemons()[j] = new PlantPokemon(imgs.get(4),"Vensaur",230,2,234.56,100,false,"plant",venasurAttacls,5);
                            }else {
                                wasHere = 0;
                                maxPlant-=1;
                                Attack[] grovlyeAttacks = new Attack[4];
                                grovlyeAttacks[0] = new Attack("Leaf bladde",70,35,30);
                                grovlyeAttacks[1] = new Attack("Bullet seed",10,5,10);
                                village.getLocalPokemons()[j] = new PlantPokemon(imgs.get(5),"Grovlye",150,1,145.6,99,false,"Plant",grovlyeAttacks,0);
                            }
                            System.out.println("Se ha creado un pokemon tipo: "+ village.getLocalPokemons()[j].getType()+" en el pueblo: "+village.getName());
                        }else if(maxRock!=0){
                            if (wasHere==0){
                                wasHere = 1;
                                maxRock-=1;
                                Attack[] onixAttacs = new Attack[4];
                                onixAttacs[0] = new Attack("Rage",20,10,10);
                                onixAttacs[1] = new Attack("Sand Storm",25,17,30);
                                village.getLocalPokemons()[j] = new RockPokemon(imgs.get(6),"Onix",200,1,100,99,false,"rock",onixAttacs,100);

                            }else {
                                wasHere = 0;
                                maxRock-=1;
                                Attack[] geodudeAttacks = new Attack[4];
                                geodudeAttacks[0] = new Attack("Rock blast",25,12,10);
                                geodudeAttacks[1] = new Attack("Sand Storm",25,17,30);
                                village.getLocalPokemons()[j] = new RockPokemon(imgs.get(7),"Geodude",254,2,124.9,77,false,"Rock",geodudeAttacks,50);

                            }
                            System.out.println("Se ha creado un pokemon tipo: "+ village.getLocalPokemons()[j].getType()+" en el pueblo: "+village.getName());
                        }else if(maxElectric!=0){
                            if (wasHere==0){
                                wasHere = 1;
                                maxElectric-=1;
                                Attack [] pikachuAttacks= new Attack[4];
                                pikachuAttacks[0] = new Attack("ThunderSock",40,20,30);
                                pikachuAttacks[1] = new Attack("Thunder Punch",75,30,50);
                                village.getLocalPokemons()[j] = new ElectricPokemon(imgs.get(8),"Pikachu",100,1,199,80,false,"Electric",pikachuAttacks,345.2);
                            }else {
                                wasHere = 0;
                                maxElectric-=1;
                                Attack [] zapddosAttacks = new Attack[4];
                                zapddosAttacks[0] = new Attack("Thunder bolt",95,34,60);
                                zapddosAttacks[1] = new Attack("Shock wave",60,30,20);
                                village.getLocalPokemons()[j] = new ElectricPokemon(imgs.get(9),"Zapdos",124,1,123.7,100,false,"Electric",zapddosAttacks,666);

                            }
                            System.out.println("Se ha creado un pokemon tipo: "+ village.getLocalPokemons()[j].getType()+" en el pueblo: "+village.getName());
                        }else {
                            if (wasHere==0){
                                wasHere = 1;
                                Attack [] pyduckAttacks = new Attack[4];
                                pyduckAttacks[0] = new Attack("Confusion",40,20,25);
                                pyduckAttacks[1] = new Attack("Telekinesis",20,10,5);
                                village.getLocalPokemons()[j] = new PsychicPokemon(imgs.get(10),"Psyduck",233,2,165.9,88,false,"Psychic",pyduckAttacks,false);


                            }else {
                                wasHere = 0;
                                Attack [] mewtwoAttacks = new Attack[4];
                                mewtwoAttacks[0] = new Attack("Pyshic",90,45,20);
                                mewtwoAttacks[1] = new Attack("Telekinesis",20,10,5);
                                village.getLocalPokemons()[j] = new PsychicPokemon(imgs.get(11),"Mewtwo",100,2,234.5,344,false,"Psyquic",mewtwoAttacks,true);

                            }
                            System.out.println("Se ha creado un pokemon tipo: "+ village.getLocalPokemons()[j].getType()+" en el pueblo: "+village.getName());
                        }
                    }

                }
            }


    }

    public void setImages(){
        imgs.add("img/pokemon/pokemon_sprites/Charizard.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Arcanine.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Blastoise.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Squirtle.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Venusaur.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Grovyle.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Onix.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Geodude.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Pikachu.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Zapdos.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Psyduck.gif_.gif");
        imgs.add("img/pokemon/pokemon_sprites/Mewtwo.gif_.gif");
    }

}

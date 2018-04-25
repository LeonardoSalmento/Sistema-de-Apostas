package models;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Jogo> jogos = new ArrayList<Jogo>();
    private ArrayList<Campeonato> campeonatos = new ArrayList<Campeonato>();
    private ArrayList<Bilhete> bilhetes = new ArrayList<Bilhete>();

    public Banco() {}


    public void criarCampeonatos(){
        Campeonato brasileiro = new Campeonato("Brasileiro","Brasil");
        this.campeonatos.add(brasileiro);
        Campeonato espanhol = new Campeonato("Espanhol","Espanha");
        this.campeonatos.add(espanhol);
        Campeonato ingles = new Campeonato("Ingles","Inglaterra");
        this.campeonatos.add(ingles);
    }

    public void criarJogos() {
        jogos = this.jogos;
        jogos.add(new Jogo(new Time("Palmeiras"), new Time("Corinthians"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Fluminense"), new Time("São Paulo"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Flamengo"), new Time("Cruzeiro"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Atlético Paranaense"), new Time("Botafogo"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Bahia"), new Time("Atlético Mineiro"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Vitória"), new Time("Coritiba"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Santos"), new Time("Paraná"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Vasco"), new Time("América Mineiro"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Chapecoense"), new Time("Internacional"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Gremio"), new Time("Ceará"),campeonatos.get(0)));
        jogos.add(new Jogo(new Time("Real Madrid"), new Time("Barcelona"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Atlético de Madrid"), new Time("Villarreal"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Sevilla"), new Time("Valencia"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Real Betis"), new Time("La Coruna"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Alavís"), new Time("Espanyol"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Real Sociedad"), new Time("Celta de Vigo"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Málaga"), new Time("Las Palmas"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Levante"), new Time("Getafe"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Osasuna"), new Time("Sporting de Gijón"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Girona"), new Time("Leganos"),campeonatos.get(1)));
        jogos.add(new Jogo(new Time("Manchester City"), new Time("Liverpool"),campeonatos.get(2)));
        jogos.add(new Jogo(new Time("Manchester United"), new Time("Chelsea"),campeonatos.get(2)));
        jogos.add(new Jogo(new Time("Arsenal"), new Time("Tottenham"),campeonatos.get(2)));
        jogos.add(new Jogo(new Time("Aston Vila"), new Time("Everton"),campeonatos.get(2)));
        jogos.add(new Jogo(new Time("Swansea"), new Time("Hull City"),campeonatos.get(2)));
        jogos.add(new Jogo(new Time("Sunderland"), new Time("Leicester City"),campeonatos.get(2)));
        jogos.add(new Jogo(new Time("Southampton"), new Time("West Bromwich"),campeonatos.get(2)));
        jogos.add(new Jogo(new Time("Crystal Palace"), new Time("NewCastle"),campeonatos.get(2)));
        jogos.add(new Jogo(new Time("Fulham"), new Time("Stoke City"),campeonatos.get(2)));
        jogos.add(new Jogo(new Time("Wigan"), new Time("West Ham"),campeonatos.get(2)));
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }


    public ArrayList<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public void setBilhetes(ArrayList<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public ArrayList<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void adicionarResultados() {
        new Resultado("Casa");
        new Resultado("Fora");
        new Resultado("Empate");
    }
}

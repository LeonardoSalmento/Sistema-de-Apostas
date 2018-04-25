package models;


public class Jogo {
    private int id;
    private Time timeDeCasa;
    private Time timeDeFora;
    private Resultado resultado;
    private Campeonato campeonato;


    public Jogo(Time timeDeCasa, Time timeDeFora, Campeonato campeonato) {
        this.timeDeCasa = timeDeCasa;
        this.timeDeFora = timeDeFora;
        this.campeonato = campeonato;
        this.id += 1;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Resultado getResultado() {
        return resultado;
    }



    public Campeonato getCampeonato() {
        return campeonato;
    }



    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }


    public void setTimeDeCasa(Time timeDeCasa) {
        this.timeDeCasa = timeDeCasa;
    }

    public Time getTimeDeCasa() {
        return timeDeCasa;
    }

    public void setTimeDeFora(Time timeDeFora) {
        this.timeDeFora = timeDeFora;
    }

    public Time getTimeDeFora() {
        return timeDeFora;
    }

    public String partida(){
        return timeDeCasa.getNome() + " X " + timeDeFora.getNome();
    }
}

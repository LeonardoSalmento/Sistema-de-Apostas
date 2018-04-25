package app;
import models.*;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistema {
    public static void main(String[] args) {
        List<Aposta> apostas = new ArrayList<>();
        List<Bilhete> bilhetes = new ArrayList<>();
        Banco banco = new Banco();
        banco.criarCampeonatos();
        banco.criarJogos();

        Scanner ler = new Scanner(System.in);

        while(true){
            menu();
            int opMenu = ler.nextInt();

            if(opMenu == 1) {
                Bilhete bilhete = new Bilhete();

                System.out.println("Nome do Apostador: ");
                Apostador apostador = new Apostador(ler.next());
                System.out.println("CPF do Apostador: ");
                apostador.setCpf(ler.next());
                bilhete.setApostador(apostador);

                for (int i = 1; i <= 5; i++) {
                    int cont = 1;
                    Aposta aposta = new Aposta();
                    System.out.println("Aposta nº " + i);
                    mostrarCampeonatos();
                    int opMenuCampeonato = ler.nextInt();

                    if (opMenuCampeonato == 1){
                        System.out.println(">>> Jogos do Brasileirão");

                        //mostrar jogos
                        for (int j = 0; j < banco.getJogos().size(); j++) {
                            if (banco.getJogos().get(j).getCampeonato().getNome().equals("Brasileiro")) {
                                System.out.println(cont + " " + banco.getJogos().get(j).partida());
                                cont++;
                            }
                        }

                        System.out.println("Escolha o jogo:");
                        System.out.print(">> ");
                        int jogo = ler.nextInt();
                        mostrarOpcoesPalpite();
                        int opMenuJogos = ler.nextInt();

                        if (opMenuJogos == 1) {
                            aposta.setPalpite("Casa");
                            aposta.setJogo(banco.getJogos().get(jogo-1));
                            apostas.add(aposta);
                        }

                        else if(opMenuJogos == 2) {
                            aposta.setPalpite("Empate");
                            aposta.setJogo(banco.getJogos().get(jogo-1));
                            apostas.add(aposta);
                        }

                        else {
                            aposta.setPalpite("Fora");
                            aposta.setJogo(banco.getJogos().get(jogo-1));
                            apostas.add(aposta);
                        }

                    }

                    else if (opMenuCampeonato == 2) {
                        System.out.println(">>> Jogos do Campeonato Espanhol");

                        //mostrar jogos
                        for (int j = 0; j < banco.getJogos().size();j++){
                            if (banco.getJogos().get(j).getCampeonato().getNome().equals("Espanhol")){
                                System.out.println(cont + " " + banco.getJogos().get(j).partida());
                                cont++;
                            }

                        }
                        System.out.println("Escolha o jogo:");

                        int jogo = ler.nextInt();
                        mostrarOpcoesPalpite();
                        int opMenuJogos = ler.nextInt();

                        if (opMenuJogos == 1){
                            aposta.setPalpite("Casa");
                            aposta.setJogo(banco.getJogos().get(jogo+9));
                            apostas.add(aposta);
                        }

                        else if(opMenuJogos == 2) {
                            aposta.setPalpite("Empate");
                            aposta.setJogo(banco.getJogos().get(jogo+9));
                            apostas.add(aposta);
                        }

                        else {
                            aposta.setPalpite("Fora");
                            aposta.setJogo(banco.getJogos().get(jogo+9));
                            apostas.add(aposta);
                        }

                    }

                    else if (opMenuCampeonato == 3) {
                        System.out.println(">>> Jogos do Campeonato Inglês");
                        //mostrar jogos

                        for (int j = 0; j< banco.getJogos().size();j++){
                            if (banco.getJogos().get(j).getCampeonato().getNome().equals("Ingles")){
                                System.out.println(cont + " " + banco.getJogos().get(j).partida());
                                cont++;
                            }
                        }

                        System.out.println("Escolha o Jogo:");
                        System.out.print(">> ");

                        int jogo = ler.nextInt();
                        mostrarOpcoesPalpite();
                        int opMenuJogos = ler.nextInt();

                        if (opMenuJogos == 1) {
                            aposta.setPalpite("Casa");
                            aposta.setJogo(banco.getJogos().get(jogo+19));
                            apostas.add(aposta);
                        }

                        else if(opMenuJogos == 2) {
                            aposta.setPalpite("Empate");
                            aposta.setJogo(banco.getJogos().get(jogo+19));
                            apostas.add(aposta);
                        }

                        else {
                            aposta.setPalpite("Fora");
                            aposta.setJogo(banco.getJogos().get(jogo+19));
                            apostas.add(aposta);
                        }

                    }

                    else {
                        System.out.println("Opcão Invalida");
                    }
                }

                bilhete.setApostas(apostas);
                bilhetes.add(bilhete);
                apostas = new ArrayList<>();
            }


            else if (opMenu == 2) {
                mostrarBilhetes(bilhetes);
            }

            else if (opMenu == 3) {
                finalizarJogos(banco);
            }

            else if (opMenu == 4) {
                distribuirValores(bilhetes);
            }

            else if (opMenu == 5) {
                break;
            }
        }
    }

    private static void mostrarBilhetes(List<Bilhete> bilhetes) {
        for (int i = 0; i < bilhetes.size(); i++) {
            System.out.println("*** Bilhete ***");
            System.out.println("Código do Bilhete: " + bilhetes.get(i).getId());
            System.out.println("Nome: " + bilhetes.get(i).getApostador().getNome());
            System.out.println("CPF: " + bilhetes.get(i).getApostador().getCpf());
            System.out.println("Valor: R$ " + bilhetes.get(i).getValor());
            System.out.println("");
            System.out.println("Apostas");

            for(int j = 0; j < bilhetes.get(i).getApostas().size(); j++){
                System.out.println("Jogo: " + bilhetes.get(i).getApostas().get(j).jogo.partida() + " - Palpite: " + bilhetes.get(i).getApostas().get(j).getPalpite());
                bilhetes.get(i).getApostas().get(j).setAcertou();

                if (bilhetes.get(i).getApostas().get(j).getAcertou()) {
                    System.out.println("Status da aposta: Acertou");
                }

                else {
                    System.out.println("Status da aposta: Errou");
                }

                System.out.println("");
            }

            verificarBilhetePremiado(bilhetes.get(i));

            if(bilhetes.get(i).getPremiado()) {
                System.out.println("Status do bilhete: Bilhete Premiado!!!");
            }

            else {
                System.out.println("Status do bilhete: Bilhete não premiado");
            }

            System.out.println("");
        }
    }

    private static void menu(){
        System.out.println("*** Menu ***");
        System.out.println("1 - Comprar Bilhete");
        System.out.println("2 - Mostrar Bilhetes");
        System.out.println("3 - Finalizar Jogos");
        System.out.println("4 - Mostrar Valor a ser Pago para cada Vencedor");
        System.out.println("5 - Sair");
        System.out.print(">> ");
    }

    private static void mostrarCampeonatos(){
        System.out.println(">>> Escolha o Campeonato");
        System.out.println("1 - Brasileirão");
        System.out.println("2 - Espanhol");
        System.out.println("3 - Inglês");
        System.out.print(">> ");
    }

    private static void distribuirValores(List<Bilhete> bilhetes) {
        double valorTotal = 0.0;
        double valorPago = 0.0;
        List<Bilhete> bilhetesPremiados = new ArrayList<>();

        for (int i = 0; i < bilhetes.size(); i++) {
            valorTotal += bilhetes.get(i).getValor();

            for (int j = 0; j < bilhetes.get(i).getApostas().size(); j++) {
                bilhetes.get(i).getApostas().get(j).setAcertou();
            }

            verificarBilhetePremiado(bilhetes.get(i));

            if (bilhetes.get(i).getPremiado()) {
                bilhetesPremiados.add(bilhetes.get(i));
            }
        }

        valorPago = (valorTotal * 0.8) / bilhetesPremiados.size();
        System.out.println("Valor a ser pago para cada apostador: R$ " + valorPago);
        System.out.println("");
    }

    private static void finalizarJogos(Banco banco) {
        banco.criarJogos();

        for (int i = 0; i < 5; i++) {
            banco.getJogos().get(i).setResultado(new Resultado("Empate"));
        }

        for (int i = 5; i < 10; i++) {
            banco.getJogos().get(i).setResultado(new Resultado("Casa"));
        }

        for (int i = 10; i < 15; i++) {
            banco.getJogos().get(i).setResultado(new Resultado("Fora"));
        }

        for (int i = 15; i < 20; i++) {
            banco.getJogos().get(i).setResultado(new Resultado("Empate"));
        }

        for (int i = 20; i < 25; i++) {
            banco.getJogos().get(i).setResultado(new Resultado("Casa"));
        }

        for (int i = 25; i < 30; i++) {
            banco.getJogos().get(i).setResultado(new Resultado("Fora"));
        }

        System.out.println("Jogos Finalizados!");
    }

    private static void verificarBilhetePremiado(Bilhete bilhete) {
        for (int i = 0; i < bilhete.getApostas().size(); i++) {
            bilhete.getApostas().get(i).setAcertou();

            if (bilhete.getApostas().get(i).getAcertou()) {
                bilhete.setPremiado(true);
            }
        }
    }

    private static void mostrarOpcoesPalpite(){
        System.out.println("*** Palpite ***");
        System.out.println("1 - Time de Casa vence");
        System.out.println("2 - Empate");
        System.out.println("3 - Time de Fora Vence");
        System.out.print(">> ");
    }

}
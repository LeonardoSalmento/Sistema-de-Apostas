package app;
import models.Aposta;
import models.Apostador;
import models.Banco;
import models.Bilhete;
import models.Campeonato;
import models.Jogo;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistema {
	public static void main(String[] args) throws IOException{
    	List<Aposta> apostas = new ArrayList<>();
    	List<Bilhete> bilhetes = new ArrayList<>();
        Banco banco = new Banco();
        banco.criarCampeonatos();
        banco.criarJogos();
       

        // TXT JAVA talvez use
        Scanner ler = new Scanner(System.in);
        int sair = 0;
        while(sair != 4){
        	menu();
	        int opMenu = ler.nextInt();
	        if(opMenu == 1) {
	        	Bilhete bilhete = new Bilhete();
	        	
	            System.out.println("Nome do Apostador: ");
	            Apostador apostador = new Apostador(ler.next());
	            System.out.println("Cpf do Apostador: ");
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
	                	for ( int j = 0; j< banco.getJogos().size();j++){
	                		if (banco.getJogos().get(j).getCampeonato().getNome().equals("Brasileiro")){
	                			System.out.println(cont + " " + banco.getJogos().get(j).partida());
	                			cont++;
	                		}	
	                	}
	                	
	                	System.out.println("Escolha o jogo:");
	                	int jogo = ler.nextInt();
	                	mostrarOpcoesPalpite();
	            		int opMenujogos = ler.nextInt();
	            		if (opMenujogos == 1){
	            			aposta.setPalpite("Casa");
	            			aposta.setJogo(banco.getJogos().get(jogo-1));
	                    	apostas.add(aposta);
	            		}
	            		else if(opMenujogos == 2){
	            			aposta.setPalpite("Empate");
	            			aposta.setJogo(banco.getJogos().get(jogo-1));
	                    	apostas.add(aposta);
	            		}
	            		
	            		else{
	            			aposta.setPalpite("Fora");
	            			aposta.setJogo(banco.getJogos().get(jogo-1));
	            			apostas.add(aposta);
	            		}
	                
	                }
	                
	                else if (opMenuCampeonato == 2){
	                	System.out.println(">>> Jogos do Campeonato Espanhol");
	                    //mostrar jogos
	                	for ( int j = 0; j< banco.getJogos().size();j++){
	                		if (banco.getJogos().get(j).getCampeonato().getNome().equals("Espanhol")){
	                			System.out.println(cont + " " + banco.getJogos().get(j).partida());
	                			cont++;
	                		}
	                		
	                	}
	                	System.out.println("Escolha o jogo:");
	
	                	int jogo = ler.nextInt();
	                	mostrarOpcoesPalpite();
	            		int opMenujogos = ler.nextInt();
	            		if (opMenujogos == 1){
	            			aposta.setPalpite("Casa");
	            			aposta.setJogo(banco.getJogos().get(jogo+9));
	                    	apostas.add(aposta);
	            		}
	            		else if(opMenujogos == 2){
	            			aposta.setPalpite("Empate");
	            			aposta.setJogo(banco.getJogos().get(jogo+9));
	                    	apostas.add(aposta);
	            		}
	            		
	            		else{
	            			aposta.setPalpite("Fora");
	            			aposta.setJogo(banco.getJogos().get(jogo+9));
	            			apostas.add(aposta);
	            		}
	                	
	                }
	                
	                else if (opMenuCampeonato == 3){
	                	System.out.println(">>> Jogos do Campeonato Inglês");
	                    //mostrar jogos
	                	for ( int j = 0; j< banco.getJogos().size();j++){
	                		if (banco.getJogos().get(j).getCampeonato().getNome().equals("Ingles")){
	                			System.out.println(cont + " " + banco.getJogos().get(j).partida());
	                			cont++;
	                		}
	                	
	                		
	                	}
	                	System.out.println("Escolha o jogo:");
	
	                	int jogo = ler.nextInt();
	                	mostrarOpcoesPalpite();
	            		int opMenujogos = ler.nextInt();
	            		if (opMenujogos == 1){
	            			aposta.setPalpite("Casa");
	            			aposta.setJogo(banco.getJogos().get(jogo+19));
	                    	apostas.add(aposta);
	            		}
	            		else if(opMenujogos == 2){
	            			aposta.setPalpite("Empate");
	            			aposta.setJogo(banco.getJogos().get(jogo+19));
	                    	apostas.add(aposta);
	            		}
	            		
	            		else{
	            			aposta.setPalpite("Fora");
	            			aposta.setJogo(banco.getJogos().get(jogo+19));
	            			apostas.add(aposta);
	            		}
	
	                }
	                
	                else{
	                	System.out.println("Opcão Invalida");
	                }
	                
	                
	            }
	            bilhete.setApostas(apostas);
	            bilhetes.add(bilhete);     
	        }

       
        	else if(opMenu == 2) {
        	 	mostrarBilhetes(bilhetes);
        	}
        
        }
	}
	
	private static void mostrarBilhetes(List<Bilhete> bilhetes){
		System.out.println("***Bilhete***");
        System.out.println("Nome : " + bilhetes.get(0).getApostador().getNome());
        System.out.println("Cpf : " + bilhetes.get(0).getApostador().getCpf());
        System.out.println("Apostas");
        for (int i = 0; i<bilhetes.size();i++){
        	for(int j = 0; j<bilhetes.get(i).getApostas().size();j++){
        		System.out.println("Jogo : " + bilhetes.get(0).getApostas().get(j).jogo.partida()+ " - Palpite: " + bilhetes.get(0).getApostas().get(j).getPalpite());
        	}
        }
	}
	
	private static void menu(){
		System.out.println("*** Menu ***");
        System.out.println("1 - Comprar Bilhete");
        System.out.println("2 - Mostrar Bilhetes");
        System.out.println("3 - Finalizar Rodada");
        System.out.println("4 - Sair\n");
	}
	
	private static void mostrarCampeonatos(){
	    System.out.println(">>> Escolha o Campeonato");
	    System.out.println("1 - Brasileirão");
	    System.out.println("2 - Espanhol");
	    System.out.println("3 - Inglês\n");
	}
	
	private static void mostrarOpcoesPalpite(){
		System.out.println("*** Palpite ***");
        System.out.println("1 - Time de Casa vence");
        System.out.println("2 - Empate");
        System.out.println("3 - Time de Fora Vence\n");
	}
    
}
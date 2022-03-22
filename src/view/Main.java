package view;

import java.util.concurrent.Semaphore;

import Controller.idPrato;


public class Main {

	public static void main(String[] args) {
		
                 int permissoes = 3;
		         Semaphore semaforo = new Semaphore(permissoes);
		          
		         for (int idPrato = 0; idPrato < 5; idPrato++) {
		              Thread tPrato = new idPrato(idPrato, idPrato, semaforo);
		              tPrato.start();

		          }


		      }

		   }



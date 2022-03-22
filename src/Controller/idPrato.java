package Controller;

import java.util.concurrent.Semaphore;

public class idPrato extends Thread {
	      
	    private int idSopacebola;
	    private int idLasanhabolonhesa;
	    private static int posCozimento;
	    private static int posEntrega;
	    private Semaphore semaforo;


	public idPrato(int idsopacebola,int idlasanhabolonhesa, Semaphore semaforo) {
	      this.idSopacebola = idsopacebola;
	      this.idLasanhabolonhesa = idlasanhabolonhesa;
	      this.semaforo = semaforo;
	}
	    
	   @Override
	   public void run() {
	      pratoinicio();
	    try {
	      semaforo.acquire();
	      pratoCozimento();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    } finally {
	      semaforo.release();
	      pratoPronto();

	   }

	}


		private void pratoinicio() {
	      int Pratopronto = (int)((Math.random() + 1001) + 1000);
	      int percentualcozimento = 1;
	      int Empreparo = 100;
	      int tempo = 1200;
	     while (percentualcozimento < Pratopronto) {
	        percentualcozimento += Empreparo;
	        try {
	           sleep(tempo);
	       } catch (InterruptedException e) {
	          e.printStackTrace();
	       }
	        System.out.println("#"+idSopacebola+idLasanhabolonhesa+" já andou "+percentualcozimento+"m.");
	       }
	        posCozimento++;
	        System.out.println("#"+idSopacebola+idLasanhabolonhesa+" foi o "+posCozimento+"o. a ficar pronto");
	  }

	     


	     private void pratoCozimento()  {
	       System.out.println("#"+idSopacebola+idLasanhabolonhesa+ " está Em preparo");
	       int tempo = (int)((Math.random() * 2001) + 1000);
	        try {
	        	sleep(tempo);
	     } catch (InterruptedException e) {
	            e.printStackTrace(); }
	     }

	   
	     
	        private void pratoPronto()  {
	            posEntrega++;
	            System.out.println("#"+idSopacebola+idLasanhabolonhesa+" foi o "+posEntrega+"o. a entregar");
	      }
}

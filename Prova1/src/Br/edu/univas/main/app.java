package Br.edu.univas.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.edu.univas.vo.*;

public class app {

	 public static void main(String[] args) throws Exception {
	        Scanner l = new Scanner(System.in);
	        Random random = new Random();
	        ArrayList<competidor> competidores = new ArrayList<>();
	        System.out.println("CADASTRO>");
	        for (int i = 0; i < 5; i++) {
	            competidor c = new competidor();
	            System.out.println("Digite o apelido do competidor: ");
	            String ap = l.nextLine();
	            System.out.println("Digite 1 para Carro e 2 para Moto: ");
	            int op = l.nextInt();
	            l.nextLine();
	            if (op == 1) {
	                carro carro = new carro();
	                c.setVeiculo(carro);
	                c.setApelido(ap);
	                competidores.add(c);
	            } else if (op == 2) {
	                moto moto = new moto();
	                c.setVeiculo(moto);
	                c.setApelido(ap);
	                competidores.add(c);
	            }
	        }
	        for (int j = 0; j < 10; j++) {
	            for (int w = 0; w < 5; w++) {
	                competidor c = competidores.get(w);
	                veiculo v = c.getveiculo();
	                v.acelerar(random.nextInt((20 - 5) + 1) + 5);
	            }
	        }
	        l.close();
	        competidor comp = competidores.get(0);
	        veiculo veic = comp.getveiculo();
	        int maior = veic.getvelocidadeAtual();
	        int indice = 0;
	        for (int z = 1; z < 5; z++) {
	            competidor c = competidores.get(z);
	            veiculo v = c.getveiculo();
	            if (maior < v.getvelocidadeAtual()) {
	                maior = v.getvelocidadeAtual();
	                indice = z;
	            }
	        }
	        //TESTE
	        // for (int x = 0; x < 5; x++) {
	        // competidor c = competidores.get(x);
	        // veiculo v = c.getveiculo();
	        // System.out.println(v.getvelocidadeAtual());
	        // }
	        competidor campeao = competidores.get(indice);
	        System.out.println("Competidor mais rápido: " + campeao.getApelido());
	        System.out.println("Velocidade: " + maior);

	    }
}

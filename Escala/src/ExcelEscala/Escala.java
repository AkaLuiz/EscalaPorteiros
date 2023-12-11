package ExcelEscala;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Escala {
	
    static Scanner input = new Scanner(System.in);
    static List<Irmao> Irmaos = new ArrayList<>();
    static Random gerador = new Random();

    public static void main(String arg[]) {

    	Irmao matheus = new Irmao("Matheus",false,false,0);
    	Irmao lucas = new Irmao("Lucas",false,false,-1);
    	Irmao tenorio = new Irmao("Tenorio",false,true,-1);
    	Irmao john = new Irmao("John",false,false,-1);
    	Irmao batman = new Irmao("Batman",false,false,-1);
        Irmao superHomem = new Irmao("Super Homem",false,false,-1);
        Irmao homemAranha = new Irmao("Homem Aranha",false,false,-1);
        Irmao bruce = new Irmao("Bruce",false,false,-1);

        Irmaos.add(matheus);
        Irmaos.add(lucas);
        Irmaos.add(tenorio);
        Irmaos.add(john);
        Irmaos.add(batman);
        Irmaos.add(superHomem);
        Irmaos.add(homemAranha);
        Irmaos.add(bruce);

//        boolean sn;
//        do {
//            Cadastrar(Irmao);
//            System.out.println("Mais Irmaos para cadastrar?");
//            sn = input.nextBoolean();
//            input.nextLine(); 
//        } while (sn == true);
        
        WritableWorkbook planilha;
		try {
			planilha = Workbook.createWorkbook(new File(
					"C:\\temp\\Escala Porteiros.xls"));
			WritableSheet aba = planilha.createSheet("Escala Porteiros - SUL GAMA", 0);
			mes("JANEIRO", 0, 1, 2, 0, aba, 31, 1);
	        mes("FEVEREIRO", 4, 5, 6, 4, aba, 29, 4);
	        mes("MARÇO", 8, 9, 10, 8, aba, 31, 5);
	        mes("ABRIL", 12, 13, 14, 12, aba, 30, 1);
	        mes("MAIO", 16, 17, 18, 16, aba, 31, 3);
	        mes("JUNHO", 20, 21, 22, 20, aba, 30, 6);
	        planilha.write();
			// Fecha o arquivo
			planilha.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
    }
    static void mes(String mes, int zero, int um, int dois, int coluna, WritableSheet aba, int resposta, int diaSemana) {
    	try {
			
    		String[] Semana = { "DOM", "SEG", "TER", "QUA", "QUI", "SEX", "SAB" };

            int dias = 0;
            int qualIrmao = gerador.nextInt(Irmaos.size());
            
            int contadorSabado = 0;
    		
    		
			Label label = new Label(zero,0,mes);
			aba.addCell(label);
			String cabecalho[] = {"NOME", "DIA", "SEMANA"};
 
			// Cor de fundo das celulas
			Colour bckcolor = Colour.GRAY_50;
			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setBackground(bckcolor);
 
			// Cor e tipo de fonte
			WritableFont fonte = new WritableFont(WritableFont.ARIAL);
			fonte.setColour(Colour.WHITE);
			cellFormat.setFont(fonte);
 
			//Colocando o header na tabela
			for (int i = 0; i <= 2; i++) {
				label = new Label(coluna, 1, cabecalho[i]);
				aba.addCell(label);
				
				WritableCell cell = aba.getWritableCell(coluna, 1);
				coluna++;
				cell.setCellFormat(cellFormat);
			}
			
			//Construção do corpo da tabela
			int linha = 1;
			for (dias = 0; dias < resposta; dias++) {
				
	            if (diaSemana == 2) {
	            	linha++;
	            	int QualIrmao = confereDias(dias, qualIrmao, diaSemana);
	                colocarLinha(linha, QualIrmao, dias, Semana, diaSemana, aba, zero, um, dois);
	                qualIrmao++;
	                if(QualIrmao == qualIrmao) {
                    	qualIrmao++;
                    }

	            } else if (diaSemana == 4) {
	            	linha++;
	            	int QualIrmao = confereDias(dias, qualIrmao, diaSemana);
	            	colocarLinha(linha, QualIrmao, dias, Semana, diaSemana, aba, zero, um, dois);
	                qualIrmao++;
	                if(QualIrmao == qualIrmao) {
                    	qualIrmao++;
                    }

	            } else if (diaSemana == 0) {
	            	
	            	linha++;
	            	int QualIrmao = confereDias(dias, qualIrmao, diaSemana);
	            	colocarLinha(linha, QualIrmao, dias, Semana, diaSemana, aba, zero, um, dois);
	                qualIrmao++;
	                if(QualIrmao == qualIrmao) {
                    	qualIrmao++;
                    }
	                if (qualIrmao >= Irmaos.size()){
	                qualIrmao = 0;
	                }
	                
	                QualIrmao = confereDias(dias, qualIrmao, diaSemana);
	                linha++;	
                	String [] semana = {"DOM (RJM)"};
                	colocarLinha(linha, QualIrmao, dias, semana, diaSemana, aba, zero, um, dois);
	                
	                
	                qualIrmao++;
	                if(QualIrmao == qualIrmao) {
                    	qualIrmao++;
                    }
	                if (qualIrmao >= Irmaos.size()){
	                qualIrmao = 0;
	                }
	                
	            } else if(Semana[diaSemana].equals("SAB")){
	   
	                contadorSabado++;
	                if(contadorSabado == 4){
	                	linha++;
	                	int QualIrmao = confereDias(dias, qualIrmao, diaSemana);
	                	colocarLinha(linha, QualIrmao, dias, Semana, diaSemana, aba, zero, um, dois);

	                    qualIrmao++;
	                    if(QualIrmao == qualIrmao) {
	                    	qualIrmao++;
	                    }
	                    if (qualIrmao >= Irmaos.size()){
	    	                qualIrmao = 0;
	    	                }
	                }
	            }
	            
	            diaSemana++;
	            
	            if (diaSemana > 6)
	                diaSemana = 0;
	            if (qualIrmao >= Irmaos.size())
	                qualIrmao = 0;
	        }
 
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    static int confereDias(int dias, int qualIrmao, int diaSemana){
    	dias++;
		
        while(dias%2 == 0 && Irmaos.get(qualIrmao).isImpar() ||
        		dias%2 != 0 && Irmaos.get(qualIrmao).isPar() ||
        		Irmaos.get(qualIrmao).getDiaSemana() != diaSemana && Irmaos.get(qualIrmao).getDiaSemana() != -1){
        	qualIrmao++;
            if (qualIrmao >= Irmaos.size()){
            	qualIrmao = gerador.nextInt(Irmaos.size());
            }
            return qualIrmao;
        }

        return qualIrmao;
    }
    
    static void colocarLinha(int linha, int qualIrmao, int dias, String[]Semana, int diaSemana, WritableSheet aba, int zero, int um, int dois) {
    	
    	Label label = new Label(zero,linha, Irmaos.get(qualIrmao).getNome());
        Label label1 = new Label(um,linha, String.valueOf(dias+1));
        Label label2 = new Label(dois,linha,Semana[diaSemana]);
        
        if(Irmaos.get(qualIrmao).getDiaSemana() != diaSemana) {
        	qualIrmao++;
        	if (qualIrmao >= Irmaos.size()){
            	qualIrmao = gerador.nextInt(Irmaos.size());
            }
        }
        if(Irmaos.get(qualIrmao).isImpar() == true && (dias+1)%2 == 0) {
        	qualIrmao++;
        	if (qualIrmao >= Irmaos.size()){
            	qualIrmao = gerador.nextInt(Irmaos.size());
            }
        }
        if(Irmaos.get(qualIrmao).isPar() == true && (dias+1)%2 != 0) {
        	qualIrmao++;
        	if (qualIrmao >= Irmaos.size()){
            	qualIrmao = gerador.nextInt(Irmaos.size());
            }
        }
        
        try {
        aba.addCell(label);
        aba.addCell(label1);
        aba.addCell(label2);
        
        WritableCellFormat linhaDados = new WritableCellFormat();
        Colour bckcolor = Colour.GRAY_25;
		linhaDados.setBackground(bckcolor);
        
        label1.setCellFormat(linhaDados);
        
        } catch (Exception e) {
			e.printStackTrace();
		}
    }

    static void Cadastrar(Irmao Irmaoadicionado) {

        System.out.println("Cadastre um Irmao, diga seu nome:");
        String nome = input.nextLine();

        System.out.println("Ele só pode dias impares? ");
        boolean impar = input.nextBoolean();

        System.out.println("Ele só pode dias pares? ");
        boolean par = input.nextBoolean();

        System.out.println("Ele só pode um dia da semana?");
        boolean simNao = input.nextBoolean();

        int dia = -1;
        if (simNao == true) {
            System.out.println("Qual?");
            dia = input.nextInt();
        }

        Irmaoadicionado = new Irmao(nome, impar, par, dia);
        Irmaos.add(Irmaoadicionado);
    }

}
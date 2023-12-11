package ExcelEscala;

public class Irmao {
    private String nome;
    private boolean par;
    private boolean impar;
    private int diaSemana;


    public Irmao(String nome, boolean par, boolean impar, int diaSemana){
        this.nome = nome;
        this.par = par;
        this.impar = impar;
        this.diaSemana = diaSemana;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isPar() {
        return par;
    }
    public void setPar(boolean par) {
        this.par = par;
    }
    public boolean isImpar() {
        return impar;
    }
    public void setImpar(boolean impar) {
        this.impar = impar;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

}

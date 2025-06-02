package classroom.model.entidades;

public class Notas {
    private String ra;
    private String nome;
    private double A1;
    private double A2;
    private double A3;
    private final int valor;
    private final String tipo;
    private final Aluno aluno;

    // Construtor
    public Notas(String ra, String nome, double A1, double A2, double A3, int valor, String tipo, Aluno aluno) {
        this.ra = ra;
        this.nome = nome;
        this.A1 = A1;
        this.A2 = A2;
        this.A3 = A3;
        this.valor = valor;
        this.tipo = tipo;
        this.aluno = aluno;
    }

    public String getRa() { return ra; }
    public String getNome() { return nome; }
    public double getA1() { return A1; }
    public double getA2() { return A2; }
    public double getA3() { return A3; }
    public int getValor() { return valor;}
    public String getTipo() { return tipo;}
    public Aluno aluno() { return aluno;}

    public void setRa(String ra) { this.ra = ra; }
    public void setNome(String nome) { this.nome = nome; }
    public void setA1(double A1) { this.A1 = A1; }
    public void setA2(double A2) { this.A2 = A2; }
    public void setA3(double A3) { this.A3 = A3; }
}

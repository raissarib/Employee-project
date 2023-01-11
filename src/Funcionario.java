public class Funcionario {

    private String nome;
    private int id;
    private String cargo;
    private double salario;
    private int quantDep;

    public Funcionario(String nome, int id, String cargo, double salario, int quantDep) {
        this.nome = nome;
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
        this.quantDep = quantDep;
    }

    public Funcionario() {

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBonus() {
        return (this.salario * 0.02) * this.quantDep;
    }

    public int getQuantDep() {
        return this.quantDep;
    }

    public void setQuantDep(int quantDep) {
        this.quantDep = quantDep;
    }


}
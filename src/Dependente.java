public class Dependente {
    private String nomeDependente;
    private Funcionario funcionario;

    public Dependente(String nomeDependente, Funcionario funcionario) {
        this.nomeDependente = nomeDependente;
        this.funcionario = funcionario;
    }

    public Dependente() {

    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public void setNomeDependente(String nomeDependente) {
        this.nomeDependente = nomeDependente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}

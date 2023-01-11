import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        ArrayList<Funcionario> fun = new ArrayList<>();
        for (;;) {
            inicioDaInterfaceGrafica(fun);
        }
    }

    public static void inicioDaInterfaceGrafica(List<Funcionario> fun) {
        String[] options = new String[]{"Clique aqui para editar seu salário", "Clique aqui para se cadastrar", "Clique aqui para excluir seu cadastro", "Clique aqui para imprimir dados"};
        int opcaoEscolhida = JOptionPane.showOptionDialog(null, "O funcionário sempre em primeiro lugar!", "Ficha da Empresa",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);


        switch (opcaoEscolhida) {
            case 0:
                try{
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira seu id"));
                double novoSalario = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o novo salário"));
                var funcionario = fun.get(id);
                funcionario.setSalario(novoSalario);
                    JOptionPane.showMessageDialog(null ,"Funcionário editado!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "id não existe");
                }
                break;

            case 1:
                try{
                    String nome = JOptionPane.showInputDialog(null, "Insira seu nome");
                    String cargo = JOptionPane.showInputDialog(null, "Insira seu cargo");
                    double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira seu salário"));
                    int qntd = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantos dependentes você possui?"));

                    Funcionario funcionario = new Funcionario(nome, fun.size(), cargo, salario, qntd);
                    fun.add(funcionario);
                    ArrayList<Dependente> deps = new ArrayList<>();
                    Dependente dep = new Dependente();
                    for (var i = 0; qntd > i; i++) {
                        var posicao = 1 + i;
                        String nomedep = JOptionPane.showInputDialog(null, "Insira o nome do " + posicao + "° dependente");
                        dep.setNomeDependente(nomedep);
                        dep.setFuncionario(funcionario);
                        deps.add(dep);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null ,"id não existe");
                }
                JOptionPane.showMessageDialog(null ,"Funcionário criado!");
                break;

            case 2:
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira seu id"));
                    var obj = fun.get(id);
                    if (fun.remove(obj)) {
                        JOptionPane.showMessageDialog(null ,"Funcionário excluido!");
                    } else {
                        JOptionPane.showMessageDialog(null ,"Id informado não existe");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null ,"id não existe");
                }
                break;

            case 3:
                for (var i = 0; fun.size() > i; i++) {
                    appendStrToFile("av3.txt", "Nome do funcionário: " + fun.get(i).getNome() + "\nQuantidade de dependentes:" + fun.get(i).getQuantDep() +  "\nBônus:" + fun.get(i).getBonus() + "\n\n");
                }
                JOptionPane.showMessageDialog(null ,"Arquivo impresso");
                break;
            default:
        }

    }

    public static void appendStrToFile(String nomedoArquivo, String informacao) {
        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(nomedoArquivo, true));

            out.write(informacao);
            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo, Erro encontrado!");
        }
    }
}

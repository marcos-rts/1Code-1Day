import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Diálogo de Mensagem
        JOptionPane.showMessageDialog(null, "Bem-vindo à calculadora simples!", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
        
        // Diálogo de Entrada
        String nome = JOptionPane.showInputDialog(null, "Qual é o seu nome?", "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);
        
        // Diálogo de Opção
        Object[] opcoes = {"Adicao", "Subtracao", "Divisao", "Multiplicacao"};
        int escolha = JOptionPane.showOptionDialog(
            null, 
            "Escolha operação desejada:", 
            "Escolha de Calculo", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opcoes, 
            opcoes[0]
        );
        
        JOptionPane.showMessageDialog(null, "Você escolheu: " + opcoes[escolha], "Operação Escolhida", JOptionPane.INFORMATION_MESSAGE);
        
        int resposta = JOptionPane.showConfirmDialog(
            null, 
            "Você deseja continuar com a " + opcoes[escolha] + "?", 
            "Confirmação", 
            JOptionPane.YES_NO_OPTION
        );
        
        if (resposta == JOptionPane.YES_OPTION) {
            // Convertendo a escolha para String
            String operacaoEscolhida = (String) opcoes[escolha];
            
            // Solicita dois números ao usuário
            String num1 = JOptionPane.showInputDialog(null, "Digite o primeiro número:");
            String num2 = JOptionPane.showInputDialog(null, "Digite o segundo número:");
            
            // Converte as entradas para números
            double number1 = Double.parseDouble(num1);
            double number2 = Double.parseDouble(num2);
            double resultado = 0;
            String operacao = "";

            // Usando switch na String escolhida
            switch (operacaoEscolhida) {
                case "Adicao":
                    resultado = number1 + number2;
                    operacao = "+";
                    break;
                    
                case "Subtracao":
                    resultado = number1 - number2;
                    operacao = "-";
                    break;
                    
                case "Divisao":
                    if (number2 != 0) {
                        resultado = number1 / number2;
                        operacao = "/";
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro: Divisão por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return; // Sai do programa em caso de erro
                    }
                    break;
                    
                case "Multiplicacao":
                    resultado = number1 * number2;
                    operacao = "*";
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Operação desconhecida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return; // Sai do programa em caso de erro
            }
            
            // Exibe o resultado final
            JOptionPane.showMessageDialog(null, "Resultado: " + number1 + " " + operacao + " " + number2 + " = " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar. Saindo...", "Saída", JOptionPane.WARNING_MESSAGE);
        }
    }
}

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Converte conversorMoeda = new Converte();
        Scanner read = new Scanner(System.in);
        String moedaBase = null;
        String moedaAlvo = null;
        List<Conversor> conversoes = new ArrayList<>();
        int op = 0;
        System.out.println("**************************************************************");
        System.out.println("Conversor de Moedas!");
        do {


            System.out.println("""
                    1) Dólar =>> Peso Argentino
                    2) Peso Argentino ==>> Dólar
                    3) Dólar ==> Real brasileiro
                    4) Real brasileiro ==> Dólar
                    5) Dólar ==>> Peso Colombiano
                    6) Peso Colombiano ==> Dólar
                    7) Peso Chileno ==> Dólar
                    8) Dólar ==> Peso Chileno
                    9) Sair
                                                                                               
                    """);
            System.out.println("**************************************************************");

                op = read.nextInt();
                if (op <=0 || op > 9){
                    System.err.println("\nDigite uma opção válida!!\n");
                    continue;
                }

            try {


                if (op == 9) {
                    System.out.println("Encerrando Sistema!");
                    break;
                }

                switch (op) {
                    case 1:
                        moedaBase = "USD";
                        moedaAlvo = "ARS";
                        break;

                    case 2:
                        moedaBase = "ARS";
                        moedaAlvo = "USD";
                        break;

                    case 3:
                        moedaBase = "USD";
                        moedaAlvo = "BRL";
                        break;

                    case 4:
                        moedaBase = "BRL";
                        moedaAlvo = "USD";
                        break;

                    case 5:
                        moedaBase = "USD";
                        moedaAlvo = "COP";
                        break;

                    case 6:
                        moedaBase = "COP";
                        moedaAlvo = "USD";
                        break;

                    case 7:
                        moedaBase = "CLP";
                        moedaAlvo = "USD";
                        break;

                    case 8:
                        moedaBase = "USD";
                        moedaAlvo = "CLP";
                        break;

                    case 9:
                        System.out.println("Encerrando Sistema!");
                        System.out.println(conversoes.toString());
                        System.exit(0);
                        break;
                }


                System.out.println("Digite o valor que deseja converter: ");
                int quantidade = read.nextInt();

                System.out.println("Tentando Converter " + moedaBase + " em " + moedaAlvo);

                Conversor resultado = conversorMoeda.converteMoeda(moedaAlvo, moedaBase, quantidade);
                if (resultado != null){
                    conversoes.add(resultado);
                }



                System.out.println("o valor " + quantidade + " [" + resultado.moedaBase() + "]" + " corresponde ao valor final de: "
                        + resultado.resultadoConversao() + " [" + resultado.moedaAlvo() + "]");

                System.out.println("**************************************************************");

            } catch (IOException e) {
                System.out.println("Erro de excessão: " + e);
            } catch (NumberFormatException e) {
                System.out.println("Erro de entrada: a quantidade digitada não é um número válido.");
            }catch (InputMismatchException e){
                System.out.println("Por favor digite apenas números!");

            }
            catch (InterruptedException e) {
                System.out.println("Serviço interrompido inexperadamente!" + e);
            }

        } while (op != 9);
        System.out.println("\n=============================================");
        System.out.println("        HISTÓRICO DE CONVERSÕES            ");
        System.out.println("=============================================");

        if (conversoes.isEmpty()){
            System.out.println("Nenhuma conversão válida foi registrada!");
        } else {
            for (int i = 0; i < conversoes.size(); i++) {
                Conversor item = conversoes.get(i);

                double quantidadeInicial = item.resultadoConversao() / item.taxaConversao();

                System.out.printf("Conversão #%d: %.2f [%s] = %.2f [%s]\n",
                        i + 1,
                        quantidadeInicial,
                        item.moedaBase(),
                        item.resultadoConversao(),
                        item.moedaAlvo()
                );

            }
        }

    }
}

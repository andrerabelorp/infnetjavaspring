package br.edu.infnet.arabeloapi;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class SystemLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        lerContas();
    }

    public static void lerContas() throws Exception {
        FileReader arquivo = new FileReader("contas.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();
        String[] campos;
        while (linha != null) {
            campos = linha.split(";");

            Conta conta = new Conta();

            conta.setId(Integer.valueOf(campos[0]));
            conta.setCodigoBanco(Integer.valueOf(campos[1]));
            conta.setNumero(Long.valueOf(campos[2]));
            conta.setSaldoAtual(Double.valueOf(campos[3]));
            conta.setAtivo(Boolean.valueOf(campos[4]));

            System.out.println("- " + conta);

            linha = leitor.readLine();
        }

        leitor.close();
    }
}

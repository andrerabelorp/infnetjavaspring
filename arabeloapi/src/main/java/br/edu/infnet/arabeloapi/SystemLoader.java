package br.edu.infnet.arabeloapi;

import br.edu.infnet.arabeloapi.model.domain.Banco;
import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.service.BancoCrudService;
import br.edu.infnet.arabeloapi.service.ContaCrudService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class SystemLoader implements ApplicationRunner {

    private final ContaCrudService contaCrudService;
    private final BancoCrudService bancoCrudService;

    public SystemLoader(ContaCrudService contaCrudService, BancoCrudService bancoCrudService) {
        this.contaCrudService = contaCrudService;
        this.bancoCrudService = bancoCrudService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        lerBancos();
        lerContas();
    }

    public void lerBancos() throws Exception {
        FileReader arquivo = new FileReader("bancos.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();
        String[] campos;
        while (linha != null) {
            campos = linha.split(";");

            Banco banco = new Banco();
            banco.setIdBacen(Integer.valueOf(campos[0]));
            banco.setNome(campos[1]);

            System.out.print("- Salvando banco... ");
            Banco bancoSalva = bancoCrudService.salvar(banco);
            System.out.println(String.format("Banco salvo, ID %d!", bancoSalva.getIdBacen()));

            linha = leitor.readLine();
        }

        System.out.println(String.format("Tamanho lista: %d.", bancoCrudService.obter().size()));

        leitor.close();
    }
    
    public void lerContas() throws Exception {
        FileReader arquivo = new FileReader("contas.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();
        String[] campos;
        while (linha != null) {
            campos = linha.split(";");

            Conta conta = new Conta();
            conta.setId(Integer.valueOf(campos[0]));
            conta.setBanco(bancoCrudService.obter(Integer.valueOf(campos[1])));
            conta.setNumero(Long.valueOf(campos[2]));
            conta.setSaldoAtual(Double.valueOf(campos[3]));
            conta.setAtivo(Boolean.valueOf(campos[4]));

            System.out.print("- Salvando conta... ");
            Conta contaSalva = contaCrudService.salvar(conta);
            System.out.println(String.format("Conta salva, ID %d!", contaSalva.getId()));

            linha = leitor.readLine();
        }

        System.out.println(String.format("Tamanho lista: %d.", contaCrudService.obter().size()));

        leitor.close();
    }
}

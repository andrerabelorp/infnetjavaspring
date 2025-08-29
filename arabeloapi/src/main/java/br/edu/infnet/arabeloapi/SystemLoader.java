package br.edu.infnet.arabeloapi;

import br.edu.infnet.arabeloapi.model.domain.Banco;
import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.model.domain.TipoConta;
import br.edu.infnet.arabeloapi.service.BancoCrudService;
import br.edu.infnet.arabeloapi.service.ContaCrudService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

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
        carregarBancos();
        carregarContas();
    }

    public void carregarBancos() throws Exception {
        FileReader arquivo = new FileReader("bancos.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();
        String[] campos;
        List<Banco> bancos = bancoCrudService.obter();
        while (linha != null) {
            campos = linha.split(";");

            Banco banco = new Banco();
            try {
                banco.setCodigoBacen(Integer.valueOf(campos[0]));
                banco.setNome(campos[1]);

                if (bancos.stream()
                        .filter(bancoEntity -> bancoEntity.getCodigoBacen().equals(banco.getCodigoBacen()))
                        .findAny().isEmpty()) {
                    System.out.print("- Salvando banco... ");
                    Banco bancoSalvo = bancoCrudService.incluir(banco);
                    System.out.println(String.format("Banco salvo, ID %d!", bancoSalvo.getId()));
                } else {
                    System.out.println("- Banco já existe.");
                }
            } catch (Exception e) {
                System.out.println(String.format("Erro ao salvar banco: [%s].", banco));
            }

            linha = leitor.readLine();
        }

        System.out.println(String.format("Tamanho lista: %d.", bancos.size()));

        leitor.close();
    }
    
    public void carregarContas() throws Exception {
        FileReader arquivo = new FileReader("contas.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();
        String[] campos;
        List<Banco> bancos = bancoCrudService.obter();
        while (linha != null) {
            campos = linha.split(";");

            Conta conta = new Conta();
            try {
                Integer codigoBanco = Integer.valueOf(campos[1]);
                conta.setBanco(
                        bancos.stream()
                                .filter(banco -> banco.getCodigoBacen().equals(codigoBanco))
                                .findFirst().get());
                conta.setNumero(Long.valueOf(campos[2]));
                conta.setSaldoAtual(Double.valueOf(campos[3]));
                conta.setAtivo(Boolean.valueOf(campos[4]));
                conta.setTipoConta(TipoConta.CORRENTE);

                System.out.print("- Salvando conta... ");
                Conta contaSalva = contaCrudService.incluir(conta);
                System.out.println(String.format("Conta salva, ID %d!", contaSalva.getId()));
            } catch (Exception e) {
                System.out.println(String.format("Erro ao salvar conta: [%s].", conta));
                System.out.println(e.getMessage());
            }

            linha = leitor.readLine();
        }

        for(Conta conta: contaCrudService.obter()) {
            System.out.println(String.format("Conta recuperada: %s", conta));
        }

        contaCrudService.obter().forEach(System.out::println);

        leitor.close();
    }
}

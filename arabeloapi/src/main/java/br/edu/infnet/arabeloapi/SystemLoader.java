package br.edu.infnet.arabeloapi;

import br.edu.infnet.arabeloapi.model.domain.Conta;
import br.edu.infnet.arabeloapi.model.domain.InstituicaoFinanceira;
import br.edu.infnet.arabeloapi.model.domain.TipoConta;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SystemLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        InstituicaoFinanceira banco = new InstituicaoFinanceira("Bradesco", "237");
        System.out.println(banco);

        Conta conta = new Conta(banco, TipoConta.CORRENTE, 1234L, "1");
        System.out.println(conta);
    }
}

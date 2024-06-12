package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeCansultas {

    public void validador(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();

        var agora = LocalDateTime.now();

        var duracaoEmMinutos = Duration.between(agora, dataConsulta).toMinutes();


        if (duracaoEmMinutos < 30) {
            throw new ValidacaoException("O tempo antes do agendamento da consulta deve ser maior que 30 minutos!");
        }

    }
}

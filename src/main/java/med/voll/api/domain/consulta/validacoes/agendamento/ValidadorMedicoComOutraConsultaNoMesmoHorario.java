package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeCansultas {

    @Autowired
    private ConsultaRepository repository;

    public void validador(DadosAgendamentoConsulta dados) {
        var medicoPossuiConsultaNoMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());

        if (medicoPossuiConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta nesse mesmo horário!");
        }
    }

}

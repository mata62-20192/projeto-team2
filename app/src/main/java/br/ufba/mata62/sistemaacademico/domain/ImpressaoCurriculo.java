package br.ufba.mata62.sistemaacademico.domain;

public class ImpressaoCurriculo {

    public static StringBuilder imprimir(Curriculo curriculo){
        StringBuilder sb = new StringBuilder("<body><html>");
        sb.append("<h2> Disciplinas Obrigatórias </h2>");
        for(Periodo periodo : curriculo.getPeriodos().values()) {
            sb.append("<h3> Semestre " + periodo.getNumero()).append("</h3> <p/>");
            for(ComponenteCurricular componente : periodo.getComponentesCurricularesObrigatorios()) {
                sb.append("<hr>");
                sb.append("	Disciplina: " + componente.getDisciplina().getNome()).append("<p/>");
                sb.append("	Código: " + componente.getDisciplina().getCodigo()).append("<p/>");
                sb.append("	Carga Horária: " + componente.getDisciplina().getCargaHoraria()).append("<p/>");
                sb.append("<hr>");
            }
        }

        sb.append("<h2> Disciplinas Optativas </h2>");
        for(ComponenteCurricular componente : curriculo.getComponentesCurricularesOptativos()) {
            sb.append("<hr>");
            sb.append("	Disciplina: " + componente.getDisciplina().getNome()).append("<p/>");
            sb.append("	Codigo: " + componente.getDisciplina().getCodigo()).append("<p/>");
            sb.append("	Carga Horaria: " + componente.getDisciplina().getCargaHoraria()).append("<p/>");
            sb.append("<hr>");
        }
        sb.append("</body></html>");
        return sb;
    }
}


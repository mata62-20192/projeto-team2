package br.ufba.mata62.sistemaacademico.controller;

import br.ufba.mata62.sistemaacademico.R;
import br.ufba.mata62.sistemaacademico.domain.Aluno;
import br.ufba.mata62.sistemaacademico.service.HistoricoService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;

class AlunoEscalonamentoAdapter extends ArrayAdapter<Aluno> {
    AlunoEscalonamentoAdapter(Context context, ArrayList<Aluno> alunos){
        super(context, R.layout.escalonamento_list_item_layout, alunos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        Aluno aluno = getItem(position);

        if(aluno != null){

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.escalonamento_list_item_layout, null);

                ViewHolder holder = new ViewHolder();
                holder.lblPosition = view.findViewById(R.id.lblPosition);
                holder.lblCR = view.findViewById(R.id.lblCR);
                holder.lblSemestre = view.findViewById(R.id.lblSemestre);
                holder.lblName = view.findViewById(R.id.lblName);
                view.setTag(holder);
            }

            ViewHolder holder = (ViewHolder)view.getTag();

            holder.lblPosition.setText(String.format(Locale.ENGLISH, "%d", position + 1));
            Double nota = HistoricoService.calcularCoeficienteRendimento(aluno.getHistorico());

            if(nota != null){
                holder.lblCR.setText(String.format(Locale.ENGLISH, "%.2f", nota));
            }else{
                holder.lblCR.setText(String.format(Locale.ENGLISH, "%f", nota));
            }

            holder.lblSemestre.setText(aluno.getSemestreInicio());
            holder.lblName.setText(aluno.getNome());
        }

        return view;
    }

    static class ViewHolder {
        public TextView lblPosition;
        public TextView lblCR;
        public TextView lblSemestre;
        public TextView lblName;
    }
}
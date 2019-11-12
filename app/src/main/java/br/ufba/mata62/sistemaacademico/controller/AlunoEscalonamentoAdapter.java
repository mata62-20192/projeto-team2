package br.ufba.mata62.sistemaacademico.controller;

import br.ufba.mata62.sistemaacademico.domain.Aluno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


class AlunoEscalonamentoAdapter extends ArrayAdapter<Aluno> {
    AlunoEscalonamentoAdapter(Context context, ArrayList<Aluno> alunos){
        super(context, android.R.layout.simple_list_item_1, alunos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        Aluno aluno = getItem(position);

        if(aluno != null){

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(android.R.layout.simple_list_item_1, null);

                ViewHolder holder = new ViewHolder();
                holder.text1 = view.findViewById(android.R.id.text1);
                view.setTag(holder);
            }

            ViewHolder holder = (ViewHolder)view.getTag();
            holder.text1.setText(aluno.getNome());
        }

        return view;
    }

    static class ViewHolder {
        public TextView text1;
    }
}
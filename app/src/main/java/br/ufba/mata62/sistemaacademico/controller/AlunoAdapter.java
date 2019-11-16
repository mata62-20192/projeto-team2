package br.ufba.mata62.sistemaacademico.controller;

import br.ufba.mata62.sistemaacademico.domain.Aluno;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

class AlunoAdapter extends ArrayAdapter<Aluno> implements Filterable{
    private List<Aluno> alunos;
    private List<Aluno> alunosFull;

    AlunoAdapter(Context context, ArrayList<Aluno> alunos){
        super(context, android.R.layout.simple_list_item_1, alunos);
        this.alunos = alunos;
        alunosFull = new ArrayList<>(alunos);
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

    @Override
    public Filter getFilter() {
        return alunoFilter;
    }

    private Filter alunoFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Aluno> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(alunosFull);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Aluno aluno : alunosFull){
                    if(aluno.getNome().toLowerCase().startsWith(filterPattern)){
                        filteredList.add(aluno);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            alunos.clear();
            alunos.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
}
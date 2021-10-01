package com.example.todoapp05;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class TodoFragment extends Fragment {
    RecyclerView recyclerView;
    EditText editText;
    TodoAdapter adapter = new TodoAdapter();
    String task;
    Button addButton;
    ArrayList<String> modelClass = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todo, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.todo_recycler);
        editText = view.findViewById(R.id.edit_text);
        addButton=view.findViewById(R.id.add_button);
        adapter = new TodoAdapter();
        recyclerView.setAdapter(adapter);
        initAdapter();

    }

    public void initAdapter(){

       addButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               task = editText.getText().toString();
               adapter.todoAdapter(task);
               Toast.makeText(requireContext(), "some", Toast.LENGTH_SHORT).show();
           }
       });

       
    }
}
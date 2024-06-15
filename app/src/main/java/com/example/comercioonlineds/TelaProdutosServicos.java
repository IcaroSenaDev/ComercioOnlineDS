package com.example.comercioonlineds;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comercioonlineds.Adapter.FoodAdapter;
import com.example.comercioonlineds.databinding.ActivityTelaProdutosServicosBinding;
import com.example.comercioonlineds.model.Food;

import java.util.ArrayList;

public class TelaProdutosServicos extends AppCompatActivity {

    private ActivityTelaProdutosServicosBinding binding;
    private FoodAdapter foodAdapter;
    private ArrayList<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityTelaProdutosServicosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerViewFood = binding.RecyclerViewFood;
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFood.setHasFixedSize(true);

        foodAdapter = new FoodAdapter(foodList, this);
        recyclerViewFood.setAdapter(foodAdapter);
        getFood();
    }

    private void getFood() {

        Food food1 = new Food(
                R.drawable.food1,
                "Frango com batata frita",
                "Batata colhida nas maiores montanhas e frita em vulcões! E frango.",
                "$ 50.0"
        );
        foodList.add(food1);

        Food food2 = new Food(
                R.drawable.food2,
                "Japa",
                "A melhor comida japonesa que você encontrará no planeta!",
                "$ 100.0"
        );
        foodList.add(food2);

        Food food3 = new Food(
                R.drawable.food3,
                "Prato da casa",
                "Uma mistura de sabores!",
                "$ 299.0"
        );
        foodList.add(food3);

        Food food4 = new Food(
                R.drawable.food4,
                "Arroz com acompanhamentos!",
                "O melhor da região",
                "$ 90.0"
        );
        foodList.add(food4);

        Food food5 = new Food(
                R.drawable.food5,
                "Macarrão",
                "A melhor massa da Itália!",
                "$ 70.0"
        );
        foodList.add(food5);
    }

}
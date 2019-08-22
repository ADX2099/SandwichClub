package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {



    public static Sandwich parseSandwichJson(String json) throws JSONException {
        String name,description,imageUrl,placeOrigin ;
        List<String> alsoKnownList = new ArrayList<>();
        List<String> ingredientsList = new ArrayList<>();

        JSONObject sandwichJSON = new JSONObject(json);
        JSONObject nameValues = sandwichJSON.getJSONObject("name");

        Sandwich sandwichDetails = new Sandwich();
        JSONArray alsoKnownArray = nameValues.getJSONArray("alsoKnownAs");
        for(int i = 0; i < alsoKnownArray.length(); i++){
            alsoKnownList.add(alsoKnownArray.getString(i) );
        }
        JSONArray ingredientsArray = sandwichJSON.getJSONArray("ingredients");
        for(int i = 0; i < ingredientsArray.length(); i++){
            ingredientsList.add(ingredientsArray.getString(i));
        }
        name = nameValues.getString("mainName");
        placeOrigin = sandwichJSON.getString("placeOfOrigin");
        description = sandwichJSON.getString("description");
        imageUrl = sandwichJSON.getString("image");

        sandwichDetails.setPlaceOfOrigin(placeOrigin);
        sandwichDetails.setMainName(name);
        sandwichDetails.setDescription(description);
        sandwichDetails.setImage(imageUrl);
        sandwichDetails.setIngredients(ingredientsList);
        sandwichDetails.setAlsoKnownAs(alsoKnownList);

        return sandwichDetails;
    }
}

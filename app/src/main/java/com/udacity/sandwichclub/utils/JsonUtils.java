package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static final String KEY_MAIN_NAME = "mainName";
    public static final String KEY_ALSO_KNOW_AS = "alsoKnownAs";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_NAME = "name";
    public static final String KEY_INGREDIENTS = "ingredients";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";


    public static Sandwich parseSandwichJson(String json) throws JSONException {
        String name,description,imageUrl,placeOrigin ;
        List<String> alsoKnownList = new ArrayList<>();
        List<String> ingredientsList = new ArrayList<>();


        JSONObject sandwichJSON = new JSONObject(json);
        JSONObject nameValues = sandwichJSON.getJSONObject(KEY_NAME);

        Sandwich sandwichDetails = new Sandwich();
        JSONArray alsoKnownArray = nameValues.getJSONArray(KEY_ALSO_KNOW_AS);
        for(int i = 0; i < alsoKnownArray.length(); i++){
            alsoKnownList.add(alsoKnownArray.getString(i) );
        }
        JSONArray ingredientsArray = sandwichJSON.getJSONArray(KEY_INGREDIENTS);
        for(int i = 0; i < ingredientsArray.length(); i++){
            ingredientsList.add(ingredientsArray.getString(i));
        }
        name = nameValues.getString(KEY_MAIN_NAME);
        placeOrigin = sandwichJSON.getString(KEY_PLACE_OF_ORIGIN);
        description = sandwichJSON.getString(KEY_DESCRIPTION);
        imageUrl = sandwichJSON.getString(KEY_IMAGE);

        sandwichDetails.setPlaceOfOrigin(placeOrigin);
        sandwichDetails.setMainName(name);
        sandwichDetails.setDescription(description);
        sandwichDetails.setImage(imageUrl);
        sandwichDetails.setIngredients(ingredientsList);
        sandwichDetails.setAlsoKnownAs(alsoKnownList);

        return sandwichDetails;
    }
}

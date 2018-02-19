package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        Sandwich sandwich = new Sandwich();

        JSONObject sandwichJSON = new JSONObject(json);
        JSONObject sandwichName = sandwichJSON.getJSONObject("name");
        String mainName = sandwichName.getString("mainName");
        JSONArray alsoKnownAsArray = sandwichName.getJSONArray("alsoKnownAs");
        String origin = sandwichJSON.getString("placeOfOrigin");
        String description = sandwichJSON.getString("description");
        String imageUrl = sandwichJSON.getString("image");
        JSONArray ingredientsArray = sandwichJSON.getJSONArray("ingredients");

        ArrayList<String> alsoKnownAsList = new ArrayList<>();
        for (int i=0; i<alsoKnownAsArray.length(); i++) {
            alsoKnownAsList.add(alsoKnownAsArray.getString(i))   ;
        }
        ArrayList<String> ingredientsList = new ArrayList<>();
        for (int i=0; i<ingredientsArray.length(); i++) {
            ingredientsList.add(ingredientsArray.getString(i))   ;
        }
        
        sandwich.setMainName(mainName);
        sandwich.setAlsoKnownAs(alsoKnownAsList);
        sandwich.setImage(imageUrl);
        sandwich.setDescription(description);
        sandwich.setIngredients(ingredientsList);
        sandwich.setPlaceOfOrigin(origin);


        return sandwich;
    }
}

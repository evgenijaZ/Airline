package com.airline.app.config;

import com.airline.app.entities.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class AircraftDeserializer extends JsonDeserializer<AbstractAircraft> {
    @Override
    public AbstractAircraft deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode tree = codec.readTree(jsonParser);

        if (tree.has("cargoWeight")) {
            return codec.treeToValue(tree, CargoPlane.class);
        }
        if (tree.has("numberOfPassengers")) {
            return codec.treeToValue(tree, PassengerPlane.class);
        }
        if (tree.has("cruisingSpeed")) {
            return codec.treeToValue(tree, Airplane.class);
        }
        if (tree.has("rotorDiameter") && tree.has("velocity")) {
            return codec.treeToValue(tree, Helicopter.class);
        }
        throw new UnsupportedOperationException("Cannot deserialize to a known type");
    }
}

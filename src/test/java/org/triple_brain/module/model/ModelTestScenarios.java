package org.triple_brain.module.model;

import org.triple_brain.module.common_utils.Uris;
import org.triple_brain.module.model.suggestion.Suggestion;
import org.triple_brain.module.model.suggestion.SuggestionOrigin;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public class ModelTestScenarios {
    public static ExternalFriendlyResource personType() {
        return ExternalFriendlyResource.withUriAndLabel(
                Uris.get("http://xmlns.com/foaf/0.1/Person"),
                "Person"
        );
    }

    public static ExternalFriendlyResource computerScientistType() {
        return ExternalFriendlyResource.withUriAndLabel(
                Uris.get("http://rdf.freebase.com/rdf/computer.computer_scientist"),
                "Computer Scientist"
        );
    }

    public static ExternalFriendlyResource timBernersLee() {
        return ExternalFriendlyResource.withUriAndLabel(
                Uris.get("http://www.w3.org/People/Berners-Lee/card#i"),
                "Tim Berners-Lee"
        );
    }

    public static ExternalFriendlyResource creatorPredicate() {
        return ExternalFriendlyResource.withUriAndLabel(
                Uris.get("http://purl.org/dc/terms/creator"),
                "Creator"
        );
    }

    public static ExternalFriendlyResource timBernersLeeInFreebase() {
        return ExternalFriendlyResource.withUriAndLabel(
                Uris.get("http://rdf.freebase.com/rdf/en/tim_berners-lee"),
                "Tim Berners-Lee"
        );
    }

    public static ExternalFriendlyResource person() {
        return ExternalFriendlyResource.withUriAndLabel(
                Uris.get("http://xmlns.com/foaf/0.1/Person"),
                "Person"
        );
    }

    public static ExternalFriendlyResource extraterrestrial() {
        return ExternalFriendlyResource.withUriAndLabel(
                Uris.get("http://rdf.example.org/extraterrestrial"),
                "Extraterrestrial"
        );
    }

    public static ExternalFriendlyResource event() {
        return ExternalFriendlyResource.withUriAndLabel(
                Uris.get("http://rdf.freebase.com/rdf/time/event"),
                "Event"
        );
    }

    public static Suggestion nameSuggestion() {
        URI personUri = Uris.get("http://xmlns.com/foaf/0.1/Person");
        return Suggestion.withSameAsDomainLabelAndOrigins(
                Uris.get("http://xmlns.com/foaf/0.1/name"),
                personUri,
                "Name",
                SuggestionOrigin.fromIdentificationWithUri(
                        personUri
                )
        );
    }

    public static Suggestion startDateSuggestion() {
        return Suggestion.withSameAsDomainLabelAndOrigins(
                Uris.get("http://rdf.freebase.com/rdf/time/event/start_date"),
                Uris.get("http://rdf.freebase.com/rdf/type/datetime"),
                "Start date",
                SuggestionOrigin.fromIdentificationWithUri(
                        Uris.get("http://rdf.freebase.com/rdf/time/event")
                )
        );
    }
}

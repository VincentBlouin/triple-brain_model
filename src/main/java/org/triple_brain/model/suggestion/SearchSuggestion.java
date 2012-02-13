package org.triple_brain.model.suggestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent Blouin
 */
public class SearchSuggestion {

    private String URI ="";
	private String name ="";
	private String description="";
	private String thumbnailURL = "";
	private String type="";
	private Boolean couldHaveProperties=false;
    private List<SearchSuggestion> properties = new ArrayList<SearchSuggestion>();

	public static SearchSuggestion withName(String name){
        return new SearchSuggestion(name);
    }

    private SearchSuggestion(String name){
        this.name = name;
    }

	public String URI() {
		return URI;
	}

	public SearchSuggestion URI(String URI) {
		this.URI = URI;
        return this;
	}

	public String name() {
		return name;
	}

	public SearchSuggestion name(String name) {
		this.name = name;
        return this;
	}

	public List<SearchSuggestion> properties() {
		return properties;
	}

	public String description() {
		return description;
	}

	public SearchSuggestion description(String description) {
		this.description = description;
        return this;
	}

	public String thumbnailURL() {
		return thumbnailURL;
	}

	public SearchSuggestion thumbnailURL(String thumbNailURL) {
		thumbnailURL = thumbNailURL;
        return this;
	}

	public String type() {
		return type;
	}

	public SearchSuggestion type(String type) {
		this.type = type;
        return this;
	}

	public Boolean couldHaveProperties() {
		return couldHaveProperties;
	}

	public SearchSuggestion couldHaveProperties(Boolean couldHaveProperties) {
		this.couldHaveProperties = couldHaveProperties;
        return this;
	}
}

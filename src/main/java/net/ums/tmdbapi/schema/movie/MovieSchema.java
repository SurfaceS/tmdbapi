/*
 * Copyright (C) 2023 Universal Media Server
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.ums.tmdbapi.schema.movie;

import net.ums.tmdbapi.schema.IntegerIdNameSchema;
import net.ums.tmdbapi.schema.language.LanguageSchema;
import net.ums.tmdbapi.schema.collection.CollectionBaseSchema;
import net.ums.tmdbapi.schema.company.CompanySchema;
import net.ums.tmdbapi.schema.country.CountrySimpleSchema;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb Movie Schema.
 *
 * @author SurfaceS
 */
public class MovieSchema extends MovieBaseSchema {

	@SerializedName("belongs_to_collection")
	private CollectionBaseSchema belongsToCollection;
	@SerializedName("budget")
	private Long budget;
	@SerializedName("genres")
	private List<IntegerIdNameSchema> genres;
	@SerializedName("homepage")
	private String homepage;
	@SerializedName("imdb_id")
	private String imdbId;
	@SerializedName("production_companies")
	private List<CompanySchema> productionCompanies;
	@SerializedName("production_countries")
	private List<CountrySimpleSchema> productionCountries;
	@SerializedName("revenue")
	private Long revenue;
	@SerializedName("runtime")
	private Long runtime;
	@SerializedName("spoken_languages")
	private List<LanguageSchema> spokenLanguages;
	@SerializedName("status")
	private String status;
	@SerializedName("tagline")
	private String tagline;

	public CollectionBaseSchema getBelongsToCollection() {
		return belongsToCollection;
	}

	public Long getBudget() {
		return budget;
	}

	public List<IntegerIdNameSchema> getGenres() {
		return genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getImdbId() {
		return imdbId;
	}

	public List<CompanySchema> getProductionCompanies() {
		return productionCompanies;
	}

	public List<CountrySimpleSchema> getProductionCountries() {
		return productionCountries;
	}

	public Long getRevenue() {
		return revenue;
	}

	public Long getRuntime() {
		return runtime;
	}

	public List<LanguageSchema> getSpokenLanguages() {
		return spokenLanguages;
	}

	public String getStatus() {
		return status;
	}

	public String getTagline() {
		return tagline;
	}

	public void setBelongsToCollection(CollectionBaseSchema value) {
		this.belongsToCollection = value;
	}

	public void setBudget(Long value) {
		this.budget = value;
	}

	public void setGenres(List<IntegerIdNameSchema> value) {
		this.genres = value;
	}

	public void setHomepage(String value) {
		this.homepage = value;
	}

	public void setImdbId(String value) {
		this.imdbId = value;
	}

	public void setProductionCompanies(List<CompanySchema> value) {
		this.productionCompanies = value;
	}

	public void setProductionCountries(List<CountrySimpleSchema> value) {
		this.productionCountries = value;
	}

	public void setRevenue(Long value) {
		this.revenue = value;
	}

	public void setRuntime(Long value) {
		this.runtime = value;
	}

	public void setSpokenLanguages(List<LanguageSchema> value) {
		this.spokenLanguages = value;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	public void setTagline(String value) {
		this.tagline = value;
	}

}

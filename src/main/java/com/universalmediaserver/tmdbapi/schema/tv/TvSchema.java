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
package com.universalmediaserver.tmdbapi.schema.tv;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.IntegerIdNameSchema;
import com.universalmediaserver.tmdbapi.schema.company.CompanySchema;
import com.universalmediaserver.tmdbapi.schema.country.CountrySimpleSchema;
import com.universalmediaserver.tmdbapi.schema.language.LanguageSchema;
import com.universalmediaserver.tmdbapi.schema.network.NetworkBaseSchema;
import com.universalmediaserver.tmdbapi.schema.person.CreatorSchema;
import com.universalmediaserver.tmdbapi.schema.tv.episode.TvEpisodeSimpleSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonShortSchema;
import java.util.List;

/**
 * TMDb Tv show Schema.
 *
 * @author SurfaceS
 */
public class TvSchema extends TvBaseSchema {

	@SerializedName("adult")
	private Boolean adult;
	@SerializedName("created_by")
	private List<CreatorSchema> createdBy;
	@SerializedName("in_production")
	private Boolean inProduction;
	@SerializedName("episode_run_time")
	private List<Long> episodeRunTime;
	@SerializedName("genres")
	private List<IntegerIdNameSchema> genres;
	@SerializedName("homepage")
	private String homepage;
	@SerializedName("languages")
	private List<String> languages;
	@SerializedName("last_air_date")
	private String lastAirDate;
	@SerializedName("last_episode_to_air")
	private TvEpisodeSimpleSchema lastEpisodeToAir;
	@SerializedName("networks")
	private List<NetworkBaseSchema> networks;
	@SerializedName("next_episode_to_air")
	private TvEpisodeSimpleSchema nextEpisodeToAir;
	@SerializedName("number_of_episodes")
	private Long numberOfEpisodes;
	@SerializedName("number_of_seasons")
	private Long numberOfSeasons;
	@SerializedName("production_companies")
	private List<CompanySchema> productionCompanies;
	@SerializedName("production_countries")
	private List<CountrySimpleSchema> productionCountries;
	@SerializedName("seasons")
	private List<TvSeasonShortSchema> seasons;
	@SerializedName("spoken_languages")
	private List<LanguageSchema> spokenLanguages;
	@SerializedName("status")
	private String status;
	@SerializedName("tagline")
	private String tagline;
	@SerializedName("type")
	private String type;

	public Boolean getAdult() {
		return adult;
	}

	public List<CreatorSchema> getCreatedBy() {
		return createdBy;
	}

	public List<Long> getEpisodeRunTime() {
		return episodeRunTime;
	}

	public List<IntegerIdNameSchema> getGenres() {
		return genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public Boolean getInProduction() {
		return inProduction;
	}

	public String getLastAirDate() {
		return lastAirDate;
	}

	public TvEpisodeSimpleSchema getLastEpisodeToAir() {
		return lastEpisodeToAir;
	}

	public List<NetworkBaseSchema> getNetworks() {
		return networks;
	}

	public TvEpisodeSimpleSchema getNextEpisodeToAir() {
		return nextEpisodeToAir;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public Long getNumberOfEpisodes() {
		return numberOfEpisodes;
	}

	public Long getNumberOfSeasons() {
		return numberOfSeasons;
	}

	public List<CompanySchema> getProductionCompanies() {
		return productionCompanies;
	}

	public List<CountrySimpleSchema> getProductionCountries() {
		return productionCountries;
	}

	public List<TvSeasonShortSchema> getSeasons() {
		return seasons;
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

	public String getType() {
		return type;
	}

	public void setAdult(Boolean value) {
		this.adult = value;
	}

	public void setCreatedBy(List<CreatorSchema> value) {
		this.createdBy = value;
	}

	public void setEpisodeRunTime(List<Long> value) {
		this.episodeRunTime = value;
	}

	public void setGenres(List<IntegerIdNameSchema> value) {
		this.genres = value;
	}

	public void setHomepage(String value) {
		this.homepage = value;
	}

	public void setInProduction(Boolean value) {
		this.inProduction = value;
	}

	public void setLanguages(List<String> value) {
		this.languages = value;
	}

	public void setLastAirDate(String value) {
		this.lastAirDate = value;
	}

	public void setLastEpisodeToAir(TvEpisodeSimpleSchema value) {
		this.lastEpisodeToAir = value;
	}

	public void setNetworks(List<NetworkBaseSchema> value) {
		this.networks = value;
	}

	public void setNextEpisodeToAir(TvEpisodeSimpleSchema value) {
		this.nextEpisodeToAir = value;
	}

	public void setNumberOfEpisodes(Long value) {
		this.numberOfEpisodes = value;
	}

	public void setNumberOfSeasons(Long value) {
		this.numberOfSeasons = value;
	}

	public void setProductionCompanies(List<CompanySchema> value) {
		this.productionCompanies = value;
	}

	public void setProductionCountries(List<CountrySimpleSchema> value) {
		this.productionCountries = value;
	}

	public void setSeasons(List<TvSeasonShortSchema> value) {
		this.seasons = value;
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

	public void setType(String value) {
		this.type = value;
	}

}

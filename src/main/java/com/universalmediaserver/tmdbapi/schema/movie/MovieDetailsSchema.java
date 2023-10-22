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
package com.universalmediaserver.tmdbapi.schema.movie;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.account.AccountStatesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.change.ChangesSchema;
import com.universalmediaserver.tmdbapi.schema.credit.MediaCreditsSchema;
import com.universalmediaserver.tmdbapi.schema.image.ImagesSchema;
import com.universalmediaserver.tmdbapi.schema.reviews.ReviewsSchema;
import com.universalmediaserver.tmdbapi.schema.video.VideosSchema;
import com.universalmediaserver.tmdbapi.schema.watchproviders.WatchProvidersSchema;

/**
 * TMDb Movie Schema.
 *
 * @author SurfaceS
 */
public class MovieDetailsSchema extends MovieSchema {

	@SerializedName("account_states")
	private AccountStatesResponseSchema accountStates;
	@SerializedName("alternative_titles")
	private MovieAlternativeTitlesSchema alternativeTitles;
	@SerializedName("changes")
	private ChangesSchema changes;
	@SerializedName("credits")
	private MediaCreditsSchema credits;
	@SerializedName("external_ids")
	private MovieExternalIdsSchema externalIds;
	@SerializedName("images")
	private ImagesSchema images;
	@SerializedName("keywords")
	private MovieKeywordsSchema keywords;
	@SerializedName("lists")
	private MovieListsSchema lists;
	@SerializedName("recommendations")
	private MovieTypedResultsSchema recommendations;
	@SerializedName("release_dates")
	private MovieReleaseDatesSchema releaseDates;
	@SerializedName("reviews")
	private ReviewsSchema reviews;
	@SerializedName("similar")
	private MovieShortResultsSchema similar;
	@SerializedName("translations")
	private MovieTranslationsSchema translations;
	@SerializedName("videos")
	private VideosSchema videos;
	@SerializedName("watch/providers")
	private WatchProvidersSchema watchProviders;

	public AccountStatesResponseSchema getAccountStates() {
		return accountStates;
	}

	public MovieAlternativeTitlesSchema getAlternativeTitles() {
		return alternativeTitles;
	}

	public ChangesSchema getChanges() {
		return changes;
	}

	public MediaCreditsSchema getCredits() {
		return credits;
	}

	public MovieExternalIdsSchema getExternalIds() {
		return externalIds;
	}

	public ImagesSchema getImages() {
		return images;
	}

	public MovieKeywordsSchema getKeywords() {
		return keywords;
	}

	public MovieListsSchema getLists() {
		return lists;
	}

	public MovieTypedResultsSchema getRecommendations() {
		return recommendations;
	}

	public MovieReleaseDatesSchema getReleaseDates() {
		return releaseDates;
	}

	public ReviewsSchema getReviews() {
		return reviews;
	}

	public MovieShortResultsSchema getSimilar() {
		return similar;
	}

	public MovieTranslationsSchema getTranslations() {
		return translations;
	}

	public VideosSchema getVideos() {
		return videos;
	}

	public WatchProvidersSchema getWatchProviders() {
		return watchProviders;
	}

	public void setAccountStates(AccountStatesResponseSchema value) {
		this.accountStates = value;
	}

	public void setAlternativeTitles(MovieAlternativeTitlesSchema value) {
		this.alternativeTitles = value;
	}

	public void setChanges(ChangesSchema value) {
		this.changes = value;
	}

	public void setCredits(MediaCreditsSchema value) {
		this.credits = value;
	}

	public void setExternalIds(MovieExternalIdsSchema value) {
		this.externalIds = value;
	}

	public void setImages(ImagesSchema value) {
		this.images = value;
	}

	public void setKeywords(MovieKeywordsSchema value) {
		this.keywords = value;
	}

	public void setLists(MovieListsSchema value) {
		this.lists = value;
	}

	public void setRecommendations(MovieTypedResultsSchema value) {
		this.recommendations = value;
	}

	public void setReleaseDates(MovieReleaseDatesSchema value) {
		this.releaseDates = value;
	}

	public void setReviews(ReviewsSchema value) {
		this.reviews = value;
	}

	public void setSimilar(MovieShortResultsSchema value) {
		this.similar = value;
	}

	public void setTranslations(MovieTranslationsSchema value) {
		this.translations = value;
	}

	public void setVideos(VideosSchema value) {
		this.videos = value;
	}

	public void setWatchProviders(WatchProvidersSchema value) {
		this.watchProviders = value;
	}

}

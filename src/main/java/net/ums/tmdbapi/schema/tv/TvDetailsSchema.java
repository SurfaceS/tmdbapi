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
package net.ums.tmdbapi.schema.tv;

import net.ums.tmdbapi.schema.account.AccountStatesSchema;
import net.ums.tmdbapi.schema.change.ChangesSchema;
import net.ums.tmdbapi.schema.credit.AggregateCreditsSchema;
import net.ums.tmdbapi.schema.credit.MediaCreditsSchema;
import net.ums.tmdbapi.schema.image.ImagesSchema;
import net.ums.tmdbapi.schema.reviews.ReviewsSchema;
import net.ums.tmdbapi.schema.video.VideosSchema;
import net.ums.tmdbapi.schema.watchproviders.WatchProvidersSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv show Schema.
 *
 * @author SurfaceS
 */
public class TvDetailsSchema extends TvSchema {

	@SerializedName("account_states")
	private AccountStatesSchema accountStates;
	@SerializedName("aggregate_credits")
	private AggregateCreditsSchema aggregateCredits;
	@SerializedName("alternative_titles")
	private TvAlternativeTitlesSchema alternativeTitles;
	@SerializedName("changes")
	private ChangesSchema changes;
	@SerializedName("content_ratings")
	private TvContentRatingsSchema contentRatings;
	@SerializedName("credits")
	private MediaCreditsSchema credits;
	@SerializedName("episode_groups")
	private TvEpisodeGroupsSchema episodeGroups;
	@SerializedName("external_ids")
	private TvExternalIdsSchema externalIds;
	@SerializedName("images")
	private ImagesSchema images;
	@SerializedName("keywords")
	private TvKeywordsSchema keywords;
	@SerializedName("recommendations")
	private TvTypedResultsSchema recommendations;
	@SerializedName("reviews")
	private ReviewsSchema reviews;
	@SerializedName("screened_theatrically")
	private TvScreenedTheatricallySchema screenedTheatrically;
	@SerializedName("similar")
	private TvSimpleResultsSchema similar;
	@SerializedName("translations")
	private TvTranslationsSchema translations;
	@SerializedName("videos")
	private VideosSchema videos;
	@SerializedName("watch/providers")
	private WatchProvidersSchema watchProviders;

	public AccountStatesSchema getAccountStates() {
		return accountStates;
	}

	public TvAlternativeTitlesSchema getAlternativeTitles() {
		return alternativeTitles;
	}

	public AggregateCreditsSchema getAggregateCredits() {
		return aggregateCredits;
	}

	public ChangesSchema getChanges() {
		return changes;
	}

	public TvContentRatingsSchema getContentRatings() {
		return contentRatings;
	}

	public MediaCreditsSchema getCredits() {
		return credits;
	}

	public TvEpisodeGroupsSchema getEpisodeGroups() {
		return episodeGroups;
	}

	public TvExternalIdsSchema getExternalIds() {
		return externalIds;
	}

	public ImagesSchema getImages() {
		return images;
	}

	public TvKeywordsSchema getKeywords() {
		return keywords;
	}

	public TvTypedResultsSchema getRecommendations() {
		return recommendations;
	}

	public ReviewsSchema getReviews() {
		return reviews;
	}

	public TvScreenedTheatricallySchema getScreenedTheatrically() {
		return screenedTheatrically;
	}

	public TvSimpleResultsSchema getSimilar() {
		return similar;
	}

	public TvTranslationsSchema getTranslations() {
		return translations;
	}

	public VideosSchema getVideos() {
		return videos;
	}

	public WatchProvidersSchema getWatchProviders() {
		return watchProviders;
	}

	public void setAccountStates(AccountStatesSchema value) {
		this.accountStates = value;
	}

	public void setAlternativeTitles(TvAlternativeTitlesSchema value) {
		this.alternativeTitles = value;
	}

	public void setAggregateCredits(AggregateCreditsSchema value) {
		this.aggregateCredits = value;
	}

	public void setChanges(ChangesSchema value) {
		this.changes = value;
	}

	public void setContentRatings(TvContentRatingsSchema value) {
		this.contentRatings = value;
	}

	public void setCredits(MediaCreditsSchema value) {
		this.credits = value;
	}

	public void setEpisodeGroups(TvEpisodeGroupsSchema value) {
		this.episodeGroups = value;
	}

	public void setExternalIds(TvExternalIdsSchema value) {
		this.externalIds = value;
	}

	public void setImages(ImagesSchema value) {
		this.images = value;
	}

	public void setKeywords(TvKeywordsSchema value) {
		this.keywords = value;
	}

	public void setRecommendations(TvTypedResultsSchema value) {
		this.recommendations = value;
	}

	public void setReviews(ReviewsSchema value) {
		this.reviews = value;
	}

	public void setScreenedTheatrically(TvScreenedTheatricallySchema value) {
		this.screenedTheatrically = value;
	}

	public void setSimilar(TvSimpleResultsSchema value) {
		this.similar = value;
	}

	public void setTranslations(TvTranslationsSchema value) {
		this.translations = value;
	}

	public void setVideos(VideosSchema value) {
		this.videos = value;
	}

	public void setWatchProviders(WatchProvidersSchema value) {
		this.watchProviders = value;
	}

}

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
package com.universalmediaserver.tmdbapi.schema.tv.season;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.credit.AggregateCreditsSchema;
import com.universalmediaserver.tmdbapi.schema.video.VideosSchema;

/**
 * TMDb Extended Tv Season Schema.
 *
 * @author SurfaceS
 */
public class TvSeasonDetailsSchema extends TvSeasonSchema {

	@SerializedName("account_states")
	private TvSeasonAccountStatesSchema accountStates;
	@SerializedName("aggregate_credits")
	private AggregateCreditsSchema aggregateCredits;
	@SerializedName("credits")
	private TvSeasonCreditsSchema credits;
	@SerializedName("external_ids")
	private TvSeasonExternalIdsSchema externalIds;
	@SerializedName("images")
	private TvSeasonImagesSchema images;
	@SerializedName("translations")
	private TvSeasonTranslationsSchema translations;
	@SerializedName("videos")
	private VideosSchema videos;

	public TvSeasonAccountStatesSchema getAccountStates() {
		return accountStates;
	}

	public AggregateCreditsSchema getAggregateCredits() {
		return aggregateCredits;
	}

	public TvSeasonCreditsSchema getCredits() {
		return credits;
	}

	public TvSeasonExternalIdsSchema getExternalIds() {
		return externalIds;
	}

	public TvSeasonImagesSchema getImages() {
		return images;
	}

	public TvSeasonTranslationsSchema getTranslations() {
		return translations;
	}

	public VideosSchema getVideos() {
		return videos;
	}

	public void setAccountStates(TvSeasonAccountStatesSchema value) {
		this.accountStates = value;
	}

	public void setAggregateCredits(AggregateCreditsSchema value) {
		this.aggregateCredits = value;
	}

	public void setCredits(TvSeasonCreditsSchema value) {
		this.credits = value;
	}

	public void setExternalIds(TvSeasonExternalIdsSchema value) {
		this.externalIds = value;
	}

	public void setImages(TvSeasonImagesSchema value) {
		this.images = value;
	}

	public void setTranslations(TvSeasonTranslationsSchema value) {
		this.translations = value;
	}

	public void setVideos(VideosSchema value) {
		this.videos = value;
	}

}

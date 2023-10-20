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
package com.universalmediaserver.tmdbapi.schema.tv.episode;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.video.VideosSchema;

/**
 * TMDb Tv Episode Schema.
 *
 * @author SurfaceS
 */
public class TvEpisodeDetailsSchema extends TvEpisodeSchema {

	@SerializedName("account_states")
	private TvEpisodeAccountStatesSchema accountStates;
	@SerializedName("credits")
	private TvEpisodeCreditsSchema credits;
	@SerializedName("external_ids")
	private TvEpisodeExternalIdsSchema externalIds;
	@SerializedName("images")
	private TvEpisodeImagesSchema images;
	@SerializedName("translations")
	private TvEpisodeTranslationsSchema translations;
	@SerializedName("videos")
	private VideosSchema videos;

	public TvEpisodeAccountStatesSchema getAccountStates() {
		return accountStates;
	}

	public TvEpisodeCreditsSchema getCredits() {
		return credits;
	}

	public TvEpisodeExternalIdsSchema getExternalIds() {
		return externalIds;
	}

	public TvEpisodeImagesSchema getImages() {
		return images;
	}

	public TvEpisodeTranslationsSchema getTranslations() {
		return translations;
	}

	public VideosSchema getVideos() {
		return videos;
	}

	public void setAccountStates(TvEpisodeAccountStatesSchema value) {
		this.accountStates = value;
	}

	public void setCredits(TvEpisodeCreditsSchema value) {
		this.credits = value;
	}

	public void setExternalIds(TvEpisodeExternalIdsSchema value) {
		this.externalIds = value;
	}

	public void setImages(TvEpisodeImagesSchema value) {
		this.images = value;
	}

	public void setTranslations(TvEpisodeTranslationsSchema value) {
		this.translations = value;
	}

	public void setVideos(VideosSchema value) {
		this.videos = value;
	}

}

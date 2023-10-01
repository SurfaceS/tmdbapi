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
package net.ums.tmdbapi.schema.tv.episode;

import net.ums.tmdbapi.schema.translation.TranslationBaseSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv Episode Translation Schema.
 *
 * @author SurfaceS
 */
public class TvEpisodeTranslationSchema extends TranslationBaseSchema {

	@SerializedName("data")
	private TvEpisodeTranslationDataSchema data;

	public TvEpisodeTranslationDataSchema getData() {
		return data;
	}

	public void setData(TvEpisodeTranslationDataSchema value) {
		this.data = value;
	}

}

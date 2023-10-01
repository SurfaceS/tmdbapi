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
package net.ums.tmdbapi.schema.tv.season;

import net.ums.tmdbapi.schema.translation.TranslationBaseSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv Season Translation Schema.
 *
 * @author SurfaceS
 */
public class TvSeasonTranslationSchema extends TranslationBaseSchema {

	@SerializedName("data")
	private TvSeasonTranslationDataSchema data;

	public TvSeasonTranslationDataSchema getData() {
		return data;
	}

	public void setData(TvSeasonTranslationDataSchema value) {
		this.data = value;
	}

}
